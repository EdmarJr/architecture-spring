package br.com.cheklab.web.mediators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.dao.OrcamentoDAO;
import br.com.cheklab.web.dao.OrcamentoProdutosDAO;
import br.com.cheklab.web.entity.Orcamento;
import br.com.cheklab.web.entity.OrcamentoProdutos;
import br.com.cheklab.web.entity.Produto;

@Service
public class OrcamentoMediator extends Mediator<Orcamento> {
	
	@Autowired
	private OrcamentoDAO dao;
	@Autowired
	private OrcamentoProdutosDAO orcamentoProdutosDAO;
	@Autowired
	private ProdutoMediator produtoMediator;
	
	@Override
	@Transactional
	public void incluir(Orcamento entidade) {
		if (entidade == null || entidade.getProdutosOrcamento() == null) {
			return;
		}
		dao.incluir(entidade);
		List<OrcamentoProdutos> produtosOrcamento = entidade.getProdutosOrcamento();
		for(OrcamentoProdutos o : produtosOrcamento) {
			Produto produto = produtoMediator.obterPorId(o.getProduto().getId());
			o.setProduto(produto);
			o.setOrcamento(entidade);
			if(o.getQuantidadeProdutos() != 0L) {
				orcamentoProdutosDAO.incluir(o);
			}
		}
		
	}
	
	@Override
	protected DAO<Orcamento> getDAO() {
		return dao;
	}
}
