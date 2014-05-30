package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.dao.ConfiguracaoDAO;
import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.entity.configuracoes.Configuracao;
import br.com.cheklab.web.enums.TipoConfiguracao;

@Service
public class ConfiguracaoMediator extends Mediator<Configuracao> {

	@Autowired
	private ConfiguracaoDAO dao;
	@Autowired
	private ImagemMediator imagemMediator;

	@Transactional(readOnly = true)
	public Configuracao obterConfiguracao() {
		Configuracao configuracao = dao.buscarPorId(TipoConfiguracao.DEFAULT
				.getId());
		if (configuracao.getLogoMenuSuperior() != null) {
			configuracao.setLogoMenuSuperior(imagemMediator
					.obterImagemPorIdEnderecoBase64(configuracao
							.getLogoMenuSuperior().getId()));
		}
		return configuracao;
	}

	@Transactional(readOnly = true)
	public Configuracao obterConfiguracaoCarregada() {
		return dao.obterConfiguracaoCarregadaPorId(TipoConfiguracao.DEFAULT
				.getId());
	}

	@Override
	protected DAO<Configuracao> getDAO() {
		return dao;
	}

}
