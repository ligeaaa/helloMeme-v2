package com.hellomeme.v2.service;

import com.hellomeme.v2.model.entity.Meme;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hellomeme.v2.model.vo.meme.MemeBriefVo;
import com.hellomeme.v2.model.vo.meme.MemeSummaryVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * (Meme)表服务接口
 *
 * @author lige
 * @since 2023-12-20 15:18:42
 */
public interface MemeService extends IService<Meme>{

    /**
     * 上传文件
     * @param files 文件集合
     * @return List<String> file的url队列
     * @author lige
     * 2023.7.16
     */
    List<String> upload(MultipartFile[] files);

    /**
     * 获得随机meme详情
     * @return MemeSummaryVo meme详情
     * @author lige
     * @since 2023.8.17
     */
    MemeSummaryVo getRandomMemeSummary();

    /**
     * 获得指定id的meme详情
     * @param memeId meme的id
     * @return MemeSummaryVo meme详情
     * @author lige
     * @since 2023.8.19
     */
    MemeSummaryVo getMemeSummary(Long memeId);

    /**
     * 为指定id的meme添加指定type的数量
     * @param memeId meme的id
     * @return boolean 是否成功
     * @author lige
     * @since 2023.8.19
     */
    Boolean addProperty(Long memeId, Long property);

    MemeBriefVo getMemeBrief(Long memeId);
}

