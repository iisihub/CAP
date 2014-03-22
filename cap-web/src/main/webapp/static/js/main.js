var logDebug = function() {
	if (window.console) {
		console.log(arguments);
	}
};
require.config({
	urlArgs : 'cache=' + parseInt(Math.random() * 1000),
	baseUrl : '../static',
	paths : {
		'libjs' : 'lib/js/libjs',          //third party lib
		'capjs' : 'lib/js/capjs',          //cap lib
		'common.properties' : 'lib/js/common/common.properties', 
		'cust-properties' : 'js/common/cust.properties', // 客制化設定檔
		'cust-common' : 'js/common/cust.common' // 客制化 CommonJS檔
	},
	shim : {
		'cust-properties' : ['libjs', 'common.properties'],
		'capjs' : ['libjs', 'cust-properties'],
		'cust-common' : ['libjs', 'cust-properties', 'capjs'] //客制化lib 載入設定
	}
});

require(['libjs', 'common.properties', 'cust-properties','capjs', 'cust-common'], function() {
	logDebug("cust js init");
});

//global method
window.loadScript = function(url) {
	require(['cust-common'], function() {
		require([url], function(pageJs) {
			logDebug(url + ' loaded!');
			pageJs && pageJs.init();
		})
	});
};
window.pageInit = function(settings) {
	if (settings) {
		define.call(window,['cust-common'], function() {
			return settings instanceof Function ? {
				init : settings
			} : settings;
		});
	}
}
