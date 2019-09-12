package com.didispace.config;

import com.didispace.annotation.MyConditionalIAnnotation;


import com.didispace.service.MyConditionalService;


import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConditionalConfig {
    public static Logger logger= Logger.getLogger(MyConditionalService.class);
 
    /**
     * 判断MyConditional 是否符合条件，是则运行MyConditionalService
     * @return
     */
    @MyConditionalIAnnotation(key = "com.example.conditional", value = "lbl")
    @ConditionalOnClass(MyConditionalService.class)
    @Bean
    public MyConditionalService initMyConditionService() {
        logger.info("MyConditionalService已加载。");
        return new MyConditionalService();
    }
}