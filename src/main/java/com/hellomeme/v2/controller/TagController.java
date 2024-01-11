package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.Tag;
import com.hellomeme.v2.service.TagService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

/**
 * (Tag)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:06:43
 */
@RestController
@RequestMapping("tag")
public class TagController {
    @Resource
    private TagService tagService;

    //region 增删改查

    /**
     * 新增数据
     * @param tag 实体
     * @return 新增结果
     * @author lige
     * @since 2023-08-08 22:21:19
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody Tag tag){
        boolean save = tagService.save(tag);
        return ResultUtils.success(save);
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2023-08-08 22:21:19
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = tagService.removeById(id);
        return ResultUtils.success(delete);
    }

    /**
     * 修改数据
     * @param tag 实体
     * @return Result
     * @author lige
     * @since 2023-08-08 22:21:19
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody Tag tag){
        boolean update = tagService.updateById(tag);
        return ResultUtils.success(update);
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2023-08-08 22:21:19
     */
    @GetMapping("/get")
    public BaseResponse<Tag> queryById(Long id) {
        Tag tag = tagService.getById(id);
        return ResultUtils.success(tag);
    }


    /**
     * 获取分页列表
     * @param page 分页， tag 实体
     * @return Result
     * @author lige
     * @since 2023-08-08 22:21:19
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<Tag>> getPageList(Page<Tag> page,Tag tag){
        Page<Tag> pageList = tagService.page(page,new LambdaQueryWrapper<Tag>(tag));
        return ResultUtils.success(pageList);
    }

    //endregion

}


