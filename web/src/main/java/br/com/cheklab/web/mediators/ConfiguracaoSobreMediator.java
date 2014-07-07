package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.ConfiguracaoSobreDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoSobre;
import br.com.cheklab.web.enums.TipoConfiguracaoEnum;

@Service
public class ConfiguracaoSobreMediator extends Mediator<ConfiguracaoSobre> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ConfiguracaoSobreDAO dao;
	@Autowired
	private ImagemMediator imagemMediator;

	@Transactional(readOnly = true)
	public ConfiguracaoSobre obterConfiguracao() {
		ConfiguracaoSobre configuracao = dao
				.buscarPorId(TipoConfiguracaoEnum.DEFAULT
				.getId());
		return configuracao;
	}

	@Override
	protected DAO<ConfiguracaoSobre> getDAO() {
		return dao;
	}

}
