package br.com.cheklab.web.entity.configuracoes;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import br.com.cheklab.web.entity.listeners.ConfiguracaoListener;

@MappedSuperclass
@EntityListeners(ConfiguracaoListener.class)
public class ConfiguracaoGeneric {

}
