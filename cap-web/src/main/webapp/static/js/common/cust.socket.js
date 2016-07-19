(function($) {
  $(document).ready(
      function() {
        "use strict";

        window.socket = io.connect('http://' + window.location.hostname + ':9092');

        socket.on('connect', function() {
          logDebug("Client has connected to the server!");
          $.ajax({
            url : url('sockethandler/initSession'),
            data : {
              socketId : socket.socket.sessionid
            },
            success : function(responseData) {
              logDebug("Client has binded to the server!");
            }
          });
          logDebug("SocketId = " + socket.socket.sessionid);
        });

        socket.on('textEvent', function(data) {
          // var data = {"startTime":"xx:xx:xx","endTime":"oo:oo:oo","content":"測試內容12345678901234567890123456789012345678901234567890"};
          var message = "".concat("<span class='cal'><br/>" + i18n.def['remind.startDate'] + data.startTime + "<br/>").concat(i18n.def['remind.endDate'] + data.endTime + "<br/>").concat(
              "<div class='text-breakAll'>" + i18n.def['remind.content'] + data.content + "</div>").concat("</span>");
          ilog.notify(message);
        });

        $("#msgContainer").on('click', ".cal", function(event) {
          CommonAPI.formSubmit({
            url : './common/calendar',
            target : "_blank"
          });
        });

        socket.on('popUpEvent', function(data) {
          var _idd = $("#remindDialog");
          if (!_idd.size()) {
            var message = "".concat("<br/>" + i18n.def['remind.startDate'] + data.startTime + "<br/>").concat(i18n.def['remind.endDate'] + data.endTime + "<br/>").concat(
                i18n.def['remind.content'] + data.content);
            _idd = $(
                "<div id='remindDialog' style='display:none'><form onsubmit='return false;'><table class='tb2' border='0' cellpadding='0' cellspacing='0' width='100%'><tbody><tr><td class='hd1' width='15%'>"
                    + i18n.def['remind.date'] + "</td><td>" + data.startTime + " ~ " + data.endTime + "</td></tr><tr><td>" + i18n.def['remind.item'] + "</td><td class='text-breakAll'>" + message
                    + "</td></tr></tbody></table></form></div>").appendTo("body");
          }
          _idd.dialog({
            title : i18n.def['remind.title'],
            modal : true,
            width : 300,
            height : 200,
            align : 'center',
            valign : 'bottom',
            buttons : API.createJSON([ {
              key : i18n.def.sure,
              value : function() {
                _idd.dialog('close');
              }
            } ])
          });
          _idd.dialog('open');
        });

        socket.on('disconnect', function() {
          logDebug("The client has disconnected!");
        });

        socket.on("reconnect_failed", function() {
          logDebug("The client has reconnect_failed!");
        });

      });
})(jQuery);
