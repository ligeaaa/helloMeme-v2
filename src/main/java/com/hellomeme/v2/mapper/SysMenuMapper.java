package com.hellomeme.v2.mapper;

import com.hellomeme.v2.model.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


/**
 * 菜单表(SysMenu)表数据库访问层
 *
 * @author lige
 * @since 2024-01-10 22:20:37
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu>{

}


