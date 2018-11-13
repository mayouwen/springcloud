package com.ustb.gateway.common;

import com.ustb.gateway.filter.RemoteAddrKeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;

import java.util.List;

/**
 * ClassName：MyConfig
 * Description:
 * author: mayouwen
 * date: 2018/11/13
 */
@Configuration
public class MyConfig {
    @Bean
    public ServerCodecConfigurer serverCodecConfigurer(){
        return new ServerCodecConfigurer() {
            @Override
            public ServerDefaultCodecs defaultCodecs() {
                return null;
            }

            @Override
            public CustomCodecs customCodecs() {
                return null;
            }

            @Override
            public void registerDefaults(boolean b) {

            }

            @Override
            public List<HttpMessageReader<?>> getReaders() {
                return null;
            }

            @Override
            public List<HttpMessageWriter<?>> getWriters() {
                return null;
            }
        };
    }
    @Bean
    public RemoteAddrKeyResolver remoteAddrKeyResolver() {
        return new RemoteAddrKeyResolver();
    }
}
