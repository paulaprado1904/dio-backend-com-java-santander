package dio.designpatterns.spring_api_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringApiRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringApiRestApplication.class, args);
	}

}
