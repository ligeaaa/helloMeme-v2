package com.hellomeme.v2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellomeme.v2.constants.MemePropertyConstant;
import com.hellomeme.v2.model.entity.Meme;
import com.hellomeme.v2.mapper.MemeMapper;
import com.hellomeme.v2.model.vo.meme.MemeBriefVo;
import com.hellomeme.v2.model.vo.meme.MemeSummaryVo;
import com.hellomeme.v2.model.vo.tag.TagSummaryVo;
import com.hellomeme.v2.service.MemeService;
import com.hellomeme.v2.service.TagGroupService;
import com.hellomeme.v2.utils.AliyunOssUtil;
import com.hellomeme.v2.utils.BeanUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * (Meme)表服务实现类
 *
 * @author lige
 * @since 2023-12-20 15:18:42
 */
@Service("memeService")
public class MemeServiceImpl extends ServiceImpl<MemeMapper, Meme> implements MemeService {

    @Autowired
    private AliyunOssUtil ossUtil;

    @Resource
    private MemeMapper memeMapper;

//    @Resource
//    private UserService userService;

    @Resource
    private TagGroupService tagGroupService;


    @Override
    public List<String> upload(MultipartFile[] files) {

        //TODO 获取当前用户
        //User user = userService.getDetail();

        //TODO 消息队列处理

        List<String> urls = new ArrayList<>();

        for (MultipartFile file:files){
            try {
                String fileName = file.getOriginalFilename();
                if (!"".equals(fileName.trim())) {
                    File newFile = new File(fileName);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    //把file里的内容复制到newFile中
                    file.transferTo(newFile);
                    String upload = ossUtil.upload(newFile);
                    //删除文件
                    newFile.delete();
                    //将url存到数据库中
                    Meme meme = new Meme();
                    meme.setUrl(upload);
                    //TODO 将当前用户id存入
                    //meme.setCreateBy(user.getId());
                    meme.setCreateBy(-1L);
                    save(meme);

                    urls.add(upload);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return urls;
    }

    @Override
    public MemeSummaryVo getRandomMemeSummary() {

        MemeSummaryVo memeSummaryVo = new MemeSummaryVo();

        //获得随机id
        Long id = null;
        //TODO 优化，不够随机，且有bug，怀疑与random有关
        while (true){
            id = memeMapper.getRandomId();
            if (id != null){
                break;
            }
        }
        return getMemeSummary(id);
    }

    @Override
    public MemeSummaryVo getMemeSummary(Long memeId) {
        MemeSummaryVo memeSummaryVo = new MemeSummaryVo();
        //获得对应的meme并存入Vo类
        Meme meme = getById(memeId);
        BeanUtils.copyBeanProp(memeSummaryVo,meme);
        //获得对应的Map<TagGroup, List<TagSummaryVo>>
        Map<String, List<TagSummaryVo>> tags = tagGroupService.getTagGroupWithTags(memeId);
        memeSummaryVo.setTags(tags);
        return memeSummaryVo;
    }

    @Override
    public Boolean addProperty(Long memeId, Long property) {

        Meme meme = getById(memeId);
        //TODO 获取当前用户
        //User user = userService.getDetail();

        if (property.equals(MemePropertyConstant.FUNNY.getPropertyId())) {
            Long countFunny = meme.getCountFunny();
            meme.setCountFunny(++countFunny);
            updateById(meme);
        }
        if (property.equals(MemePropertyConstant.INTERESTING.getPropertyId())) {
            Long countInteresting = meme.getCountInteresting();
            meme.setCountInteresting(++countInteresting);
            updateById(meme);
        }
        if (property.equals(MemePropertyConstant.BORING.getPropertyId())) {
            Long countBoring = meme.getCountBoring();
            meme.setCountBoring(++countBoring);
            updateById(meme);
        }

        //TODO 消息队列处理

        return true;
    }

    @Override
    public MemeBriefVo getMemeBrief(Long memeId) {
        MemeBriefVo memeBriefVo = new MemeBriefVo();
        Meme meme = getById(memeId);
        BeanUtils.copyBeanProp(memeBriefVo, meme);
        return memeBriefVo;
    }

}

