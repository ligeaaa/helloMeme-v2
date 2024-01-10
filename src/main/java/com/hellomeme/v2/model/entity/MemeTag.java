package com.hellomeme.v2.model.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (MemeTag)实体类
 *
 * @author lige
 * @since 2024-01-10 22:20:24
 */
@Data
@TableName("meme_tag")
public class MemeTag{

    /**memeId*/
    private Long memeId;

    /**tagId*/
    private Long tagId;

    /**创建人的用户id*/    
    private Long createBy;
    
    /**创建时间*/    
    private Date createTime;
    

}


