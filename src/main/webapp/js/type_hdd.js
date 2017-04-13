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

	//Edit/delete pos
	$(".editPos").click(function() {
		//Dialog "Edit pos"
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



	//Dialog "Delete pos"
    /*$("#deleteDialog").dialog({
	    modal: true});
	$("#deleteDialog #deleteDialogOk").click(function() {
    	$("#mtab #id2").remove();
    	$('#deleteDialog').dialog('close');
	});
*/

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

function saveEditedPosToDatabase(){
	
}