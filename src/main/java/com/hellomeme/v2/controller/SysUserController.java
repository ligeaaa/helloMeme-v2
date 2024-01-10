package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.SysUser;
import com.hellomeme.v2.service.SysUserService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:58
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    //region 增删改查

    /**
     * 新增数据
     * @param sysUser 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:20:58
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody SysUser sysUser){
        boolean save = sysUserService.save(sysUser);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:58
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = sysUserService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param sysUser 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:58
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody SysUser sysUser){
        boolean update = sysUserService.updateById(sysUser);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:58
     */
    @GetMapping("/get")
    public BaseResponse<SysUser> queryById(Long id) {
        SysUser sysUser = sysUserService.getById(id);
        return ResultUtils.success(sysUser);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， sysUser 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:58
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<SysUser>> getPageList(Page<SysUser> page,@RequestBody SysUser sysUser){
        Page<SysUser> pageList = sysUserService.page(page,new LambdaQueryWrapper<SysUser>(sysUser));
        return ResultUtils.success(pageList);
    }

    //endregion

}


