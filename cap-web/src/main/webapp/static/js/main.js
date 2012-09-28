var logDebug = function(){
    if (window.console && window.console.firebug) {
        console.log.apply(this, arguments);
    }
    
};
require.config({
    urlArgs: 'cache=' + parseInt(Math.random() * 1000),
    baseUrl: '../static',
    paths: {
        'libjs': 'lib/js/libjs',
        'capjs': 'lib/js/capjs',
        'cust-properties': 'js/common/cust.properties',
        'cust-common': 'js/common/cust.common'
    },
    shim: {
        'capjs': ['libjs'],
        'cust-properties': ['libjs', 'capjs'],
        'cust-common': ['libjs', 'capjs', 'cust-properties']
    }
});

require(['cust-common', 'libjs', 'capjs'], function(){
    console.log("cust js init");
});
//load page js by cust-common 
var loadScript = function(url){
    require(['cust-common'], function(){
        require([url], function(pageJs){
            console.log(url + ' loaded!');
            pageJs && pageJs.init();
        })
    });
};

var pageInit = function(settings){
    if (settings) {
        define(function(){
            return settings instanceof Function ? {
                init: settings
            } : settings;
        });
    }
};
