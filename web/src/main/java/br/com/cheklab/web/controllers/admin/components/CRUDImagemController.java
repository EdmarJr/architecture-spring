package br.com.cheklab.web.controllers.admin.components;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cheklab.web.entity.EntidadeComImagens;
import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.enums.TipoInclusaoImagemEnum;
import br.com.cheklab.web.mediators.ImagemMediator;
import br.com.cheklab.web.mediators.Mediator;
import br.com.cheklab.web.mediators.ProdutoMediator;

@Component
public class CRUDImagemController {

	@Autowired
	private ProdutoMediator produtoMediator;
	@Autowired
	private ImagemMediator imagemMediator;
	@Autowired
	private ServletContext context;

	public void incluir(Imagem imagem) {
		if (TipoInclusaoImagemEnum.obterPorDescricao(imagem.getTipoEntidade()) == TipoInclusaoImagemEnum.PRODUTO) {
			incluir(imagem, produtoMediator);
		}
	}
	public void alterar(Imagem imagem) {
		imagemMediator.alterar(imagem);
	}
	public void excluir(Imagem imagem) {
		if (TipoInclusaoImagemEnum.obterPorDescricao(imagem.getTipoEntidade()) == TipoInclusaoImagemEnum.PRODUTO) {
			excluir(imagem, produtoMediator);
		}
	}

	@SuppressWarnings("unchecked")
	private void excluir(Imagem imagem,
			@SuppressWarnings("rawtypes") Mediator mediator) {
		EntidadeComImagens entidade = (EntidadeComImagens) mediator
				.obterPorId(imagem.getIdEntidade());
		entidade.getImagens().remove(imagem);
		mediator.alterar(entidade);
		imagemMediator.excluir(imagem);
	}

	@SuppressWarnings({ "unchecked" })
	private void incluir(Imagem imagem,
			@SuppressWarnings("rawtypes") Mediator mediator) {
		EntidadeComImagens entidade = (EntidadeComImagens) mediator
				.obterPorId(imagem.getIdEntidade());
		entidade.getImagens().add(imagem);
		mediator.alterar(entidade);
	}
	
}
