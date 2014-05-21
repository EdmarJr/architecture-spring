package br.com.cheklab.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;


public abstract class DAO<T> {
	@PersistenceContext
	private EntityManager entityManager;

	Class<T> clazz;

	public DAO() {
		clazz = getEntidade();
	}

	protected Session abrirSessao() {
		Session session = (Session) entityManager.getDelegate();
		return session;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional(readOnly = true)
	public T buscarPorId(Long id) {
		Criteria criteria = abrirSessao().createCriteria(clazz);
		criteria.add(Restrictions.eq("id", id));
		return (T) criteria.uniqueResult();
	}

	public void excluir(T entidade) {
		entityManager.remove(entidade);
	}

	public void incluir(T entidade) {
		entityManager.persist(entidade);
	}

	public void alterar(T entidade) {
		entityManager.merge(entidade);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> obterTodos() {
		Session session = abrirSessao();
		Criteria criteria = session.createCriteria(clazz);
		List<T> list = criteria.list();
		session.close();
		return list;
	}

	public abstract Class<T> getEntidade();

}
