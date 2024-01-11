package com.hellomeme.v2.controller;

import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import com.hellomeme.v2.exception.BusinessException;
import com.hellomeme.v2.model.entity.Meme;
import com.hellomeme.v2.model.vo.meme.MemeBriefVo;
import com.hellomeme.v2.model.vo.meme.MemeSummaryVo;
import com.hellomeme.v2.service.MemeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.hellomeme.v2.common.ErrorCode.NULL_ERROR;

/**
 * (Meme)表控制层
 *
 * @author lige
 * @since 2023-12-20 15:18:42
 */
@RestController
@RequestMapping("meme")
public class MemeController {
    @Resource
    private MemeService memeService;

    /**
     * 测试专用接口
     * @return String
     * @author lige
     * @since 2023.7.23
     */
    @GetMapping("/test")
    public String test() {
        System.out.println("测试数据库连接和mybatis功能："+memeService.count());
        System.out.println("helloMeme~");
        return "helloMeme";
    }

    /**
     * 上传文件
     * @param files 文件集合
     * @return List<String> file的url队列
     * @author lige
     * @since 2023.7.16
     */
    @PostMapping("/uploadFile")
    public BaseResponse<List<String>> upload(@RequestParam("files") MultipartFile[] files) {
        if (files == null) {
            throw new BusinessException(NULL_ERROR,"上传文件为空");
        }
        return ResultUtils.success(memeService.upload(files));
    }

    /**
     * 根据id修改文件
     * @param meme 要修改的meme
     * @return Boolean 是否修改成功
     * @author lige
     * @since 2023.7.22
     */
    @PostMapping("/update")
    //TODO 不要直接传Meme，建立一个对应的vo类
    public BaseResponse<Boolean> update(@RequestBody Meme meme){
        if (meme.getId() == null) {
            throw new BusinessException(NULL_ERROR,"未传入meme的id");
        }
        return ResultUtils.success(memeService.updateById(meme));
    }

    /**
     * 获得随机meme详情
     * @return MemeSummaryVo meme详情
     * @author lige
     * @since 2023.8.17
     */
    @GetMapping("/get/random/memeSummary")
    public BaseResponse<MemeSummaryVo> getRandomMemeSummary(){
        return  ResultUtils.success(memeService.getRandomMemeSummary());
    }

    /**
     * 获得指定id的meme详情
     * @param memeId meme的id
     * @return MemeSummaryVo meme详情
     * @author lige
     * @since 2023.8.19
     */
    @GetMapping("/get/memeSummary")
    public BaseResponse<MemeSummaryVo> getMemeSummary(Long memeId){

        return ResultUtils.success(memeService.getMemeSummary(memeId));
    }

    /**
     * 获得指定id的meme详情
     * @param memeId meme的id
     * @return MemeSummaryVo meme详情
     * @author lige
     * @since 2023.8.19
     */
    @GetMapping("/get/memeBrief")
    public BaseResponse<MemeBriefVo> getMemeBrief(Long memeId){
        return ResultUtils.success(memeService.getMemeBrief(memeId));
    }

    /**
     * 为指定id的meme添加指定propertyId对应的property的数量
     * @param memeId meme的id
     * @param propertyId 属性名
     * @return boolean 是否成功
     * @author lige
     * @since 2023.8.19
     */
    @PostMapping("/add/property")
    public BaseResponse<Boolean> addProperty(Long memeId, Long propertyId){
        return ResultUtils.success(memeService.addProperty(memeId,propertyId));
    }

}


