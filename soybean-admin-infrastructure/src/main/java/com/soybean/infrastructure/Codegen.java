package com.soybean.infrastructure;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.template.impl.EnjoyTemplate;

public class Codegen {

    private static final String baseInfoFileName = "soybean-admin-infrastructure";
    private static final String baseInfoUrl = "com.soybean.infrastructure";

    private static final String ctrlBusFileName = "soybean-admin-portal";
    private static final String ctrlBusUrl = "com.soybean.portal";

    public static void main(String[] args) {
        //配置数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/pwa?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("rootroot");


        String[] tableNames = {"bus_admin_account", ""};
        GlobalConfig globalConfig = createGlobalConfigBaseInfo(tableNames);
        Generator generator = new Generator(dataSource, globalConfig);

        GlobalConfig ctrlConfig = createGlobalConfigCtrlAndServiceInfo(tableNames);

        Generator ctrlGenerator = new Generator(dataSource, ctrlConfig);

        //生成代码
        generator.generate();
        ctrlGenerator.generate();
    }


    public static GlobalConfig createGlobalConfigBaseInfo(String... tableNames) {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setSourceDir(System.getProperty("user.dir") + "/" + baseInfoFileName + "/" + "/src/main/java");
        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage(baseInfoUrl)
                .setEntityPackage(baseInfoUrl + ".resources.entity")
                .setMapperPackage(baseInfoUrl + ".resources.mapper")
                .setServicePackage(baseInfoUrl + ".service")
                .setServiceImplPackage(baseInfoUrl + ".service.impl")
                .setMapperXmlPath(System.getProperty("user.dir").concat("/" + baseInfoFileName).concat("/src/main/resources/mapper"))
        ;

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("bus_")
                .setGenerateTable(tableNames);

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setWithSwagger(true)
                .setJdkVersion(17);

        //设置生成 mapper
        globalConfig.enableMapper();
        globalConfig.enableEntity();
        globalConfig.enableMapperXml();
        globalConfig.enableService();
        globalConfig.enableServiceImpl();


        return globalConfig;
    }

    public static GlobalConfig createGlobalConfigCtrlAndServiceInfo(String... tables) {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setSourceDir(System.getProperty("user.dir") + "/" + ctrlBusFileName + "/" + "/src/main/java");
        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage(ctrlBusUrl);

        globalConfig.getPackageConfig()
                .setEntityPackage(baseInfoUrl + ".resources.entity")
                .setServicePackage(baseInfoUrl + ".service")
                .setControllerPackage(ctrlBusUrl + ".ctrl");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("bus_")
                .setGenerateTable(tables);

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setWithSwagger(true)
                .setJdkVersion(17);

        //设置生成 mapper
        globalConfig.enableController();
        globalConfig.disableEntity();
        globalConfig.disableServiceImpl();
        globalConfig.disableMapper();
        globalConfig.disableMapperXml();
        globalConfig.disableService();

        //设置controller
        globalConfig.getControllerConfig()
                .setClassPrefix("Bus")
                .setClassSuffix("Ctrl")

//                .setSuperClass(BaseController.class)
        ;

        globalConfig.getTemplateConfig()
                .setTemplate(new EnjoyTemplate())
                .setController("/template/ctrl.tpl");
        return globalConfig;
    }
}
