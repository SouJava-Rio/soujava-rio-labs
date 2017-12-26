<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC-VALIDACAO</title>
</head>
<body>

		<c:if test="${erros != null}">
			<div>
				<div>
					<p style="background-color: red;">${erros}</p>
				</div>
			</div>
		</c:if>

		<form action="validar" method="post">
			<label for="nome">Nome:</label> <input id="nome"
				placeholder="Digite o seu Nome" type="text" name="nome" /> <label
				for="email">Email:</label> <input id="email"
				placeholder="Digite o seu Email" type="text" name="email" /> <input
				type="submit" value="Registrar" />
		</form>
</body>
</html>