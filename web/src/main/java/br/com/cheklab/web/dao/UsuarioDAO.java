package br.com.cheklab.web.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.cheklab.web.config.HibernateUtil;
import br.com.cheklab.web.entity.Usuario;

@Repository
public class UsuarioDAO {
	
	public Usuario obterPorEmail(String email) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));
		return (Usuario) criteria.uniqueResult();
	}
}
