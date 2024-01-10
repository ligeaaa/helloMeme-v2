package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.Comment;
import com.hellomeme.v2.mapper.CommentMapper;
import com.hellomeme.v2.service.CommentService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * (Comment)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:00
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;

}

