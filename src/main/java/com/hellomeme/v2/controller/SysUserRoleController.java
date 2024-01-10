package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.SysUserRole;
import com.hellomeme.v2.service.SysUserRoleService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * (SysUserRole)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:21:02
 */
@RestController
@RequestMapping("sysUserRole")
public class SysUserRoleController {

    @Resource
    private SysUserRoleService sysUserRoleService;

    //region 增删改查

    /**
     * 新增数据
     * @param sysUserRole 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:21:02
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody SysUserRole sysUserRole){
        boolean save = sysUserRoleService.save(sysUserRole);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:21:02
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = sysUserRoleService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param sysUserRole 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:21:02
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody SysUserRole sysUserRole){
        boolean update = sysUserRoleService.updateById(sysUserRole);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:21:02
     */
    @GetMapping("/get")
    public BaseResponse<SysUserRole> queryById(Long id) {
        SysUserRole sysUserRole = sysUserRoleService.getById(id);
        return ResultUtils.success(sysUserRole);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， sysUserRole 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:21:02
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<SysUserRole>> getPageList(Page<SysUserRole> page,@RequestBody SysUserRole sysUserRole){
        Page<SysUserRole> pageList = sysUserRoleService.page(page,new LambdaQueryWrapper<SysUserRole>(sysUserRole));
        return ResultUtils.success(pageList);
    }

    //endregion

}


