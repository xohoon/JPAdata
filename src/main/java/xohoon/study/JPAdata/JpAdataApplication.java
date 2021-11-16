package xohoon.study.JPAdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories(basePackages = "") -> spring boot는 없어도 됨
public class JpAdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpAdataApplication.class, args);
	}

}
