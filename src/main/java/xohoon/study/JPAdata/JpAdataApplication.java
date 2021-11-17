package xohoon.study.JPAdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
// @EnableJpaRepositories(basePackages = "") -> spring boot는 없어도 됨
public class JpAdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpAdataApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAware<String>() {
			@Override
			public Optional<String> getCurrentAuditor() {
				return Optional.of(UUID.randomUUID().toString());
			}
		};
//		return () -> Optional.of(UUID.randomUUID().toString()); -> 람다식
//		security 쓰면 security 에서 id 꺼내서 써야함
	}
}
