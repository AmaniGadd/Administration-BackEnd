package org.pfe.administration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdministrationApplication{

	public static void main(String[] args) {
		SpringApplication.run(AdministrationApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelmapper =new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelmapper;
	}
}
