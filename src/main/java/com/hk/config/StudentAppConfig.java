package com.hk.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@EnableWebMvc
@ComponentScan(basePackages = {"com.hk"})
public class StudentAppConfig implements WebMvcConfigurer {

@Bean
public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

@Bean
public JdbcTemplate jdbcTemplate() {
	JdbcTemplate jdbcTemplate =new JdbcTemplate(dataSource());
	return jdbcTemplate;
}

@Bean
public DataSource dataSource() {
	
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setUsername("root");
	dataSource.setPassword("hrishi2002");
	dataSource.setUrl("jdbc:mysql://localhost:3306/school_database");
	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	
	return dataSource;
}

@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/urltostaticresource/**")
		.addResourceLocations("/resourses/");
	}  

}
