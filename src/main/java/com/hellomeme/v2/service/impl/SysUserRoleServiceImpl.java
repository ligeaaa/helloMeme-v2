package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.SysUserRole;
import com.hellomeme.v2.mapper.SysUserRoleMapper;
import com.hellomeme.v2.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * (SysUserRole)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:21:02
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

}

