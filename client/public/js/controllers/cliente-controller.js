angular.module('dashboard').controller('ClienteController', function($scope, $http){

    $scope.colunas = [
        {
            text: "Nome"
        }
    ];

    $scope.linhas = [];

    var promise = $http.get('http://localhost:8090/clientes')
    promise.then(function(retorno){

        $scope.linhas = _.map(retorno.data, function(cliente){
            return {
                nome: cliente.nome
            }
        });
    }).catch(function(error){
        console.log(error)
    });
});