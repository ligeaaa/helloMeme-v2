package com.hellomeme.v2.model.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (TagGroup)实体类
 *
 * @author lige
 * @since 2024-01-10 22:21:07
 */
@Data
@TableName("tag_group")
public class TagGroup{
    @TableId
    /**tagGroupId*/
    private Integer id;

    /**tagGroup名字*/    
    private String name;
    

}


