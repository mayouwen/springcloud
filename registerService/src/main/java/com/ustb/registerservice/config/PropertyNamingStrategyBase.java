package com.ustb.registerservice.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

/**
 * ClassName：PropertyNamingStrategyBase
 * Description:
 * author: mayouwen
 * date: 2020/8/31
 */
public class PropertyNamingStrategyBase extends PropertyNamingStrategy {

    public PropertyNamingStrategyBase() {
    }

    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return super.nameForGetterMethod(config, method, defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return super.nameForSetterMethod(config, method, defaultName);
    }
}
