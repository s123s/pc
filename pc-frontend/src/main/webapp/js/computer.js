
// saveAnswer- ответ от Ajax-сохранения
saveNewPosToHTML = function (saveAnswer) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = $("#mtab #emptyTr");
	var idLocal = saveAnswer.retObject.idComputer;

	var idComputer = saveAnswer.retObject.idComputer;
	var idTypeComputer = $("#newDialog #idTypeComputer").val();
	var typeComputerName = $("#newDialog #idTypeComputer option:selected").text();
	var invNumberComputer = $("#newDialog #invNumberComputer")[0].value;
	var buhName = $("#newDialog #buhName")[0].value;
	var domainName = $("#newDialog #domainName")[0].value;
	var idMother = $("#newDialog #idMother").val();
	var motherName = $("#newDialog #idMother option:selected").text();
	var idProcessor = $("#newDialog #idProcessor").val();
	var processorName = $("#newDialog #idProcessor option:selected").text();

	
    var $clone = $tr.clone();
    $clone[0].id = "id"+idLocal;
    $clone.find('.myIndex').text('xxx');
    $clone.find('.idComputer').text(idComputer);
    
	$clone.find(".workplaceCount").text("");
	$clone.find(".typeComputerDescription").text(typeComputerName);
	$clone.find(".invNumberComputer").text(invNumberComputer);
	$clone.find(".buhName").text(buhName);
	$clone.find(".domainName").text(domainName);
	$clone.find(".idMother").text(idMother);
	$clone.find(".displayNameMother").text(motherName);
	$clone.find(".idProcessor").text(idProcessor);
	$clone.find(".displayNameProcessor").text(processorName);
	
	$clone[0].hidden = false;

	$("#mtab").find('tbody')
		.append ($clone);
}

saveNewPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var idTypeComputer = $("#newDialog #idTypeComputer").val();
	var typeComputerName = $("#newDialog #idTypeComputer option:selected").text();
	var invNumberComputer = $("#newDialog #invNumberComputer")[0].value;
	var buhName = $("#newDialog #buhName")[0].value;
	var domainName = $("#newDialog #domainName")[0].value;
	var idMother = $("#newDialog #idMother").val();
	var motherName = $("#newDialog #idMother option:selected").text();
	var idProcessor = $("#newDialog #idProcessor").val();
	var processorName = $("#newDialog #idProcessor option:selected").text();

	var json = { 
			typeComputer:{"idTypeComputer"		: idTypeComputer,
						  "description"			: typeComputerName,
						 },
				"invNumber"		: invNumberComputer, 
				"buhName"	: buhName,  
				"domainName"	: domainName,  
			mother:{"idMother"		: idMother,
			  //"motherName"			: motherName,
			 },
			 processor:{"idProcessor"		: idProcessor,
			 // "description"			: typeComputerName,
			 }, };

	$.ajax({
		url: "computer/create",
	    	 
	    data: JSON.stringify(json),
	    contentType: "application/json",
	   	type: "POST",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
		success: function(retObject) {
			saveNewPosToHTML(retObject);
			$('#newDialog').dialog('close');
		}
    });
}


/*Fill dialog window from table node*/
fillEditDialog = function  (idTr) {
	$("#editDialog #idTr")[0].value = idTr;
	var idComputer = $("#mtab").find("#"+idTr).find(".idComputer").text();
	var idProducer = $("#mtab").find("#"+idTr).find(".idProducer").text();
	var model = $("#mtab").find("#"+idTr).find(".model").text();
	var socket = $("#mtab").find("#"+idTr).find(".socket").text();

	$("#editDialog #id")[0].value = idComputer;
	$("#idProducer [value='" +idProducer+ "']").attr("selected", "selected");
	$("#editDialog #model")[0].value = model;
	$("#editDialog #socket")[0].value = socket;
}

saveEditedPosToHTML = function () {
	var idTrLocal = $("#editDialog #idTr")[0].value;
	var idProducer = $("#editDialog #idProducer").val();
	var producerShortName = $("#editDialog #idProducer option:selected").text();
	var model = $("#editDialog #model")[0].value;
	var socket = $("#editDialog #socket")[0].value;

	$("#mtab").find("#"+idTrLocal).find(".idProducer").text(idProducer);
	$("#mtab").find("#"+idTrLocal).find(".producerName").text(producerShortName);
	$("#mtab").find("#"+idTrLocal).find(".model").text(model);
	$("#mtab").find("#"+idTrLocal).find(".socket").text(socket);
}

saveEditedPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var idComputer = $("#editDialog #id")[0].value;
	var idProducer = $("#editDialog #idProducer").val();
	var producerShortName = $("#editDialog #idProducer option:selected").text();
	var model = $("#editDialog #model")[0].value;
	var socket = $("#editDialog #socket")[0].value;

	var json = { "idComputer"	: idComputer,
				producer:{"idProducer"		: idProducer,
						  "shortname"		: producerShortName,
						 },
				"model"		: model,
				"socket"	: socket, };

	$.ajax({
		url: "type_mother/save_edited",
	    	 
	    data: JSON.stringify(json),
	    contentType: "application/json",
	   	type: "POST",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
		success: function(smartphone) {
    		saveEditedPosToHTML();
    		$('#editDialog').dialog('close');
    	}
    });
}

/*Fill dialog window from table node*/
fillDeleteDialog = function (idTr) {
	var idComputer = $("#mtab").find("#"+idTr).find(".idComputer").text();

	$("#deleteDialog #idTr")[0].value = idTr;
	$("#deleteDialog #id")[0].value = idComputer;
}

removePosFromHTML = function () {
	var idTrLocal = $("#deleteDialog #idTr")[0].value ;
	$("#mtab #"+ idTrLocal).remove();
}

deleteFromDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var idLocal = $("#deleteDialog #id")[0].value
	var json = { "idComputer"	: idLocal };

	$.ajax({
		url: "type_mother/delete",
	    	 
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

	/*Create dialog*/
	$("#newDialog").dialog({
		autoOpen: false,
		resizable:false,
		width: 350,
		modal: true
	});
	$("#newDialog #newDialogSave").click(function() {
		saveNewPosToDatabase();
   	});

	/*Edit dialog*/
	$("#editDialog").dialog({
		autoOpen: false,
		resizable:false,
		width: 350,
		modal: true
	});

	$("#editDialog #editDialogSave").click(function() {
		saveEditedPosToDatabase();
   	});


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
initDialogsValidations= function () {
	$("#newDialogForm").validate({
    	rules:{
    		idTypeRamSpec:{ required: true, },
			model: {	required: true,	},
			socket: {	required: true,	},
		},
        messages:{
        	idTypeRamSpec:{ required: "Это поле обязательно для заполнения", },
			model:{ required: "Это поле обязательно для заполнения", },
			socket:{ required: "Это поле обязательно для заполнения", },
		}
	});

	$("#editDialogForm").validate({
    	rules:{
    		idTypeRamSpec:{ required: true, },
			model: {	required: true,	},
			socket: {	required: true,	},
		},
        messages:{
        	idTypeRamSpec:{ required: "Это поле обязательно для заполнения", },
			model:{ required: "Это поле обязательно для заполнения", },
			socket:{ required: "Это поле обязательно для заполнения", },
		}
	});
}

/**Разрешено удалять?*/
permitedToDelete = function (idTr) {
	var numberOfMothers = $("#mtab").find("#"+idTr).find(".numberOfMothers").text();
	return (numberOfMothers > 0)? false:true;
}

/**Dialogs actions registration*/
registerDialogsActions = function () {
		//New pos
	$("body").on("click", ".newPos", function () {
			$('#newDialog').dialog('open');
		});

		//Edit pos
	$("body").on("click", ".editPos", function () {
		var idTr = this.parentNode.parentNode.id;
		fillEditDialog(idTr);	//fill edit_dialog fields from table
		$('#editDialog').dialog('open');
	});

		//Delete pos
	$("body").on("click", ".deletePos", function () {
		var idTr = this.parentNode.parentNode.id;
		if (permitedToDelete(idTr)) {
			fillDeleteDialog(idTr);		//fill delete_dialog fields from table
			$('#deleteDialog').dialog('open');
		}
		else {
			simpleDialogOpen("Сообщение", "Есть материнские платы с таким типом. Удаление невозможно.");
		}
	});

}

thisPageInit = function () {
	createDialogs ();
	initDialogsValidations ();
	registerDialogsActions ();
}

$(function() {
	globalInit();
	thisPageInit();
})