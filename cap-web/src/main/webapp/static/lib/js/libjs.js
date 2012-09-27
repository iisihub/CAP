require.config({
    //all js setting
    paths: {
        'jquery': 'lib/js/jquery/jquery-1.8.2',
        'jquery-ui': 'lib/js/jquery/ui/js/jquery-ui-1.8.23.custom.min',
        'jqgrid-i18n': 'lib/js/jquery/plugin/jquery.jqGrid-4.2.0/js/i18n/grid.locale-cn',
        'jqgrid': 'lib/js/jquery/plugin/jquery.jqGrid-4.2.0/js/jquery.jqGrid.min',
        'validate-i18n': 'lib/js/jquery/plugin/formValidator/languages/jquery.validationEngine-zh_CN',
        'validate': 'lib/js/jquery/plugin/formValidator/jquery.validationEngine',
        'fileupload': 'lib/js/jquery/plugin/ajaxfileupload/ajaxfileupload',
        'blockui': 'lib/js/jquery/plugin/blockUI/jquery.blockUI'
    },
    shim: {
        'jquery-ui': ['jquery'],
        'jqgrid-i18n': ['jquery'],
        'jqgrid': ['jquery-ui', 'jqgrid-i18n'],
        'validate-i18n': ['jquery'],
        'validate': ['jquery', 'validate-i18n'],
        'fileupload': ['jquery'],
        'blockui': ['jquery']
    }
});

define('libjs', ['jquery', 'jquery-ui', 'jqgrid', 'validate', 'fileupload', 'blockui'], function(){
    window.console && window.console.log('lib init');
});

