angular.module('dashboard').controller('TipoController', function($scope, $http){
    $scope.colunas = [
        {text:'Nome'}       
    ];
    $scope.linhas = [];
 
    var promise = $http.get('http://localhost:8090/tipo-veiculos');
    
    promise.then(function(retorno){
        //seleciona só os dados pertinentes
        $scope.linhas = _.map(retorno.data, function(tipo){
            return {
                nome: tipo.nome               
            }
        });
    }).catch(function(erro){
        console.log(erro);
    });
});