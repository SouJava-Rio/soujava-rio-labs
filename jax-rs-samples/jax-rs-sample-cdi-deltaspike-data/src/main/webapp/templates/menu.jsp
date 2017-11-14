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
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	name="viewport" content="width=device-width, initial-scale=1">
<title>JAX-RS-SAMPLE-CDI-DELTASPIKE-DATA</title>
<link href="<c:url value="/recursos/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">JAX-RS-SAMPLE-CDI-DELTASPIKE-DATA</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active" ><a href="jsp/consultarRegistros.jsp">JUGS</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="/recursos/bootstrap/js/jquery.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/recursos/bootstrap/js/bootstrap.min.js"/>"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>