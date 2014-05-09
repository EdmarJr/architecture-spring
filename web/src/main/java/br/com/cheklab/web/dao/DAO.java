package br.com.cheklab.web.dao;

import org.hibernate.Session;

import br.com.cheklab.web.config.HibernateUtil;

public abstract class DAO {
	protected Session abrirSessao() {
		return HibernateUtil.getSessionFactory().openSession();
	}
}
