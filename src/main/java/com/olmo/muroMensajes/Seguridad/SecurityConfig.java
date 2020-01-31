package com.olmo.muroMensajes.Seguridad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.olmo.muroMensajes.Servicios.Autenticacion;
import com.olmo.muroMensajes.datos.mensajes.Encoder;


@Configuration
@EnableWebSecurity(debug=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Autenticacion autenticacion;
	
	@Autowired
	private Encoder encoder;
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        
	    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setPasswordEncoder(encoder.bcryptPasswordEncoder());
	        provider.setUserDetailsService(autenticacion);
	    	
	    	auth.authenticationProvider(provider);
	    }
	 
	 

}
