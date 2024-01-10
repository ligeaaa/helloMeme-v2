package com.hellomeme.v2.model.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (SysUser)实体类
 *
 * @author lige
 * @since 2024-01-10 22:20:58
 */
@Data
@TableName("sys_user")
public class SysUser{
    @TableId
    /**主键*/
    private Long id;

    /**用户姓名*/    
    private String userName;
    
    /**昵称*/    
    private String nickName;
    
    /**密码*/    
    private String password;
    
    /**邮箱*/    
    private String email;
    
    /**手机号*/    
    private String phonenumber;
    
    /**用户性别（0男，1女，2未知）*/    
    private String sex;
    
    /**头像*/    
    private String avatar;
    
    /**账号状态（0正常 1停用）*/    
    private String status;
    
    /**删除标记，0表示未删除，1表示删除*/    
    private Integer delFlag;
    
    /**创建时间*/    
    private Date createTime;
    
    /**更新时间*/    
    private Date updateTime;
    

}


