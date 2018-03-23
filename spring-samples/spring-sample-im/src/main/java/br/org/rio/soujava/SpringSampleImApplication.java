package br.org.rio.soujava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import br.org.rio.soujava.config.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringSampleImApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSampleImApplication.class, args);
	}
}
