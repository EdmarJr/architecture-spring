package br.com.cheklab.web.utils;

import java.util.List;

import br.com.cheklab.web.entity.Categoria;

public class CategoriasUtils {
	private static List<Categoria> categoriasDispovenis;

	public static List<Categoria> getCategoriasDispovenis() {
		return categoriasDispovenis;
	}

	public static void setCategoriasDispovenis(List<Categoria> categoriasDispovenis) {
		CategoriasUtils.categoriasDispovenis = categoriasDispovenis;
	}

	
	
}
