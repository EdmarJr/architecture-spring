package br.com.cheklab.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NossosTrabalhosController { 
	@RequestMapping(value="/nossosTrabalhos**")
	private String obterPagina() {
		return "nossosTrabalhos";
	}

}