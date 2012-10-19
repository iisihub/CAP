var logDebug = function() {
	if (window.console && window.console.firebug) {
		console.log.apply(this, arguments);
	}

};
require.config({
	urlArgs : 'cache=' + parseInt(Math.random() * 1000),
	baseUrl : '../static',
	paths : {
		'libjs' : 'lib/js/libjs',          //third party lib
		'capjs' : 'lib/js/capjs',          //cap lib
		'capjs.properties' : 'lib/js/common/common.properties', 
		'cust-properties' : 'js/common/cust.properties', // 客制化設定檔
		'cust-common' : 'js/common/cust.common'　 // 客制化 CommonJS檔
	},
	shim : {
		'cust-properties' : ['libjs', 'capjs.properties'],
		'capjs' : ['libjs', 'cust-properties'],
		'cust-common' : ['libjs', 'capjs', 'cust-properties'] //客制化lib 載入設定
	}
});

require(['cust-common', 'libjs', 'capjs'], function() {
	console.log("cust js init");

	$.extend(window, {
		router : {
			set : function(settings) {
				if (settings) {
					Backbone.history && Backbone.history.stop();
					window._router = new (Backbone.Router.extend(settings));
					Backbone.history.start();
				}
			},
			to : function(path) {
				if (path && window._router)
					window._router.navigate(path, {
						trigger : true						
					});
				else
					throw "no router";
			}
		}
	});
});

//global method
window.loadScript = function(url) {
	require(['cust-common'], function() {
		require([url], function(pageJs) {
			console.log(url + ' loaded!');
			pageJs && pageJs.init();
		})
	});
};
window.pageInit = function(settings) {
	if (settings) {
		define(['cust-common'], function() {
			return settings instanceof Function ? {
				init : settings
			} : settings;
		});
	}
}
