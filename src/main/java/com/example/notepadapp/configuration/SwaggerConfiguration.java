package com.example.notepadapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public static final String SWAGGER_BASE_PACKAGE_DOCKET = "com.example.notepadapp";

    public static final String SWAGGER_API_INFO_TITLE = "NOTEPAD APP API";

    public static final String SWAGGER_API_INFO_VERSION = "v1";

    @Bean
    public Docket getProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_BASE_PACKAGE_DOCKET))
                .paths(PathSelectors.any())
                .build().apiInfo(getCustomApiInfo());
    }

    private ApiInfo getCustomApiInfo() {
        return new ApiInfo(SWAGGER_API_INFO_TITLE, null, SWAGGER_API_INFO_VERSION, null, null, null, null,
                Collections.emptyList());
    }

}

