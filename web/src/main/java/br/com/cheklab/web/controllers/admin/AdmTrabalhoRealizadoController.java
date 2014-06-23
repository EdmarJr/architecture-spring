package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cheklab.web.entity.TrabalhoRealizado;
import br.com.cheklab.web.mediators.ImagemMediator;
import br.com.cheklab.web.mediators.TrabalhoRealizadoMediator;

@Controller
public class AdmTrabalhoRealizadoController {

	@Autowired
	private TrabalhoRealizadoMediator mediator;
	@Autowired
	private ImagemMediator imagemMediator;

	@RequestMapping(method = RequestMethod.POST, value = "/admin/trabalhoRealizado/incluir")
	@ResponseBody
	public String incluirTrabalhoRealizado(TrabalhoRealizado trabalhoRealizado) {
		mediator.incluir(trabalhoRealizado);
		return "Inclusão realizada com sucesso.";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/trabalhoRealizado/excluir")
	@ResponseBody
	public String excluirTrabalhoRealizado(Long idEntidade) {
		mediator.excluir(mediator.obterPorId(idEntidade));
		return "Exclusão realizada com sucesso.";
	}

}
