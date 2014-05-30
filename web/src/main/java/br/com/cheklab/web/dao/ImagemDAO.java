package br.com.cheklab.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.Imagem;

@Repository
@Transactional
public class ImagemDAO extends DAO<Imagem> {

	@Override
	public Class<Imagem> getEntidade() {
		return Imagem.class;
	}

	public Imagem obterRegistroMaiorId() {
		Session session = obterSessao();
		Criteria criteria = session.createCriteria(Imagem.class);
		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(1);
		Imagem uniqueResult = (Imagem) criteria.uniqueResult();
		return uniqueResult;
	}
}
