

$(function() {
	$(".left.pane").resizable({
		handles : "e, w"
	});
	$(".right.pane").resizable({
		handles : "e, w"
	});
	$(".center.pane .inner .bottom").resizable({
		handles : "n, s"
	});


$(document).ready(function(){

	$("#editDialog").dialog({
		autoOpen: false,
		resizable:false,
		modal: true});

	$("#newDialog").dialog({
		autoOpen: false,
		resizable:false,
		modal: true});

	$("#deleteDialog").dialog({
		autoOpen: false,
		resizable:false,
		modal: true});
	
	
	$("#editDialogForm").validate({
    	rules:{
        	model:{
            	required: true,
			},
			capacity:{
				required: true,
				number: true,
			}

		},
        messages:{
        	model:{
            	required: "Это поле обязательно для заполнения",
			},
        	capacity:{
            	required: "Это поле обязательно для заполнения",
            	number: "Должно быть число",
			},
		}
	});


	$("#newDialogForm").validate({
    	rules:{
        	model:{
            	required: true,
			},
			capacity:{
				required: true,
				number: true,
			}

		},
        messages:{
        	model:{
            	required: "Это поле обязательно для заполнения",
			},
        	capacity:{
            	required: "Это поле обязательно для заполнения",
            	number: "Должно быть число",
			},
		}
	});
 
});


	//Edit pos
	$(".editPos").click(function() {
		fillEditDialog(this.parentNode.parentNode.id);	//Заполнение диалогового окна значениями
		

		$('#editDialog').dialog('open');
		
    	$("#editDialog #editDialogSave").click(function() {
    	//$("#mtab #id2").remove();
    		saveEditedPosToHTML();
    		saveEditedPosToDatabase();
    		$('#editDialog').dialog('close');
	   	});
	});


	//New pos
	$(".newPos").unbind("click").bind('click', (function() {
		//fillEditDialog(this.parentNode.parentNode.id);	//Заполнение диалогового окна значениями
		
		$('#newDialog').dialog('open');

    	$("#newDialog #newDialogSave").click(function() {
    		saveNewPosToDatabase();
    		//saveNewPosToHTML();
    		$('#newDialog').dialog('close');
	   	});
	}));

	//Delete pos
	$(".deletePos").click(function() {
		fillDeleteDialog(this.parentNode.parentNode.id);	//Заполнение диалогового окна значениями

		$('#deleteDialog').dialog('open');


		$("#deleteDialog #deleteDialogOk").click(function() {
			removePosFromHTML();
			deleteFromDatabase();
	    	renumerate("mtab");
	    	$('#deleteDialog').dialog('close');
		});
	});

});


// saveAnswer- ответ от Ajax-сохранения
function saveNewPosToHTML(saveAnswer) {
	if ( !saveAnswer.successfully ) return;
	
	var $tr    = $("#mtab #emptyTr");
	var idLocal = saveAnswer.retObject.idTypeHdd;

	
    var $clone = $tr.clone();
    $clone[0].id = "id"+idLocal;
    $clone.find('.myIndex').text('xxx');
    $clone.find('.idTypeHdd').text(idLocal);
    $clone.find('.model').text( $("#newDialog #model")[0].value );
    $clone.find('.capacity').text($("#newDialog #capacity")[0].value);
	$clone[0].hidden = false;

	$("#mtab").find('tbody')
		.append ($clone);
    //$("#mtab tr:last").after($clone);
}

function saveNewPosToDatabase(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var json = { 
		//"idTypeHdd"	: $("#newDialog #id")[0].value,
				"model"		: $("#newDialog #model")[0].value,
				"capacity"	: $("#newDialog #capacity")[0].value};

	  //var json = { "idTypeHdd" : "1", "model" : "2", "capacity": "3"};

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
		}
    });
}



/*Fill dialog window for edtiting from table node*/
function fillEditDialog (idTr) {
	$("#editDialog #idTr")[0].value = idTr;
	$("#editDialog #id")[0].value = $("#mtab").find("#"+idTr).find(".idTypeHdd").text();
	$("#editDialog #model")[0].value = $("#mtab").find("#"+idTr).find(".model").text();
	$("#editDialog #capacity")[0].value = $("#mtab").find("#"+idTr).find(".capacity").text();
}

function saveEditedPosToHTML() {
	var idTrLocal = $("#editDialog #idTr")[0].value;
	$("#mtab").find("#"+idTrLocal).find(".model").text($("#editDialog #model")[0].value);
	$("#mtab").find("#"+idTrLocal).find(".capacity").text($("#editDialog #capacity")[0].value);
}


function saveEditedPosToDatabase(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var json = { "idTypeHdd"	: $("#editDialog #id")[0].value,
				"model"		: $("#editDialog #model")[0].value,
				"capacity"	: $("#editDialog #capacity")[0].value};

	  //var json = { "idTypeHdd" : "1", "model" : "2", "capacity": "3"};

		///dataType : "json",
	$.ajax({
		url: "type_hdd/save_edited",
	    	 
	    data: JSON.stringify(json),
	    contentType: "application/json",
	   	type: "POST",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
		success: function(smartphone) {
		   /* var respContent = "";
		     
		    respContent += "<span class='success'>Smartphone was created: [";
		    respContent += smartphone.producer + " : ";
		    respContent += smartphone.model + " : " ;
		    respContent += smartphone.price + "]</span>";
		     
		    $("#sPhoneFromResponse").html(respContent);     */    
		}
    });
}



function fillDeleteDialog (idTr, id) {
	$("#deleteDialog  #idTr")[0].value = idTr;
	$("#deleteDialog #id")[0].value = id;
}

function removePosFromHTML() {
	var idTrLocal = $("#deleteDialog #idTr")[0].value ;
//	$("#mtab #id2").remove();
	$("#mtab #"+ idTrLocal).remove();

}


function deleteFromDatabase (){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var idLocal = $("#deleteDialog #id")[0].value



	var json = { "idTypeHdd"	: idLocal };

	$.ajax({
		url: "type_hdd/delete",
	    	 
	    data: JSON.stringify(json),
	    contentType: "application/json",
	   	type: "delete",

	    beforeSend: function(xhr) {
	        xhr.setRequestHeader(header, token);
	    },
		success: function(smartphone) {
			//
		}
    });
}


function renumerate (idTable) {
	$("#" + idTable  +" tr").each(function(i){
		$(" .myIndex", this).text(i);
	});
}
