package com.clinicamedica.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.clinicamedica.dto.PerfilAcessoDTO;
import com.clinicamedica.entity.perfil_acesso;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		/*
		 * ModelMapper modelMapper = new ModelMapper();
		 * modelMapper.createTypeMap(PerfilAcessoDTO.class, perfil_acesso.class)
		 * .<String>addMapping(src -> src.getPrestador().getLogin().getLogin(),
		 * (dest,value) -> dest.setPrestador(value));
		 */
		return new ModelMapper();
	}
}
