package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.mediators.ProdutoMediator;

@Controller
public class AdmProdutoController {
	
	@Autowired
	private ProdutoMediator mediator;
	
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
}
