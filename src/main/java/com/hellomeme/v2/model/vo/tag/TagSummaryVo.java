package com.hellomeme.v2.model.vo.tag;

import lombok.Data;

/**
 * TagSummaryVo
 * @author lige
 * @since 2023-08-17
 */
@Data
public class TagSummaryVo {

    /**tagId*/
    private Long id;

    /**tag的名字*/
    private String tagName;

    /**被使用的数量*/
    private Long tagCount;

}
