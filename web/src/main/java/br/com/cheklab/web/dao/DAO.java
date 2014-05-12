package br.com.cheklab.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.cheklab.web.config.HibernateUtil;

public abstract class DAO<T> {

	Class<T> clazz;

	public DAO() {
		clazz = getEntidade();
	}

	protected Session abrirSessao() {
		return HibernateUtil.getSessionFactory().openSession();
	}

	@SuppressWarnings({ "unchecked" })
	public T buscarPorId(Long id) {
		Criteria criteria = abrirSessao().createCriteria(clazz);
		criteria.add(Restrictions.eq("id", id));
		return (T) criteria.uniqueResult();
	}

	public void excluir(T entidade) {
		abrirSessao().delete(entidade);
	}

	@SuppressWarnings("unchecked")
	public List<T> obterTodos() {
		Criteria criteria = abrirSessao().createCriteria(clazz);
		return criteria.list();
	}

	public abstract Class<T> getEntidade();
}
