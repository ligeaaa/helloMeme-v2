package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.SysRole;
import com.hellomeme.v2.mapper.SysRoleMapper;
import com.hellomeme.v2.service.SysRoleService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * 角色表(SysRole)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:48
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}

