package com.olmo.muroMensajes.Roles;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.olmo.muroMensajes.datos.mensajes.Usuario;



@Entity
@Table(name="Roles")
public class Rol {

	
	@Id
	private String nombre_rol;
	
	
	
	@ManyToMany(cascade=CascadeType.MERGE)
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void addUsuario(Usuario usuario) {

		if (!usuarios.contains(usuario)) {

			usuarios.add(usuario);

			// decirle al coche que añada este concesionario
			List<Rol> roles = usuario.getRoles();
			if (!roles.contains(this)) {

				roles.add(this);
			}
		}
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	@Override
	public String toString() {
		return "Rol [nombre_rol=" + nombre_rol + "]";
	}


	
	
	
}
