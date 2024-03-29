package cn.soybean.system.application.service

import cn.soybean.framework.common.consts.AppConstants
import cn.soybean.framework.common.consts.enums.DbEnums
import cn.soybean.framework.common.util.LoginHelper.Companion.DEPT_KEY
import cn.soybean.framework.common.util.LoginHelper.Companion.TENANT_KEY
import cn.soybean.framework.common.util.LoginHelper.Companion.USER_AVATAR
import cn.soybean.framework.common.util.LoginHelper.Companion.USER_KEY
import cn.soybean.framework.common.util.getClientIPAndPort
import cn.soybean.system.domain.entity.SystemLoginLogEntity
import cn.soybean.system.domain.entity.SystemTenantEntity
import cn.soybean.system.domain.entity.SystemUserEntity
import cn.soybean.system.domain.service.RoleService
import cn.soybean.system.domain.service.TenantService
import cn.soybean.system.domain.service.UserService
import cn.soybean.system.infrastructure.dto.UserPermAction
import cn.soybean.system.interfaces.dto.request.PwdLoginRequest
import cn.soybean.system.interfaces.vo.LoginRespVO
import io.smallrye.jwt.build.Jwt
import io.smallrye.mutiny.Uni
import io.vertx.ext.web.RoutingContext
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Event
import org.eclipse.microprofile.jwt.Claims

@ApplicationScoped
class AuthService(
    private val tenantService: TenantService,
    private val userService: UserService,
    private val roleService: RoleService,
    private val routingContext: RoutingContext,
    private val eventBus: Event<SystemLoginLogEntity>,
    private val userPermActionEventBus: Event<UserPermAction>
) {

    fun pwdLogin(req: PwdLoginRequest): Uni<LoginRespVO> = tenantService.findAndVerifyTenant(req.tenantName)
        .flatMap { tenant ->
            userService.findAndVerifyUserCredentials(req.userName, req.password, tenant.id!!)
                .flatMap { user ->
                    roleService.getRoleCodesByUserId(user.id!!)
                        .map { roles -> Triple(tenant, user, roles) }
                }
        }
        .map { (tenant, user, roles) ->
            createLoginRespVO(tenant, user, roles).also {
                saveLoginLog(user, tenant.id)
            }
        }

    private fun createLoginRespVO(
        tenantEntity: SystemTenantEntity,
        systemUserEntity: SystemUserEntity,
        roleCodes: Set<String>
    ): LoginRespVO {
        val tokenValue = Jwt.upn(systemUserEntity.accountName)
            .subject(systemUserEntity.id.toString())
            .groups(roleCodes + AppConstants.APP_COMMON_ROLE)
            .claim(TENANT_KEY, tenantEntity.id)
            .claim(USER_KEY, systemUserEntity.id)
            .claim(DEPT_KEY, systemUserEntity.deptId ?: "")
            .claim(USER_AVATAR, systemUserEntity.avatar ?: "")
            .claim(Claims.nickname.name, systemUserEntity.nickName)
            .claim(Claims.gender.name, systemUserEntity.gender ?: "")
            .sign()
        userPermActionEventBus.fireAsync(systemUserEntity.id?.let { UserPermAction(it) })
        return LoginRespVO(tokenValue, "")
    }

    private fun saveLoginLog(user: SystemUserEntity, tenantId: Long?) {
        val (ip, port) = getClientIPAndPort(routingContext.request())
        val loginLogEntity = SystemLoginLogEntity(
            loginType = DbEnums.LoginType.PC,
            userId = user.id,
            accountName = user.accountName,
            userIp = ip,
            userPort = port,
            userAgent = routingContext.request().getHeader("User-Agent") ?: "Unknown",
        )
        loginLogEntity.tenantId = tenantId
        loginLogEntity.createBy = user.id
        loginLogEntity.createAccountName = user.accountName
        eventBus.fireAsync(loginLogEntity)
    }
}