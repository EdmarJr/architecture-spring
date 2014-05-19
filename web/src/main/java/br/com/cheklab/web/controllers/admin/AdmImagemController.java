package br.com.cheklab.web.controllers.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cheklab.web.controllers.admin.components.CRUDImagemController;
import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.enums.TipoInclusaoImagemEnum;
import br.com.cheklab.web.mediators.ImagemMediator;
import br.com.cheklab.web.mediators.ProdutoMediator;

@Controller
public class AdmImagemController {

	@Autowired
	private ProdutoMediator produtoMediator;
	@Autowired
	private ImagemMediator imagemMediator;
	@Autowired
	private CRUDImagemController crudImagem;

	@RequestMapping(value = "/admin/imagem/imagens")
	public ModelAndView gerenciarImagensProduto(
			@RequestParam(required = true, value = "idEntidade") Long idEntidade,
			@RequestParam(required = true, value = "tipoEntidade") String tipoEntidade) {
		ModelAndView model = new ModelAndView();
		if (TipoInclusaoImagemEnum.obterPorDescricao(tipoEntidade) == TipoInclusaoImagemEnum.PRODUTO) {
			model.addObject("imagens", produtoMediator
					.obterPorIdComInializacaoDeImagens(idEntidade).getImagens());
		}
		model.addObject("tipoEntidade", tipoEntidade);
		model.addObject("idEntidade", idEntidade);
		model.setViewName("/admin/imagem/imagens");
		return model;
	}


	
	@RequestMapping(value = "/admin/imagem/incluir", method = RequestMethod.GET)
	public ModelAndView acionarIncluirImagem(
			@RequestParam(required = true, value = "idEntidade") Long idEntidade,
			@RequestParam(required = true, value = "tipoEntidade") String tipoEntidade) {
		ModelAndView model = new ModelAndView();
		Imagem vo = new Imagem();
		vo.setTipoEntidade(tipoEntidade);
		vo.setIdEntidade(idEntidade);
		model.addObject("imagem", vo);
		model.setViewName("/admin/imagem/incluirImagem");
		return model;
	}

	@RequestMapping(value = "/admin/imagem/incluir", method = RequestMethod.POST)
	public ModelAndView incluirImagem(@ModelAttribute Imagem imagem) {
		crudImagem.incluir(imagem);
		return gerenciarImagensProduto(imagem.getIdEntidade(),
				imagem.getTipoEntidade());
	}
	
	@RequestMapping(value = "/admin/imagem/editar", method = RequestMethod.GET)
	public ModelAndView acionarEditarImagem(
			@RequestParam(required = true, value = "idEntidade") Long idEntidade,
			@RequestParam(required = true, value = "idImagem") Long idImagem,
			@RequestParam(required = true, value = "tipoEntidade") String tipoEntidade) {
		Imagem imagem = imagemMediator.obterImagemPorIdEnderecoBase64(idImagem);
		ModelAndView model = new ModelAndView();
		imagem.setTipoEntidade(tipoEntidade);
		imagem.setIdEntidade(idEntidade);
		model.addObject("imagem", imagem);
		model.setViewName("/admin/imagem/editarImagem");
		return model;
	}
	@RequestMapping(value = "/admin/imagem/editar", method = RequestMethod.POST)
	public ModelAndView editarImagem(@Valid @ModelAttribute Imagem imagem) {
		crudImagem.alterar(imagem);
		return gerenciarImagensProduto(imagem.getIdEntidade(),
				imagem.getTipoEntidade());
	}

	@RequestMapping(value="/admin/imagem/excluir", method=RequestMethod.POST)
	@ResponseBody
    public String excluir(Long idImagem) {
        Imagem imagem = new Imagem();
        imagem.setId(idImagem);
		crudImagem.excluir(imagem);
		return idImagem.toString();
    }

}
