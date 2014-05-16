package br.com.cheklab.web.controllers.admin;

import javax.validation.Valid;

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
		binder.registerCustomEditor(Categoria.class, this.categoriaConverter);
	}

	@RequestMapping(value = "/admin/produtos**", method = RequestMethod.GET)
	public ModelAndView paginaProdutos() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/produtos");
		model.addObject("produtos", mediator.obterProdutos());
		return model;
	}

	@RequestMapping(value = "/admin/produto/incluir**", method = RequestMethod.GET)
	public ModelAndView incluirProduto() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/produto/incluirProduto");
		model.addObject("categoriasSelect", categoriaMediator.obterTodos());
		model.addObject("produto", new Produto());
		return model;
	}

	@RequestMapping(value = "/admin/produto/incluir**", method = RequestMethod.POST)
	public ModelAndView processSubmitIncluir(
			@ModelAttribute("produto") Produto produto, BindingResult result,
			Model model) {
		mediator.incluir(produto);
		return paginaProdutos();
	}

	@RequestMapping(value = "/admin/produto/editar**", method = RequestMethod.GET)
	public ModelAndView editarProduto(
			@RequestParam(value = "idProduto", required = true) Long idProduto) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/produto/editarProduto");
		model.addObject("produto",
				mediator.obterPorIdComInializacaoDeImagens(idProduto));
		model.addObject("categoriasSelect", categoriaMediator.obterTodos());
		return model;
	}

	@RequestMapping(value = "/admin/produto/editar**", method = RequestMethod.POST)
	public ModelAndView processSubmitEditar(@Valid Produto produto,
			BindingResult result, Model model) {
		mediator.alterar(produto);
		return paginaProdutos();
	}
}
