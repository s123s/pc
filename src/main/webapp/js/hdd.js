
var varListOfFreeTypeHdds;


/*Fill dialog window from table node*/
/*fillEditDialog = function  (idTr) {
	$("#editDialog #idTr")[0].value = idTr;
	var idTypeHdd = $("#mtab").find("#"+idTr).find(".idTypeHdd").text();
	var idProducer = $("#mtab").find("#"+idTr).find(".idProducer").text();
	var capacity = $("#mtab").find("#"+idTr).find(".capacity").text();

	$("#editDialog #id")[0].value = idTypeHdd;
	$("#idProducer [value='" +idProducer+ "']").attr("selected", "selected");
	$("#editDialog #capacity")[0].value = capacity;
}

saveEditedPosToHTML = function () {
	var idTrLocal = $("#editDialog #idTr")[0].value;
	var idProducer = $("#editDialog #idProducer").val()
	var producerShortName = $("#editDialog #idProducer option:selected").text();
	var capacity = $("#editDialog #capacity")[0].value;

	$("#mtab").find("#"+idTrLocal).find(".idProducer").text(idProducer);
	$("#mtab").find("#"+idTrLocal).find(".producerName").text(producerShortName);
	$("#mtab").find("#"+idTrLocal).find(".capacity").text(capacity);
}

*/


/** saveAnswer- ответ от Ajax-сохранения*/
saveNewPosOnTrToHTML = function (saveAnswer, trTag) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = trTag;
	var idLocal = saveAnswer.retObject.idHdd;

	 trTag.id = "id"+idLocal;
	 $('.idHdd', trTag).text(idLocal);
	 $tr.class = "";

	 $('.okPos', trTag)[0].hidden = true;
	 $('.deletePos', trTag)[0].hidden = false;
}


/**Внимание! Параметры: trTag - тег. е idTr*/
saveNewPosOnTrToDatabase = function (trTag){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var idComputer = $("#idComputer", trTag).text();
	var idTypeHdd = $("idTypeHdd>option:selected").text();

	var json = { 
				"idComputer": idComputer,
				"idTypeHdd"	: idTypeHdd};

	$.ajax({
		url: "hdd/create",
	    	 
	    data: JSON.stringify(json),
	    contentType: "application/json",
	   	type: "POST",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
		success: function(retObject) {
			saveNewPosOnTrToHTML(retObject, trTag);
		}
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

/*	Edit dialog
	$("#editDialog").dialog({
		autoOpen: false,
		resizable:false,
		modal: true
	});

	$("#editDialog #editDialogSave").click(function() {
		saveEditedPosToDatabase();
//		saveEditedPosToHTML();
//		$('#editDialog').dialog('close');
   	});
*/
	$( "#menu" ).menu();

	/*Delete dialog*/
	$("#deleteDialog").dialog({
		autoOpen: false,
		resizable:false,
		modal: true
	});
	$("#deleteDialog #deleteDialogOk").click(function() {
		deleteFromDatabase();
/*		removePosFromHTML();
	   	renumerate("mtab");
	   	$('#deleteDialog').dialog('close');*/
	});
}


/**Dialogs fields validation*/
initValidations= function () {
	$("#newDialogForm").validate({
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
	});
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
		var trTag = this.parentNode.parentNode;
		saveNewPosOnTrToDatabase(trTag);
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