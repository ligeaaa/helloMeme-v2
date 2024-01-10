package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.SysRole;
import com.hellomeme.v2.service.SysRoleService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * 角色表(SysRole)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:48
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    //region 增删改查

    /**
     * 新增数据
     * @param sysRole 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:20:48
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody SysRole sysRole){
        boolean save = sysRoleService.save(sysRole);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:48
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = sysRoleService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param sysRole 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:48
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody SysRole sysRole){
        boolean update = sysRoleService.updateById(sysRole);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:48
     */
    @GetMapping("/get")
    public BaseResponse<SysRole> queryById(Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return ResultUtils.success(sysRole);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， sysRole 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:48
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<SysRole>> getPageList(Page<SysRole> page,@RequestBody SysRole sysRole){
        Page<SysRole> pageList = sysRoleService.page(page,new LambdaQueryWrapper<SysRole>(sysRole));
        return ResultUtils.success(pageList);
    }

    //endregion

}


