package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.config.Inicializacao;
import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaInicial;
import br.com.cheklab.web.mediators.ConfiguracaoPaginaInicialMediator;
import br.com.cheklab.web.mediators.ImagemMediator;

@Controller
public class AdmConfiguracoesPaginaInicialController {

	@Autowired
	private ConfiguracaoPaginaInicialMediator mediator;
	@Autowired
	private Inicializacao inicializacao;
	@Autowired
	private ImagemMediator imagemMediator;

	@RequestMapping(method = RequestMethod.GET, value = "/admin/configuracao/paginaInicial")
	public ModelAndView carregarConfiguracao() {
		ModelAndView model = new ModelAndView();
		ConfiguracaoPaginaInicial configuracao = mediator.obterConfiguracao();
		if (configuracao.getImagemPaginaInicial() != null) {
			configuracao.setImagemPaginaInicial(imagemMediator
					.obterImagemPorIdEnderecoBase64(configuracao
							.getImagemPaginaInicial().getId()));
		}

		model.addObject("configuracaoPaginaInicial", configuracao);
		model.addObject("imagem", new Imagem());
		model.setViewName("/admin/configuracao/configuracaoPaginaInicial");
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/configuracao/paginaInicial")
	@ResponseBody
	public String alterarConfiguracao(
			ConfiguracaoPaginaInicial configuracaoPaginaInicial) {
		imagemMediator.gerenciarEntidadeComImagem(configuracaoPaginaInicial);
		ConfiguracaoPaginaInicial config = mediator
				.obterPorId(configuracaoPaginaInicial.getId());
		config.setPaginaInicial(configuracaoPaginaInicial.getImagemPaginaInicial());
		config.setTexto1(configuracaoPaginaInicial.getTexto1());
		config.setTexto2(configuracaoPaginaInicial.getTexto2());
		config.setTituloTexto1(configuracaoPaginaInicial.getTituloTexto1());
		config.setTituloTexto2(configuracaoPaginaInicial.getTituloTexto2());
		config.setTextoImagem(configuracaoPaginaInicial.getTextoImagem());
		mediator.alterar(config);
		inicializacao.carregarConfiguracoes();
		return "Configurações alteradas com sucesso.";
	}

}
