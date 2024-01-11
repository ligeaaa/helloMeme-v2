package com.hellomeme.v2.service;

import com.hellomeme.v2.model.entity.TagGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hellomeme.v2.model.vo.tag.TagSummaryVo;

import java.util.List;
import java.util.Map;

/**
 * (TagGroup)表服务接口
 *
 * @author lige
 * @since 2024-01-10 22:21:08
 */
public interface TagGroupService extends IService<TagGroup>{

    /**
     * 获得对应id的tagGroup下的所有tag
     * @param id tagGroup的id
     * @return list形式的tag
     * @author lige
     * @since 2023-08-17
     */
    List<TagSummaryVo> getTags(Long id);


    /**
     * 以map形式返回对应meme的所有tags
     * @param memeId meme的id
     * @return 对应meme的所有tags
     * @author lige
     * @since 2023-08-17
     */
    Map<String, List<TagSummaryVo>> getTagGroupWithTags(Long memeId);
}

