package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.Tag;
import com.hellomeme.v2.model.entity.TagGroup;
import com.hellomeme.v2.mapper.TagGroupMapper;
import com.hellomeme.v2.model.vo.tag.TagSummaryVo;
import com.hellomeme.v2.service.TagGroupService;
import com.hellomeme.v2.service.TagService;
import com.hellomeme.v2.utils.BeanUtils;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * (TagGroup)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:21:08
 */
@Service("tagGroupService")
public class TagGroupServiceImpl extends ServiceImpl<TagGroupMapper, TagGroup> implements TagGroupService {
    @Resource
    private TagGroupMapper tagGroupMapper;

    @Resource
    private TagService tagService;

    @Override
    public List<TagSummaryVo> getTags(Long id) {
        //获得对应tagGroupId下的所有tag
        LambdaQueryWrapper<Tag> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Tag::getTagGroupId,id);
        List<Tag> tagList = tagService.list(lambdaQueryWrapper);
        //封装成TagSummaryVo类
        List<TagSummaryVo> tagSummaryVos = new ArrayList<>();
        BeanUtils.copyListBeanProps(tagSummaryVos, tagList, TagSummaryVo.class);

        return tagSummaryVos;
    }

    @Override
    public Map<String, List<TagSummaryVo>> getTagGroupWithTags(Long memeId) {
        Map<String, List<TagSummaryVo>> map = new LinkedHashMap<String, List<TagSummaryVo>>();

        //查询所有tagGroup
        List<TagGroup> tagGroups = list();

        for (TagGroup tagGroup:tagGroups){
            Integer tagGroupId = tagGroup.getId();
            //查询对应meme中的属于对应tagGroup的所有tag
            List<Tag> tags = tagGroupMapper.getTagGroupWithTags(tagGroupId,memeId);
            //封装成TagSummaryVo类
            List<TagSummaryVo> tagSummaryVos = new ArrayList<>();
            BeanUtils.copyListBeanProps(tagSummaryVos, tags, TagSummaryVo.class);
            //存入map
            map.put(tagGroup.getName(),tagSummaryVos);
        }
        //按照tagGroupId排序

        return map;
    }
}

