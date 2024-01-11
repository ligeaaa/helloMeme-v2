package com.hellomeme.v2.config;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 把配置文件中的配置信息读取到该类中.
 */
@Data
@Configuration
public class OssConfiguration {
    @Value("${endpoint}")
    private String endPoint;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessKeySecret}")
    private String accessKeySecret;
    @Value("${filehost}")
    private String fileHost;
    @Value("${bucketName}")
    private String bucketName;
}