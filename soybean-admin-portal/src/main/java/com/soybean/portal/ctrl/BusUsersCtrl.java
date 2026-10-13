package com.soybean.portal.ctrl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.paginate.Page;
import com.soybean.domain.model.UsersDTO;
import com.soybean.infrastructure.Result;
import com.soybean.infrastructure.resources.entity.UsersDO;
import com.soybean.infrastructure.service.UsersService;
import com.soybean.portal.request.users.UsersLoginRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 用户信息表 控制层。
 *
 * @author coding
 * @since 2024-08-20
 */
@RestController
@Tag(name = "用户信息表接口")
@RequestMapping("/sys/users/")
public class BusUsersCtrl {

    @Autowired
    private UsersService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Operation(summary = "登录")
    @PostMapping("login")
    public Result<String> login(@Valid @RequestBody @Parameter(description = "用户信息表") UsersLoginRequest request) {
        UsersDTO usersDTO = new UsersDTO();
        UsersDTO.UsersBasic usersBasic = new UsersDTO.UsersBasic();
        usersBasic.setUsername(request.getUsername());
        usersBasic.setPassword(request.getPassword());
        usersDTO.setUsersBasic(usersBasic);
        UsersDTO loginUsers = usersService.login(usersDTO);
        if (Objects.isNull(loginUsers) || Objects.isNull(loginUsers.getUsersBasic())) {
            return Result.failed("用户名或密码错误");
        }
        String encodedPassword = loginUsers.getUsersBasic().getPassword();
        if (!passwordEncoder.matches(request.getPassword(), encodedPassword)) {
            return Result.failed("用户名或密码错误");
        }
        StpUtil.login(loginUsers.getUserId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return Result.success(tokenInfo.getTokenValue());
    }

    /**
     * 添加用户信息表。
     *
     * @param usersDO 用户信息表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(summary = "保存用户信息表")
    public Result<Boolean> save(@RequestBody @Parameter(description = "用户信息表") UsersDO usersDO) {
        boolean save = usersService.save(usersDO);
        return Result.success(save);
    }

    /**
     * 根据主键删除用户信息表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(summary = "根据主键用户信息表")
    public Result<Boolean> remove(@PathVariable @Parameter(description = "用户信息表主键") Serializable id) {
        boolean remove = usersService.removeById(id);
        return Result.success(remove);
    }

    /**
     * 根据主键更新用户信息表。
     *
     * @param usersDO 用户信息表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(summary = "根据主键更新用户信息表")
    public Result<Boolean> update(@RequestBody @Parameter(description = "用户信息表主键") UsersDO usersDO) {
        boolean update = usersService.updateById(usersDO);
        return Result.success(update);
    }

    /**
     * 查询所有用户信息表。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(summary = "查询所有用户信息表")
    public Result<List<UsersDO>> list() {
        List<UsersDO> list = usersService.list();
        return Result.success(list);
    }

    /**
     * 根据用户信息表主键获取详细信息。
     *
     * @param id 用户信息表主键
     * @return 用户信息表详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(summary = "根据主键获取用户信息表")
    public Result<UsersDO> getInfo(@PathVariable @Parameter(description = "用户信息表主键") Serializable id) {
        UsersDO detail = usersService.getById(id);
        return Result.success(detail);
    }

    /**
     * 分页查询用户信息表。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(summary = "分页查询用户信息表")
    public Result<Page<UsersDO>> page(@Parameter(description = "分页信息") Page<UsersDO> page) {
        Page<UsersDO> data = usersService.page(page);
        return Result.success(data);
    }

}
