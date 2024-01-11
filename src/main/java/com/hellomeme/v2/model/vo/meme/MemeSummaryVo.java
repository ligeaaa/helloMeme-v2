package com.hellomeme.v2.model.vo.meme;


import com.hellomeme.v2.model.vo.tag.TagSummaryVo;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Meme信息具化版
 * @author lige
 * @since 2023-08-17
 */
@Data
public class MemeSummaryVo {

    /**memeId*/
    private Long id;

    /**meme图片url*/
    private String url;

    /**meme创建人的用户id*/
    private Long createBy;

    /**meme创建时间*/
    private Date createTime;

    /**tagGroup和其对应的所有tag*/
    private Map<String, List<TagSummaryVo>> tags;

}
