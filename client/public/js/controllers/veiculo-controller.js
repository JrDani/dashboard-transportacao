angular.module('dashboard').controller('VeiculoController', function($scope, $http){

    $scope.colunas = [
        {
            text: "ID do veículo"
        },
        {
            text: "Tipo de veículo"
        }
    ]
    $scope.linhas = [];

    var promise = $http.get('http://localhost:8090/veiculos')
    promise.then(function(retorno){

        $scope.linhas = _.map(retorno.data, function(veiculo){
            return {
                id: veiculo.id_veiculo,
                tipo_veiculo: veiculo.tipoVeiculo.nome
            }
        });
    }).catch(function(error){
        console.log(error);
    });
});