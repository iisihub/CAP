pageInit(function() {
  $(document).ready(function() {
    "use strict";
    $("#submit").click(function() {
      $.ajax({
        url : url('samplehandler/checkCaptcha'),
        data : {
          captcha : $("#captcha").val()
        },
        complete : function() {
          $("#captcha").trigger("refresh");
        }
      });
    });

  });
});
