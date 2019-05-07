angular.module('dashboard', ['todasDiretivas', 'ngRoute', 'tc.chartjs'])
.config(function($routeProvider){     

    $routeProvider.when('/', {
        templateUrl: 'partials/dashboard.html',
        controller: 'DashboardController'
    });

    $routeProvider.when('/minerio', {
        templateUrl: 'partials/minerio.html',
        controller: 'MinerioController'
    });

    $routeProvider.when('/pedido', {
        templateUrl: 'partials/pedido.html',
        controller: 'PedidoController'
    });

    $routeProvider.when('/cliente', {
        templateUrl: 'partials/cliente.html',
        controller: 'ClienteController'
    });

    $routeProvider.when('/tipo-veiculos', {
        templateUrl: 'partials/tipo-veiculos.html',
        controller: 'TipoController'
    });

    $routeProvider.when('/veiculo', {
        templateUrl: 'partials/veiculo.html',
        controller: 'VeiculoController'
    });

    $routeProvider.otherwise({ redirectTo: '/'});
});