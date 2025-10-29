package com.dxr.hospitalmedicinemanagementsystem.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

public class Generator {
    public static void main(String[] args) {
        // 数据源配置
        String url = "jdbc:mysql:///school_hospital_pharmacy?serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        String packageName = "com.dxr.hospitalmedicinemanagementsystem";

        // 获取项目根目录（自动适配当前环境）
        String projectPath = System.getProperty("user.dir");

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("dxr") // 作者
                            // 代码输出到项目的 java 目录（自动拼接路径）
                            .outputDir(projectPath + "/src/main/java")
                            .disableOpenDir() // 生成后不打开文件夹
                            .commentDate("yyyy-MM-dd"); // 注释日期格式
                    // 如需 Swagger，确保项目已引入依赖，否则注释掉下面一行
                    // .enableSwagger()
                })
                .packageConfig(builder -> {
                    builder.parent(packageName) // 父包名
                            .entity("entity")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            // mapper.xml 输出到 resources/mapper 目录（符合 Maven 规范）
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    projectPath + "/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user", "medicine", "inventory", "sale_order", "sale_item") // 要生成的表
                            .entityBuilder()
                            .enableLombok() // 启用 Lombok
                            .enableTableFieldAnnotation() // 字段添加 @TableField 注解
                            .versionColumnName("version") // 乐观锁字段
                            .logicDeleteColumnName("deleted") // 逻辑删除字段
                            .controllerBuilder()
                            .enableRestStyle() // 生成 @RestController
                            .mapperBuilder()
                            .enableBaseResultMap() // 生成基础 ResultMap
                            .enableBaseColumnList(); // 生成基础 ColumnList
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用 Velocity 模板
                .execute();
    }
}