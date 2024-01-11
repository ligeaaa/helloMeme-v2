package com.hellomeme.v2.model.vo.messageVo;


import com.hellomeme.v2.model.entity.Meme;
import com.hellomeme.v2.model.entity.SysMessage;
import lombok.Data;
/**
 * MemeMessageVo
 * @author lige
 * @since 2023-08-24
 */
@Data
public class MemeMessageVo{

    /**消息*/
    private SysMessage message;

    /**meme*/
    private Meme meme;

}
