angular.module('dashboard', ['todasDiretivas', 'ngRoute', 'tc.chartjs'])
.config(function($routeProvider, $locationProvider){
    
    $locationProvider.html5Mode(true);

    $routeProvider.when('/', {
        templateUrl: 'partials/dashboard.html',
        controller: 'DashboardController'
    });

    $routeProvider.otherwise({ redirectTo: '/'});
});