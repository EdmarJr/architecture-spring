package br.com.cheklab.web.controllers;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.utils.ConfiguracoesUtils;

@Component
public class MasterController implements Serializable{
	public ModelAndView obterModelAndView() {
		ModelAndView model = new ModelAndView();
		model.addObject("configuracao", ConfiguracoesUtils.getConfiguracao());
		model.addObject("configuracaoPaginaOrcamento", ConfiguracoesUtils.getConfiguracaoPaginaOrcamento());
		model.addObject("configuracaoPaginaInicial", ConfiguracoesUtils.getConfiguracaoPaginaInicial());
		model.addObject("configuracaoPaginaProdutos", ConfiguracoesUtils.getConfiguracaoPaginaProdutos());
		model.addObject("configuracaoEndereco", ConfiguracoesUtils.getConfiguracaoEndereco());
		model.addObject("configuracaoNossosTrabalhos",
				ConfiguracoesUtils.getConfiguracaoNossosTrabalhos());
		return model;
	}
}
