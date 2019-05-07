angular.module('dashboard').controller('MinerioController', function($scope, $http){

    $scope.colunas = [
        {text:'Nome'}, 
        {text:'Valor por grama (R$)'}
    ];
    $scope.linhas = [];
 
    var promise = $http.get('http://localhost:8090/minerios');
    
    promise.then(function(retorno){
        //seleciona só os dados pertinentes
        $scope.linhas = _.map(retorno.data, function(minerio){
            return {
                nome: minerio.nome,
                valor_grama: minerio.valor_grama
            }
        });
    }).catch(function(erro){
        console.log(erro);
    });
});