<%--

    The MIT License
    Copyright © 2017 Daniel Dias

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html ng-app="consultarRegistrosControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUGS</title>

<script type="text/javascript" src="../recursos/angular/angular.min.js"></script>
<script type="text/javascript" src="../recursos/scriptView/consultarRegistrosController.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>

<br />
<div class="container">
    <div class="row">
	<a class="btn btn-primary" href="adicionarRegistros.jsp">Adicionar Registros</a>
	<hr />
	<table ng-controller="consultarRegistrosController"
		data-ng-init="init()" id="tableData"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>JUG</th>
				<th>Leader</th>
				<th>Email</th>
				<th>Descrição</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="usuario in usuarios">
				<td>{{ usuario.id }}</td>
				<td>{{ usuario.nome }}</td>
				<td>{{ usuario.leader }}</td>
				<td>{{ usuario.email }}</td>
				<td>{{ usuario.descricao }}</td>
				<td><a href="#" ng-click="excluirRegistro(usuario.id)"><span class="glyphicon glyphicon-trash"></span> Excluir JUG </a></td>
			</tr>
		</tbody>
	</table>
</div>
</div>

	<br />
	<br />
	<jsp:include page="/templates/rodape.jsp"></jsp:include>
</body>
</html>