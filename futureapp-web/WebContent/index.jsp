<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expire" content="-1">

<title>Web App Of The Future</title>
<script>
function redirect()
{
	window.location = "${pageContext.request.contextPath}/future/student/listDetails";
}
</script>

</head>
<body onload="redirect()">
</body>
</html>