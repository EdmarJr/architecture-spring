package br.com.cheklab.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.entity.Categoria;
import br.com.cheklab.web.entity.Produto;
import br.com.cheklab.web.mediators.CategoriaMediator;
import br.com.cheklab.web.mediators.ProdutoMediator;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoMediator mediator;
	@Autowired
	private CategoriaMediator categoriaMediator;
	@Autowired
	private MasterController controller;

	private ModelAndView obterView() {
		ModelAndView model = controller.obterModelAndView();
		model.addObject("produtoPesquisa", new Produto());
		model.addObject("categorias", categoriaMediator.obterTodos());
		return model;
	}

	@RequestMapping(value = "/produtos/filtrar**", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView filtrarPesquisa(Produto produtoPesquisa) {
		List<Produto> produtos = mediator.filtrarComPaginacao(1,
				produtoPesquisa);
		ModelAndView model = obterView();
		model.addObject("produtos", produtos);
		model.setViewName("produtos/galeriaProdutos");
		return model;
	}

	@RequestMapping(value = "/produtos**", method = RequestMethod.GET)
	public ModelAndView paginaProdutos(
			@RequestParam(value = "idCategoria", required = false, defaultValue = "-1") Long idCategoria) {
		ModelAndView model = obterView();
		Categoria categoria = null;
		if (idCategoria == -1) {
			categoria = categoriaMediator.obterCategoriaPrincipal();
		} else {
			categoria = categoriaMediator.obterPorId(idCategoria);
		}
		List<Produto> produtos = mediator
				.obterProdutosPorCategoriaPaginaComInicializacaoDeImagens(
						categoria, 1L);
		model.addObject("produtos", produtos);
		model.setViewName("produtos/galeriaProdutos");
		return model;
	}

	@RequestMapping(value = "/produtosPaginados/pagina**", method = RequestMethod.GET)
	public ModelAndView proximaPagina(
			Long idPagina,
			@RequestParam(value = "idCategoria", required = false, defaultValue = "1") Long idCategoria,
			@RequestParam(value = "criterioPesquisa", required = false, defaultValue = "N/A") String criterioPesquisa) {

		List<Produto> produtos = null;
		if (!criterioPesquisa.equals("N/A")) {
			Produto produto = new Produto();
			produto.setNome(criterioPesquisa);
			produtos = mediator.filtrarComPaginacao(
					Integer.parseInt(idPagina.toString()), produto);
		} else {
			produtos = mediator
					.obterProdutosPorCategoriaPaginaComInicializacaoDeImagens(
							categoriaMediator.obterPorId(idCategoria), idPagina);
		}
		ModelAndView model = controller.obterModelAndView();
		model.addObject("produtos", produtos);
		model.setViewName("withoutTemplate/paginacaoProdutos");
		return model;
	}

	@RequestMapping(value = "/produtos/detalhar**", method = RequestMethod.GET)
	public ModelAndView paginaDetalharProduto(
			@RequestParam(value = "idProduto", required = false, defaultValue = "1") Long idProduto) {
		ModelAndView model = obterView();
		model.setViewName("produtos/detalharProduto");
		Produto produto = mediator.obterPorId(idProduto);
		model.addObject("produto", produto);
		return model;
	}
}
