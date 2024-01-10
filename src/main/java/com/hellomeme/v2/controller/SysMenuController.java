package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.SysMenu;
import com.hellomeme.v2.service.SysMenuService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * 菜单表(SysMenu)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:38
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    //region 增删改查

    /**
     * 新增数据
     * @param sysMenu 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:20:38
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody SysMenu sysMenu){
        boolean save = sysMenuService.save(sysMenu);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:38
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = sysMenuService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param sysMenu 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:38
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody SysMenu sysMenu){
        boolean update = sysMenuService.updateById(sysMenu);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:38
     */
    @GetMapping("/get")
    public BaseResponse<SysMenu> queryById(Long id) {
        SysMenu sysMenu = sysMenuService.getById(id);
        return ResultUtils.success(sysMenu);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， sysMenu 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:38
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<SysMenu>> getPageList(Page<SysMenu> page,@RequestBody SysMenu sysMenu){
        Page<SysMenu> pageList = sysMenuService.page(page,new LambdaQueryWrapper<SysMenu>(sysMenu));
        return ResultUtils.success(pageList);
    }

    //endregion

}


