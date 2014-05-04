package br.com.cheklab.web.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.PermissoesUsuario;

@Service("assembler")
public class Assembler {
	
	
	@Transactional(readOnly = true)
	  User buildUserFromUserEntity(br.com.cheklab.web.entity.Usuario userEntity) {

	    String username = userEntity.getEmail();
	    String password = userEntity.getSenha();
	    boolean enabled = userEntity.getAtivo();
	    boolean accountNonExpired = userEntity.getAtivo();
	    boolean credentialsNonExpired = userEntity.getAtivo();
	    boolean accountNonLocked = userEntity.getAtivo();

	    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (PermissoesUsuario role : userEntity.getRoles()) {
	      authorities.add(new SimpleGrantedAuthority(role.getPermissao()));
	    }

	    User user = new User(username, password, enabled,
	      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    return user;
	  }
	
}
