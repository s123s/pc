
// saveAnswer- ответ от Ajax-сохранения
/*saveNewPosToHTML = function (saveAnswer) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = $("#mtab #emptyTr");
	var idLocal = saveAnswer.retObject.idTypeHdd;
	var idProducer = $("#newDialog #idProducer").val();
	var producerShortName = $("#newDialog #idProducer option:selected").text();
	var capacity = $("#newDialog #capacity")[0].value;
	
    var $clone = $tr.clone();
    $clone[0].id = "id"+idLocal;
    $clone.find('.myIndex').text('xxx');
    $clone.find('.idTypeHdd').text(idLocal);
    
	$clone.find(".idProducer").text(idProducer);
	$clone.find(".producerName").text(producerShortName);

	$clone.find('.capacity').text(capacity);
	$clone.find('.numberOfHdds').text(0);
    
	$clone[0].hidden = false;

	$("#mtab").find('tbody')
		.append ($clone);
}

saveNewPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var idProducer = $("#newDialog #idProducer").val();
	var producerShortName = $("#newDialog #idProducer option:selected").text();
	var capacity = $("#newDialog #capacity")[0].value;

	var json = { 
				producer:{"idProducer"		: idProducer,
						  "shortname"		: producerShortName,
						 },
				"capacity"	: capacity};

	$.ajax({
		url: "type_hdd/create",
	    	 
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
}*/


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

saveEditedPosToDatabase = function (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var idTypeHdd = $("#editDialog #id")[0].value;
	var idProducer = $("#editDialog #idProducer").val();
	var producerShortName = $("#editDialog #idProducer option:selected").text();
	var capacity = $("#editDialog #capacity")[0].value;

	var json = { "idTypeHdd"	: idTypeHdd,
				producer:{"idProducer"		: idProducer,
						  "shortname"		: producerShortName,
						 },
				"capacity"	: capacity};

	$.ajax({
		url: "type_hdd/save_edited",
	    	 
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
}*/

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
initDialogsValidations= function () {
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

/**Разрешено удалять?*/
permitedToDelete = function (idTr) {
	var invNumber = $("#mtab").find("#"+idTr).find(".invNumber").text();
	return (invNumber.length != 0)? false:true;

}
/**Dialogs actions registration*/
registerDialogsActions = function () {
		//New pos
	$("body").on("click", ".newPos", function () {
	//	$(".newPos").click(function() {
			$('#newDialog').dialog('open');
		});

/*		//Edit pos
	$("body").on("click", ".editPos", function () {
		var idTr = this.parentNode.parentNode.id;
		fillEditDialog(idTr);	//fill edit_dialog fields from table
		$('#editDialog').dialog('open');
	});
*/
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

/*removeOptionFromAllSelects = function(pNewValue, POldValue){
	$( ".idTypeHdd select :not(option:selected)[value='"+pNewValue+"']" ).remove();
	sПодчищаем
	$( ".idTypeHdd select :not(option:selected)[value='"+POldValue+"']" ).remove();
}
addOptionToAllSelects = function(pValue){
	var optionIdTypeHdd = $( ".idTypeHdd select option[value='"+ pValue+"']" )[0].outerHTML;
	$( ".idTypeHdd select" ).append(optionIdTypeHdd);
}*/

/*Добавить options в select (selectElement)*/
addOptionsToSelect = function (selectElement) {
	$.each($( "#listOfFreeTypeHdds")[0].options, function(key, value) {
		value.removeAttr("selected")";
	    $(selectElement).append(value);
	});
}

initSelects = function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	/*$(".idTypeHdd select").selectmenu();*/
	var options = []; 
 
	$.ajax({
		url: "type_hdd/list_free_type_hdd",
	    	 
	    contentType: "application/json",
	   	type: "post",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
	    /*Список непривязанных TypeHdd*/
		success: function(listOfRetOblectsTypeHdds) {
			   for (i = 0; i <listOfRetOblectsTypeHdds.length ; i++) {
			        options.push("<option value='" + listOfRetOblectsTypeHdds[i].idTypeHdd + "'>" 
												   + listOfRetOblectsTypeHdds[i].producer.shortname +"&nbsp;"
												   + listOfRetOblectsTypeHdds[i].capacity
			        							   + "Gb</option>");
			    }
			    $( "#listOfFreeTypeHdds" ).append(options.join(""));
		}
    });

	$( ".idTypeHdd select" ).on( "mouseenter", function( event, ui ) {
		addOptionsToSelect (this);
	} );
	
	$( ".idTypeHdd select" ).on( "change", function( event, ui ) {
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
	initDialogsValidations ();
	registerDialogsActions ();
	
	initSelects();
}

$(function() {
	globalInit();
	thisPageInit();
})