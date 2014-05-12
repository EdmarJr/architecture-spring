package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.Imagem;

@Repository
public class ImagemDAO extends DAO<Imagem> {

	@Override
	public Class<Imagem> getEntidade() {
		return Imagem.class;
	}
}
