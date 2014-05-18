package br.com.cheklab.web.controllers.admin.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.entity.Produto;
import br.com.cheklab.web.enums.TipoInclusaoImagemEnum;
import br.com.cheklab.web.mediators.ImagemMediator;
import br.com.cheklab.web.mediators.ProdutoMediator;

@Component
public class CRUDImagemController {

	@Autowired
	private ProdutoMediator produtoMediator;
	@Autowired
	private ImagemMediator imagemMediator;	
	
	
	public void incluir(Imagem imagem) {
		if (TipoInclusaoImagemEnum.obterPorDescricao(imagem.getTipoEntidade()) == TipoInclusaoImagemEnum.PRODUTO) {
			incluirImagemProduto(imagem);
		}
	}
	public void alterar(Imagem imagem) {
		if (TipoInclusaoImagemEnum.obterPorDescricao(imagem.getTipoEntidade()) == TipoInclusaoImagemEnum.PRODUTO) {
			editarImagemProduto(imagem);
		}
	}
	public void excluir(Imagem imagem) {
		imagemMediator.excluir(imagem);
	}
	
	private void editarImagemProduto(Imagem imagem) {
		Imagem imagemTemp = imagemMediator.obterPorId(imagem.getId());
		imagem.setProduto(imagemTemp.getProduto());
		imagemMediator.alterar(imagem);
	}


	private void incluirImagemProduto(Imagem imagem) {
		Produto produto = produtoMediator
				.obterPorId(imagem.getIdEntidade());
		imagem.setProduto(produto);
		imagemMediator.incluir(imagem);
	}
	
}
