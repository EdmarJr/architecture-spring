package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cheklab.web.entity.TrabalhoRealizado;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoNossosTrabalhos;
import br.com.cheklab.web.mediators.ConfiguracaoNossosTrabalhosMediator;
import br.com.cheklab.web.mediators.ImagemMediator;
import br.com.cheklab.web.mediators.TrabalhoRealizadoMediator;

@Controller
public class AdmTrabalhoRealizadoController {

	@Autowired
	private TrabalhoRealizadoMediator mediator;
	@Autowired
	private ImagemMediator imagemMediator;
	@Autowired
	private ConfiguracaoNossosTrabalhosMediator configMediator;

	@RequestMapping(method = RequestMethod.POST, value = "/admin/trabalhoRealizado/incluir")
	@ResponseBody
	public String incluirTrabalhoRealizado(TrabalhoRealizado trabalhoRealizado, ConfiguracaoNossosTrabalhos configuracaoNossosTrabalhos) {
		trabalhoRealizado.setId(null);
		trabalhoRealizado.setConfiguracaoNossosTrabalhos(configMediator.obterPorId(configuracaoNossosTrabalhos.getId()));
		imagemMediator.gerenciarEntidadeComImagem(trabalhoRealizado);
		mediator.incluir(trabalhoRealizado);
		return "Inclusão realizada com sucesso.";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/trabalhoRealizado/excluir")
	@ResponseBody
	public String excluirTrabalhoRealizado(Long idEntidade) {
		TrabalhoRealizado trabalhoRealizado = mediator.obterPorId(idEntidade);
		trabalhoRealizado.setConfiguracaoNossosTrabalhos(null);
		mediator.alterar(trabalhoRealizado);
		Long retorno = trabalhoRealizado.getId();
		return retorno.toString();
	}

}
