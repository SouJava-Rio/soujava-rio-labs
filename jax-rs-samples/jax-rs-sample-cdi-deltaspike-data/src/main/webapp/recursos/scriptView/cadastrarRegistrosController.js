var cadastrarControllerApp = angular.module("cadastrarControllerApp",[]);

cadastrarControllerApp.controller("cadastrarController",function($scope, $window, $http){

	/*DEFININDO O MODELO PARA O NOSSO FORMULÁRIO*/
	$scope.nome  = null;
	$scope.leader = null;
	$scope.email = null;
	$scope.descricao = null;
	
	$scope.salvarUsuario = function(){

		/*DEFINI O OBJETO QUE VAI SER ENVIADO VIA AJAX PELO ANGULARJS*/
		var usuarioModel =  new Object();
		usuarioModel.nome = $scope.nome,
		usuarioModel.leader  = $scope.leader,
		usuarioModel.email = $scope.email,
		usuarioModel.descricao = $scope.descricao;

		/*EXECUTA O POST PARA SALVAR O REGISTRO*/
		var response = $http.post("/jax-rs-sample-cdi-deltaspike-data/app/jug/cadastrar", usuarioModel);

		response.success(function(data, status, headers, config) {

			swal({
				text: data.mensagem,
				icon: "success"
				}).then(function() {
				// Redirect the user
				window.location.href = "../jsp/consultarRegistros.jsp";
				});
			 
	 });
		
	 response.error(function(data, status, headers, config) {
		 /*SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM*/
		 //$window.alert(data);
		 swal(data, {
		      icon: "success", 
		    });

	 });		

	};
});