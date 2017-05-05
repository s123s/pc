
function globalInit() {
	$(".left.pane").resizable({
			handles : "e, w"
		});
	$(".right.pane").resizable({
		handles : "e, w"
	});
	$(".center.pane .inner .bottom").resizable({
		handles : "n, s"
	});

	/*Create dialog*/
	simpleDialog = $("#simpleDialog").dialog({
		autoOpen: false,
		resizable:false,
		modal: true
	});
	$("#simpleDialog #simpleDialogOk").click(function() {
			$('#simpleDialog').dialog('close');
   	});
}


function simpleDialogOpen(title, message) {
	//$("#simpleDialog").attr("title", title);
	//simpleDialog

	$( "#simpleDialog" ).dialog( "option", "title", title );
	$("#simpleDialog #message").text(message);
	$("#simpleDialog").dialog("open");
}