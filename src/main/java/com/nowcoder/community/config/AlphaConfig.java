package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

/**
 * @BelongsProject: community
 * @Author: zhangyipeng
 * @CreateTime: 2022-08-18  11:01
 * @Description: TODO
 * @Version: 1.0
 */

@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    }
}