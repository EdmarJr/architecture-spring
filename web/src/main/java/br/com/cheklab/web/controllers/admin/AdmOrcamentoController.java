package br.com.cheklab.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.entity.Orcamento;
import br.com.cheklab.web.mediators.OrcamentoMediator;

@Controller
public class AdmOrcamentoController {

	@Autowired
	private OrcamentoMediator mediator;

	@RequestMapping(value = "/admin/orcamentos", method = RequestMethod.GET)
	public ModelAndView carregarOrcamentos(
			@RequestParam(value = "idOrcamento", required = false) Long idOrcamento) {
		ModelAndView model = new ModelAndView();
		model.addObject("orcamentos", mediator.obterTodos());
		model.setViewName("/admin/orcamentos");
		return model;
	}

	@RequestMapping(value = "/admin/orcamento/processar**", method = RequestMethod.GET)
	public ModelAndView processarOrcamento(@RequestParam(value = "idOrcamento", required = true)Long idOrcamento) {
		ModelAndView model = new ModelAndView();
		model.addObject("orcamento", mediator.obterPorId(idOrcamento));
		model.setViewName("/admin/orcamento/processarOrcamento");
		return model;
	}
	@RequestMapping(value = "/admin/orcamento/processar**", method = RequestMethod.POST)
	public ModelAndView processarOrcamento(@ModelAttribute Orcamento orcamento) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/orcamentos");
		return model;
	}

	@RequestMapping(value = "/admin/orcamento/detalhar**", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView detalharOrcamento(Long idOrcamento) {
		ModelAndView modelAndView = new ModelAndView();
		Orcamento orcamento = mediator.obterPorId(idOrcamento);
		modelAndView.addObject("orcamentoSelecionado", orcamento);
		modelAndView.setViewName("/admin/orcamentos");
		return modelAndView;
	}
}
