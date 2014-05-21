package br.com.cheklab.web.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cheklab.web.mediators.ImagemMediator;
import br.com.cheklab.web.utils.GerenciadorImagem;

@Component
public class Inicializacao implements InitializingBean {

	@Autowired
	private ImagemMediator imagemMediator;

	@Override
	public void afterPropertiesSet() throws Exception {
		AutowireHelper.autowire(this, this.imagemMediator);
		GerenciadorImagem.contadorImagem = imagemMediator.obterContadorImagem();
	}

}
