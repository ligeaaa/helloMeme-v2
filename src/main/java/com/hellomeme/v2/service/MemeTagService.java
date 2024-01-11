package com.hellomeme.v2.service;

import com.hellomeme.v2.model.entity.MemeTag;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (MemeTag)表服务接口
 *
 * @author lige
 * @since 2024-01-10 22:20:25
 */
public interface MemeTagService extends IService<MemeTag>{
    /**
     * 删除对应tagId和memeId的关联记录
     * @param tagId tagId,
     * @param memeId memId
     * @return 删除是否成功
     * @author lige
     * @since 2023-08-17 16:25:30
     */
    Boolean deleteMemeTag(Long tagId, Long memeId);
}

