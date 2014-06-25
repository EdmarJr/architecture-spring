package br.com.cheklab.web.mediators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.CategoriaDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.Categoria;

@Service
public class CategoriaMediator extends Mediator<Categoria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoriaDAO dao;

	@Override
	@Transactional(readOnly=true)
	public List<Categoria> obterTodos() {
		return dao.obterCategoriasEFilhas();
	}
	
	@Transactional(readOnly=true)
	public Categoria obterPorPosicao(Integer posicao) {
		return dao.obterPorPosicao(posicao);
	}
	
	@Transactional(readOnly=true)
	public Categoria obterCategoriaPrincipal() {
		return obterPorPosicao(1);
	}

	@Override
	protected DAO<Categoria> getDAO() {
		return dao;
	}
	
	@Override
	@Transactional
	public void incluir(Categoria entidade) {
		validarPosicoes(entidade);
		dao.incluir(entidade);
	}
	
	@Override
	@Transactional
	public void excluir(Categoria entidade) {
		entidade.setAtivo(Boolean.FALSE);
		getDAO().alterar(entidade);
	}
	
	@Override
	@Transactional
	public void alterar(Categoria categoria) {
		validarPosicoes(categoria);
		getDAO().alterar(categoria);

	}

	private void validarPosicoes(Categoria categoria) {
		if(categoria.getPosicao() == 1 && seExisteCategoriaComPosicaoUm()) {
			ajustarAntigoRegistroComPosicaoUm();
		}
	}

	private void ajustarAntigoRegistroComPosicaoUm() {
		Categoria categoriaPosicao = obterPorPosicao(1);
		categoriaPosicao.setPosicao(2);
		getDAO().alterar(categoriaPosicao);
	}
	
	private Boolean seExisteCategoriaComPosicaoUm() {
		Categoria categoriaPosicao = obterPorPosicao(1);
		if(categoriaPosicao != null) {
			getDAO().desligar(categoriaPosicao);
			return true;
		}
		return false;
	}

}
