package des.springprueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import des.springprueba.dao.ModuloDao;
import des.springprueba.entity.Modulo;

@Transactional
@Service
public class ModuloServiceImpl implements ModuloService {

	@Autowired
	ModuloDao moduloDao;

	@Override
	public List<Modulo> listarModulos() {
		return moduloDao.listarModulos();
	}

	@Override
	public List<Modulo> listarModulosPorNombre(String nombreModulo) {
		return moduloDao.listarModulosPorNombre(nombreModulo);
	}

	@Override
	public Modulo obtenerModulo(long idModulo) {
		return moduloDao.find(idModulo);
	}

}
