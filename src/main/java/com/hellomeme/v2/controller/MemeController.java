package com.hellomeme.v2.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellomeme.v2.common.BaseResponse;
import com.hellomeme.v2.common.ResultUtils;
import com.hellomeme.v2.model.entity.Meme;
import com.hellomeme.v2.service.MemeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    //region 增删改查

    /**
     * 新增数据
     * @param meme 实体
     * @return 新增结果
     * @author lige
     * @since 2023-12-20 15:18:42
     **/
    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody Meme meme){
        boolean save = memeService.save(meme);
        return ResultUtils.success(save);
    }
    
     /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     * @author lige
     * @since 2023-12-20 15:18:42
     */
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> deleteById(Long id) {
        boolean delete = memeService.removeById(id);
        return ResultUtils.success(delete);
    }
    
     /**
     * 修改数据
     * @param meme 实体
     * @return Result
     * @author lige
     * @since 2023-12-20 15:18:42
     **/
    @PutMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody Meme meme){
        boolean update = memeService.updateById(meme);
        return ResultUtils.success(update);
    }
    
     /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     * @author lige
     * @since 2023-12-20 15:18:42
     */
    @GetMapping("/get")
    public BaseResponse<Meme> queryById(Long id) {
        Meme meme = memeService.getById(id);
        return ResultUtils.success(meme);
    }
    

    /**
     * 获取分页列表
     * @param page 分页， meme 实体
     * @return Result
     * @author lige
     * @since 2023-12-20 15:18:42
     **/
    @GetMapping("/pageList")
    public BaseResponse<Page<Meme>> getPageList(Page<Meme> page,@RequestBody Meme meme){
        Page<Meme> pageList = memeService.page(page,new LambdaQueryWrapper<Meme>(meme));
        return ResultUtils.success(pageList);
    }

    //endregion

}


