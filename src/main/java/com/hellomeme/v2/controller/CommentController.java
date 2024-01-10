package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.Comment;
import com.hellomeme.v2.service.CommentService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * (Comment)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:00
 */
@RestController
@RequestMapping("comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    //region 增删改查

    /**
     * 新增数据
     * @param comment 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:20:00
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody Comment comment){
        boolean save = commentService.save(comment);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:00
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = commentService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param comment 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:00
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody Comment comment){
        boolean update = commentService.updateById(comment);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:00
     */
    @GetMapping("/get")
    public BaseResponse<Comment> queryById(Long id) {
        Comment comment = commentService.getById(id);
        return ResultUtils.success(comment);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， comment 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:00
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<Comment>> getPageList(Page<Comment> page,@RequestBody Comment comment){
        Page<Comment> pageList = commentService.page(page,new LambdaQueryWrapper<Comment>(comment));
        return ResultUtils.success(pageList);
    }

    //endregion

}


