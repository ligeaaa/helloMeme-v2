package com.hellomeme.v2.model.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 菜单表(SysMenu)实体类
 *
 * @author lige
 * @since 2024-01-10 22:20:37
 */
@Data
@TableName("sys_menu")
public class SysMenu{
    @TableId
    
    private Long id;

    /**菜单名*/    
    private String menuName;
    
    /**路由地址*/    
    private String path;
    
    /**组件路径*/    
    private String component;
    
    /**菜单状态（0显示 1隐藏）*/    
    private String visible;
    
    /**菜单状态（0正常 1停用）*/    
    private String status;
    
    /**权限标识*/    
    private String perms;
    
    /**菜单图标*/    
    private String icon;
    
        
    private Long createBy;
    
        
    private Date createTime;
    
        
    private Long updateBy;
    
        
    private Date updateTime;
    
    /**是否删除（0未删除 1已删除）*/    
    private Integer delFlag;
    
    /**备注*/    
    private String remark;
    

}


