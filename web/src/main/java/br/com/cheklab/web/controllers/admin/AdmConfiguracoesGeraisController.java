package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.entity.configuracoes.Configuracao;
import br.com.cheklab.web.mediators.ConfiguracaoMediator;
import br.com.cheklab.web.mediators.ImagemMediator;

@Controller
public class AdmConfiguracoesGeraisController {

	@Autowired
	private ConfiguracaoMediator mediator;
	@Autowired
	private ImagemMediator imagemMediator;
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin/configuracao/gerais")
	public ModelAndView carregarConfiguracao() {
		ModelAndView model = new ModelAndView();
		Configuracao configuracao = mediator.obterConfiguracao();
		model.addObject("configuracao", configuracao);
		model.setViewName("/admin/configuracao/gerais");
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/configuracao/gerais")
	@ResponseBody
	public String alterarConfiguracao(Configuracao configuracao) {
		configuracao.getImagem().setEnderecoMiniatura(configuracao.getImagem().getEndereco());
		configuracao.getImagem().setTipoEntidade("configuracao");
		configuracao.getImagem().setNome("logo");
		configuracao.getImagem().setIdEntidade(configuracao.getId());
		mediator.alterar(configuracao);
		return "Configurações alteradas com sucesso.";
	}

}
