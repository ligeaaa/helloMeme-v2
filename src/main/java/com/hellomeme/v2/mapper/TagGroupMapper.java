package com.hellomeme.v2.mapper;

import com.hellomeme.v2.model.entity.Tag;
import com.hellomeme.v2.model.entity.TagGroup;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (TagGroup)表数据库访问层
 *
 * @author lige
 * @since 2024-01-10 22:21:07
 */
@Mapper
public interface TagGroupMapper extends BaseMapper<TagGroup>{
    /**
     * 根据传入的memeId和tagGroupId查询对应meme中对应tagGroup的tag列表
     * @param tagGroupId tagGroup的id
     * @param memeId meme的id
     * @return Tag形式的list
     * @author lige
     * @since 2023-08-17
     */
    List<Tag> getTagGroupWithTags(@Param("tagGroupId") Integer tagGroupId, @Param("memeId") Long memeId);
}


