package com.hellomeme.v2.model.vo.meme;

import lombok.Data;

import java.util.Date;

/**
 * Meme信息简化版
 *
 * @author lige
 * @since 2023-08-24
 */
@Data
public class MemeBriefVo {

    /**图片id*/
    private Long id;

    /**图片url*/
    private String url;

    /**创建人的用户id*/
    private Long createBy;

    /**创建时间*/
    private Date createTime;

    /**funny的数量*/
    private Long countFunny;

    /**interesting的数量*/
    private Long countInteresting;

    /**boring的数量*/
    private Long countBoring;
}
