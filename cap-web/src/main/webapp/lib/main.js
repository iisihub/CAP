require({
    baseUrl: '../',
    paths: {
        // angular: 'js/module/angularjs',
        order: 'js/requirejs/plugin/order',
        text: 'js/requirejs/plugin/text'//,
        //  use: 'js/requirejs/plugin/use'
    }
});


require(['order!js/json3.min', 'order!js/module/jquery', 'order!js/module/angularjs', 'order!js/module/cap', 'order!js/module/app'], function(){
    var app = arguments[arguments.length - 1];
    app.config(['$routeProvider', function($routeProvider){
        return $routeProvider.when('/:subMenu', {
            controller: 'mainMenuCtrl',
            reloadOnSearch: true
        }).when('/:subMenu/:page', {
            controller: 'mainMenuCtrl',
            reloadOnSearch: true
        }).otherwise({
            redirectTo: '/0'
        });
    }]);
    return angular.bootstrap(window.document, ['app']);
});
