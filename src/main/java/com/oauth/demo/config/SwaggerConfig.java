package com.oauth.demo.config;

import com.oauth.demo.constants.FasConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport{
    public static final Contact DEFAULT_CONTACT = new Contact(
            "demo", "https://demo.io", "");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Policy API", "Mock Policy API", "1.0.2",
            "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =new HashSet<>();

    @Bean
    public Docket engagementApi() {
        List<Parameter> aParameters = addHeader();
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(aParameters)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select().apis(RequestHandlerSelectors.basePackage("com.oauth.demo.controller"))
                .build();

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Add custom header to swagger-ui
     *
     * @return List of headers added.
     */
    private List<Parameter> addHeader() {
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name(FasConstants.X_API_KEY).modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        List<Parameter> aParameters = new ArrayList<Parameter>();
        aParameters.add(aParameterBuilder.build());
        return aParameters;
    }
}
