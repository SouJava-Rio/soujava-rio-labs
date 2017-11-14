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
<!DOCTYPE html>
<html ng-app="cadastrarControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar JUG</title>
<script type="text/javascript" src="../recursos/angular/angular.min.js"></script>
<script type="text/javascript"
	src="../recursos/scriptView/cadastrarRegistrosController.js"></script>
<script type="text/javascript" src="../recursos/scriptView/funcoes.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form ng-controller="cadastrarController">
                <h2>Novo Cadastro de JUG</h2>
                
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input id="nome" ng-model="nome" class="form-control" placeholder="Nome da JUG" autofocus>
                </div>
                
                <div class="form-group">
                    <label for="leader">Leader:</label>
                    <input type="text" id="leader" ng-model="leader" class="form-control" placeholder="JUG Leader">
                </div>
                
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" ng-model="email" class="form-control" placeholder="Email">
                </div>
          
                <div class="form-group">
                    <label for="descricao">Descricao:</label>
                    <textarea type="" id="descricao" ng-model="descricao" class="form-control" placeholder="descriçao da JUG"></textarea>
                </div>
                
                <button class="btn btn-primary btn-block" ng-click="salvarUsuario()">Registrar</button>
            </form>
        </div>
    </div>
</div>

<br />
<br />
	<jsp:include page="/templates/rodape.jsp"></jsp:include>
</body>
</html>