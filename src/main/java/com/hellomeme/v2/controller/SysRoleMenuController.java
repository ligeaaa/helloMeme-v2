package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.SysRoleMenu;
import com.hellomeme.v2.service.SysRoleMenuService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * (SysRoleMenu)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:52
 */
@RestController
@RequestMapping("sysRoleMenu")
public class SysRoleMenuController {

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    //region 增删改查

    /**
     * 新增数据
     * @param sysRoleMenu 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:20:52
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody SysRoleMenu sysRoleMenu){
        boolean save = sysRoleMenuService.save(sysRoleMenu);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:52
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = sysRoleMenuService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param sysRoleMenu 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:52
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody SysRoleMenu sysRoleMenu){
        boolean update = sysRoleMenuService.updateById(sysRoleMenu);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:52
     */
    @GetMapping("/get")
    public BaseResponse<SysRoleMenu> queryById(Long id) {
        SysRoleMenu sysRoleMenu = sysRoleMenuService.getById(id);
        return ResultUtils.success(sysRoleMenu);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， sysRoleMenu 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:52
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<SysRoleMenu>> getPageList(Page<SysRoleMenu> page,@RequestBody SysRoleMenu sysRoleMenu){
        Page<SysRoleMenu> pageList = sysRoleMenuService.page(page,new LambdaQueryWrapper<SysRoleMenu>(sysRoleMenu));
        return ResultUtils.success(pageList);
    }

    //endregion

}


