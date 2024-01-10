package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.SysRoleMenu;
import com.hellomeme.v2.mapper.SysRoleMenuMapper;
import com.hellomeme.v2.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * (SysRoleMenu)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:52
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

}

