

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

    /*$( "#editDialog" ).dialog({
	    modal: true});
	$("#editDialogSave").click(function() {
  		alert("Saving..");
	});
*/

	//Edit pos
	$(".editPos").click(function() {
		fillEditDialog(this.parentNode.parentNode.id);	//Заполнение диалогового окна значениями
		
    	$("#editDialog").dialog({
    	    modal: true});

    	$("#editDialog #editDialogSave").click(function() {
    	//$("#mtab #id2").remove();
    		saveEditedPosToHTML();
    		saveEditedPosToDatabase();
    		$('#editDialog').dialog('close');
	   	});
	});


	//Delete pos
	$(".deletePos").click(function() {
		fillDeleteDialog(this.parentNode.parentNode.id);	//Заполнение диалогового окна значениями
		
		//Dialog "Delete pos"
	    $("#deleteDialog").dialog({
		    modal: true});
		$("#deleteDialog #deleteDialogOk").click(function() {
			removePosFromHTML();
	    	renumerate();
	    	$('#deleteDialog').dialog('close');
		});
	});

});

/*Fill dialog window for edtiting from table node*/
function fillEditDialog (idTr) {
	$("#editDialog #idTr")[0].value = idTr;
	$("#editDialog #id")[0].value = $("#mtab").find("#"+idTr).find(".idTypeHdd").text();
	$("#editDialog #model")[0].value = $("#mtab").find("#"+idTr).find(".model").text();
	$("#editDialog #capacity")[0].value = $("#mtab").find("#"+idTr).find(".capacity").text();
}

function saveEditedPosToHTML() {
	var idTrLocal = $("#editDialog #idTr")[0].value ;
	$("#mtab").find("#"+idTrLocal).find(".model").text($("#editDialog #model")[0].value);
	$("#mtab").find("#"+idTrLocal).find(".capacity").text($("#editDialog #capacity")[0].value);
}


function fillDeleteDialog (idTr) {
	$("#deleteDialog #id")[0].value = idTr;
}

function removePosFromHTML() {
	var idLocal = $("#deleteDialog #id")[0].value ;
//	$("#mtab #id2").remove();
	$("#mtab #"+ idLocal).remove();

}

function saveEditedPosToDatabase(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	      var json = { "producer" : "1", "model" : "2", "price": "3"};

	    	 //url: $("#newSmartphoneForm").attr( "action"),
	    $.ajax({
	    	url: "type_hdd/save_edited",
	    	 
        data: JSON.stringify(json),
        type: "POST",

        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.setRequestHeader(header, token);
        },
                success: function(smartphone) {
            var respContent = "";
             
            respContent += "<span class='success'>Smartphone was created: [";
            respContent += smartphone.producer + " : ";
            respContent += smartphone.model + " : " ;
            respContent += smartphone.price + "]</span>";
             
            $("#sPhoneFromResponse").html(respContent);         
        }
    });



}
function renumerate () {

}