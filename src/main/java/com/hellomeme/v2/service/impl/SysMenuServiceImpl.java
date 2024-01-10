package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.model.entity.SysMenu;
import com.hellomeme.v2.mapper.SysMenuMapper;
import com.hellomeme.v2.service.SysMenuService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * 菜单表(SysMenu)表服务实现类
 *
 * @author lige
 * @since 2024-01-10 22:20:38
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

}

