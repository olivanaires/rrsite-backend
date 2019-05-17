package br.com.isoftware.rrsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.isoftware.rrsite.config.AuditorAwareConfig;
import br.com.isoftware.rrsite.model.User;

/**
 * Created by olivan on 11/05/2019.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaAuditing
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Bean
    public AuditorAware<User> auditorProvider() {
        return new AuditorAwareConfig();
    }

}
