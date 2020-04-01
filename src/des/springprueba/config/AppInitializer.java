package des.springprueba.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import des.springprueba.config.WebMvcConfig;
import des.springprueba.config.PersistenceJPAHibernateConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {/*PersistenceJPAHibernateConfig.class*/ };
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
 
}