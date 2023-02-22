package xyz.helbertt.supermarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;


import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@EnableWebMvc
public class SwaggerConfig {
	
	private static final String BASE_PACKAGE = "xyz.helbertt.supermarket.controller";
	private static final String API_TITLE = "Supermarket";
	private static final String API_DESCRIPTION = "Supermarket API";
	private static final String CONTACT_NAME = "Helbertt Dalarme";
	private static final String CONTACT_URL = "http://helbertt.xyz";
	private static final String CONTACT_EMAIL = "helbertt@helbertt.xyz";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				//.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false)
				//.globalResponseMessage(RequestMethod.GET, responseMessageForGET())
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(API_TITLE)
				.description(API_DESCRIPTION)
				.version("1.0.0")
				.license("MIT")
				.licenseUrl("#")
				.contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL))
				.build();
	}
	
	/*
	@SuppressWarnings({ "serial", "deprecation" })
	private List<ResponseMessage> responseMessageForGET() {
		return new ArrayList<ResponseMessage>() {{
			add(new ResponseMessageBuilder()
					.code(500)
					.message("500 message")
					.responseModel(new ModelRef("Error"))
					.build());
			add(new ResponseMessageBuilder()
					.code(403)
					.message("Forbidden!")
					.build());
		}};
	}
	*/
}
