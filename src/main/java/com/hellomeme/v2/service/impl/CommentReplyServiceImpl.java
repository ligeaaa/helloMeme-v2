package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.CommentReply;
import com.hellomeme.v2.mapper.CommentReplyMapper;
import com.hellomeme.v2.service.CommentReplyService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * (CommentReply)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:09
 */
@Service("commentReplyService")
public class CommentReplyServiceImpl extends ServiceImpl<CommentReplyMapper, CommentReply> implements CommentReplyService {
    @Resource
    private CommentReplyMapper commentReplyMapper;

}

