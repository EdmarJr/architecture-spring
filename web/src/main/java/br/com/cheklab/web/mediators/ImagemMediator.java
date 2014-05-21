package br.com.cheklab.web.mediators;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Transactional(readOnly = true)
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

	@Transactional(readOnly = true)
	public Long obterContadorImagem() {
		Imagem registro = dao.obterRegistroMaiorId();
		if (registro == null) {
			return 0L;
		}
		return registro.getId();
	}

	@Override
	public void excluir(Imagem entidade) {
		entidade = obterPorId(entidade.getId());
		entidade.setAtivo(Boolean.FALSE);
		alterar(entidade);
	}

	@Override
	protected DAO<Imagem> getDAO() {
		return dao;
	}

}
