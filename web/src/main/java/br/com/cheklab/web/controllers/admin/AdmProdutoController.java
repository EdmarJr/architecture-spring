package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.converters.CategoriaConverter;
import br.com.cheklab.web.entity.Categoria;
import br.com.cheklab.web.entity.Produto;
import br.com.cheklab.web.mediators.CategoriaMediator;
import br.com.cheklab.web.mediators.ProdutoMediator;

@Controller
public class AdmProdutoController {

	@Autowired
	private ProdutoMediator mediator;
	@Autowired
	private CategoriaMediator categoriaMediator;

	@Autowired
	private CategoriaConverter categoriaConverter;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Categoria.class, "categoria",
				this.categoriaConverter);
	}

	@RequestMapping(value = "/admin/produtos**", method = RequestMethod.GET)
	public ModelAndView paginaProdutos() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/produtos");
		model.addObject("produtos", mediator.obterProdutos());
		return model;
	}

	@RequestMapping(value = "/admin/produto/incluir**", method = RequestMethod.GET)
	public ModelAndView acionarIncluirProduto() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/produto/incluirProduto");
		model.addObject("categoriasSelect", categoriaMediator.obterTodos());
		model.addObject("produto", new Produto());
		return model;
	}

	@RequestMapping(value = "/admin/produto/incluir**", method = RequestMethod.POST)
	public ModelAndView incluirProduto(
			@ModelAttribute("produto") Produto produto, BindingResult result,
			Model model) {
		incluirProduto(produto);
		return paginaProdutos();
	}

	@RequestMapping(value = "/admin/produto/editar**", method = RequestMethod.GET)
	public ModelAndView acionarAlterarProduto(
			@RequestParam(value = "idProduto", required = true) Long idProduto) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/produto/editarProduto");
		Produto produto = mediator.obterPorIdComInializacaoDeImagens(idProduto);
		model.addObject("produto",
				produto);
		model.addObject("categoria", produto.getCategoria());
		model.addObject("categoriasSelect", categoriaMediator.obterTodos());
		return model;
	}

	@RequestMapping(value = "/admin/produto/editar**", method = RequestMethod.POST)
	public ModelAndView alterarProduto(Produto produto,
			BindingResult result, Model model) {
		alterarProduto(produto);
		return paginaProdutos();
	}

	@RequestMapping(value = "/admin/produto/excluir", method = RequestMethod.POST)
	@ResponseBody
	public String excluir(Long idEntidade) {
		Produto produto = new Produto();
		produto.setId(idEntidade);
		mediator.excluir(produto);
		return idEntidade.toString();
	}

	@RequestMapping(value = "/admin/produto/incluirAjax", method = RequestMethod.POST)
	@ResponseBody
	public String incluirProdutoAjax(Produto produto) {
		incluirProduto(produto);
		return produto.getId().toString();
	}

	@RequestMapping(value = "/admin/produto/editarAjax", method = RequestMethod.POST)
	@ResponseBody
	public String alterarProdutoAjax(Produto produto) {
		alterarProduto(produto);
		return produto.getId().toString();
	}

	private void alterarProduto(Produto produto) {
		Produto produtoTemp = mediator.obterPorId(produto.getId());
		produto.setImagens(produtoTemp.getImagens());
		mediator.alterar(produtoTemp);
	}

	private void incluirProduto(Produto produto) {
		mediator.incluir(produto);
	}

}
