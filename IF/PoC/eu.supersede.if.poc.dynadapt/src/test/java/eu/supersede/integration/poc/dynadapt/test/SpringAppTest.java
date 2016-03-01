package eu.supersede.integration.poc.dynadapt.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import eu.supersede.integration.poc.dynadapt.Dashboard;

@SpringBootApplication
public class SpringAppTest extends SpringBootServletInitializer {
	//implements ApplicationListener<ApplicationPreparedEvent>{
		private static final Logger log = LoggerFactory.getLogger(SpringAppTest.class);
		
		public static void main(String[] args) {
			SpringApplication app = new SpringApplication (SpringAppTest.class);
			ConfigurableApplicationContext ctx = app.run(args);
			ctx.publishEvent(new ApplicationPreparedEvent(app, args, ctx));
		}
		
		@Override
		protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
			return application.sources(SpringAppTest.class);
		}
	}