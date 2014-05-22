package br.com.cheklab.web.converters;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cheklab.web.entity.Categoria;
import br.com.cheklab.web.mediators.CategoriaMediator;

@Component
public class CategoriaConverter extends PropertyEditorSupport {

	@Autowired
	private CategoriaMediator mediator;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text.equals("")) {
			return;
		}
		Categoria categoria = mediator.obterPorId(new Long(text));
		setValue(categoria);
	}
	
	@Override
	public String getAsText() {
		Categoria s = (Categoria) getValue();
		if (s == null) {
			return null;
		} else {
			return s.getId().toString();
		}
	}

}
