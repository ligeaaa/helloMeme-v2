package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.SysUser;
import com.hellomeme.v2.mapper.SysUserMapper;
import com.hellomeme.v2.service.SysUserService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * (SysUser)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:58
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

}

