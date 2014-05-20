package br.com.cheklab.web.mediators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cheklab.web.dao.CategoriaDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.Categoria;

@Service
public class CategoriaMediator extends Mediator<Categoria> {

	@Autowired
	private CategoriaDAO dao;

	@Override
	public List<Categoria> obterTodos() {
		return dao.obterCategoriasEFilhas();
	}

	@Override
	protected DAO<Categoria> getDAO() {
		return dao;
	}

	@Override
	public void incluir(Categoria entidade) {
		entidade.setAtivo(Boolean.TRUE);
		getDAO().incluir(entidade);
	}

	@Override
	public void alterar(Categoria entidade) {
		entidade.setAtivo(Boolean.TRUE);
		getDAO().alterar(entidade);
	}

	@Override
	public void excluir(Categoria entidade) {
		entidade.setAtivo(Boolean.FALSE);
		getDAO().alterar(entidade);
	}

}
