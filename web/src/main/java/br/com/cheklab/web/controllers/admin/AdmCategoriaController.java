package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.converters.CategoriaConverter;
import br.com.cheklab.web.entity.Categoria;
import br.com.cheklab.web.mediators.CategoriaMediator;

@Controller
public class AdmCategoriaController {

	@Autowired
	private CategoriaMediator mediator;

	@Autowired
	private CategoriaConverter categoriaConverter;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Categoria.class, this.categoriaConverter);
	}

	@RequestMapping(value = "/admin/categorias", method = RequestMethod.GET)
	public ModelAndView carregarCategorias() {
		ModelAndView model = new ModelAndView();
		model.addObject("categorias", mediator.obterTodos());
		model.setViewName("/admin/categorias");
		return model;
	}

	@RequestMapping(value = "/admin/categoria/editar**", method = RequestMethod.GET)
	public ModelAndView acionarEditarCategoria(@RequestParam(value = "idCategoria", required = true)Long idCategoria) {
		ModelAndView model = new ModelAndView();
		model.addObject("categoria", mediator.obterPorId(idCategoria));
		model.addObject("categoriasSelect", mediator.obterTodos());
		model.setViewName("/admin/categoria/editarCategoria");
		return model;
	}
	@RequestMapping(value = "/admin/categoria/incluir**", method = RequestMethod.GET)
	public ModelAndView acionarIncluirCategoria() {
		ModelAndView model = new ModelAndView();
		model.addObject("categoria", new Categoria());
		model.addObject("categoriasSelect", mediator.obterTodos());
		model.setViewName("/admin/categoria/incluirCategoria");
		return model;
	}
	@RequestMapping(value = "/admin/categoria/visualizar**", method = RequestMethod.GET)
	public ModelAndView acionarVisualizarCategoria(@RequestParam(value = "idCategoria", required = true)Long idCategoria) {
		ModelAndView model = new ModelAndView();
		model.addObject("categoria", mediator.obterPorId(idCategoria));
		model.setViewName("/admin/categoria/visualizarCategoria");
		return model;
	}
	
	@RequestMapping(value = "/admin/categoria/editar**", method = RequestMethod.POST)
	public ModelAndView editarCategoria(@ModelAttribute Categoria categoria) {
		mediator.alterar(categoria);
		return carregarCategorias();
	}
	@RequestMapping(value = "/admin/categoria/incluir**", method = RequestMethod.POST)
	public ModelAndView incluirCategoria(@ModelAttribute Categoria categoria) {
		mediator.incluir(categoria);
		return carregarCategorias();
	}
	
	
}
