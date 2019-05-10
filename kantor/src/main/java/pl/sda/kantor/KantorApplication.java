package pl.sda.kantor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KantorApplication {

	public static void main(String[] args) {
		SpringApplication.run(KantorApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
