package com.hellomeme.v2.model.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 一些常量(ConstantAvatar)实体类
 *
 * @author lige
 * @since 2024-01-10 22:20:18
 */
@Data
@TableName("constant_avatar")
public class ConstantAvatar{
    @TableId
    
    private Integer id;

    /**内容*/    
    private String data;
    
    /**描述*/    
    private String description;
    

}


