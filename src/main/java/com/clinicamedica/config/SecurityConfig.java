package com.clinicamedica.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsAwareConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.clinicamedica.security.JWTAuthenticationFilter;
import com.clinicamedica.security.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	//Permitindo acesso sem precisar de token
	private static final String[] PUBLI_MATCHERS = {
	    "/swagger-ui**"
	};
	
	//Somente leitura 
	//Faz somente o metodo get
	private static final String[] PUBLI_MATCHERS_GET = {
		    "/medico/**",
		    "/api-prestador/**",
		    "/api-login/**",
		    "/api-perfil-acesso/**",
		    "/api-perfil/**"
		};
	
	//Sobreecrevendo metodo
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		//habilitar acesso externo tipo banco h2 e swagger
		if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		//Autorizando as url terem permissão sem token -> public_matchers
		http.cors().and().csrf().disable(); // Se o metodo corsConfigurationSource for definido ele aplica as configurações
		//Observação desabilitando csrf não vamos guarda  sessão
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLI_MATCHERS_GET).permitAll()
			.antMatchers(PUBLI_MATCHERS)
			.permitAll()
			.anyRequest()
			.authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		//garantido que não terá sessão do usuário
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		//Permitindo acesso o acesso aos meus endpoint pelas configurações basicas PermitDefaultValues
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
	//Gera um bean para criação de senha com hash
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}