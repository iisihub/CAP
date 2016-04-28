pageInit(function() {
  $(document).ready(function() {
    $.ajax({
      url : url("pwdpolicyhandler/query"),
      success : function(result) {
        $(document).injectData(result);
      }
    });
    $('#confirm').click(function() {
      $.ajax({
        url : url("pwdpolicyhandler/modify"),
        data : $('#mform').serializeData(),
        success : function() {
        }
      });
    });
  });
});
