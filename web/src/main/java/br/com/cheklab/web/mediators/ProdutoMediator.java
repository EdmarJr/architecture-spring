package br.com.cheklab.web.mediators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cheklab.web.dao.ProdutoDAO;
import br.com.cheklab.web.entity.Produto;

@Service
public class ProdutoMediator {
	
	@Autowired
	private ProdutoDAO dao;
	
	public List<Produto> obterProdutos() {
		return dao.obterProdutos();
	}
}
