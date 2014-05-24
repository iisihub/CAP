pageInit(function() {
  $(document).ready(function() {
    $.ajax({
      url : "webroot/pwdpolicyhandler/query",
      success : function(result) {
        $(document).injectData(result);
      }
    });
    $('#confirm').click(function(){
      $.ajax({
        url : "webroot/pwdpolicyhandler/modify",
        data : $('#mform').serializeData(),
        success : function() {
        }
      });
    });
  });
});
