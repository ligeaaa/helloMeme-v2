package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.CommentReply;
import com.hellomeme.v2.service.CommentReplyService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * (CommentReply)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:09
 */
@RestController
@RequestMapping("commentReply")
public class CommentReplyController {

    @Resource
    private CommentReplyService commentReplyService;

    //region 增删改查

    /**
     * 新增数据
     * @param commentReply 实体
     * @return 新增结果
     * @author lige
     * @since 2024-01-10 22:20:09
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody CommentReply commentReply){
        boolean save = commentReplyService.save(commentReply);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:09
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = commentReplyService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param commentReply 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:09
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody CommentReply commentReply){
        boolean update = commentReplyService.updateById(commentReply);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:09
     */
    @GetMapping("/get")
    public BaseResponse<CommentReply> queryById(Long id) {
        CommentReply commentReply = commentReplyService.getById(id);
        return ResultUtils.success(commentReply);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， commentReply 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:09
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<CommentReply>> getPageList(Page<CommentReply> page,@RequestBody CommentReply commentReply){
        Page<CommentReply> pageList = commentReplyService.page(page,new LambdaQueryWrapper<CommentReply>(commentReply));
        return ResultUtils.success(pageList);
    }

    //endregion

}


