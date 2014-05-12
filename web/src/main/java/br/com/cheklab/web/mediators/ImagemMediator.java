package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cheklab.web.dao.ImagemDAO;
import br.com.cheklab.web.entity.Imagem;

@Service
public class ImagemMediator {
	
	@Autowired
	private ImagemDAO dao;
	
	public void excluir(Imagem imagem) {
		dao.excluir(imagem);
	}

}
