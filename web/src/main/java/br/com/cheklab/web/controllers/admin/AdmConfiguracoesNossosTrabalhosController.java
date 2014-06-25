package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.config.Inicializacao;
import br.com.cheklab.web.entity.TrabalhoRealizado;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoNossosTrabalhos;
import br.com.cheklab.web.mediators.ConfiguracaoNossosTrabalhosMediator;
import br.com.cheklab.web.mediators.ImagemMediator;

@Controller
public class AdmConfiguracoesNossosTrabalhosController {

	@Autowired
	private ConfiguracaoNossosTrabalhosMediator mediator;
	@Autowired
	private Inicializacao inicializacao;
	@Autowired
	private ImagemMediator imagemMediator;
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin/configuracao/nossosTrabalhos")
	public ModelAndView carregarConfiguracao() {
		ModelAndView model = new ModelAndView();
		ConfiguracaoNossosTrabalhos configuracao = mediator.obterConfiguracao();
		model.addObject("configuracaoNossosTrabalhos", configuracao);
		model.addObject("trabalhoRealizado", new TrabalhoRealizado());
		model.setViewName("/admin/configuracao/configuracaoNossosTrabalhos");
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/configuracao/nossosTrabalhos")
	@ResponseBody
	public String alterarConfiguracao(ConfiguracaoNossosTrabalhos configuracaoNossosTrabalhos) {
		mediator.alterar(configuracaoNossosTrabalhos);
		inicializacao.carregarConfiguracoes();
		return "Configurações alteradas com sucesso.";
	}

}
