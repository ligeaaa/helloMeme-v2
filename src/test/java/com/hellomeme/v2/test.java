package com.hellomeme.v2;


import com.hellomeme.v2.controller.MemeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test {


    @Autowired
    private MemeController memeController;

    //测试数据库是否成功连接，以及基本的调用是否成功
    @Test
    public void testGetTagGroupWithTags(){
        System.out.println(memeController.queryById(3L));
        System.out.println("123");
    }

}
