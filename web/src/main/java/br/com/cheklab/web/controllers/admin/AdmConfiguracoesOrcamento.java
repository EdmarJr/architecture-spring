package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoOrcamento;
import br.com.cheklab.web.mediators.ConfiguracaoOrcamentoMediator;

@Controller
public class AdmConfiguracoesOrcamento {

	@Autowired
	private ConfiguracaoOrcamentoMediator mediator;
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin/configuracao/orcamento")
	public ModelAndView carregarConfiguracao() {
		ModelAndView model = new ModelAndView();
		ConfiguracaoOrcamento configuracaoOrcamento = mediator
				.obterConfiguracaoOrcamento();
		model.addObject("configuracaoOrcamento", configuracaoOrcamento);
		model.setViewName("/admin/configuracao/configuracaoOrcamento");
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/configuracao/orcamento")
	@ResponseBody
	public String alterarConfiguracao(
			ConfiguracaoOrcamento configuracaoOrcamento) {
		mediator.alterar(configuracaoOrcamento);
		return "Configurações alteradas com sucesso.";
	}

}
