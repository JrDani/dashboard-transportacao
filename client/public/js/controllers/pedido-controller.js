angular.module('dashboard').controller('PedidoController', function($scope, $http, $filter){

    $scope.colunas = [{text:'Minério'}, 
    {text:'Cliente'},  
    {text: 'Quantidade (kg)'},
    {text: 'Data do pedido'},
    {text: 'Total do pedido'}];

    $scope.linhas = [];

    var promise = $http.get('http://localhost:8090/pedidos');

    promise.then(function(retorno){
        
        //seleciona só os dados pertinentes
        $scope.linhas = _.map(retorno.data, function(pedido){
            return {
                minerio: pedido.minerio.nome,
                cliente: pedido.cliente.nome,             
                quantidade: pedido.quantidade_kg,
                data: $filter('date')(pedido.data_pedido, "dd/MM/yyyy"),
                total: pedido.total
            }
        })

    }).catch(function(error){
        console.log(error);
    });
})