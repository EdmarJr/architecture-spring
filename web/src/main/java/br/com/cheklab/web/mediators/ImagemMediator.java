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
public class ImagemMediator extends Mediator<Imagem> {
	@Autowired
	private ImagemDAO dao;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private GerenciadorImagem gerenciadorImagem;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	public void excluir(Imagem imagem) {
		imagem = dao.buscarPorId(imagem.getId());
		dao.excluir(imagem);
	}

	@Override
	public void incluir(Imagem entidade) {
		definirEnderecoImagens(entidade);
		getDAO().incluir(entidade);
	}

	@Override
	public void alterar(Imagem entidade) {
		definirEnderecoImagens(entidade);
		getDAO().alterar(entidade);
	}

	public void definirEnderecoImagens(Imagem entidade) {
		entidade.setEndereco(gerenciadorImagem.salvarImagem(
				entidade.getEndereco(),
				definirEnderecoImagem(entidade, "ampliada")));
		entidade.setEnderecoMiniatura(gerenciadorImagem.salvarImagem(
				entidade.getEnderecoMiniatura(),
				definirEnderecoImagem(entidade, "miniatura")));
	}

	private String definirEnderecoImagem(Imagem imagem, String tipoImagem) {
		return servletContext.getRealPath("/") + "resources" + File.separator
				+ "images" + File.separator + imagem.getTipoEntidade()
				+ File.separator + tipoImagem + File.separator
				+ imagem.getNome();
	}


	public Imagem obterImagemPorIdEnderecoBase64(Long id) {
		Imagem imagem = getDAO().buscarPorId(id);
		imagem.setEndereco(gerenciadorImagem.obterImagemBase64(servletContext
				.getRealPath("/")
				+ "resources"
				+ File.separator
				+ imagem.getEndereco()));
		imagem.setEnderecoMiniatura(gerenciadorImagem
				.obterImagemBase64(servletContext.getRealPath("/")
						+ "resources" + File.separator
						+ imagem.getEnderecoMiniatura()));
		return imagem;
	}

	public Long obterContadorImagem() {
		Imagem registro = dao.obterRegistroMaiorId();
		if (registro == null) {
			return 0L;
		}
		return registro.getId();
	}

	@Override
	protected DAO<Imagem> getDAO() {
		return dao;
	}

}
