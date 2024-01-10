package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.ConstantAvatar;
import com.hellomeme.v2.mapper.ConstantAvatarMapper;
import com.hellomeme.v2.service.ConstantAvatarService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * 一些常量(ConstantAvatar)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:19
 */
@Service("constantAvatarService")
public class ConstantAvatarServiceImpl extends ServiceImpl<ConstantAvatarMapper, ConstantAvatar> implements ConstantAvatarService {
    @Resource
    private ConstantAvatarMapper constantAvatarMapper;

}

