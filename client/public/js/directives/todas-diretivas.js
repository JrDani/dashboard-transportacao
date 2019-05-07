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
    })
    .directive('dashHeader', function(){
        var ddo = {};

        ddo.restrict = "AE";
        ddo.scope = {}
        ddo.templateUrl = "js/directives/dash-header.html";
        return ddo;
    })
    .directive('dashFooter', function(){
        var ddo = {};
        ddo.restrict = "AE";
        ddo.scope = {};
        ddo.templateUrl = "js/directives/dash-footer.html";
        return ddo;
    })
    .directive('dashContentList', function(){
        var ddo = {};
        
        ddo.restrict = "AE";
        ddo.scope = {
            titulo: '@',
            colunas: '=',
            linhas: '='
        }
        ddo.templateUrl = "js/directives/dash-contentlist.html";
        return ddo;
    });