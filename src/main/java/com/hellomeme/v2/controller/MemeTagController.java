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
     * @since 2024-01-10 22:20:26
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody MemeTag memeTag){
        boolean save = memeTagService.save(memeTag);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2024-01-10 22:20:26
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = memeTagService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param memeTag 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:26
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody MemeTag memeTag){
        boolean update = memeTagService.updateById(memeTag);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2024-01-10 22:20:26
     */
    @GetMapping("/get")
    public BaseResponse<MemeTag> queryById(Long id) {
        MemeTag memeTag = memeTagService.getById(id);
        return ResultUtils.success(memeTag);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， memeTag 实体
     * @return Result
     * @author lige
     * @since 2024-01-10 22:20:26
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<MemeTag>> getPageList(Page<MemeTag> page,@RequestBody MemeTag memeTag){
        Page<MemeTag> pageList = memeTagService.page(page,new LambdaQueryWrapper<MemeTag>(memeTag));
        return ResultUtils.success(pageList);
    }

    //endregion

}


