package com.hellomeme.v2.mapper;

import com.hellomeme.v2.model.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


/**
 * (Comment)表数据库访问层
 *
 * @author lige
 * @since 2024-01-10 22:19:59
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment>{

}


