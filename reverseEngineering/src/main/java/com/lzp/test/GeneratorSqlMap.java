package com.lzp.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
/**
 * 可以创建专门的逆向工程类来实现自动生成文件（配置文件的配置要求较低）
 * 也可以是直接使用generator的插件直接生成文件 （需要修改xml的配置文件，配置要求较高）
 */

public class GeneratorSqlMap {
    public  void  generator () throws Exception{
        ArrayList<String> warnings = new ArrayList<>();
        boolean overwrite=true;

        File configFile = new File("src/main/resources/generatorConfig.xml");//绝对路径和相对路径都能实现

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) {
        try {
            GeneratorSqlMap generatorSqlMap=new GeneratorSqlMap();
            generatorSqlMap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

