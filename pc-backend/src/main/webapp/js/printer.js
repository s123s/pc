
// saveAnswer- ответ от Ajax-сохранения
saveNewPosToHTML = function (saveAnswer) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = $("#mtab #emptyTr");
	var idLocal = saveAnswer.retObject.idPrinter;
	var invNumber = $("#newDialog #invNumber")[0].value;
	var model = $("#newDialog #model")[0].value;
	var cartridge = $("#newDialog #cartridge")[0].value;
	
    var $clone = $tr.clone();
    $clone[0].id = "id"+idLocal;
    $clone.find('.myIndex').text('xxx');
    $clone.find('.idPrinter').text(idLocal);
    
	$clone.find('.invNumber').text(invNumber);
	$clone.find('.model').text(model);
	$clone.find('.cartridge').text(cartridge);
	$clone[0].hidden = false;

	$("#mtab").find('tbody')
		.append ($clone);
}

saveNewPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var invNumber = $("#newDialog #invNumber")[0].value;
	var model = $("#newDialog #model")[0].value;
	var cartridge = $("#newDialog #cartridge")[0].value;

	var json = { 
				"invNumber"		: invNumber, 
				"model"		: model,  
				"cartridge"		: cartridge, };

	$.ajax({
		url: "printer/create",
	    	 
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
	var idPrinter = $("#mtab").find("#"+idTr).find(".idPrinter").text();
	var invNumber = $("#mtab").find("#"+idTr).find(".invNumber").text();
	var model = $("#mtab").find("#"+idTr).find(".model").text();
	var cartridge = $("#mtab").find("#"+idTr).find(".cartridge").text();

	$("#editDialog #id")[0].value = idPrinter;
	$("#idPrinter [value='" +idPrinter+ "']").attr("selected", "selected");
	$("#editDialog #invNumber")[0].value = invNumber;
	$("#editDialog #model")[0].value = model;
	$("#editDialog #cartridge")[0].value = cartridge;
}

saveEditedPosToHTML = function () {
	var idTrLocal = $("#editDialog #idTr")[0].value;
	var invNumber = $("#editDialog #invNumber")[0].value;
	var model = $("#editDialog #model")[0].value;
	var cartridge = $("#editDialog #cartridge")[0].value;
	
	$("#mtab").find("#"+idTrLocal).find(".invNumber").text(invNumber);
	$("#mtab").find("#"+idTrLocal).find(".model").text(model);
	$("#mtab").find("#"+idTrLocal).find(".cartridge").text(cartridge);
}

saveEditedPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var idPrinter = $("#editDialog #id")[0].value;
	var invNumber = $("#editDialog #invNumber")[0].value;
	var model = $("#editDialog #model")[0].value;
	var cartridge = $("#editDialog #cartridge")[0].value;

	var json = { "idPrinter"	: idPrinter,
				"invNumber"	: invNumber, 
				"model"		: model,  
				"cartridge"	: cartridge, };

	$.ajax({
		url: "printer/save_edited",
	    	 
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
	var idPrinter = $("#mtab").find("#"+idTr).find(".idPrinter").text();

	$("#deleteDialog #idTr")[0].value = idTr;
	$("#deleteDialog #id")[0].value = idPrinter;
}

removePosFromHTML = function () {
	var idTrLocal = $("#deleteDialog #idTr")[0].value ;
	$("#mtab #"+ idTrLocal).remove();
}

deleteFromDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var idLocal = $("#deleteDialog #id")[0].value
	var json = { "idPrinter"	: idLocal };

	$.ajax({
		url: "printer/delete",
	    	 
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
    		idPrinter:{ required: true, },
			invNumber: {	required: true, number: true	},
			model: {	required: true,	},
			cartridge: {	required: true,	},
		},
        messages:{
        	idPrinter:{ required: "Это поле обязательно для заполнения", },
			invNumber:{ required: "Это поле обязательно для заполнения", number: "Должно быть число", },
			model:{ required: "Это поле обязательно для заполнения", },
			cartridge:{ required: "Это поле обязательно для заполнения", },
		}
	});

	$("#editDialogForm").validate({
    	rules:{
    		idPrinter:{ required: true, },
			invNumber: {	required: true, number: true	},
			model: {	required: true,	},
			cartridge: {	required: true,	},
		},
        messages:{
        	idPrinter:{ required: "Это поле обязательно для заполнения", },
			invNumber:{ required: "Это поле обязательно для заполнения", number: "Должно быть число", },
			model:{ required: "Это поле обязательно для заполнения", },
			cartridge:{ required: "Это поле обязательно для заполнения", },
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