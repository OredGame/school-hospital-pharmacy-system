package com.dxr.hospitalmedicinemanagementsystem.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {
   @Bean
   public MybatisPlusInterceptor mybatisPlusInterceptor() {
      //1.定义mp拦截器
      MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
      //2.添加分页拦截器
      interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
      //3.乐观锁拦截器
      interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
       return interceptor;
   }
}
