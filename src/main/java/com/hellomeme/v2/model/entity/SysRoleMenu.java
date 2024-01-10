package com.hellomeme.v2.model.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (SysRoleMenu)实体类
 *
 * @author lige
 * @since 2024-01-10 22:20:52
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenu{

    /**角色ID*/
    private Long roleId;

    /**菜单id*/
    private Long menuId;


}


