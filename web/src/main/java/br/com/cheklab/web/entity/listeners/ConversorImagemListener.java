package br.com.cheklab.web.entity.listeners;

import java.io.File;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cheklab.web.config.AutowireHelper;
import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.utils.GerenciadorImagem;

@Component
public class ConversorImagemListener {

	@Autowired
	private GerenciadorImagem gerenciadorImagem;
	@Autowired
	private ServletContext servletContext;

	@PrePersist
	@PreUpdate
	public void converterImagem(Imagem entidade) {
		if (entidade.getAtivo() == null) {
			entidade.setAtivo(Boolean.TRUE);
		}
		if (entidade.getEndereco() == null
				|| entidade.getEnderecoMiniatura() == null) {
			return;
		}
		AutowireHelper.autowire(this, this.gerenciadorImagem);
		entidade.setEndereco(gerenciadorImagem.salvarImagem(
				entidade.getEndereco(),
				definirEnderecoImagem(entidade, "ampliada")));
		entidade.setEnderecoMiniatura(gerenciadorImagem.salvarImagem(
				entidade.getEnderecoMiniatura(),
				definirEnderecoImagem(entidade, "miniatura")));
	}

	private String definirEnderecoImagem(Imagem imagem, String tipoImagem) {
		AutowireHelper.autowire(this, this.servletContext);
		return servletContext.getRealPath("/") + "resources" + File.separator
				+ "images" + File.separator + imagem.getTipoEntidade()
				+ File.separator + tipoImagem + File.separator
				+ imagem.getNome();
	}

	@PostPersist
	private void setContadorImagem(Imagem imagem) {
		GerenciadorImagem.contadorImagem = imagem.getId();
	}


}
