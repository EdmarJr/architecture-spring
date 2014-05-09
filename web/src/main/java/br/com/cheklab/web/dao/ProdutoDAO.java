package br.com.cheklab.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.Produto;

@Repository
public class ProdutoDAO extends DAO{
	@SuppressWarnings("unchecked")
	public List<Produto> obterProdutos() {
		Session sessao = abrirSessao();
		Criteria criteria = sessao.createCriteria(Produto.class);
		return criteria.list();
	}
}