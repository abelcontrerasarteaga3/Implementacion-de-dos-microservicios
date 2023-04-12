package com.facturacion.start;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.facturacion.start.entity.TbCliente;
import com.facturacion.start.entity.TbFactura;
import com.facturacion.start.entity.TbFacturaDetalle;
import com.facturacion.start.entity.TbProducto;
import com.facturacion.start.repository.TbClienteRepImpl;
import com.facturacion.start.repository.TbFacturaRepImpl;
import com.facturacion.start.repository.TbProductoRepImpl;
import com.facturacion.start.security.JWTAuthorizationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableTransactionManagement
public class MantenimientoFacturacionApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(MantenimientoFacturacionApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/usuario/login").permitAll()
					.anyRequest().authenticated();


			// Configuración de CORS
			http.headers().addHeaderWriter(new StaticHeadersWriter("Content-Type", "application/json"));
			http.headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Type-Options", "nosniff"));
			http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "http://localhost:4200"));
			http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "GET,POST"));
			http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "Authorization,Content-Type"));
		}
		@Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
	        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	}
	
	
    
	
	
}
