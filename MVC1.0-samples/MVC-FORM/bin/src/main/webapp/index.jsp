<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC-FORM</title>
</head>
<body>
	<form action="app/form" method="post">
		<label for="nome">Nome:</label>
		<input id="nome" placeholder="Digite o seu Nome" type="text" name="nome"/>
		<input type="submit" value="salvar"/>
	</form>
</body>
</html>