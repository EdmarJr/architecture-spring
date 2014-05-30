package br.com.cheklab.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.Produto;

@Repository
@Transactional
public class ProdutoDAO extends DAO<Produto> {
	@SuppressWarnings("unchecked")
	public List<Produto> obterProdutos() {
		Session sessao = obterSessao();
		Criteria criteria = sessao.createCriteria(Produto.class);
		return criteria.list();
	}

	@Transactional(readOnly = true)
	public Produto obterPorIdComInializacaoDeImagens(Long id) {
		Produto produto = buscarPorId(id);
		Hibernate.initialize(produto.getImagens());
		return produto;
	}

	@Override
	public Class<Produto> getEntidade() {
		return Produto.class;
	}
}
