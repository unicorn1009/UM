package com.unicorn.um.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("unicorn");
        gc.setOpen(false);   // 生成后是否打开文件夹
        gc.setFileOverride(true);    // 生成代码时是否覆盖已有文件
        gc.setIdType(IdType.AUTO); // 选择主键策略
        gc.setDateType(DateType.ONLY_DATE); // 生成实体中的时间类型，默认为LocalDateTime，设置该值后则改为Date类型
//         gc.setSwagger2(true);      // 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/ume?serverTimezone=GMT%2B8&useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.unicorn");
        pc.setModuleName(scanner("模块名"));
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
//        // 覆盖已生成代码
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        cfg.setFileCreate((configBuilder, fileType, filePath) -> {
//            //如果是Entity则直接返回true表示写文件
//            if (fileType == FileType.ENTITY) {
//                return true;
//            }
//            //否则先判断文件是否存在
//            File file = new File(filePath);
//            boolean exist = file.exists();
//            if (!exist) {
//                file.getParentFile().mkdirs();
//            }
//            //文件不存在或者全局配置的fileOverride为true才写文件
//            return !exist || configBuilder.getGlobalConfig().isFileOverride();
//        });



        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";
        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
//        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
        //生成策略的配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //生成指定表
        strategyConfig.setInclude(new String[]{"common_user"});
        //可变参数用数组，最好再模板里把它注释掉
        //        strategyConfig.setTablePrefix(new String[]{""});
        //驼峰命名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //字段驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //设置实体Bean的lombok
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setTablePrefix("common_");

        //设置生成策略
        mpg.setStrategy(strategyConfig);

        //执行自动生成器
        mpg.execute();
    }
}
