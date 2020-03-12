package com.elioms.cambioymoneda;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;
import com.elioms.cambioymoneda.models.FileStorageProperties;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class CambioymonedaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CambioymonedaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
