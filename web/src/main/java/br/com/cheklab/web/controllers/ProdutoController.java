package br.com.cheklab.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.entity.Produto;
import br.com.cheklab.web.mediators.CategoriaMediator;
import br.com.cheklab.web.mediators.ProdutoMediator;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoMediator mediator;
	@Autowired
	private CategoriaMediator categoriaMediator;
	
	@RequestMapping(value = "/produtos**", method = RequestMethod.GET)
	public ModelAndView paginaProdutos(
			@RequestParam(value = "idCategoria", required = false, defaultValue = "1") Long idCategoria,
			@RequestParam(value = "idPagina", required = false, defaultValue = "1") Long idPagina) {
		ModelAndView model = new ModelAndView();
		model.setViewName("produtos/galeriaProdutos");
		List<Produto> produtos = mediator.obterProdutosPorCategoriaPaginaComInicializacaoDeImagens(
				categoriaMediator.obterPorId(idCategoria), idPagina);
		model.addObject("produtos",
				produtos);
		return model;
	}
}
