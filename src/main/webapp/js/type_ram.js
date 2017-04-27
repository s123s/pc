
// saveAnswer- ответ от Ajax-сохранения
saveNewPosToHTML = function (saveAnswer) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = $("#mtab #emptyTr");
	var idLocal = saveAnswer.retObject.idTypeRam;
	var idTypeRamSpec = $("#newDialog #idTypeRamSpec").val();
	var descriptionTypeRamSpec = $("#newDialog #idTypeRamSpec option:selected").text();
	var capacity = $("#newDialog #capacity")[0].value;
	
    var $clone = $tr.clone();
    $clone[0].id = "id"+idLocal;
    $clone.find('.myIndex').text('xxx');
    $clone.find('.idTypeRam').text(idLocal);
    
	$clone.find(".idTypeRamSpec").text(idTypeRamSpec);
	$clone.find(".descriptionTypeRamSpec").text(descriptionTypeRamSpec);

    $clone.find('.capacity').text(capacity);
	$clone[0].hidden = false;

	$("#mtab").find('tbody')
		.append ($clone);
}

saveNewPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var idTypeRamSpec = $("#newDialog #idTypeRamSpec").val();
	var descriptionTypeRamSpec = $("#newDialog #idTypeRamSpec option:selected").text();
	var capacity = $("#newDialog #capacity")[0].value;

	var json = { 
				typeRamSpec:{"idTypeRamSpec"		: idTypeRamSpec,
							"description"		: descriptionTypeRamSpec,
							},
				"capacity"	: capacity};

	$.ajax({
		url: "type_ram/create",
	    	 
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
	var idTypeRam = $("#mtab").find("#"+idTr).find(".idTypeRam").text();
	var idTypeRamSpec = $("#mtab").find("#"+idTr).find(".idTypeRamSpec").text();
	var capacity = $("#mtab").find("#"+idTr).find(".capacity").text();

	$("#editDialog #id")[0].value = idTypeRam;
	$("#idTypeRamSpec [value='" +idTypeRamSpec+ "']").attr("selected", "selected");
	$("#editDialog #capacity")[0].value = capacity;
}

saveEditedPosToHTML = function () {
	var idTrLocal = $("#editDialog #idTr")[0].value;
	var idTypeRamSpec = $("#editDialog #idTypeRamSpec").val()
	var descriptionTypeRamSpec = $("#editDialog #idTypeRamSpec option:selected").text();
	var capacity = $("#editDialog #capacity")[0].value;

	$("#mtab").find("#"+idTrLocal).find(".idTypeRamSpec").text(idTypeRamSpec);
	$("#mtab").find("#"+idTrLocal).find(".descriptionTypeRamSpec").text(descriptionTypeRamSpec);
	$("#mtab").find("#"+idTrLocal).find(".capacity").text(capacity);
}

saveEditedPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var idTypeRam = $("#editDialog #id")[0].value;
	var idTypeRamSpec = $("#editDialog #idTypeRamSpec").val();
	var descriptionTypeRamSpec = $("#editDialog #idTypeRamSpec option:selected").text();
	var capacity = $("#editDialog #capacity")[0].value;

	var json = { "idTypeRam"	: idTypeRam,
					typeRamSpec:{"idTypeRamSpec"	: idTypeRamSpec,
								"description"		: descriptionTypeRamSpec,
						 		},
				"capacity"	: capacity};

	$.ajax({
		url: "type_ram/save_edited",
	    	 
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
	var idTypeRam = $("#mtab").find("#"+idTr).find(".idTypeRam").text();

	$("#deleteDialog #idTr")[0].value = idTr;
	$("#deleteDialog #id")[0].value = idTypeRam;
}

removePosFromHTML = function () {
	var idTrLocal = $("#deleteDialog #idTr")[0].value ;
	$("#mtab #"+ idTrLocal).remove();
}

deleteFromDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var idLocal = $("#deleteDialog #id")[0].value
	var json = { "idTypeRam"	: idLocal };

	$.ajax({
		url: "type_ram/delete",
	    	 
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
		//saveNewPosToHTML();
		//$('#newDialog').dialog('close');
   	});

	/*Edit dialog*/
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
initDialogsValidations= function () {
	$("#newDialogForm").validate({
    	rules:{
    		idTypeRamSpec:{
            	required: true,
			},
			capacity:{
				required: true,
				number: true,
			}

		},
        messages:{
        	idTypeRamSpec:{
            	required: "Это поле обязательно для заполнения",
			},
        	capacity:{
            	required: "Это поле обязательно для заполнения",
            	number: "Должно быть число",
			},
		}
	});

	$("#editDialogForm").validate({
    	rules:{
    		idTypeRamSpec:{
            	required: true,
			},
			capacity:{
				required: true,
				number: true,
			}

		},
        messages:{
        	idTypeRamSpec:{
            	required: "Это поле обязательно для заполнения",
			},
        	capacity:{
            	required: "Это поле обязательно для заполнения",
            	number:	"Должно быть число",
			},
		}
	});
}


/**Dialogs actions registration*/
registerDialogsActions = function () {
		//New pos
	$("body").on("click", ".newPos", function () {
	//	$(".newPos").click(function() {
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