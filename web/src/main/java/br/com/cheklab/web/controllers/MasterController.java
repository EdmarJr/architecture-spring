package br.com.cheklab.web.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.entity.Categoria;
import br.com.cheklab.web.utils.CategoriasUtils;
import br.com.cheklab.web.utils.ConfiguracoesUtils;

@Component
@Scope()
public class MasterController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModelAndView obterModelAndView() {
		ModelAndView model = new ModelAndView();
		model.addObject("configuracao", ConfiguracoesUtils.getConfiguracao());
		model.addObject("configuracaoPaginaOrcamento", ConfiguracoesUtils.getConfiguracaoPaginaOrcamento());
		model.addObject("configuracaoPaginaInicial", ConfiguracoesUtils.getConfiguracaoPaginaInicial());
		model.addObject("configuracaoPaginaProdutos", ConfiguracoesUtils.getConfiguracaoPaginaProdutos());
		model.addObject("configuracaoEndereco", ConfiguracoesUtils.getConfiguracaoEndereco());
		model.addObject("configuracaoNossosTrabalhos",
				ConfiguracoesUtils.getConfiguracaoNossosTrabalhos());
		model.addObject("configuracaoSobre",
				ConfiguracoesUtils.getConfiguracaoSobre());
		return model;
	}
	
}
