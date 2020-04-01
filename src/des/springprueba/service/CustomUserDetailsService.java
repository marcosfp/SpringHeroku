package des.springprueba.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import des.springprueba.dao.ProfesorDao;
import des.springprueba.entity.Profesor;
import des.springprueba.entity.Rol;

@Transactional
@Service
public class CustomUserDetailsService implements  UserDetailsService {

	@Autowired
	private ProfesorDao profesorDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Profesor profesor = profesorDao.findByUsername(email);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Rol rol : profesor.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		}

		return new org.springframework.security.core.userdetails.User(profesor.getUsername(), profesor.getPassword(),
				grantedAuthorities);
	}
}
