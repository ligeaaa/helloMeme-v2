package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.Meme;
import com.hellomeme.v2.mapper.MemeMapper;
import com.hellomeme.v2.service.MemeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * (Meme)表服务实现类
 *
 * @author lige
 * @since 2023-12-20 15:18:42
 */
@Service("memeService")
public class MemeServiceImpl extends ServiceImpl<MemeMapper, Meme> implements MemeService {
    @Resource
    private MemeMapper memeMapper;

}

