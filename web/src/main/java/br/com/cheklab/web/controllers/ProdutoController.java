package br.com.cheklab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.mediators.ProdutoMediator;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoMediator mediator;
	
	@RequestMapping(value = "/produtos**", method = RequestMethod.GET)
	public ModelAndView paginaProdutos() {
		ModelAndView model = new ModelAndView();
		model.setViewName("produtos");
		model.addObject("produtos", mediator.obterProdutos());
		return model;
	}
	
}