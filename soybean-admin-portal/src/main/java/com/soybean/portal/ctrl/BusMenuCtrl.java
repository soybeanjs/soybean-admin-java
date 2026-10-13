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
import com.soybean.infrastructure.resources.entity.MenuDO;
import com.soybean.infrastructure.service.MenuService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.io.Serializable;
import java.util.List;

/**
 *  菜单权限表 控制层。
 *
 * @author gutsyzhan
 * @since 2024-09-15
 */
@RestController
@Tag(name = "菜单权限表接口")
@RequestMapping("/sys/menu/")
public class BusMenuCtrl {

    @Autowired
    private MenuService menuService;

    /**
     * 添加。
     *
     * @param menuDO 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(summary = "保存")
    public Result<Boolean> save(@RequestBody @Parameter(description = "") MenuDO menuDO) {
        boolean save = menuService.save(menuDO);
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
        boolean remove = menuService.removeById(id);
        return Result.success(remove);
    }

    /**
     * 根据主键更新。
     *
     * @param menuDO 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(summary = "根据主键更新")
    public Result<Boolean> update(@RequestBody @Parameter(description = "主键") MenuDO menuDO) {
        menuService.updateById(menuDO);
        return Result.success();
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(summary = "查询所有")
    public Result<List<MenuDO>> list() {
        List<MenuDO> list = menuService.list();
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
    public Result<MenuDO> getInfo(@PathVariable @Parameter(description = "主键") Serializable id) {
        MenuDO detail=menuService.getById(id);
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
    public Result<Page<MenuDO>> page(@Parameter(description = "分页信息") Page<MenuDO> page) {
    Page<MenuDO> data = menuService.page(page);
        return Result.success(data);
    }

}
