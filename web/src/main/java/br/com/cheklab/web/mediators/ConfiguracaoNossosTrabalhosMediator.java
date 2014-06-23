package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.ConfiguracaoNossosTrabalhosDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoNossosTrabalhos;
import br.com.cheklab.web.enums.TipoConfiguracaoEnum;

@Service
public class ConfiguracaoNossosTrabalhosMediator extends Mediator<ConfiguracaoNossosTrabalhos> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ConfiguracaoNossosTrabalhosDAO dao;

	@Transactional(readOnly = true)
	public ConfiguracaoNossosTrabalhos obterConfiguracao() {
		ConfiguracaoNossosTrabalhos configuracao = dao.buscarPorId(TipoConfiguracaoEnum.DEFAULT
				.getId());
		return configuracao;
	}

	@Override
	protected DAO<ConfiguracaoNossosTrabalhos> getDAO() {
		return dao;
	}

}
