angular.module('todasDiretivas', [])
    .directive('graficoBarra', function(){
        var ddo = {};
        ddo.restrict = "AE";
        ddo.scope = {
            id:'@',
            cliente: '@',
            minerio: '@',
            total: '@'
        };
        ddo.transclude = true;
        ddo.templateUrl = "js/directives/grafico-barra.html";

        return ddo;
    });