package mx.com.bankaya.pokedex.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("mx.com.bankaya.pokedex")
@EnableJpaRepositories(basePackages="mx.com.bankaya.pokedex.repository")
@EnableTransactionManagement
@EntityScan(basePackages="mx.com.bankaya.pokedex.entity")
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}
}