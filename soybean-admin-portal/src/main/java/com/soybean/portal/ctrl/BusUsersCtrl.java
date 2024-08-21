package com.soybean.portal.ctrl;

import com.mybatisflex.core.paginate.Page;
import com.soybean.domain.service.UsersService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.soybean.infrastructure.Result;
import com.soybean.infrastructure.resources.entity.UsersDO;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.Serializable;
import java.util.List;

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
    public Result login(@RequestBody @ApiParam("用户信息表") UsersDO usersDO) {
        usersService.login(null);
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
        usersService.updateById(usersDO);
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
    public Result<UsersDO> getInfo(@PathVariable @ApiParam("用户信息表主键") Serializable id) {
        UsersDO detail=usersService.getById(id);
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
        return Result.success(data);
    }

}
