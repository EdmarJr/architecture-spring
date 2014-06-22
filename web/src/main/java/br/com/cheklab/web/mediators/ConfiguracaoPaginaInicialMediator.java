package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.ConfiguracaoPaginaInicialDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaInicial;
import br.com.cheklab.web.enums.TipoConfiguracaoEnum;

@Service
public class ConfiguracaoPaginaInicialMediator extends Mediator<ConfiguracaoPaginaInicial> {

	@Autowired
	private ConfiguracaoPaginaInicialDAO dao;

	@Transactional(readOnly = true)
	public ConfiguracaoPaginaInicial obterConfiguracao() {
		ConfiguracaoPaginaInicial configuracao = dao.buscarPorId(TipoConfiguracaoEnum.DEFAULT
				.getId());
		return configuracao;
	}

	@Override
	protected DAO<ConfiguracaoPaginaInicial> getDAO() {
		return dao;
	}

}
