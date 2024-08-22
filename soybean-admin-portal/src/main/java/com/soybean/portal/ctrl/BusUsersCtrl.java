package com.soybean.portal.ctrl;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.paginate.Page;
import com.soybean.domain.model.UsersDTO;
import com.soybean.infrastructure.Result;
import com.soybean.infrastructure.factory.mapper.UsersMapperFactory;
import com.soybean.infrastructure.resources.entity.UsersDO;
import com.soybean.infrastructure.service.UsersService;
import com.soybean.portal.request.users.UsersLoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 用户信息表 控制层。
 *
 * @author coding
 * @since 2024-08-20
 */
@RestController
@Api(tags = "用户信息表接口")
@RequestMapping("/sys/users/")
@Repository
public class BusUsersCtrl {

    @Autowired
    private UsersService usersService;


    @PostMapping("login")
    public Result login(@RequestBody @ApiParam("用户信息表") UsersLoginRequest request) {
        UsersDTO usersDTO = new UsersDTO();
        UsersDTO.UsersBasic usersBasic = new UsersDTO.UsersBasic();
        usersBasic.setUsername(request.getUsername());
        usersBasic.setPassword(request.getPassword());
        usersDTO.setUsersBasic(usersBasic);
        UsersDTO loginUsers = usersService.login(usersDTO);
        if (Optional.ofNullable(loginUsers).isEmpty()) {
            return Result.failed("当前用户不存在");
        }
        String password = loginUsers.getUsersBasic().getPassword();
        if (!password.equals(request.getPassword())) {
            return Result.failed("密码错误");
        }
        //todo 登录处理satoken
//        StpUtil.login(usersDTO.getUserId()).;
        return Result.success();
    }

    /**
     * 添加用户信息表。
     *
     * @param usersDO 用户信息表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @ApiOperation("保存用户信息表")
    public Result<Boolean> save(@RequestBody @ApiParam("用户信息表") UsersDO usersDO) {
        boolean save = usersService.save(null);
        return Result.success(save);
    }

    /**
     * 根据主键删除用户信息表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @ApiOperation("根据主键用户信息表")
    public Result<Boolean> remove(@PathVariable @ApiParam("用户信息表主键") Serializable id) {
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
    @ApiOperation("根据主键更新用户信息表")
    public Result<Boolean> update(@RequestBody @ApiParam("用户信息表主键") UsersDO usersDO) {
        usersService.updateById(null);
        return Result.success();
    }

    /**
     * 查询所有用户信息表。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @ApiOperation("查询所有用户信息表")
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
    @ApiOperation("根据主键获取用户信息表")
    public Result<UsersDTO> getInfo(@PathVariable @ApiParam("用户信息表主键") Serializable id) {
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
    @ApiOperation("分页查询用户信息表")
    public Result<Page<UsersDO>> page(@ApiParam("分页信息") Page<UsersDO> page) {
        Page<UsersDO> data = usersService.page(page);
        UsersMapperFactory.MAPPER.map(new UsersDO());
        return Result.success(data);
    }

}
