<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin/js/fancy/source/jquery.fancybox.css?v=2.1.5"/>' />
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/fancy/source/jquery.fancybox.js?v=2.1.5"/>'></script>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin/js/fancy/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7"/>' />
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/fancy/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/fancy/jquery.mousewheel-3.0.6.pack.js"/>'></script>
<style>
.containerImgAndIcon {
	display: flex;
	float: left;
	margin: 2px 2px 2px 2px;
}

.iconEditAboveImg {
	position: absolute;
	right: 135px;
	bottom: 135px;
	z-index: 10;
	visibility: hidden;
}

.iconDeleteAboveImg:HOVER {
	background-color: red;
	cursor: pointer;
}

.iconDeleteAboveImg {
	position: absolute;
	left: 135px;
	bottom: 135px;
	z-index: 10;
	visibility: hidden;
}

.iconEditAboveImg:HOVER {
	background-color: green;
	cursor: pointer;
}

.imgMiniaturaFancy {
	display: inline-block;
	max-width: 100%;
	height: auto;
	padding: 4px;
	line-height: 1.428571429;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 4px;
	-webkit-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out;
	position: relative;
	z-index: 1;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				var imgsmini = document
						.getElementsByClassName("imgMiniaturaFancy");

				for (var i = 0; i < imgsmini.length; i++) {
					imgsmini[i].parentNode.parentNode.onmouseover = function(
							event) {
						var imgid = event.currentTarget.id;
						var iconsEdit = document.getElementById("iconedit"
								+ imgid);
						iconsEdit.style.visibility = "initial";
						var iconsDelete = document.getElementById("icondelete"
								+ imgid);
						iconsDelete.style.visibility = "initial";
					};
					imgsmini[i].parentNode.parentNode.onmouseout = function(
							event) {
						var imgid = event.currentTarget.id;
						var iconsEdit = document.getElementById("iconedit"
								+ imgid);
						iconsEdit.style.visibility = "hidden";
						var iconsDelete = document.getElementById("icondelete"
								+ imgid);
						iconsDelete.style.visibility = "hidden";
					};
				}
			});
</script>
<script type="text/javascript">
	$(document).ready(
			function() {

				$('.fancybox').fancybox();

				$('.fancybox-thumbs')
						.fancybox(
								{
									openEffect : 'none',
									closeEffect : 'none',

									prevEffect : 'none',
									nextEffect : 'none',

									closeBtn : false,

									helpers : {
										title : {
											type : 'inside'
										},
										buttons : {}
									},

									afterLoad : function() {
										this.title = 'Image '
												+ (this.index + 1)
												+ ' of '
												+ this.group.length
												+ (this.title ? ' - '
														+ this.title : '');
									}
								});

				$('.fancybox-thumbs').fancybox({
					prevEffect : 'none',
					nextEffect : 'none',

					closeBtn : true,
					arrows : false,
					nextClick : true,

					helpers : {
						thumbs : {
							width : 20,
							height : 20
						}
					}
				});

			});
</script>


<c:set var='urlClickEdit'
	value='${param.urlEdit == null ? "" : param.urlEdit}' />
<c:set var='urlClickDelete'
	value='${param.urlDelete == null ? "" : param.urlDelete}' />
	
<script>

	   
	  function deletarImagem (idImagem, idEntidade, tipoEntidade) {
	       
	       
	    $.ajax({xhr: function(){
	        var xhr = new window.XMLHttpRequest();
	        //Upload progress
	        xhr.upload.addEventListener("progress", function(evt){
	        if (evt.lengthComputable) {
	          var percentComplete = evt.loaded / evt.total;
	          //Do something with upload progress
	          console.log(percentComplete);
	          }
	        }, false);
	      //Download progress
	        xhr.addEventListener("progress", function(evt){
	          if (evt.lengthComputable) {
	            var percentComplete = evt.loaded / evt.total;
	          //Do something with download progress
	            console.log(percentComplete);
	          }
	        }, false);
	        return xhr;
	      },
	        url: "${urlClickDelete}",
	        data: { "idImagem" : idImagem, "idEntidade" : idEntidade, "tipoEntidade" : tipoEntidade},
	        type: "POST",
	        success: function(data) {
	        	if(data != "-1") {
	        		var divImagemDelete = document.getElementById("img" + data);
	        		var parentDiv = divImagemDelete.parentNode;
	        		parentDiv.removeChild(divImagemDelete);
	        	}        
	        }
	    });
	      
	    event.preventDefault();
	  }

	    

</script>


<c:forEach items="${imagens}" var="imagem">
	<div class="containerImgAndIcon" id="img${imagem.id}"
		style="position: relative; width: 150px; height: 150px;">
		<a class="fancybox-thumbs" data-fancybox-group="thumb"
			title="${imagem.nome}"
			href='<c:url value="/resources/${imagem.endereco}"/>'><img
			class="imgMiniaturaFancy" width="150px"
			src='<c:url value="/resources/${imagem.enderecoMiniatura}"/>' /></a> 
			<img
			id="icondeleteimg${imagem.id}" onclick="deletarImagem('${imagem.id}','${idEntidade}', '${tipoEntidade}')"
			src='<c:url value="/resources/admin/icons/delete.png"/>'
			class="iconDeleteAboveImg" alt="Excluir" width=.. height=.. />
			 <img		
			id="iconeditimg${imagem.id}" onclick="window.location.href = '${urlClickEdit}&idImagem=${imagem.id}'"
			src='<c:url value="/resources/admin/icons/image_edit.png"/>'
			class="iconEditAboveImg" alt="Editar" width=.. height=.. />
	</div>
</c:forEach>






