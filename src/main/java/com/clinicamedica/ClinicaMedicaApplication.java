package com.clinicamedica;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.clinicamedica.config.FileStorageCofig;

@EnableConfigurationProperties({
	FileStorageCofig.class
})
@SpringBootApplication
public class ClinicaMedicaApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ClinicaMedicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
}
