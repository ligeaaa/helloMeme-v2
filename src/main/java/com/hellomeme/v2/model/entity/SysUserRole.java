package com.hellomeme.v2.model.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (SysUserRole)实体类
 *
 * @author lige
 * @since 2024-01-10 22:21:02
 */
@Data
@TableName("sys_user_role")
public class SysUserRole{

    /**用户id*/
    private Long userId;

    /**角色id*/
    private Long roleId;


}


