<html>
<head>
<TITLE>Crunchify - Spring MVC Example with AJAX call</TITLE>
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
 
<style type="text/css">
body {
//    background-image:
//        url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
    function crunchifyAjax() {
    	var token = $("meta[name='_csrf']").attr("content");
    	var header = $("meta[name='_csrf_header']").attr("content");
    	
    	
        $.ajax({

            type: "POST",
            url : 'ajaxtest.html',
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success : function(data) {
                $('#result').html(data);
            }
        });
    }
</script>
 
<script type="text/javascript">
    var intervalId = 0;
    intervalId = setInterval(crunchifyAjax, 3000);
</script>
</head>
 
<body>
    <div align="center">
        <br> <br> ${message} <br> <br>
        <div id="result"></div>
        <br>
        <p>
            by <a href="http://crunchify.com">Crunchify.com</a>
        </p>
    </div>
</body>
</html>