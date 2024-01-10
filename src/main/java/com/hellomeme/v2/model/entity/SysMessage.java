package com.hellomeme.v2.model.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (SysMessage)实体类
 *
 * @author lige
 * @since 2024-01-10 22:20:43
 */
@Data
@TableName("sys_message")
public class SysMessage{
    @TableId
    
    private Long messageId;

    /**message内容*/    
    private String content;
    
    /**附带内容*/    
    private String data;
    
    /**topic（对应rocketMQ中的topic）*/    
    private String topic;
    
    /**接收者id，没有则为-1*/    
    private Long receiverId;
    
    /**发送者id，系统为-1*/    
    private Long senderId;
    
    /**创建时间*/    
    private Date createTime;
    
    /**临时数据*/    
    private String tmpdata;
    

}


