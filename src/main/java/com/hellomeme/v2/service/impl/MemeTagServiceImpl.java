package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.MemeTag;
import com.hellomeme.v2.mapper.MemeTagMapper;
import com.hellomeme.v2.service.MemeTagService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * (MemeTag)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:26
 */
@Service("memeTagService")
public class MemeTagServiceImpl extends ServiceImpl<MemeTagMapper, MemeTag> implements MemeTagService {
    @Resource
    private MemeTagMapper memeTagMapper;

}

