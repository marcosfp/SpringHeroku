package des.springprueba.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import des.springprueba.entity.Email;
import des.springprueba.entity.Profesor;
import des.springprueba.service.ProfesorService;

@Controller
public class LoginController {

	@Autowired
	ProfesorService profesorService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/access-denied";
	}

	@PostMapping("/crearProfesor")
	public String createUser(@ModelAttribute("profesor") Profesor elProfesor) {
		Profesor profesor = profesorService.crearPorfesor(elProfesor);

		return "redirect:/index";
	}

	@GetMapping("/signup")
	public String showForm() {
		return "signup";
	}

	@PostMapping("/signup")
	public String crearUsuario(HttpServletRequest request) {

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String username = request.getParameter("nombreUsuario");
		String direccionemail = request.getParameter("email");
		String password = request.getParameter("password");
		
		Profesor p = new Profesor();
		p.setNombreProfesor(nombre);
		p.setApellidosProfesor(apellidos);
		p.setPassword(password);
		p.setUsername(username);
		
		Email email = new Email();
		email.setDireccionEmail(direccionemail);
		p.addEmails(email);
		profesorService.crearPorfesor(p);
		

		return "redirect:/";
	}

}
