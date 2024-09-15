package com.soybean.portal.ctrl;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.soybean.infrastructure.Result;
import com.soybean.infrastructure.resources.entity.UserRoleDO;
import com.soybean.infrastructure.service.UserRoleService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.Serializable;
import java.util.List;

/**
 *  用户和角色关联控制层。
 *
 * @author gutsyzhan
 * @since 2024-09-15
 */
@RestController
@Api(tags = "用户和角色关联表接口")
@RequestMapping("/sys/userRole/")
public class BusUserRoleCtrl {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 添加。
     *
     * @param userRoleDO 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @ApiOperation("保存")
    public Result<Boolean> save(@RequestBody @ApiParam("") UserRoleDO userRoleDO) {
        boolean save = userRoleService.save(userRoleDO);
        return Result.success(save);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @ApiOperation("根据主键")
    public Result<Boolean> remove(@PathVariable @ApiParam("主键") Serializable id) {
        boolean remove = userRoleService.removeById(id);
        return Result.success(remove);
    }

    /**
     * 根据主键更新。
     *
     * @param userRoleDO 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @ApiOperation("根据主键更新")
    public Result<Boolean> update(@RequestBody @ApiParam("主键") UserRoleDO userRoleDO) {
        userRoleService.updateById(userRoleDO);
        return Result.success();
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @ApiOperation("查询所有")
    public Result<List<UserRoleDO>> list() {
        List<UserRoleDO> list = userRoleService.list();
         return Result.success(list);
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    @ApiOperation("根据主键获取")
    public Result<UserRoleDO> getInfo(@PathVariable @ApiParam("主键") Serializable id) {
        UserRoleDO detail=userRoleService.getById(id);
        return Result.success(detail);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @ApiOperation("分页查询")
    public Result<Page<UserRoleDO>> page(@ApiParam("分页信息") Page<UserRoleDO> page) {
    Page<UserRoleDO> data = userRoleService.page(page);
        return Result.success(data);
    }

}
