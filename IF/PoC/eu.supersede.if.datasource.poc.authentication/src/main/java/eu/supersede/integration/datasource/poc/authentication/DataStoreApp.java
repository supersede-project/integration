package eu.supersede.integration.datasource.poc.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataStoreApp extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication (DataStoreApp.class);
		ConfigurableApplicationContext ctx = app.run(args);
		ctx.publishEvent(new ApplicationPreparedEvent(app, args, ctx));
	}
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
		return application.sources(DataStoreApp.class);
	}
}
