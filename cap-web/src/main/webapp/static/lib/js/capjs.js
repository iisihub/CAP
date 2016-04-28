require.config({
  paths : {
    'common.properties' : 'lib/js/common/common.properties',
    'common.jqgrid' : 'lib/js/common/common.jqgrid',
    'common.message' : 'lib/js/common/common.message',
    'commonjs' : 'lib/js/common/common'
  },
  shim : {
    'commonjs' : [ 'libjs' ], //, 'common.properties'],
    'common.message' : [ 'libjs' ],
    'common.jqgrid' : [ 'commonjs' ]
  }
});

define('capjs', [ 'libjs', 'commonjs', 'common.jqgrid', 'common.message' ], function(capjs) {
  logDebug("cap js init");
});
