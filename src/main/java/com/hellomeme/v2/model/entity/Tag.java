package com.hellomeme.v2.model.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (Tag)实体类
 *
 * @author lige
 * @since 2024-01-10 22:06:43
 */
@Data
@TableName("tag")
public class Tag{
    @TableId
    /**tagId*/
    private Long id;

    /**tag的名字*/    
    private String tagName;
    
    /**被使用的数量*/    
    private Long tagCount;
    
    /**tagGroupId*/    
    private Integer tagGroupId;
    
    /**删除标记，0表示未删除，1表示删除*/    
    private Integer delFlag;
    
    /**审核状态（0表示审核未通过，1表示审核通过，默认为0）*/    
    private Integer checkStatus;
    
    /**创建人的用户id*/    
    private Long createBy;
    
    /**创建时间*/    
    private Date createTime;
    
    /**更新人*/    
    private Long updateBy;
    
    /**更新时间*/    
    private Date updateTime;
    

}


