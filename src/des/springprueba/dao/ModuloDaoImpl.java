package des.springprueba.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import des.springprueba.entity.Modulo;

@Repository
@Component("ModuloDao")
public class ModuloDaoImpl extends GenericDaoImpl<Modulo> implements ModuloDao {

	@Override
	public List<Modulo> listarModulosPorNombre(String nombreModulo) {
		Query query = this.em
                .createQuery("select u FROM modulo u where u.nombreModulo= :nombre");
        query.setParameter("nombre", nombreModulo);
        List<Modulo> lModulo = query.getResultList();
        
        if (lModulo != null ) {
            return lModulo;
        }
		return null;
	}

	@Override
	public List<Modulo> listarModulos() {
		Query query = this.em
                .createQuery("FROM modulo");
        List<Modulo> lModulo = query.getResultList();
        
        if (lModulo != null ) {
            return lModulo;
        }
		return null;
	}

}
