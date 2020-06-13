package com.songbo.server.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName MybatisPlusConfig
 * @Description TODO
 * @Author songbo
 * @Date 19-9-23 下午12:51
 **/
@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = "com.songbo.server.mapper")
public class MybatisPlusConfig {

    /**
      *@Description TODO 分页
      *@param
      *@return
    **/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
