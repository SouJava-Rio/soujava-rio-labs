<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC-POST-REDIRECT-GET</title>
</head>
<body>
	<form action="app/redirect" method="post">
		<label for="nome">Nome:</label>
		<input id="nome" placeholder="Digite o seu Nome" type="text" name="nome"/>
		<input type="submit" value="enviar"/>
	</form>
</body>
</html>