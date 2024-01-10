package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.TagGroup;
import com.hellomeme.v2.mapper.TagGroupMapper;
import com.hellomeme.v2.service.TagGroupService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

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

}

