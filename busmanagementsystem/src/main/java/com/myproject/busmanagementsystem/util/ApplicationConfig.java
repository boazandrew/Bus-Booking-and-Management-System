package com.myproject.busmanagementsystem.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class ApplicationConfig {
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Bus Booking App", "www.busbookingapp.com", "andrewirin30@gmail.com");

		List<VendorExtension> list = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("Bus Management System", "Bus Managing App", "Version 1.0",
				"1 Year of free service", contact, "wwww.infolicencecom", "infolicence@gamil.com", list);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.myproject.busmanagementsystem")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);

	}
}
