package des.springprueba.service;

import java.util.List;

import des.springprueba.entity.Email;
import des.springprueba.entity.Modulo;
import des.springprueba.entity.Profesor;

public interface ProfesorService {

	public Profesor crearPorfesor(Profesor porfesor);
	
	public Profesor obtenerProfesor(long idProfesor);
	
	public List<Profesor> listarProfesores();
	
	public Profesor anadirEmail(long idProfesor, Email email);
	
	public void eliminarPorfesor (long idProfesor);
	
	public List<Profesor> listarProfesorPorNombreYApellidos( String nombreapellidos);
	
	public List<Modulo> listarModulosNombre(String nombreModulo);
	
	public List<Modulo> listarModulosProfesor (long idProfesor);
	
	public List<Modulo> listarModulos();
	
	public Email crearEmail(Email email);
	
	public void eliminarEmail(long idProfesor, Email email);
	
	public Profesor findByUsername(String username);
	
	public Profesor modificarProfesor(Profesor profesor);
	
}
