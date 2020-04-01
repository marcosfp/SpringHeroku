package des.springprueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import des.springprueba.dao.EmailDao;
import des.springprueba.dao.ModuloDao;
import des.springprueba.dao.ProfesorDao;
import des.springprueba.entity.Email;
import des.springprueba.entity.Modulo;
import des.springprueba.entity.Profesor;

@Transactional
@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorDao profesorDao;

	@Autowired
	private EmailDao emailDao;

	@Autowired
	private ModuloDao moduloDao;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Profesor crearPorfesor(Profesor profesor) {

		profesor.setPassword(bCryptPasswordEncoder.encode(profesor.getPassword()));
		return profesorDao.create(profesor);
	}

	@Override
	public void eliminarPorfesor(long idProfesor) {

		profesorDao.delete(idProfesor);
	}

	@Override
	public List<Profesor> listarProfesorPorNombreYApellidos(String nombreyapellidos) {

		return profesorDao.buscarPorfesorPorNombreYApellidos(nombreyapellidos);
	}

	@Override
	public List<Modulo> listarModulosNombre(String nombreModulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modulo> listarModulosProfesor(long idProfesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesor> listarProfesores() {
		return profesorDao.listarPorfesores();
	}

	@Override
	public Profesor obtenerProfesor(long idProfesor) {
		return profesorDao.find(idProfesor);
	}

	@Override
	public List<Modulo> listarModulos() {
		return moduloDao.listarModulos();
	}

	@Override
	public Profesor anadirEmail(long idProfesor, Email email) {

		return profesorDao.anadirEmail(idProfesor, email);
	}

	@Override
	public Email crearEmail(Email email) {

		return emailDao.create(email);
	}

	@Override
	public void eliminarEmail(long idProfesor, Email email) {

		Profesor p = profesorDao.find(idProfesor);
		p.removeEmails(email);
		emailDao.update(email);

	}

	@Override
	public Profesor findByUsername(String username) {

		return profesorDao.findByUsername(username);
	}

	@Override
	public Profesor modificarProfesor(Profesor profesor) {

		profesor.setPassword(bCryptPasswordEncoder.encode(profesor.getPassword()));
		profesorDao.update(profesor);
		
		return null;
	}

}
