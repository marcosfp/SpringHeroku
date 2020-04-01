package des.springprueba.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import des.springprueba.entity.Email;
import des.springprueba.entity.Profesor;
import des.springprueba.entity.Rol;

@Repository
@Component("ProfesorDao")
public class ProfesorDaoImpl extends GenericDaoImpl<Profesor> implements ProfesorDao {

	
    @Autowired
    private RolRepository rolRepository;
	
    
	public Profesor create (Profesor profesor) {
		
		Set<Rol> roles  =new HashSet<Rol>();
		
		Rol rol = rolRepository.getOne(1);
		roles.add(rol);
		profesor.setRoles(roles);
        this.em.persist(profesor);
        
		return profesor;
	}
    
	
	@Override
	public Profesor buscarPorEmail(String email) {
		Query query = this.em.createQuery("select u FROM Profesor u where u.email= :email");
		query.setParameter("email", email);
		Profesor profesor = (Profesor) query.getSingleResult();

		if (profesor != null) {
			return profesor;
		}
		return null;
	}

	@Override
	public List<Profesor> buscarPorfesorPorNombreYApellidos(String nombreyapellidos) {

		String nym = "%" + nombreyapellidos + "%";
		Query query = this.em.createQuery("select u FROM Profesor u where concat (u.nombre,' 'u apellidos) like  :nym");
		query.setParameter("nym", nym);
		List<Profesor> lProfesor = query.getResultList();

		if (lProfesor != null) {
			return lProfesor;
		}
		return null;
	}

	@Override
	public List<Profesor> listarPorfesores() {
		Query query = this.em.createQuery("FROM Profesor");
		List<Profesor> lProfesor = query.getResultList();

		if (lProfesor != null) {
			return lProfesor;
		}
		return null;
	}

	@Override
	public Profesor anadirEmail(long idProfesor, Email email) {

		Profesor profesor = this.find(idProfesor);
		profesor.addEmails(email);

		return profesor;
	}

	@Override
	public Profesor findByUsername(String username) {
		Query query = this.em.createQuery("FROM Profesor u where u.username= :username");
		query.setParameter("username", username);
		Profesor profesor = (Profesor) query.getSingleResult();

		if (profesor != null) {
			return profesor;
		}
		return null;
	}

}
