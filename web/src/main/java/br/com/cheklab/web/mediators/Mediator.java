package br.com.cheklab.web.mediators;

import java.util.List;

import br.com.cheklab.web.dao.DAO;

public abstract class Mediator<T> {
	public void incluir(T entidade) {
		getDAO().incluir(entidade);
	}

	public void alterar(T entidade) {
		getDAO().alterar(entidade);

	}

	public void excluir(T entidade) {
		getDAO().excluir(entidade);

	}
	
	public List<T> obterTodos() {
		return getDAO().obterTodos();
	}
	
	public T obterPorId(Long id) {
		return getDAO().buscarPorId(id);
	}

	protected abstract DAO<T> getDAO();
}
