package com.kg.ssm.simple.util.mbg;

import com.google.common.collect.Lists;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * MyBatis Generator 自动生成xml文件
 */
public class MBG {
    public static void main(String[] args) {

        List<String> warnings = Lists.newArrayList();
        boolean overwrite = true;
        File file = new File("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration conf;

        try {
            conf = cp.parseConfiguration(file);
            DefaultShellCallback dsc = new DefaultShellCallback(overwrite);
            MyBatisGenerator mbg = new MyBatisGenerator(conf, dsc, warnings);
            mbg.generate(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
