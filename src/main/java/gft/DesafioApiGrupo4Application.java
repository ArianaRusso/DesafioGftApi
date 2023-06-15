package gft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DesafioApiGrupo4Application {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiGrupo4Application.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
