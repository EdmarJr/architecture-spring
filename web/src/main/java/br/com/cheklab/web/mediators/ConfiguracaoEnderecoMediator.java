package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.ConfiguracaoEnderecoDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoEndereco;
import br.com.cheklab.web.enums.TipoConfiguracaoEnum;

@Service
public class ConfiguracaoEnderecoMediator extends Mediator<ConfiguracaoEndereco> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ConfiguracaoEnderecoDAO dao;
	@Autowired
	private ImagemMediator imagemMediator;

	@Transactional(readOnly = true)
	public ConfiguracaoEndereco obterConfiguracao() {
		ConfiguracaoEndereco configuracao = dao.buscarPorId(TipoConfiguracaoEnum.DEFAULT
				.getId());
		return configuracao;
	}

	@Override
	protected DAO<ConfiguracaoEndereco> getDAO() {
		return dao;
	}

}
