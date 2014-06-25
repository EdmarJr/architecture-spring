package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaInicial;
import br.com.cheklab.web.entity.configuracoes.EstrofePaginaInicial;
import br.com.cheklab.web.mediators.ConfiguracaoPaginaInicialMediator;
import br.com.cheklab.web.mediators.EstrofePaginaInicialMediator;
import br.com.cheklab.web.mediators.ImagemMediator;

@Controller
public class AdmEstrofePaginaInicialController {

	@Autowired
	private EstrofePaginaInicialMediator mediator;
	@Autowired
	private ImagemMediator imagemMediator;
	@Autowired
	private ConfiguracaoPaginaInicialMediator configMediator;

	@RequestMapping(method = RequestMethod.POST, value = "/admin/estrofePaginaInicial/incluir")
	@ResponseBody
	public String incluirEstrofePaginaInicial(
			EstrofePaginaInicial estrofePaginaInicial,
			ConfiguracaoPaginaInicial configuracaoPaginaInicial) {
		ConfiguracaoPaginaInicial config = configMediator
				.obterPorId(configuracaoPaginaInicial.getId());
		estrofePaginaInicial.setConfiguracaoPaginaInicial(config);
		estrofePaginaInicial.setId(null);
		mediator.incluir(estrofePaginaInicial);
		return "Inclusão realizada com sucesso.";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/estrofePaginaInicial/excluir")
	@ResponseBody
	public String excluirEstrofePaginaInicial(Long idEntidade) {
		EstrofePaginaInicial estrofePaginaInicial = mediator
				.obterPorId(idEntidade);
		estrofePaginaInicial.setConfiguracaoPaginaInicial(null);
		mediator.alterar(estrofePaginaInicial);
		Long retorno = estrofePaginaInicial.getId();
		return retorno.toString();
	}

}
