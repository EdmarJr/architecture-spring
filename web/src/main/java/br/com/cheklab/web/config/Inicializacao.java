package br.com.cheklab.web.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.cheklab.web.mediators.ConfiguracaoEnderecoMediator;
import br.com.cheklab.web.mediators.ConfiguracaoMediator;
import br.com.cheklab.web.mediators.ConfiguracaoNossosTrabalhosMediator;
import br.com.cheklab.web.mediators.ConfiguracaoOrcamentoMediator;
import br.com.cheklab.web.mediators.ConfiguracaoPaginaInicialMediator;
import br.com.cheklab.web.mediators.ConfiguracaoPaginaProdutosMediator;
import br.com.cheklab.web.mediators.ImagemMediator;
import br.com.cheklab.web.utils.ConfiguracoesUtils;
import br.com.cheklab.web.utils.GerenciadorImagem;

@Component
@Scope("singleton")
public class Inicializacao implements InitializingBean {

	@Autowired
	private ImagemMediator imagemMediator;
	@Autowired
	private ConfiguracaoMediator configuracaoMediator;
	@Autowired
	private ConfiguracaoPaginaInicialMediator configuracaoPaginaInicialMediator;
	@Autowired
	private ConfiguracaoPaginaProdutosMediator configuracaoPaginaProdutosMediator;
	@Autowired
	private ConfiguracaoOrcamentoMediator configuracaoOrcamentoMediator;
	@Autowired
	private ConfiguracaoEnderecoMediator configuracaoEnderecoMediator;
	@Autowired
	private ConfiguracaoNossosTrabalhosMediator configuracaoNossosTrabalhosMediator;

	@Override
	public void afterPropertiesSet() throws Exception {
		AutowireHelper.autowire(this, this.imagemMediator);
		AutowireHelper.autowire(this, this.configuracaoMediator);
		AutowireHelper.autowire(this, this.configuracaoPaginaProdutosMediator);
		AutowireHelper.autowire(this, this.configuracaoOrcamentoMediator);
		AutowireHelper.autowire(this, this.configuracaoNossosTrabalhosMediator);
		GerenciadorImagem.contadorImagem = imagemMediator.obterContadorImagem();
		carregarConfiguracoes();
	}

	public void carregarConfiguracoes() {
		ConfiguracoesUtils.setConfiguracao(configuracaoMediator
				.obterConfiguracao());
		ConfiguracoesUtils
				.setConfiguracaoPaginaInicial(configuracaoPaginaInicialMediator
						.obterConfiguracao());
		ConfiguracoesUtils
				.setConfiguracaoPaginaProdutos(configuracaoPaginaProdutosMediator
						.obterConfiguracao());
		ConfiguracoesUtils
				.setConfiguracaoPaginaOrcamento(configuracaoOrcamentoMediator
						.obterConfiguracao());
		ConfiguracoesUtils.setConfiguracaoEndereco(configuracaoEnderecoMediator
				.obterConfiguracao());
		ConfiguracoesUtils
				.setConfiguracaoNossosTrabalhos(configuracaoNossosTrabalhosMediator
						.obterConfiguracao());
	}

}
