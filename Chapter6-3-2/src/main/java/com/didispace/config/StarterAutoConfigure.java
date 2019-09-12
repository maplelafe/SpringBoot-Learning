package com.didispace.config;

import com.didispace.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConditionalOnClass StarterService在IOC中加载StarterAutoConfigure中的Bean
 * EnableConfigurationProperties加载properties文件内容
 *
 * @ConditionalOnBean，仅在当前上下文中存在某个bean时，才会实例化这个Bean。
 @ConditionalOnClass，某个class位于类路径上，才会实例化这个Bean。
 @ConditionalOnExpression，当表达式为true的时候，才会实例化这个Bean。
 @ConditionalOnMissingBean，仅在当前上下文中不存在某个bean时，才会实例化这个Bean。
 @ConditionalOnMissingClass，某个class在类路径上不存在的时候，才会实例化这个Bean。
 @ConditionalOnNotWebApplication，不是web应用时才会实例化这个Bean。
 @AutoConfigureAfter，在某个bean完成自动配置后实例化这个bean。
 @AutoConfigureBefore，在某个bean完成自动配置前实例化这个bean。
 */
@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "example.service", value = "enabled", havingValue = "true")
    StarterService starterService (){
        return new StarterService(properties.getConfig());
    }

}