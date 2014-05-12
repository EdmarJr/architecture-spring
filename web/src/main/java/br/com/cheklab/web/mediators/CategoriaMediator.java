package br.com.cheklab.web.mediators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cheklab.web.dao.CategoriaDAO;
import br.com.cheklab.web.entity.Categoria;

@Service
public class CategoriaMediator {
	
	@Autowired
	private CategoriaDAO dao;
	
	public List<Categoria> obterCategorias() {
		return dao.obterTodos();
	}


}
