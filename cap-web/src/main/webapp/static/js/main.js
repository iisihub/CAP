require.config({
    urlArgs: 'cache=' + parseInt(Math.random() * 100),
    baseUrl: '../static',
    paths: {
        'libjs': 'lib/js/libjs',
        'capjs': 'lib/js/capjs',
        'cust-properties': 'js/cust/cust.properties',
        'cust-common': 'js/cust/custCommon'
    },
    shim: {
        'capjs': ['libjs'],
        'cust-common': ['libjs', 'capjs', 'cust-properties']
    }
});

require(['cust-common', 'libjs', 'capjs'], function(){
    console.log("cust js init");
});
//load page js by cust-common 
function loadScript(url){
    require(['cust-common'], function(){
        require([url], function(){
            console.log(url + ' loaded!');
        })
    });
}
