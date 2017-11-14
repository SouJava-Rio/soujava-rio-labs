var consultarRegistrosControllerApp = angular.module("consultarRegistrosControllerApp",[]);

consultarRegistrosControllerApp.controller("consultarRegistrosController",function($scope, $window, $http){

	/*CRIANDO UM ARRAY PARA OS REGISTROS QUE VÃO SER RETORNADOS PELO REST*/
	 $scope.usuarios = new Array();

	 $scope.init = function(){

		 /*CHAMA O MÉTODO consultarTodos DO CONTROLLER GERENCIADO PELO REST*/
		 var response = $http.get("/jax-rs-sample-cdi-deltaspike-data/app/jug");

		 response.success(function(data, status, headers, config) {

			 /*SETA OS REGISTROS QUE FORAM RETORNADOS DO CONTROLLER DO REST,
			  ESSE REGISTROS VÃO PREENCHER OS CAMPOS DA TABELA DA PÁGINA consultarRegistros.jsp
			  ATAVÉS DO ng-repeat do AngularJS*/
			 $scope.usuarios = data;

		 });

		 response.error(function(data, status, headers, config) {
			 /*SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM*/
			 swal(data, {
			      icon: "warning", 
			    });

		 });
	 }

	 /*FUNÇÃO PARA EXCLUIR UM REGISTRO*/	 
	 $scope.excluirRegistro = function(codigo){
		 
		 swal({
			 title : "Você tem certeza que deseja excluir este registro ?",
			 text : "Você não poderá recuperar este registro após excluir !",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  var response = $http.delete("/jax-rs-sample-cdi-deltaspike-data/app/jug/deletar/" + codigo);
				  
				  response.success(function(data, status, headers, config) {

						// $window.alert(data.mensagem);
						 swal(data.mensagem, {
						      icon: "success", 
						    });
						 $scope.init();
					 });
			    
			  } else {
			    swal("Seus Dados estão seguros!"); 
			  }
			});
	 }
});