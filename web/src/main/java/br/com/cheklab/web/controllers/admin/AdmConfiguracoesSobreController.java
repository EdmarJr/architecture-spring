package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.config.Inicializacao;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoSobre;
import br.com.cheklab.web.mediators.ConfiguracaoSobreMediator;
import br.com.cheklab.web.mediators.ImagemMediator;

@Controller
public class AdmConfiguracoesSobreController {

	@Autowired
	private ConfiguracaoSobreMediator mediator;
	@Autowired
	private ImagemMediator imagemMediator;
	@Autowired
	private Inicializacao inicializacao;

	@RequestMapping(method = RequestMethod.GET, value = "/admin/configuracao/sobre")
	public ModelAndView carregarConfiguracao() {
		ModelAndView model = new ModelAndView();
		ConfiguracaoSobre configuracao = mediator.obterConfiguracao();
		model.addObject("configuracaoSobre", configuracao);
		model.setViewName("/admin/configuracao/configuracaoSobre");
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/configuracao/sobre")
	@ResponseBody
	public String alterarConfiguracao(ConfiguracaoSobre configuracaoSobre) {
		mediator.alterar(configuracaoSobre);
		inicializacao.carregarConfiguracoes();
		return "Configurações alteradas com sucesso.";
	}

}
