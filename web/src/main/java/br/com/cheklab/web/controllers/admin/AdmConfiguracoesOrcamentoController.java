package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.config.Inicializacao;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaOrcamento;
import br.com.cheklab.web.mediators.ConfiguracaoOrcamentoMediator;

@Controller
public class AdmConfiguracoesOrcamentoController {

	@Autowired
	private ConfiguracaoOrcamentoMediator mediator;
	
	@Autowired
	private Inicializacao inicializacao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin/configuracao/orcamento")
	public ModelAndView carregarConfiguracao() {
		ModelAndView model = new ModelAndView();
		ConfiguracaoPaginaOrcamento configuracaoOrcamento = mediator
				.obterConfiguracao();
		model.addObject("configuracaoOrcamento", configuracaoOrcamento);
		model.setViewName("/admin/configuracao/configuracaoOrcamento");
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/configuracao/orcamento")
	@ResponseBody
	public String alterarConfiguracao(
			ConfiguracaoPaginaOrcamento configuracaoOrcamento) {
	
		mediator.alterar(configuracaoOrcamento);
		inicializacao.carregarConfiguracoes();
		return "Configurações alteradas com sucesso.";
	}

}
