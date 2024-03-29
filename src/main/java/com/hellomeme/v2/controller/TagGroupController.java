package com.hellomeme.v2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.model.entity.TagGroup;
import com.hellomeme.v2.model.vo.tag.TagSummaryVo;
import com.hellomeme.v2.service.TagGroupService;
import org.springframework.web.bind.annotation.*;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import jakarta.annotation.Resource;

import java.util.List;

/**
 * (TagGroup)表控制层
 *
 * @author lige
 * @since 2024-01-10 22:21:08
 */
@RestController
@RequestMapping("tagGroup")
public class TagGroupController {


    @Resource
    private TagGroupService tagGroupService;

    //region 增删改查

    /**
     * 新增数据
     * @param tagGroup 实体
     * @return 新增结果
     * @author lige
     * @since 2023-08-11 15:49:39
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody TagGroup tagGroup){
        boolean save = tagGroupService.save(tagGroup);
        return ResultUtils.success(save);
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2023-08-11 15:49:39
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Integer id) {
        boolean delete = tagGroupService.removeById(id);
        return ResultUtils.success(delete);
    }

    /**
     * 修改数据
     * @param tagGroup 实体
     * @return Result
     * @author lige
     * @since 2023-08-11 15:49:39
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody TagGroup tagGroup){
        boolean update = tagGroupService.updateById(tagGroup);
        return ResultUtils.success(update);
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2023-08-11 15:49:39
     */
    @GetMapping("/get")
    public BaseResponse<TagGroup> queryById(Integer id) {
        TagGroup tagGroup = tagGroupService.getById(id);
        return ResultUtils.success(tagGroup);
    }


    /**
     * 获取分页列表
     * @param page 分页， tagGroup 实体
     * @return Result
     * @author lige
     * @since 2023-08-11 15:49:39
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<TagGroup>> getPageList(Page<TagGroup> page,@RequestBody TagGroup tagGroup){
        Page<TagGroup> pageList = tagGroupService.page(page,new LambdaQueryWrapper<TagGroup>(tagGroup));
        return ResultUtils.success(pageList);
    }

    //endregion

    /**
     * 获取全部tagGroup
     * @return Result
     * @author lige
     * @since 2023-08-17
     **/
    @GetMapping("/get/list")
    public BaseResponse<List<TagGroup>> getList(){
        return ResultUtils.success(tagGroupService.list());
    }

    /**
     * 获取对应tagGroup中的所有tag
     * @param id tagGroup的id
     * @return Result
     * @author lige
     * @since 2023-08-17
     **/
    @GetMapping("/get/tags")
    public BaseResponse<List<TagSummaryVo>> getTags(Long id){
        return ResultUtils.success(tagGroupService.getTags(id));
    }
}


