package com.ustb.registerservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName：WebConfigration
 * Description:
 * author: mayouwen
 * date: 2020/8/31
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    public WebConfiguration() {
    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(getMappingJackson2CborHttpMessageConverter());
        converters.add(stringHttpMessageConverter());
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList();
        supportedMediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
        supportedMediaTypes.add(MediaType.parseMediaType("text/plain;charset=UTF-8"));
        supportedMediaTypes.add(MediaType.parseMediaType("application/json;charset=UTF-8"));
        stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return stringHttpMessageConverter;
    }

    private MappingJackson2CborHttpMessageConverter getMappingJackson2CborHttpMessageConverter() {
        MappingJackson2CborHttpMessageConverter mappingJackson2CborHttpMessageConverter = new MappingJackson2CborHttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategyBase());
        mappingJackson2CborHttpMessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2CborHttpMessageConverter;
    }

}
