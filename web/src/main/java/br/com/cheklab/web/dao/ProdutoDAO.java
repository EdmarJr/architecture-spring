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
import br.com.cheklab.web.entity.Produto;

@Repository
@Transactional
public class ProdutoDAO extends DAO<Produto> {
	@SuppressWarnings("unchecked")
	public List<Produto> obterProdutos() {
		Session sessao = obterSessao();
		Criteria criteria = sessao.createCriteria(Produto.class);
		criteria.addOrder(Order.asc("posicao"));
		return criteria.list();
	}

	@Transactional(readOnly = true)
	public Produto obterPorIdComInializacaoDeImagens(Long id) {
		Produto produto = buscarPorId(id);
		Hibernate.initialize(produto.getImagens());
		return produto;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> obterProdutosPorCategoriaComInicializacaoDeImagens(
			Categoria categoria, Integer idStart, Long qntdRegistros) {
		Session sessao = obterSessao();
		Criteria criteria = sessao.createCriteria(Produto.class);
		criteria.add(Restrictions.eq("categoria", categoria));
		criteria.add(Restrictions.eq("ativo", true));
		criteria.addOrder(Order.asc("posicao"));
		criteria.setFirstResult(idStart);
		criteria.setMaxResults(20);
		List<Produto> list = criteria.list();
		for (Produto p : list) {
			Hibernate.initialize(p.getImagens());
		}
		return list;
	}

	@Transactional(readOnly = true)
	public List<Produto> filtrarComPaginacao(Produto entidade, Integer rowStart, Integer qntdRegistros) {
		return filtrar(entidade, "posicao", true, true, rowStart,qntdRegistros);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produto> filtrar(Produto entidade) {
		return filtrar(entidade, "posicao", true, false, null, null);
	}

	@Override
	public Class<Produto> getEntidade() {
		return Produto.class;
	}
}
