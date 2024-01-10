package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.Tag;
import com.hellomeme.v2.mapper.TagMapper;
import com.hellomeme.v2.service.TagService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * (Tag)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:06:43
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Resource
    private TagMapper tagMapper;

}

