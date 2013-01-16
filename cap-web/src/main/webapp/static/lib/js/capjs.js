require.config({
    paths : {
        'common.properties' : 'lib/js/common/common.properties',
        'common.jqgrid' : 'lib/js/common/common.jqgrid',
        'commonjs' : 'lib/js/common/common'
    },
    shim : {
        'commonjs' : ['libjs'], //, 'common.properties'],
        'common.jqgrid' : ['commonjs']
    }
});

define('capjs', ['libjs', 'commonjs', 'common.jqgrid'], function(capjs) {
    logDebug("cap js init");
});
