package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.MemeTag;
import com.hellomeme.v2.service.MemeTagService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * (MemeTag)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:20:26
 */
@RestController
@RequestMapping("memeTag")
public class MemeTagController {

    @Resource
    private MemeTagService memeTagService;

    //region 增删改查

    /**
     * 新增数据
     * @param memeTag 实体
     * @return 新增结果
     * @author lige
     * @since 2023-08-17 16:25:30
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody MemeTag memeTag){
        //TODO 获取用户信息
        //User user = userService.getDetail();
        //memeTag.setCreateBy(user.getId());
        memeTag.setCreateBy(-1L);
        //TODO 判断是否已经存在meme-tag对应关系，若有应报错
        boolean save = memeTagService.save(memeTag);
        return ResultUtils.success(save);
    }

    //TODO tag添加功能的完善（例如审核等）

    /**
     * 删除对应tagid和memeid的关联记录
     * @param memeTag 实体
     * @return 删除是否成功
     * @author lige
     * @since 2023-08-17 16:25:30
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteMemeTag(@RequestBody MemeTag memeTag) {
        return ResultUtils.success(memeTagService.deleteMemeTag(memeTag.getTagId(), memeTag.getMemeId()));
    }

    //endregion

}


