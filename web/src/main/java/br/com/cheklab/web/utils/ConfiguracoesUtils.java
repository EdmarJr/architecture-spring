package br.com.cheklab.web.utils;

import br.com.cheklab.web.entity.configuracoes.Configuracao;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoEndereco;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaInicial;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaOrcamento;
import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaProdutos;

public class ConfiguracoesUtils {
	private static Configuracao configuracao;
	private static ConfiguracaoPaginaOrcamento configuracaoPaginaOrcamento;
	private static ConfiguracaoPaginaInicial configuracaoPaginaInicial;
	private static ConfiguracaoPaginaProdutos configuracaoPaginaProdutos;
	private static ConfiguracaoEndereco configuracaoEndereco;
	
	public static Configuracao getConfiguracao() {
		return configuracao;
	}
	public static void setConfiguracao(Configuracao configuracao) {
		ConfiguracoesUtils.configuracao = configuracao;
	}
	public static ConfiguracaoPaginaOrcamento getConfiguracaoPaginaOrcamento() {
		return configuracaoPaginaOrcamento;
	}
	public static void setConfiguracaoPaginaOrcamento(
			ConfiguracaoPaginaOrcamento configuracaoPaginaOrcamento) {
		ConfiguracoesUtils.configuracaoPaginaOrcamento = configuracaoPaginaOrcamento;
	}
	public static ConfiguracaoPaginaInicial getConfiguracaoPaginaInicial() {
		return configuracaoPaginaInicial;
	}
	public static void setConfiguracaoPaginaInicial(
			ConfiguracaoPaginaInicial configuracaoPaginaInicial) {
		ConfiguracoesUtils.configuracaoPaginaInicial = configuracaoPaginaInicial;
	}
	public static ConfiguracaoPaginaProdutos getConfiguracaoPaginaProdutos() {
		return configuracaoPaginaProdutos;
	}
	public static void setConfiguracaoPaginaProdutos(
			ConfiguracaoPaginaProdutos configuracaoPaginaProdutos) {
		ConfiguracoesUtils.configuracaoPaginaProdutos = configuracaoPaginaProdutos;
	}
	public static ConfiguracaoEndereco getConfiguracaoEndereco() {
		return configuracaoEndereco;
	}
	public static void setConfiguracaoEndereco(
			ConfiguracaoEndereco configuracaoEndereco) {
		ConfiguracoesUtils.configuracaoEndereco = configuracaoEndereco;
	}
	
	
	
	
	
}
