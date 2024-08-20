<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="#(packageConfig.mapperPackage).#(table.buildMapperClassName())">

        <resultMap id="BaseResultMap" type="com.coding.fengniao.resource.AdminInfoDO">
            <!--
              WARNING - @mbg.generated
              This element is automatically generated by MyBatis Generator, do not modify.
            -->
            <id column="id" jdbcType="BIGINT" property="id"/>
            <result column="username" jdbcType="VARCHAR" property="username"/>
            <result column="password" jdbcType="VARCHAR" property="password"/>
            <result column="token" jdbcType="VARCHAR" property="token"/>
            <result column="gmt_created" jdbcType="TIMESTAMP" property="gmtCreated"/>
            <result column="gmt_modified" jdbcType="TIMESTAMP" property="gmtModified"/>
        </resultMap>

    <resultMap id="BaseResultMap" type="#(#(packageConfig.entityPackage).#(table.buildEntityClassName()))">
        #for(column : table.columns)

        <result column="

            <id column="id" jdbcType="#(column.propertySimpleType)" property="id"/>
            #set(comment = javadocConfig.formatColumnComment(column.comment))
            #if(isNotBlank(comment))
            /**
             * #(comment)
             */
            #end
            #set(annotations = column.buildAnnotations())
            #if(isNotBlank(annotations))
            #(annotations)
            #end
            #if(withSwagger && swaggerVersion.getName() == "FOX")
            @ApiModelProperty("#(column.comment)")
            #end
            #if(withSwagger && swaggerVersion.getName() == "DOC")
            @Schema(description = "#(column.comment)")
            #end
            private #(column.propertySimpleType) #(column.property)#if(isNotBlank(column.propertyDefaultValue)) = #(column.propertyDefaultValue)#end;

        #end


</mapper>