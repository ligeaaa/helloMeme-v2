package com.hellomeme.v2.model.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (Meme)实体类
 *
 * @author lige
 * @since 2023-12-20 15:18:42
 */
@Data
@TableName("meme")
public class Meme{
    @TableId
    /**图片id*/
    private Long id;

    /**图片url*/    
    private String url;
    
    /**删除标记，0表示未删除，1表示删除*/    
    private Integer delFlag;
    
    /**funny的数量*/    
    private Long countFunny;
    
    /**interesting的数量*/    
    private Long countInteresting;
    
    /**boring的数量*/    
    private Long countBoring;
    
    /**创建人的用户id*/    
    private Long createBy;
    
    /**创建时间*/    
    private Date createTime;
    
    /**更新人*/    
    private Long updateBy;
    
    /**更新时间*/    
    private Date updateTime;
    

}


