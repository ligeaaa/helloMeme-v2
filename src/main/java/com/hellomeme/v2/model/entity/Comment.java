package com.hellomeme.v2.model.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (Comment)实体类
 *
 * @author lige
 * @since 2024-01-10 22:19:59
 */
@Data
@TableName("comment")
public class Comment{
    @TableId
    /**评论id*/
    private Long commentId;

    /**回复的图片id*/    
    private Long memeId;
    
    /**发送者id*/    
    private Long senderId;
    
    /**被回复者id*/    
    private Long receiverId;
    
    /**评论内容*/    
    private String content;
    
    /**0待审核，1通过，2不通过*/    
    private Integer checkState;
    
    /**点赞数*/    
    private Long praseCount;
    
    /**删除标记，默认为0，1为删除*/    
    private String delFlag;
    
    /**创建时间*/    
    private Date createTime;
    
    /**更新时间*/    
    private Date updateTime;
    

}


