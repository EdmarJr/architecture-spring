package br.com.cheklab.web.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.Usuario;

@Repository
@Transactional
public class UsuarioDAO extends DAO<Usuario> {
	
	public Usuario obterPorEmail(String email) {
		Criteria criteria = abrirSessao().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));
		Usuario usuario = (Usuario) criteria.uniqueResult();
		return usuario;
	}

	@Override
	public Class<Usuario> getEntidade() {
		return Usuario.class;
	}
}
