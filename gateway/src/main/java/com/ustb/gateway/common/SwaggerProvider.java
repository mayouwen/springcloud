package com.ustb.gateway.common;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName：SwaggerProvider
 * Description:
 * author: mayouwen
 * date: 2018/12/4
 */

@Component
@Primary
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {
    public static final String API_URI = "/v2/api-docs";


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("认证系统", "REGISTERSERVICE/v2/api-docs"));
        resources.add(swaggerResource("一标六实", "BASEINFOSERVICE/v2/api-docs"));
        resources.add(swaggerResource("事件管理", "EVENT-MANAGE-SERVICE/v2/api-docs"));
        resources.add(swaggerResource("智能应用", "INTELLEGENTSERVICE/v2/api-docs"));
        resources.add(swaggerResource("大数据分析", "BIGDATASERVICE/v2/api-docs"));
        resources.add(swaggerResource("档案管理", "ARCHIVESMANAGESERVICE/v2/api-docs"));
        resources.add(swaggerResource("webSocket", "WEBSOCKETSERVICE/v2/api-docs"));
        resources.add(swaggerResource("主页", "INDEXDATASERVICE/v2/api-docs"));
        resources.add(swaggerResource("ID生成服务", "IDGENERATORSERVICE/v2/api-docs"));
        resources.add(swaggerResource("vdp-core", "ICCORESERVICE/v2/api-docs"));
        resources.add(swaggerResource("vdp-布控服务", "ICDISPOSITIONSERVICE/v2/api-docs"));
        resources.add(swaggerResource("vdp-人脸服务", "ICFACESERVICE/v2/api-docs"));
        resources.add(swaggerResource("vdp-地图服务", "ICGISSERVICE/v2/api-docs"));
        resources.add(swaggerResource("vdp-车辆服务", "ICVEHICLESERVICE/v2/api-docs"));
        resources.add(swaggerResource("vms-视频服务", "ICVMSSERVICE/v2/api-docs"));
        resources.add(swaggerResource("告警中心", "ALARMSSERVICE/v2/api-docs"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
