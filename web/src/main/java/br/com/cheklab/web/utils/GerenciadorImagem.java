package br.com.cheklab.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;

public class GerenciadorImagem {
	
	private static Long contador = 0l;
	private final static String PREFIXO_PRIMEIRA_PARTE_BASE64 = "data:image/";
	private final static String PREFIXO_SEGUNDA_PARTE_BASE64 = ";base64,";
	
	private static byte[] converterParaBytes(String enderecoBase64) {
		Integer posicaoBase64 = enderecoBase64.indexOf("base64,");
		return Base64.decodeBase64(enderecoBase64.substring(posicaoBase64 + 7, enderecoBase64.length()));
	}

	public static String salvarImagem(String enderecoBase64,
			String enderecoLocal) {
		byte[] bytes = converterParaBytes(enderecoBase64);
		Path path = Paths.get(enderecoLocal + (contador++) + definirFormato(enderecoBase64));
		criarCaminho(path);
		try {
			OutputStream out = Files.newOutputStream(path,  StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			for (byte b : bytes) {
				out.write(b);
			}
			out.flush();
			out.close();
			String retorno = obterRetorno(path);
			return retorno;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String obterRetorno(Path path) {
		String str = "resources"+File.separator;
		String retorno = path.toString().substring(path.toString().lastIndexOf(str) + str.length(), path.toString().length());
		return retorno;
	}
	
	private static String definirFormato(String enderecoBase64) {
		String padraoBase64 = "data:image/";
		String retorno = "." + enderecoBase64.substring(enderecoBase64.indexOf(padraoBase64) + padraoBase64.length(), enderecoBase64.indexOf(";"));
		return retorno;
	}

	private static void criarCaminho(Path path) {
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
	
	public static Boolean excluirImagem(String caminho) {
		File file = new File(caminho);
		if(file.delete()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String obterImagemBase64(String endereco) {
		String base64 = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(Paths.get(endereco).toFile());
			byte[] arrayBytes = IOUtils.toByteArray(fileInputStream);
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
