package br.com.cheklab.web.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;

import br.com.cheklab.web.entity.Usuario;
import br.com.cheklab.web.entity.PermissoesUsuario;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory configureSessionFactory()
			throws HibernateException {
		@SuppressWarnings("rawtypes")
		Class[] annotadeClass = {PermissoesUsuario.class, Usuario.class};
		
		
		Configuration configuration = new Configuration();
		configuration.configure("br/com/cheklab/web/config/hibernate.cfg.xml");
		
		for(@SuppressWarnings("rawtypes") Class classe : annotadeClass) {
			configuration.addAnnotatedClass(classe);
		}
		
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	@Bean
	public static SessionFactory getSessionFactory() {
		return configureSessionFactory();
	}

}