package br.com.cheklab.web.mediators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.dao.ProdutoDAO;
import br.com.cheklab.web.entity.Produto;

@Service
public class ProdutoMediator extends Mediator<Produto> {
	
	@Autowired
	private ProdutoDAO dao;
	@Autowired
	private ImagemMediator imagemMediator;
	
	@Transactional(readOnly = true)
	public List<Produto> obterProdutos() {
		return dao.obterProdutos();
	}

	@Transactional(readOnly = true)
	public Produto obterPorIdComInializacaoDeImagens(Long id) {
		return dao.obterPorIdComInializacaoDeImagens(id);
	}
	
	@Override
	@Transactional
	public void excluir(Produto entidade) {
		entidade = obterPorId(entidade.getId());
		entidade.setAtivo(Boolean.FALSE);
		getDAO().alterar(entidade);
	}

	@Transactional(readOnly = true)
	public List<Produto> filtrar(Produto produto) {
		return dao.filtrar(produto);
	}

	@Override
	@Transactional
	public void alterar(Produto entidade) {
		entidade.setAtivo(Boolean.TRUE);
		getDAO().alterar(entidade);
	}

	@Override
	@Transactional
	public void incluir(Produto entidade) {
		entidade.setAtivo(Boolean.TRUE);
		getDAO().incluir(entidade);
	}

	@Override
	protected DAO<Produto> getDAO() {
		return dao;
	}
}
