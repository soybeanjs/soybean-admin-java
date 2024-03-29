package cn.soybean.system.infrastructure.repository

import cn.soybean.system.domain.entity.SystemDeptEntity
import cn.soybean.system.domain.repository.SystemDeptRepository
import io.quarkus.hibernate.reactive.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class SystemDeptRepositoryImpl : SystemDeptRepository, PanacheRepository<SystemDeptEntity> 