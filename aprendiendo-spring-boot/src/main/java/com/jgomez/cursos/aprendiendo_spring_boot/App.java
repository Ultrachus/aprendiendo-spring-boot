package com.jgomez.cursos.aprendiendo_spring_boot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//Anotación principal de spring boot que inicializa el proyecto
@SpringBootApplication
//Anotación que indica a Spring que paquetes debe escanear en busca de otros beans
@ComponentScan({ "controllers", "services" })
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			log.debug("Vamos a inspeccionar las semillas que Spring Boot ha proporcionado:");
			System.out.println("Vamos a inspeccionar las semillas que Spring Boot ha proporcionado:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				log.debug(beanName);
				System.out.println(beanName);
			}

		};
	}
}