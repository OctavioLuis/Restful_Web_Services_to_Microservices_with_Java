package com.unsis.edu.resfullwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class ResfullWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResfullWebServicesApplication.class, args);
	}
	
	/*@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver= new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver();
	}*/
	

}
