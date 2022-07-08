package shakhmat.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import shakhmat.repository.DataRepository;
import shakhmat.repository.impl.DataRepositoryImpl;

@SpringBootApplication
public class ShakhmatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShakhmatApplication.class, args);
	}

}
