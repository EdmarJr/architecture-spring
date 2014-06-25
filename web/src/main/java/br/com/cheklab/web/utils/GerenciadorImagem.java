package br.com.cheklab.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class GerenciadorImagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String PREFIXO_PRIMEIRA_PARTE_BASE64 = "data:image/";
	private final static String PREFIXO_SEGUNDA_PARTE_BASE64 = ";base64,";
	public static Long contadorImagem;
	
	private byte[] converterParaBytes(String enderecoBase64) {
		Integer posicaoBase64 = enderecoBase64.indexOf("base64,");
		return Base64.decodeBase64(enderecoBase64.substring(posicaoBase64 + 7, enderecoBase64.length()));
	}

	public String salvarImagem(String enderecoBase64,
			String enderecoLocal) {
		byte[] bytes = converterParaBytes(enderecoBase64);
		Path path = Paths.get(enderecoLocal + obterContadorImagem()
				+ definirFormato(enderecoBase64));
		criarCaminho(path);
		try {
			OutputStream out = Files.newOutputStream(path,  StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
			for (byte b : bytes) {
				out.write(b);
			}
			out.flush();
			out.close();
			out = null;
			String retorno = obterRetorno(path);
			return retorno;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static Long obterContadorImagem() {
		return contadorImagem;
	}

	private String obterRetorno(Path path) {
		String str = "resources"+File.separator;
		String retorno = path.toString().substring(path.toString().lastIndexOf(str) + str.length(), path.toString().length());
		return retorno;
	}
	
	private String definirFormato(String enderecoBase64) {
		String padraoBase64 = "data:image/";
		String retorno = "." + enderecoBase64.substring(enderecoBase64.indexOf(padraoBase64) + padraoBase64.length(), enderecoBase64.indexOf(";"));
		return retorno;
	}

	private void criarCaminho(Path path) {
		Iterator<Path> iterator = path.iterator();
		Path next = Paths.get(path.getRoot().toString() + iterator.next().toString());
		while(iterator.hasNext()) {
			Path next2 = iterator.next();
			next = Paths.get(next.toString() + "/" + next2.toString());
			if(!next.toFile().exists() && next2.toString().indexOf(".") == -1) {
				try {
					Files.createDirectories(next);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public Boolean excluirImagem(String caminho) {
		File file = new File(caminho);
		try {
			FileDeleteStrategy.FORCE.delete(file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String obterImagemBase64(String endereco) {
		String base64 = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(Paths.get(endereco).toFile());
			byte[] arrayBytes = IOUtils.toByteArray(fileInputStream);
			fileInputStream.close();
			fileInputStream = null;
			String url = new String(Base64.encodeBase64(arrayBytes), "UTF-8");
			String pedacoFormato = endereco.substring(endereco.length() - 6, endereco.length());
			String formato = pedacoFormato.substring(pedacoFormato.indexOf(".") + 1, pedacoFormato.length());
			base64 = PREFIXO_PRIMEIRA_PARTE_BASE64 + formato + PREFIXO_SEGUNDA_PARTE_BASE64 + url;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return base64;
	}

}
