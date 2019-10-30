package br.edu.ifsp.lp2a4.iforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class IforumApplication {

	public static void main(String[] args) {
		SpringApplication.run(IforumApplication.class, args);
	}
	
	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
