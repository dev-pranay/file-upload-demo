package com.pk.main.config;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pk.main.model.UserDetail;

/**
 * @author PranaySK
 */

@Configuration
@EnableWebMvc
public class FileUploadConfig implements WebMvcConfigurer {

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSize(500000);// 0.5MB

		return resolver;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource datasource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource);
		sessionFactory.setAnnotatedClasses(UserDetail.class);

		return sessionFactory;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
