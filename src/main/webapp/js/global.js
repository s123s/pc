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




}