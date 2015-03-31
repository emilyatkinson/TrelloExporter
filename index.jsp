<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>URL Highlighter</title>
</head>
<body>
	<h1>Hello!</h1>
	<p>
		Please input your Trello board's URL: 
	</p>
	<c:if test="${message != null}">
		<p>
			<i>${message}</i>
		</p>
	</c:if>
	<form action="trelloURL" method="post">
		<input type="hidden" name="action" value="add"> <label
			class="pad_top">Please enter URL:</label> <input type="userUrl"
			name="userUrl"><br> <label>&nbsp;</label> <input
			type="submit" value="Let's Highlight!" class="margin_left">
	</form>
</body>
</html>