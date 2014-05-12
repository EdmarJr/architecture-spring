package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.mediators.ImagemMediator;

@Controller
public class AdmImagemController {

	@Autowired
	private ImagemMediator mediator;

	@RequestMapping(value = "/admin/image/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Boolean excluirImagem(@PathVariable int id) {
		Imagem imagem = new Imagem();
		imagem.setId(new Long(id));
		mediator.excluir(imagem);
		return true;
	}
}
