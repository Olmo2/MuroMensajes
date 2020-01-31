package com.olmo.muroMensajes.datos.mensajes;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olmo.muroMensajes.Roles.Rol;
import com.olmo.muroMensajes.Roles.RolDAO;

@Controller
public class MensajeRutas {

	@Autowired
	private MensajeDAO mensajeDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private RolDAO rolDAO;

	@Autowired
	private Encoder encoder;

	/*
	 * Cuando alguien abre esta ruta, la vista abre el html "mensajes" y añade la
	 * lista de mensajes
	 */

	@GetMapping("/mensajes")
	public ModelAndView todosLosMensajes() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mensajes");
		mav.addObject("mensaje", new Mensaje());

		List<Mensaje> listaMensajes = (List<Mensaje>) mensajeDAO.findAll();
		mav.addObject("mensajes", listaMensajes);

		return mav;
	}

	@PostMapping("/mensajes/anadir")
	public String mensajesAnadir(@ModelAttribute Mensaje mensaje) {

		mensajeDAO.save(mensaje);

		return "redirect:/mensajes";
	}

	@GetMapping("/mensajes/borrar/{id}")
	public String mensajesBorrar(@PathVariable Long id) {

		// versión 1
		Mensaje mensaje = mensajeDAO.findById(id).get();
		mensajeDAO.delete(mensaje);

	

		return "redirect:/mensajes";
	}

	@GetMapping("/usuarios/borrar/{id}")
	public String usuariosBorrar(@PathVariable String id) {
		
//		usuarioDAO.findById(id).get().getRoles().clear();
		System.out.println(usuarioDAO.findById(id).get());
		System.out.println(rolDAO.findById("admin").get());
//		rolDAO.deleteById("admin");
		usuarioDAO.deleteById(id);
	
		

		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios")
	public ModelAndView todosLosUsuario() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios");
		mav.addObject("usuario", new Usuario());
		mav.addObject("rol", new Rol());

		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDAO.findAll();
		mav.addObject("usuarios", listaUsuarios);

		return mav;
	}

	@PostMapping("/usuarios/anadir")
	public String usuariosAñadir(@ModelAttribute Usuario usuario) {

		/* IOC del encoder */

		Rol rol1 = rolDAO.findById(usuario.getRol()).get();

		System.out.println(usuario);
		
		usuario.addRol(rol1);
		rol1.addUsuario(usuario);
		
		usuarioDAO.save(usuario);
		rolDAO.save(rol1);
		

		return "redirect:/usuarios";
	}

}
