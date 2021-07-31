package one.digitalinnovation.personapi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiAdmin(){
        return new Docket (DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("one.digitalinnovation.personapi"))
            .paths(PathSelectors.ant("/**"))
            .build()
            .apiInfo(metaData());

    }

    @Bean
    public ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("API-REST")
                .description("Desenvolvendo um sistema de gerenciamento de pessoas em APIRest e SpringBoot")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("DIO", "https://web.digitalinnovation.one", "contato@digitalinnovationone.com.br"))
                .build();
    }

}
