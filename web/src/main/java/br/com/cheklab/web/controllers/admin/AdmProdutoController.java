package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cheklab.web.entity.Produto;
import br.com.cheklab.web.mediators.CategoriaMediator;
import br.com.cheklab.web.mediators.ProdutoMediator;

@Controller
public class AdmProdutoController {

	@Autowired
	private ProdutoMediator mediator;
	@Autowired
	private CategoriaMediator categoriaMediator;

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
		model.addObject("produtos", mediator.obterProdutos());
		return model;
	}

	@RequestMapping(value = "/admin/produto/editar**", method = RequestMethod.GET)
	public ModelAndView editarProduto(
			@RequestParam(value = "idProduto", required = true) Long idProduto) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/produto/editarProduto");
		model.addObject("produto",
				mediator.obterPorIdComInializacaoDeImagens(idProduto));
		model.addObject("categorias", categoriaMediator.obterCategorias());
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@Validated Produto produto,
			BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs) {
		return "";
	}
}
