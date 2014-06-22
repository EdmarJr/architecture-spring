package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.ConfiguracaoOrcamentoDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaOrcamento;
import br.com.cheklab.web.enums.TipoConfiguracaoEnum;

@Service
public class ConfiguracaoOrcamentoMediator extends
		Mediator<ConfiguracaoPaginaOrcamento> {

	@Autowired
	private ConfiguracaoOrcamentoDAO dao;
	@Autowired
	private ImagemMediator imagemMediator;

	@Transactional(readOnly = true)
	public ConfiguracaoPaginaOrcamento obterConfiguracao() {
		ConfiguracaoPaginaOrcamento configuracao = dao
				.buscarPorId(TipoConfiguracaoEnum.DEFAULT.getId());
		return configuracao;
	}

	@Override
	protected DAO<ConfiguracaoPaginaOrcamento> getDAO() {
		return dao;
	}

}
