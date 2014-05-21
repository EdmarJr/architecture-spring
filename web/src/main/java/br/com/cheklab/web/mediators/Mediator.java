package br.com.cheklab.web.mediators;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.DAO;

public abstract class Mediator<T> {
	@Transactional
	public void incluir(T entidade) {
		getDAO().incluir(entidade);
	}

	@Transactional
	public void alterar(T entidade) {
		getDAO().alterar(entidade);

	}

	@Transactional
	public void excluir(T entidade) {
		getDAO().excluir(entidade);

	}
	
	@Transactional(readOnly = true)
	public List<T> obterTodos() {
		return getDAO().obterTodos();
	}
	
	@Transactional(readOnly = true)
	public T obterPorId(Long id) {
		return getDAO().buscarPorId(id);
	}

	protected abstract DAO<T> getDAO();
}
