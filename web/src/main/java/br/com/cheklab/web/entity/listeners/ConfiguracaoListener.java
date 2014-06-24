package br.com.cheklab.web.entity.listeners;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cheklab.web.config.AutowireHelper;
import br.com.cheklab.web.config.Inicializacao;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoGeneric;

public class ConfiguracaoListener {

	@Autowired
	private Inicializacao inicializacao;

	@PostUpdate
	private void atualizarConfiguracoes(ConfiguracaoGeneric configuracao) {
		AutowireHelper.autowire(this, this.inicializacao);
		inicializacao.carregarConfiguracoes();
	}

}
