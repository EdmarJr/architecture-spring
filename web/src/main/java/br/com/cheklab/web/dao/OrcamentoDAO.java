package br.com.cheklab.web.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.Orcamento;

@Repository
@Transactional
public class OrcamentoDAO extends DAO<Orcamento> {

	@Override
	public List<Orcamento> obterTodos() {
		List<Orcamento> listaTodos = super.obterTodos();
		Collections.sort(listaTodos, new Comparator<Orcamento>() {

			@Override
			public int compare(Orcamento o1, Orcamento o2) {
				if (o1.getEmAberto() && o2.getEmAberto()) {
					int compareTo = o1.getHoraRegistro().compareTo(
							o2.getHoraRegistro());
					if (compareTo == 1) {
						return -1;
					} else if (compareTo == -1) {
						return 1;
					}
					return compareTo;
				} else {
					if (o1.getEmAberto() != null && o1.getEmAberto()) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});
		return listaTodos;
	}

	@Override
	public Class<Orcamento> getEntidade() {
		return Orcamento.class;
	}
	
	
}
