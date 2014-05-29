package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.entity.configuracoes.Configuracao;
import br.com.cheklab.web.mediators.ConfiguracaoMediator;

@Controller
public class AdmConfiguracoesGerais {

	@Autowired
	private ConfiguracaoMediator mediator;
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin/configuracao/gerais")
	public ModelAndView carregarConfiguracao() {
		ModelAndView model = new ModelAndView();
		model.addObject("configuracao", mediator.obterConfiguracao());
		model.setViewName("/admin/configuracao/gerais");
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/configuracao/gerais")
	public String alterarConfiguracao(@ModelAttribute Configuracao configuracao) {
		mediator.alterar(configuracao);
		return "";
	}

}
