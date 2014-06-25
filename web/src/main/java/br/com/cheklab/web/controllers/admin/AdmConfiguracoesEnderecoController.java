package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.config.Inicializacao;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoEndereco;
import br.com.cheklab.web.mediators.ConfiguracaoEnderecoMediator;
import br.com.cheklab.web.mediators.ImagemMediator;

@Controller
public class AdmConfiguracoesEnderecoController {

	@Autowired
	private ConfiguracaoEnderecoMediator mediator;
	@Autowired
	private ImagemMediator imagemMediator;
	@Autowired
	private Inicializacao inicializacao;

	@RequestMapping(method = RequestMethod.GET, value = "/admin/configuracao/endereco")
	public ModelAndView carregarConfiguracao() {
		ModelAndView model = new ModelAndView();
		ConfiguracaoEndereco configuracao = mediator.obterConfiguracao();
		model.addObject("configuracaoEndereco", configuracao);
		model.setViewName("/admin/configuracao/configuracaoEndereco");
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/configuracao/endereco")
	@ResponseBody
	public String alterarConfiguracao(ConfiguracaoEndereco configuracaoEndereco) {
		mediator.alterar(configuracaoEndereco);
		inicializacao.carregarConfiguracoes();
		return "Configurações alteradas com sucesso.";
	}

}
