package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.ConstantAvatar;
import com.hellomeme.v2.service.ConstantAvatarService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * 一些常量(ConstantAvatar)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:19
 */
@RestController
@RequestMapping("constantAvatar")
public class ConstantAvatarController {

    @Resource
    private ConstantAvatarService constantAvatarService;

    //region 增删改查

    /**
     * 新增数据
     * @param constantAvatar 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:20:19
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody ConstantAvatar constantAvatar){
        boolean save = constantAvatarService.save(constantAvatar);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:19
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Integer id) {
        boolean delete = constantAvatarService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param constantAvatar 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:19
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody ConstantAvatar constantAvatar){
        boolean update = constantAvatarService.updateById(constantAvatar);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:19
     */
    @GetMapping("/get")
    public BaseResponse<ConstantAvatar> queryById(Integer id) {
        ConstantAvatar constantAvatar = constantAvatarService.getById(id);
        return ResultUtils.success(constantAvatar);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， constantAvatar 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:19
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<ConstantAvatar>> getPageList(Page<ConstantAvatar> page,@RequestBody ConstantAvatar constantAvatar){
        Page<ConstantAvatar> pageList = constantAvatarService.page(page,new LambdaQueryWrapper<ConstantAvatar>(constantAvatar));
        return ResultUtils.success(pageList);
    }

    //endregion

}


