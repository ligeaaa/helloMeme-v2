package com.hellomeme.v2.mapper;

import com.hellomeme.v2.model.entity.Meme;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


/**
 * (Meme)表数据库访问层
 *
 * @author lige
 * @since 2023-12-20 15:18:42
 */
@Mapper
public interface MemeMapper extends BaseMapper<Meme>{

}


