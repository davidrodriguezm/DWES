package com.drodriguezm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class EJERCICIOApplication {

	public static void main(String[] args) {
		SpringApplication.run(EJERCICIOApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("locale/traduccion");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
