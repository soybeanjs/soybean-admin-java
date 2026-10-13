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
import com.soybean.infrastructure.resources.entity.RoleMenuDO;
import com.soybean.infrastructure.service.RoleMenuService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.io.Serializable;
import java.util.List;

/**
 *  角色和菜单关联表 控制层。
 *
 * @author gutsyzhan
 * @since 2024-09-15
 */
@RestController
@Tag(name = "角色和菜单关联表接口")
@RequestMapping("/sys/roleMenu/")
public class BusRoleMenuCtrl {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 添加。
     *
     * @param roleMenuDO 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(summary = "保存")
    public Result<Boolean> save(@RequestBody @Parameter(description = "") RoleMenuDO roleMenuDO) {
        boolean save = roleMenuService.save(roleMenuDO);
        return Result.success(save);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(summary = "根据主键")
    public Result<Boolean> remove(@PathVariable @Parameter(description = "主键") Serializable id) {
        boolean remove = roleMenuService.removeById(id);
        return Result.success(remove);
    }

    /**
     * 根据主键更新。
     *
     * @param roleMenuDO 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(summary = "根据主键更新")
    public Result<Boolean> update(@RequestBody @Parameter(description = "主键") RoleMenuDO roleMenuDO) {
        roleMenuService.updateById(roleMenuDO);
        return Result.success();
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(summary = "查询所有")
    public Result<List<RoleMenuDO>> list() {
        List<RoleMenuDO> list = roleMenuService.list();
         return Result.success(list);
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(summary = "根据主键获取")
    public Result<RoleMenuDO> getInfo(@PathVariable @Parameter(description = "主键") Serializable id) {
        RoleMenuDO detail=roleMenuService.getById(id);
        return Result.success(detail);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(summary = "分页查询")
    public Result<Page<RoleMenuDO>> page(@Parameter(description = "分页信息") Page<RoleMenuDO> page) {
    Page<RoleMenuDO> data = roleMenuService.page(page);
        return Result.success(data);
    }

}
