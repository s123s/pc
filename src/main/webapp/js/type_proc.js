
// saveAnswer- ответ от Ajax-сохранения
saveNewPosToHTML = function (saveAnswer) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = $("#mtab #emptyTr");
	var idLocal = saveAnswer.retObject.idTypeProc;
	var idProducer = $("#newDialog #idProducer").val();
	var producerShortName = $("#newDialog #idProducer option:selected").text();
	var model = $("#newDialog #model")[0].value;
	var socket = $("#newDialog #socket")[0].value;
	
    var $clone = $tr.clone();
    $clone[0].id = "id"+idLocal;
    $clone.find('.myIndex').text('xxx');
    $clone.find('.idTypeProc').text(idLocal);
    
	$clone.find(".idProducer").text(idProducer);
	$clone.find(".producerName").text(producerShortName);

    $clone.find('.model').text(model);
    $clone.find('.socket').text(socket);
	$clone[0].hidden = false;

	$("#mtab").find('tbody')
		.append ($clone);
}

saveNewPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var idProducer = $("#newDialog #idProducer").val();
	var producerShortName = $("#newDialog #idProducer option:selected").text();
	var model = $("#newDialog #model")[0].value;
	var socket = $("#newDialog #socket")[0].value;

	var json = { 
				producer:{"idProducer"		: idProducer,
						  "shortname"		: producerShortName,
						 },
				"model"		: model, 
				"socket"	: socket, };

	$.ajax({
		url: "type_proc/create",
	    	 
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
	var idTypeProc = $("#mtab").find("#"+idTr).find(".idTypeProc").text();
	var idProducer = $("#mtab").find("#"+idTr).find(".idProducer").text();
	var model = $("#mtab").find("#"+idTr).find(".model").text();
	var socket = $("#mtab").find("#"+idTr).find(".socket").text();

	$("#editDialog #id")[0].value = idTypeProc;
	$("#idProducer [value='" +idProducer+ "']").attr("selected", "selected");
	$("#editDialog #model")[0].value = model;
	$("#editDialog #socket")[0].value = socket;
}

saveEditedPosToHTML = function () {
	var idTrLocal = $("#editDialog #idTr")[0].value;
	var idProducer = $("#editDialog #idProducer").val()
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
	var idTypeProc = $("#editDialog #id")[0].value;
	var idProducer = $("#editDialog #idProducer").val();
	var producerShortName = $("#editDialog #idProducer option:selected").text();
	var model = $("#editDialog #model")[0].value;
	var socket = $("#editDialog #socket")[0].value;

	var json = { "idTypeProc"	: idTypeProc,
				producer:{"idProducer"		: idProducer,
						  "shortname"		: producerShortName,
						 },
				"model"		: model,
				"socket"	: socket, };

	$.ajax({
		url: "type_proc/save_edited",
	    	 
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
	var idTypeProc = $("#mtab").find("#"+idTr).find(".idTypeProc").text();

	$("#deleteDialog #idTr")[0].value = idTr;
	$("#deleteDialog #id")[0].value = idTypeProc;
}

removePosFromHTML = function () {
	var idTrLocal = $("#deleteDialog #idTr")[0].value ;
	$("#mtab #"+ idTrLocal).remove();
}

deleteFromDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var idLocal = $("#deleteDialog #id")[0].value
	var json = { "idTypeProc"	: idLocal };

	$.ajax({
		url: "type_proc/delete",
	    	 
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
		modal: true
	});
	$("#newDialog #newDialogSave").click(function() {
		saveNewPosToDatabase();
   	});

	/*Edit dialog*/
	$("#editDialog").dialog({
		autoOpen: false,
		resizable:false,
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
		fillDeleteDialog(idTr);		//fill delete_dialog fields from table
		$('#deleteDialog').dialog('open');
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