package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.ConfiguracaoPaginaProdutosDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaProdutos;
import br.com.cheklab.web.enums.TipoConfiguracaoEnum;

@Service
public class ConfiguracaoPaginaProdutosMediator extends Mediator<ConfiguracaoPaginaProdutos> {

	@Autowired
	private ConfiguracaoPaginaProdutosDAO dao;
	@Autowired
	private ImagemMediator imagemMediator;

	@Transactional(readOnly = true)
	public ConfiguracaoPaginaProdutos obterConfiguracao() {
		ConfiguracaoPaginaProdutos configuracao = dao.buscarPorId(TipoConfiguracaoEnum.DEFAULT
				.getId());
		return configuracao;
	}

	@Override
	protected DAO<ConfiguracaoPaginaProdutos> getDAO() {
		return dao;
	}

}
