package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.SysMessage;
import com.hellomeme.v2.mapper.SysMessageMapper;
import com.hellomeme.v2.service.SysMessageService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * (SysMessage)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:43
 */
@Service("sysMessageService")
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements SysMessageService {
    @Resource
    private SysMessageMapper sysMessageMapper;

}

