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
import com.soybean.infrastructure.resources.entity.RoleDO;
import com.soybean.infrastructure.service.RoleService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.Serializable;
import java.util.List;

/**
 * 角色信息表 控制层。
 *
 * @author gutsyzhan
 * @since 2024-09-05
 */
@RestController
@Api(tags = "角色信息表接口")
@RequestMapping("/sys/role")
public class BusRoleCtrl {

    @Autowired
    private RoleService roleService;

    /**
     * 添加。
     *
     * @param roleDO 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @ApiOperation("保存")
    public Result<Boolean> save(@RequestBody @ApiParam("") RoleDO roleDO) {
        boolean save = roleService.save(roleDO);
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
        boolean remove = roleService.removeById(id);
        return Result.success(remove);
    }

    /**
     * 根据主键更新。
     *
     * @param roleDO 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @ApiOperation("根据主键更新")
    public Result<Boolean> update(@RequestBody @ApiParam("主键") RoleDO roleDO) {
        roleService.updateById(roleDO);
        return Result.success();
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @ApiOperation("查询所有")
    public Result<List<RoleDO>> list() {
        List<RoleDO> list = roleService.list();
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
    public Result<RoleDO> getInfo(@PathVariable @ApiParam("主键") Serializable id) {
        RoleDO detail=roleService.getById(id);
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
    public Result<Page<RoleDO>> page(@ApiParam("分页信息") Page<RoleDO> page) {
    Page<RoleDO> data = roleService.page(page);
        return Result.success(data);
    }

}
