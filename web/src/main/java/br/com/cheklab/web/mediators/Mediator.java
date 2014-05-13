package br.com.cheklab.web.mediators;

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

	protected abstract DAO<T> getDAO();
}
