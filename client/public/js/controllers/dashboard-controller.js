angular.module('dashboard').controller('DashboardController', function($scope, $http){
    
    $scope.pedidos = [];
    
    var promise = $http.get('http://localhost:8090/pedidos');
    promise.then(function(retorno){      

        var minerio = _.groupBy(retorno.data, function(pedido) {
            return pedido.minerio.nome;
          });
        //console.log(minerio);
         
        var totalPorMinerio = _.map(minerio, function(pedidos){
            pedidos.total = _.map(pedidos, function(pedido){
                return parseFloat(pedido.total);
            });
            return _.reduce(pedidos.total, function(sum, n) {
                return sum + n;
              }, 0);             
        });
        //console.log(totalPorMinerio)
        
        $scope.dados = {
            labels: Object.getOwnPropertyNames(minerio),
            datasets: [
              {
                  label: "A",
                  backgroundColor:  'rgba(255, 99, 132, 1)',
                  borderColor: 'rgba(255,99,132,1)',
                  data: totalPorMinerio
              }
            ]
        };
  
        $scope.options = {
            scales: {
                xAxes: [{
                    stacked: true
                }],
                yAxes: [{
                    stacked: true
                }]
            },
            legend: {
                display: true,
                labels: {
                    fontColor: 'rgb(255, 99, 132)'
                }
            },
            title: {
                display: true,
                text: 'Total de venda por minérios em R$ (Real/Brasil)'
            }
  
            // Chart.js options can go here.
        };

    }).catch(function(erro){
        console.log(erro);
    });

});    
