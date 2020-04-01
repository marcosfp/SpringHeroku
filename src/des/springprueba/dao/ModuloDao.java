package des.springprueba.dao;

import java.util.List;

import des.springprueba.entity.Modulo;

public interface ModuloDao extends GenericDao<Modulo>{

	public List<Modulo> listarModulos();
	
	public List<Modulo> listarModulosPorNombre(String nombreModulo);
	
	
}
