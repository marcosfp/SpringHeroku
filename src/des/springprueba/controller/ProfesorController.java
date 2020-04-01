package des.springprueba.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import des.springprueba.entity.Email;
import des.springprueba.entity.Profesor;
import des.springprueba.service.ProfesorService;

@Controller
@RequestMapping(value = "/profesor")
public class ProfesorController {

	@Autowired
	ProfesorService profesorService;

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView listarPorfesores() {

		ModelAndView mav = new ModelAndView();

		List<Profesor> lProfesor = profesorService.listarProfesores();

		mav.addObject("profesores", lProfesor);
		mav.setViewName("profesor_lista");
		return mav;
	}

//	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, value = "/myprofile")
	public String perfilPersonal(HttpServletRequest request) {
		
        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("idUsuario") != null)
        	return "redirect:/profesor/perfil/" + session.getAttribute("idUsuario");
        else 
        	return"redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/perfil/{id}")
	public ModelAndView perfilProfesor(@PathVariable("id") long idProfesor,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		Profesor profesor = profesorService.obtenerProfesor(idProfesor);

		long idSession= (long) request.getSession().getAttribute("idUsuario");
		
		Boolean propietario= idSession == idProfesor;
		
		mav.addObject("propietario", propietario);
		mav.addObject("profesor", profesor);
		mav.setViewName("profesor_perfil");
		return mav;
	}
	// TRABAAJAR AQUI
	@GetMapping("/perfil/actualizar/{id}")
	public ModelAndView mostrarActualizarPerfilProfesor(@PathVariable("id") long idProfesor,HttpServletRequest request) {

		System.out.println("\n\n EEEEEEEEEEEEEEEEEEEEEEEEEEEOOOOOOOOOOOO \n\n");
		Profesor profesor = profesorService.obtenerProfesor(idProfesor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("profesor", profesor);
		mav.setViewName("profesor_perfil_actualizar");
		return mav;
	}
	
	@PostMapping("/perfil/actualizar/{id}")
	public String actualizarPerfilProfesor(@PathVariable("id") long idProfesor,@Valid Profesor profesorFormulario,BindingResult bindingResult, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		long idUsuarioSession= (long) request.getSession().getAttribute("idUsuario");
		if (idUsuarioSession != idProfesor) {
			return "redirect:/index";
		}
		
		if (bindingResult.hasErrors()) {
			return "profesor_perfil_actualizar";
		}
		
		Profesor profesorBD = profesorService.obtenerProfesor(idProfesor);
		profesorBD.setUsername(profesorFormulario.getUsername());
		profesorBD.setNombreProfesor(profesorFormulario.getNombreProfesor());
		profesorBD.setApellidosProfesor(profesorFormulario.getApellidosProfesor());
		profesorBD.setPassword(profesorFormulario.getPassword());
		
		profesorService.modificarProfesor(profesorBD);
		
		return "redirect:/profesor/perfil/" + idUsuarioSession;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/anadir_email/{id}")
	public String anadirEmail(@PathVariable("id") long idProfesor, HttpServletRequest request) {

		String direccion_email = request.getParameter("nuevoemail");

		Email email = new Email();
		email.setDireccionEmail(direccion_email);

		Profesor profesor = profesorService.anadirEmail(idProfesor, email);

		return "redirect:/profesor/perfil/" + idProfesor;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/eliminar_email/{idProfesor}/{idEmail}")
	public String eliminarEmail(@PathVariable("idEmail") long idEmail, @PathVariable("idProfesor") long idProfesor) {

		Email email = new Email();
		email.setIdEmail(idEmail);

		profesorService.eliminarEmail(idProfesor, email);

		return "redirect:/profesor/perfil/" + idProfesor;
	}
}
