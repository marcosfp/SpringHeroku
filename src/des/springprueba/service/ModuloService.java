package des.springprueba.service;

import java.util.List;

import des.springprueba.entity.Modulo;

public interface ModuloService {

	public List<Modulo> listarModulos();
	
	public List<Modulo> listarModulosPorNombre(String nombreModulo);

	public Modulo obtenerModulo(long idModulo);
	
}
