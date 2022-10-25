package br.sc.senac.urbanwood;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UrbanWoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbanWoodApplication.class, args);
	}
}
