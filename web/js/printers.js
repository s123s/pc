

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


/*
$(document).ready(function(){
	$("#editDialogForm").validate({
    	rules:{
        	model:{
            	required: true,
			},
		},
        messages:{
        	model:{
            	required: "Это поле обязательно для заполнения",
			},
		}
	});
 
});
*/

    /*$( "#editDialog" ).dialog({
	    modal: true});
	$("#editDialogSave").click(function() {
  		alert("Saving..");
	});
*/

	//Edit pos
/*	$(".editPos").click(function() {
		//Dialog "Edit pos"
		fillEditDialog(this.parentNode.parentNode.id);	//Заполнение диалогового окна значениями
    	$("#editDialog").dialog({
    	    modal: true});

    	$("#editDialog #editDialogSave").click(function() {
    	//$("#mtab #id2").remove();
    		saveEditedPosToHTML();
    		saveEditedPosToDatabase();
    		renumerate();
    		$('#editDialog').dialog('close');
	   	});
	    });*/



	//Dialog "Delete pos"
    $("#deleteDialog").dialog({
	    modal: true});
	$("#deleteDialog #deleteDialogOk").click(function() {
    	$("#mtab #id2").remove();
    	$('#deleteDialog').dialog('close');
	});

});



//$(function() {

$(document).ready(function(){

    $(".left.pane").resizable({
        handles : "e, w"
    });
    $(".right.pane").resizable({
        handles : "e, w"
    });
    $(".center.pane .inner .bottom").resizable({
        handles : "n, s"
    });


   /* $("#newDialog").dialog({
        autoOpen: false,
        resizable:false,
        modal: true
    });
    $("#newDialog #newDialogSave").click(function() {
        saveNewPosToDatabase();
        //saveNewPosToHTML();
        //$('#newDialog').dialog('close');
    });

*/

  /*  $("#editDialog").dialog({
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


   /* $("#newDialogForm").validate({
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



    //New pos
    $("body").on("click", ".newPos", function () {
//	$(".newPos").click(function() {
        $('#newDialog').dialog('open');
    });

    //Edit pos
    $("body").on("click", ".editPos", function () {
        fillEditDialog(this.parentNode.parentNode.id);	//Заполнение диалогового окна значениями
        $('#editDialog').dialog('open');
    });*/

    //Delete pos
    $("body").on("click", ".deletePos", function () {
        fillDeleteDialog(this.parentNode.parentNode.id);	//Заполнение диалогового окна значениями
        $('#deleteDialog').dialog('open');
    });

});


// saveAnswer- ответ от Ajax-сохранения
/*
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
}

function saveNewPosToDatabase(){
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    var json = {
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
            $('#newDialog').dialog('close');
        }
    });
}



/!*Fill dialog window for edtiting from table node*!/
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
}
*/


function fillDeleteDialog (idTr) {
    $("#deleteDialog #idTr")[0].value = idTr;
    $("#deleteDialog #id")[0].value = $("#mtab").find("#"+idTr).find(".idTypeHdd").text();
}

function removePosFromHTML() {
    var idTrLocal = $("#deleteDialog #idTr")[0].value ;
    $("#mtab #"+ idTrLocal).remove();
}


function deleteFromDatabase (){
	url: "deletePrinter"
}
  /*  var token = $("meta[name='_csrf']").attr("content");
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
            removePosFromHTML();
            renumerate("mtab");
            $('#deleteDialog').dialog('close');
        }
    });
}*/

function renumerate (idTable) {
    $("#" + idTable  +" tr").each(function(i){
        $(" .myIndex", this).text(i);
    });
}