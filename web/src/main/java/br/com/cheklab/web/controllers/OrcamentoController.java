package br.com.cheklab.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.entity.Orcamento;
import br.com.cheklab.web.entity.OrcamentoProdutos;
import br.com.cheklab.web.mediators.OrcamentoMediator;
import br.com.cheklab.web.mediators.ProdutoMediator;

@Controller
@Scope("session")
public class OrcamentoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private OrcamentoMediator mediator;
	@Autowired
	private ProdutoMediator produtorMediator;
	private List<OrcamentoProdutos> orcamentos;
	private Orcamento orcamento;

	@PostConstruct
	private void init() {
		orcamento = new Orcamento();
		orcamentos = new ArrayList<OrcamentoProdutos>();
	}

	private ModelAndView obterView() {
		ModelAndView model = new ModelAndView();
		model.addObject("orcamentos", orcamentos);
		return model;
	}

	@RequestMapping(value = "/orcamentos**", method = RequestMethod.GET)
	public ModelAndView paginaOrcamentos(
			@RequestParam(value = "idCategoria", required = false, defaultValue = "1") Long idCategoria,
			@RequestParam(value = "idPagina", required = false, defaultValue = "1") Long idPagina) {
		ModelAndView model = obterView();
		model.addObject("orcamentos", orcamentos);
		model.addObject("orcamento", orcamento);
		model.setViewName("/orcamento/gerenciarOrcamentos");
		return model;
	}

	@RequestMapping(value = "/adicionarProdutoOrcamento**", method = RequestMethod.POST)
	@ResponseBody
	public String adicionarOrcamento(Long idProduto) {
		OrcamentoProdutos orcamentoTemp = new OrcamentoProdutos();
		orcamentoTemp.setQuantidadeProdutos(1L);
		orcamentoTemp.setOrcamento(orcamento);
		orcamentoTemp.setProduto(produtorMediator
				.obterPorIdComInializacaoDeImagens(idProduto));
		orcamentos.add(orcamentoTemp);
		return "sucesso";
	}

	@RequestMapping(value = "/incluirOrcamento**", method = RequestMethod.POST)
	@ResponseBody
	public String enviarOrcamento(Orcamento orcamento) {
		mediator.incluir(orcamento);
		return "sucesso";
	}
}
