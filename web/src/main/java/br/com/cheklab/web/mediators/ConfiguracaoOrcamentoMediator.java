package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.ConfiguracaoOrcamentoDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoOrcamento;
import br.com.cheklab.web.enums.TipoConfiguracao;

@Service
public class ConfiguracaoOrcamentoMediator extends
		Mediator<ConfiguracaoOrcamento> {

	@Autowired
	private ConfiguracaoOrcamentoDAO dao;
	@Autowired
	private ImagemMediator imagemMediator;

	@Transactional(readOnly = true)
	public ConfiguracaoOrcamento obterConfiguracaoOrcamento() {
		ConfiguracaoOrcamento configuracao = dao
				.buscarPorId(TipoConfiguracao.DEFAULT.getId());
		return configuracao;
	}

	@Override
	protected DAO<ConfiguracaoOrcamento> getDAO() {
		return dao;
	}

}
