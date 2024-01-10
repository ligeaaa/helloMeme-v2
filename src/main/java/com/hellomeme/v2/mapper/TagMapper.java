package com.hellomeme.v2.mapper;

import com.hellomeme.v2.model.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


/**
 * (Tag)表数据库访问层
 *
 * @author lige
 * @since 2024-01-10 22:06:43
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag>{

}


