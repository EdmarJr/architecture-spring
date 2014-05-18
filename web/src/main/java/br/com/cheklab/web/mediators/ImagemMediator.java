package br.com.cheklab.web.mediators;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.dao.ImagemDAO;
import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.utils.GerenciadorImagem;

@Service
public class ImagemMediator extends Mediator<Imagem>{
	@Autowired
	private ImagemDAO dao;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor={RuntimeException.class})
	public void excluir(Imagem imagem) {
		imagem = dao.buscarPorId(imagem.getId());
		String caminhoAmpliada = servletContext.getRealPath("/") + "resources" + File.separator + imagem.getEndereco();
		String caminhoMiniatura = servletContext.getRealPath("/") + "resources" + File.separator + imagem.getEnderecoMiniatura();	
		if(GerenciadorImagem.excluirImagem(caminhoAmpliada) && GerenciadorImagem.excluirImagem(caminhoMiniatura)) {
			dao.excluir(imagem);
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public void incluir(Imagem entidade) {
		entidade.setEndereco(GerenciadorImagem.salvarImagem(
				entidade.getEndereco(), definirEnderecoImagem(entidade, "ampliada")));
		entidade.setEnderecoMiniatura(GerenciadorImagem.salvarImagem(
				entidade.getEnderecoMiniatura(),
				definirEnderecoImagem(entidade, "miniatura")));
		getDAO().incluir(entidade);
	}
	
	@Override
	public void alterar(Imagem entidade) {
		entidade.setEndereco(GerenciadorImagem.salvarImagem(
				entidade.getEndereco(), definirEnderecoImagem(entidade, "ampliada")));
		entidade.setEnderecoMiniatura(GerenciadorImagem.salvarImagem(
				entidade.getEnderecoMiniatura(),
				definirEnderecoImagem(entidade, "miniatura")));
		getDAO().alterar(entidade);
	}
	
	private String definirEnderecoImagem(Imagem imagem, String tipoImagem) {
		return servletContext.getRealPath("/") + "resources" + File.separator
				+ "images" + File.separator + imagem.getTipoEntidade()
				+ File.separator + tipoImagem + File.separator
				+ imagem.getNome();
	}


	@Override
	protected DAO<Imagem> getDAO() {
		return dao;
	}
	
	public Imagem obterImagemPorIdEnderecoBase64(Long id) {
		Imagem imagem = getDAO().buscarPorId(id);
		imagem.setEndereco(GerenciadorImagem.obterImagemBase64(servletContext.getRealPath("/")+"resources"+File.separator+imagem.getEndereco()));
		imagem.setEnderecoMiniatura(GerenciadorImagem.obterImagemBase64(servletContext.getRealPath("/")+"resources"+File.separator+imagem.getEnderecoMiniatura()));
		return imagem;
}

}
