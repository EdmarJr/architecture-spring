package br.com.cheklab.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.Categoria;

@Repository
@Transactional
public class CategoriaDAO extends DAO<Categoria> {

	@Override
	public Class<Categoria> getEntidade() {
		return Categoria.class;
	}

	@Transactional(readOnly = true)
	public Categoria obterPorPosicao(Integer posicao) {
		Session session = obterSessao();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.eq("posicao", posicao));
		return (Categoria) criteria.uniqueResult();
	}

	@Transactional(readOnly = true)
	public List<Categoria> obterCategoriasEFilhas() {
		Session session = obterSessao();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.isNull("categoriaPai"));
		criteria.add(Restrictions.eq("ativo", true));
		criteria.addOrder(Order.asc("posicao"));
		@SuppressWarnings("unchecked")
		List<Categoria> categorias = criteria.list();
		for (Categoria categoria : categorias) {
			Hibernate.initialize(categoria.getCategoriasFilha());
		}
		return categorias;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Categoria> obterTodos() {
		Session session = obterSessao();
		Criteria criteria = session.createCriteria(clazz);
		criteria.addOrder(Order.asc("posicao"));
		List<Categoria> list = criteria.list();
		return list;
	}
}
