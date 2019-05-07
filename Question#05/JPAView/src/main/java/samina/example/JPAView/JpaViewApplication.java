package samina.example.JPAView;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
public class JpaViewApplication {
	 

	public static void main(String[] args) {
		SpringApplication.run(JpaViewApplication.class, args);
	}

}
