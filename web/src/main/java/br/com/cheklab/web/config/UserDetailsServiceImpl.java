package br.com.cheklab.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.UsuarioDAO;
import br.com.cheklab.web.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioDAO userDAO;
	@Autowired
	private Assembler assembler;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Usuario userEntity = userDAO.obterPorEmail(username);
		if (userEntity == null)
			throw new UsernameNotFoundException("user not found");

		return assembler.buildUserFromUserEntity(userEntity);
	}
}
