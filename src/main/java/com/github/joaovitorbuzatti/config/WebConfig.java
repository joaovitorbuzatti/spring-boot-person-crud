package com.github.joaovitorbuzatti.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.joaovitorbuzatti.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration 
public class WebConfig implements WebMvcConfigurer {

    @Override 
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        /** 
        configurer.favorParameter(true)
         .parameterName("mediaType")
         .ignoreAcceptHeader(false)
         .useRegisteredExtensionsOnly(false)
         .defaultContentType(MediaType.APPLICATION_JSON)
         .mediaType("json", MediaType.APPLICATION_JSON)
         .mediaType("xml", MediaType.APPLICATION_XML);
*/
        configurer.favorParameter(false)
         .ignoreAcceptHeader(false)
         .useRegisteredExtensionsOnly(false)
         .defaultContentType(MediaType.APPLICATION_JSON)
         .mediaType("json", MediaType.APPLICATION_JSON)
         .mediaType("xml", MediaType.APPLICATION_XML)
         .mediaType("yaml", MediaType.APPLICATION_YAML); 

    }

    @Override
    public void extendMessageConverters(
            List<HttpMessageConverter<?>> converters) {

        converters.add(new YamlJackson2HttpMessageConverter());
    }

}
