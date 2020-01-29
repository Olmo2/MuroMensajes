package com.olmo.muroMensajes.datos.mensajes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.olmo.muroMensajes.Roles.Rol;

@Entity
@Table(name="usuarios")
public class Usuario implements UserDetails{
	
	
	@Id
	@Column(name="usuraio")
	private String zapatilla;
	
	
	@Column
	private String password;
	
	@Column 
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column 
	private String email;
	
	@Column 
	private int telefono;
	
	@OneToMany(mappedBy="usuario")
	List<Rol> roles = new ArrayList<Rol>();

	

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getZapatilla() {
		return zapatilla;
	}

	public void setZapatilla(String zapatilla) {
		this.zapatilla = zapatilla;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.zapatilla;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	

	
	
	

}
