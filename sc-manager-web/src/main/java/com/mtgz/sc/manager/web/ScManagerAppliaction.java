package com.mtgz.sc.manager.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com.mtgz"})
@Slf4j
@ServletComponentScan
@ImportResource({"classpath:application-velocity.xml"})
public class ScManagerAppliaction extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ScManagerAppliaction.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ScManagerAppliaction.class, args);
	}

}
