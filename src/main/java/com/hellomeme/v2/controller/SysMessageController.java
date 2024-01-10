package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.SysMessage;
import com.hellomeme.v2.service.SysMessageService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * (SysMessage)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:43
 */
@RestController
@RequestMapping("sysMessage")
public class SysMessageController {

    @Resource
    private SysMessageService sysMessageService;

    //region 增删改查

    /**
     * 新增数据
     * @param sysMessage 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:20:43
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody SysMessage sysMessage){
        boolean save = sysMessageService.save(sysMessage);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:43
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = sysMessageService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param sysMessage 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:43
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody SysMessage sysMessage){
        boolean update = sysMessageService.updateById(sysMessage);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:43
     */
    @GetMapping("/get")
    public BaseResponse<SysMessage> queryById(Long id) {
        SysMessage sysMessage = sysMessageService.getById(id);
        return ResultUtils.success(sysMessage);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， sysMessage 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:43
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<SysMessage>> getPageList(Page<SysMessage> page,@RequestBody SysMessage sysMessage){
        Page<SysMessage> pageList = sysMessageService.page(page,new LambdaQueryWrapper<SysMessage>(sysMessage));
        return ResultUtils.success(pageList);
    }

    //endregion

}


