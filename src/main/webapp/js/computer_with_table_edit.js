/** saveAnswer- ответ от Ajax-сохранения*/
saveNewPosOnTrToHTML = function (saveAnswer, trElement) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = trElement;
	var idLocal = saveAnswer.retObject.idmother;

	 trElement.id = "id"+idLocal;
	 $('.idmother', trElement).text(idLocal);
	 $tr.class = "";
	 
 	//action
	$("select",$tr).on( "change", function( event, ui ) {
		saveEditedPosToDatabase(this.parentNode.parentNode);
	} );


	 $('.okPos', trElement)[0].hidden = true;
	 $('.deletePos', trElement)[0].hidden = false;
}


/**Внимание! Параметры: trElement - тег. idTr*/
saveNewPosOnTrToDatabase = function (trElement){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");


	var idTypeMother = $(".idTypeMother>select", trElement).val();

	var json = {  "idmother"	: "",
				computer:{"idComputer" : "", },
				typeMother:{"idTypeMother"		: idTypeMother, },
				};

	$.ajax({
		url: "mother/create",
	    	 
	    data: JSON.stringify(json),
	    contentType: "application/json",
	   	type: "POST",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
		success: function (retObject) {
			saveNewPosOnTrToHTML(retObject, this);
		}.bind(trElement)	//context == <tr>
    });
}

saveEditedPosToDatabase = function (trElement){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var idmother = $(".idmother", trElement).text();
	var idComputer = $(".idComputer", trElement).text();
	var idTypeMother = $(".idTypeMother>select", trElement).val();

	var json = { "idmother"	: idmother,
				computer:{"idComputer" : idComputer, },
				typeMother:{"idTypeMother"		: idTypeMother, },
				};

	$.ajax({
		url: "mother/save_edited",
	    	 
	    data: JSON.stringify(json),
	    contentType: "application/json",
	   	type: "POST",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
		success: function(smartphone) {
    		simpleDialogOpen("Сообщение", "Сохранение прошло успешно");
    	}
    });
}

/*Fill dialog window from table node*/
fillDeleteDialog = function (idTr) {
	var idmother = $("#mtab").find("#"+idTr).find(".idmother").text();

	$("#deleteDialog #idTr")[0].value = idTr;
	$("#deleteDialog #id")[0].value = idmother;
}

removePosFromHTML = function () {
	var idTrLocal = $("#deleteDialog #idTr")[0].value ;
	$("#mtab #"+ idTrLocal).remove();
}

deleteFromDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var idLocal = $("#deleteDialog #id")[0].value
	var json = { "idmother"	: idLocal };

	$.ajax({
		url: "mother/delete",
	    	 
	    data: JSON.stringify(json),
	    contentType: "application/json",
	   	type: "delete",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
		success: function(smartphone) {
			removePosFromHTML();
    		renumerate("mtab");
    		$('#deleteDialog').dialog('close');
		}
    });
}

renumerate = function (idTable) {
	$("#" + idTable  +" tr").each(function(i){
		$(" .myIndex", this).text(i);
	});
}

/**Create dialogs for C/U/D (crud)*/
createDialogs = function (){

	$( "#menu" ).menu();

	/*Delete dialog*/
	$("#deleteDialog").dialog({
		autoOpen: false,
		resizable:false,
		modal: true
	});
	$("#deleteDialog #deleteDialogOk").click(function() {
		deleteFromDatabase();
	});
}


/**Dialogs fields validation*/
initValidations= function () {
/*	$("#newDialogForm").validate({
    	rules:{
    		idProducer:{
            	required: true,
			},
			capacity:{
				required: true,
				number: true,
			}

		},
        messages:{
        	idProducer:{
            	required: "Это поле обязательно для заполнения",
			},
        	capacity:{
            	required: "Это поле обязательно для заполнения",
            	number: "Должно быть число",
			},
		}
	});*/
}

addPosToHTML = function () {
	var $tr    = $("#mtab #emptyTr");

	var $clone = $tr.clone();
    $clone[0].id = "emptyTrNew";
    $clone.find('.myIndex').text( $("#mtab>tbody>tr").length );
    $clone.find('.idmother').text("");
 	$clone.find(".idComputer").text("");
 	$clone.find(".invNumberComputer").text("");
 	$clone[0].hidden = false;
	
	$("#mtab").find('tbody')
		.append ($clone);
}

/**Разрешено удалять?*/
permitedToDelete = function (idTr) {
	var idWorkplace = $("#mtab").find("#"+idTr).find(".idWorkplace").text();
	return (idWorkplace.length != 0)? false:true;

}
/**Dialogs actions registration*/
registerActions = function () {
		//New pos
	$("body").on("click", ".newPos", function () {
		addPosToHTML();
	});

		//Ok pos
	$("body").on("click", ".okPos", function () {
		var trElement = this.parentNode.parentNode;
		saveNewPosOnTrToDatabase(trElement);
	});

	$( ".idTypeMother select" ).on( "change", function( event, ui ) {
		saveEditedPosToDatabase(this.parentNode.parentNode);
	} );


		//Delete pos
	$("body").on("click", ".deletePos", function () {
		var idTr = this.parentNode.parentNode.id;
		if (permitedToDelete(idTr)) {
			fillDeleteDialog(idTr);		//fill delete_dialog fields from table
			$('#deleteDialog').dialog('open');
		}
		else {
			simpleDialogOpen("Сообщение", "Винчестер установлен в компьютере. Удаление невозможно.");
		}
	});

}

/*Добавить options в select (selectElement)*/
addOptionsToTypeMothersSelect = function (selectElement) {
	$.each($( "#listOfFreeTypeMothers")[0].options, function(key, value) {
		//value.removeAttr("selected");
		value.selected = false;
	    $(selectElement).append(value);
	});
}


initSelects = function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	/*$(".idTypeHdd select").selectmenu();*/
	var options = []; 
 
	$.ajax({
		url: "type_mother/list_free_type_mother",
	    	 
	    contentType: "application/json",
	   	type: "post",
	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
	    /*Список непривязанных Mother*/
		success: function(listOfRetOblectsMothers) {
			   for (i = 0; i <listOfRetOblectsMothers.length ; i++) {
			        options.push("<option value='" + listOfRetOblectsMothers[i].idTypeMother + "'>" 
												   + listOfRetOblectsMothers[i].getShortname() +", Model:" + listOfRetOblectsMothers[i].model +", Socket:" +listOfRetOblectsMothers[i].socket
												   		"</option>");
			    }
			    $( "#listOfFreeTypeMothers" ).append(options.join(""));
		}
    });
	$( ".idTypeMother select" ).on( "mouseenter", function( event, ui ) {
		addOptionsToTypeMothersSelect (this);
	} );
	
	$( ".idTypeMother select" ).on( "change", function( event, ui ) {
		this.options.length = 1;
		
/*		var idTypeHddInBase = $(".idTypeHddInBase",  this.parentNode.parentNode);
		removeOptionFromAllSelects(this.value, idTypeHddInBase);
		addOptionToAllSelects (idTypeHddInBase);*/
		/*	var options = []; 
		    for (i = 10; i <21 ; i++) {
		        options.push("<option value='" + i + "'>" + "str_"+ i+ "</option>");
		    }
		    //append after populating all options
		    //$('.idTypeHdd select')
		    this.append(options.join(""));
		    $(".idTypeHdd select").selectmenu("refresh");*/
			
		   /* 
		    $.when( $.ajax( "type_hdd/list_free_type_hdd" ) ).then(
		    		function( data, textStatus, jqXHR ) {
		    	  		$('.idTypeHdd select').selectmenu("refresh");
		    		});
		    */
		    
		    //$('.idTypeHdd select').selectmenu("refresh");
		    
	/*	    event.preventDefault();
			return true;*/
		} );
}


thisPageInit = function () {
	createDialogs ();
	initValidations ();
	registerActions ();
	initSelects();
}

$(function() {
	globalInit();
	thisPageInit();
})