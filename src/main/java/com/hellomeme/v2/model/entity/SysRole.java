package com.hellomeme.v2.model.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 角色表(SysRole)实体类
 *
 * @author lige
 * @since 2024-01-10 22:20:47
 */
@Data
@TableName("sys_role")
public class SysRole{
    @TableId
    
    private Long id;

        
    private String name;
    
    /**角色权限字符串*/    
    private String roleKey;
    
    /**角色状态（0正常 1停用）*/    
    private String status;
    
    /**del_flag*/    
    private Integer delFlag;
    
        
    private Long createBy;
    
        
    private Date createTime;
    
        
    private Long updateBy;
    
        
    private Date updateTime;
    
    /**备注*/    
    private String remark;
    

}


