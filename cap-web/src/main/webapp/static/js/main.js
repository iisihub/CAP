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
        'capjs.properties': 'lib/js/common/common.properties',
        'cust-properties': 'js/common/cust.properties',
        'cust-common': 'js/common/cust.common'
    },
    shim: {
        'cust-properties': ['libjs', 'capjs.properties'],
        'capjs': ['libjs', 'cust-properties'],
        'cust-common': ['libjs', 'capjs', 'cust-properties']
    }
});

require(['cust-common', 'libjs', 'capjs'], function(){
    console.log("cust js init");
});
// load page js by cust-common
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
        define(['cust-common'], function(){
            return settings instanceof Function ? {
                init: settings
            } : settings;
        });
    }
};
