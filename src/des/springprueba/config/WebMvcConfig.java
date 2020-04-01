package des.springprueba.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "des.springprueba" })
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;

	/*
	 * Establecemos que los recursos sean cagador de /WEB-INF/templates/ y añadamos
	 * el sufijo .html
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver() {

		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false);
		templateResolver.setCacheTTLMs(0L);

		return templateResolver;
	}

	/* Permite añadir anotacones de Spring security a los ficheros html */
	@Bean
	public SpringSecurityDialect securityDialect() {
		return new SpringSecurityDialect();
	}

	/* Establecemos Thymeleaf como motor de plantillas */
	@Bean
	public SpringTemplateEngine templateEngine() {

		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);

		templateEngine.addDialect(securityDialect());

		return templateEngine;
	}

	/*
	 * Configuramos que las vistas sean resueltaas con el motor de plantillas de
	 * Spring
	 */
	@Bean
	public ViewResolver viewResolver() {

		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setCache(false);
		return viewResolver;

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
				"/css/**",
				"/js/**",
				"/images/**"
				).addResourceLocations(
						"/WEB-INF/css/",
						"/WEB-INF/js/",
						"/WEB-INF/images/")
				.setCachePeriod(3600);
//				.resourceChain(true).addResolver(new PathResourceResolver());
	}
}
