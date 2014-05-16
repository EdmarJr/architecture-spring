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
		Session sessao = abrirSessao();
		sessao.beginTransaction();
		sessao.delete(entidade);
		sessao.getTransaction().commit();
		sessao.close();
	}

	public void incluir(T entidade) {
		Session sessao = abrirSessao();
		sessao.beginTransaction();
		sessao.persist(entidade);
		sessao.getTransaction().commit();
		sessao.close();
	}

	public void alterar(T entidade) {
		Session sessao = abrirSessao();
		sessao.beginTransaction();
		sessao.merge(entidade);
		sessao.getTransaction().commit();
		sessao.close();
	}

	@SuppressWarnings("unchecked")
	public List<T> obterTodos() {
		Session session = abrirSessao();
		Criteria criteria = session.createCriteria(clazz);
		List<T> list = criteria.list();
		session.close();
		return list;
	}

	public abstract Class<T> getEntidade();
}
