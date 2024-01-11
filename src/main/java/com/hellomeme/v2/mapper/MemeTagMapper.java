package com.hellomeme.v2.mapper;

import com.hellomeme.v2.model.entity.MemeTag;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


/**
 * (MemeTag)表数据库访问层
 *
 * @author lige
 * @since 2024-01-10 22:20:25
 */
@Mapper
public interface MemeTagMapper extends BaseMapper<MemeTag>{

    Boolean deleteMemeTag(@Param("tagId") Long tagId, @Param("memeId") Long memeId);
}


