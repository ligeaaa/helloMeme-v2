package com.hellomeme.v2.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.hellomeme.v2.config.OssConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 封装文件上传方法
 */
@Component
public class AliyunOssUtil {
    @Autowired
    private OssConfiguration config;

    /**
     * 上传文件
     * @param file 文件
     * @return url
     */
    public String upload(File file) {
        if (file == null) {
            return null;
        }
        String endPoint = config.getEndPoint();
        String keyId = config.getAccessKeyId();
        String keySecret = config.getAccessKeySecret();
        String bucketName = config.getBucketName();
        String fileHost = config.getFileHost();
        
        //定义子文件的格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        //阿里云文件上传客户端
        OSSClient client = new OSSClient(endPoint, keyId, keySecret);
        try {
            //判断桶是否存在
            if (!client.doesBucketExist(bucketName)) {
                //创建桶
                client.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                //设置访问权限为公共读
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                //发起创建桶的请求
                client.createBucket(createBucketRequest);
            }
            //当桶存在时,进行文件上传
            //设置文件路径和名称
            String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", ""));
            PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            //文件上传成功后,返回当前文件的路径
            if (result != null) {
                return fileUrl;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
        return null;
    }
}