angular.module('dashboard').controller('DashboardController', function($scope, $http){
    
    $scope.pedidos = [];
    $scope.relacaoVeiculoTiposVeiculos = {};
    
    var promise = $http.get('http://localhost:8090/pedidos');
    promise.then(function(retorno){      

        /*Valor total por minerios */
        var mineriosNosPedidos = _.groupBy(retorno.data, function(pedido) {           
            return pedido.minerio.nome;
        });
        //console.log(minerio);
        var totalPorMinerios = _.map(mineriosNosPedidos, function(pedidos){
            pedidos.total = _.map(pedidos, function(pedido){
                return parseFloat(pedido.total);
            });
            return _.reduce(pedidos.total, function(sum, n) {
                return sum + n;
              }, 0);             
        });
        //console.log(totalPorMinerios)
        $scope.totalPorMinerios_dados = deBarraDados(mineriosNosPedidos, totalPorMinerios);
        $scope.totalPorMinerios_options = configuracao('Total de venda por minérios em R$ (Reais)');        

    }).catch(function(erro){
        console.log(erro);
    });

    //dividir em services 
    var promiseVeiculos = $http.get('http://localhost:8090/veiculos');
    promiseVeiculos.then(function(retorno){
        var tiposDeVeiculos = _.groupBy(retorno.data, function(veiculos) {           
            return veiculos.tipoVeiculo.nome;
        });
        var contadorVeiculo = _.map(tiposDeVeiculos, function(veiculos){        
            return veiculos.length;
        });
        //console.log(tiposDeVeiculos);
        //console.log(contadorVeiculo);
        $scope.veiculosCirculacao_dados = deDonautDados(tiposDeVeiculos, contadorVeiculo);
        $scope.veiculosCirculacao_options = configuracao('Veículos em circulação');
                  
    }).catch(function(erro){
        console.log(erro);
    });

    //dividir em services 
    var promiseMinerios = $http.get('http://localhost:8090/minerios');
    promiseMinerios.then(function(retorno){
        $scope.minerios = retorno.data;
    }).catch(function(erro){
        console.log(erro);
    });

    //dividir em services 
    var promiseTipoVeiculo = $http.get('http://localhost:8090/minerios');
    promiseTipoVeiculo.then(function(retorno){
        $scope.tipoVeiculo = retorno.data;
    }).catch(function(erro){
        console.log(erro);
    });
    
});    

function deBarraDados(minerios, totalPorMinerio){    
    
    return {
        labels: Object.getOwnPropertyNames(minerios),
        datasets: [
          {
              label: "A",
              backgroundColor:  'rgba(255, 99, 132, 1)',
              borderColor: 'rgba(255,99,132,1)',
              data: totalPorMinerio
          }
        ]
    };    
}

function deDonautDados(key, contador){
    return  {
        // Chart.js data structure goes here
        // e.g. Pie Chart Data Structure http://www.chartjs.org/docs/#doughnut-pie-chart-data-structure
        labels: Object.getOwnPropertyNames(key),
        datasets: [
          {
            data: contador,
            backgroundColor: [
              "#FF6384",
              "#36A2EB",
              "#FFCE56"
            ],
            hoverBackgroundColor: [
              "#FF6384",
              "#36A2EB",
              "#FFCE56"
            ]
          }
        ]
      };
}

function configuracao(titulo){
    return {
        title: {
            display: true,
            text: titulo
        }
    }
}