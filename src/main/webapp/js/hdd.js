/** saveAnswer- ответ от Ajax-сохранения*/
saveNewPosOnTrToHTML = function (saveAnswer, trElement) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = trElement;
	var idLocal = saveAnswer.retObject.idHdd;

	 trElement.id = "id"+idLocal;
	 $('.idHdd', trElement).text(idLocal);
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


	var idTypeHdd = $(".idTypeHdd>select", trElement).val();

	var json = {  "idHdd"	: "",
				computer:{"idComputer" : "", },
				typeHdd:{"idTypeHdd"		: idTypeHdd, },
				};

	$.ajax({
		url: "hdd/create",
	    	 
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

	var idHdd = $(".idHdd", trElement).text();
	var idComputer = $(".idComputer", trElement).text();
	var idTypeHdd = $(".idTypeHdd>select", trElement).val();

	var json = { "idHdd"	: idHdd,
				computer:{"idComputer" : idComputer, },
				typeHdd:{"idTypeHdd"		: idTypeHdd, },
				};

	$.ajax({
		url: "hdd/save_edited",
	    	 
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
	var idHdd = $("#mtab").find("#"+idTr).find(".idHdd").text();

	$("#deleteDialog #idTr")[0].value = idTr;
	$("#deleteDialog #id")[0].value = idHdd;
}

removePosFromHTML = function () {
	var idTrLocal = $("#deleteDialog #idTr")[0].value ;
	$("#mtab #"+ idTrLocal).remove();
}

deleteFromDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var idLocal = $("#deleteDialog #id")[0].value
	var json = { "idHdd"	: idLocal };

	$.ajax({
		url: "hdd/delete",
	    	 
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
    $clone.find('.idHdd').text("");
 	$clone.find(".idComputer").text("");
 	$clone.find(".invNumberComputer").text("");
 	$clone[0].hidden = false;

	$("#mtab").find('tbody')
		.append ($clone);
}

/**Разрешено удалять?*/
permitedToDelete = function (idTr) {
	var invNumber = $("#mtab").find("#"+idTr).find(".invNumber").text();
	return (invNumber.length != 0)? false:true;

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

	$( ".idTypeHdd select" ).on( "change", function( event, ui ) {
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

thisPageInit = function () {
	createDialogs ();
	initValidations ();
	registerActions ();
}

$(function() {
	globalInit();
	thisPageInit();
})