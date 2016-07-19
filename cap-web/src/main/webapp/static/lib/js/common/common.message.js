(function($) {
  logDebug("common message init");
  var msgButton, msg, newMsg, msgContainer, parent, index = 0;
  var s = $.extend({
    hide : false,
    parentID : null,
    log_server : true,
    log_client : true,
    keepCount : 10,
    writterLog : function(css, message, fn) {
      var msgicon = $("<span class='ui-icon ui-float " + css + "'/>").css('margin-left', '10px');
      var msgdiv = $("<div type='ilog'/>").attr('title', message).addClass('logit').addClass(css || '').html((++index) + ":" + css + ":" + message).hover(function() {
        $(this).addClass('logmi');
      }, function() {
        $(this).removeClass('logmi');
      }).before(msgicon);
      $('#inner').prepend(msgdiv).prepend(msgicon);
      toggleMsg(true);
    }
  }, Properties.ilog || {});

  var ilog;
  ilog = window['ilog'] = {
    setup : function(settings) {
      s = $.extend(true, s, settings || {});
      init();
    },
    /**
     * 增加 message 層級
     * @param {Object} level
     * @param {Object} css
     */
    addMessageLevel : function(level, css, fn) {
      if (typeof level == 'string') {
        level = [ {
          level : level,
          css : css || "",
          fn : fn || s.writterLog
        } ];
      }
      for (k in level) {
        var o = level[k];
        ilog[o.level] = (function(oo) {
          return function(message) {
            return writterLog(oo.css, message, oo.fn) || ilog;

          };
        })(o);
      }
    }
  };
  var defaultMsg = [];
  defaultMsg.push({
    level : "debug",
    css : "log_debug"
  });
  s.log_server && defaultMsg.push({
    level : "server",
    css : "log_server"
  });
  s.log_client && defaultMsg.push({
    level : "client",
    css : "log_client"
  });
  defaultMsg.push({
    level : "notify",
    css : "notify"
  });
  ilog.addMessageLevel(defaultMsg);
  function init() {
    parent = $((s.parentID) ? ("#" + s.parentID) : 'body');
    (newMsg = newMsg || $("<div id='newSysMsgArea' class='" + (s.hide ? "hide" : "") + "'><div id='newSysMsgArea_inner' style='position:relative'></div></div>")).appendTo(parent);
    (msgButton = msgButton || $("<div id='sysMsgButton'><div id='msgicon' class='nl' /></div>")).appendTo(newMsg.find("#newSysMsgArea_inner"));
    (msgContainer = msgContainer
        || $(
            "<div id='msgContainer'><div class='innerTitle ui-state-default' >" + mi18n.messageArea + "</div><div id='innerShowall'><p>" + ""/*mi18n.showAll*/
                + "</p></div><div id='inner'></div></div>").prepend($("<div class='innerTitle' style='float:right'>ｘ　</div>").click(buttonClick))).appendTo(newMsg.find("#newSysMsgArea_inner"));
    msgButton.find("#msgicon").click(buttonClick);
  }

  function buttonClick() {
    toggleMsg();
  }

  function writterLog(css, message, fn) {
    try {
      logDebug(css, message);
    } catch (e) {
    }
    ;
    if (css == 'log_debug')
      return;
    return fn ? fn.call(s, css, message) : s.writterLog(css, message);
  }

  function toggleMsg(flag) {
    flag ? newMsg.attr('class').indexOf('on') < 0 && newMsg.addClass('on') : newMsg.toggleClass('on');
    newMsg.show();
    $('#msgicon').toggleClass('on');
    msgContainer[flag ? 'show' : 'toggle']();
  }

  //    function logSwitch(){
  //        s[this.value] = !s[this.value];
  //    }

  var mi18n = ({
    'zh-tw' : {
      messageArea : '系統訊息(System Message)',
      showAll : '顯示全部'
    }
  }[(window.navigator.userLanguage || window.navigator.language).toLowerCase()]) || {
    messageArea : 'SysMessage',
    showAll : 'Show All'
  };

  $(document).ready(function() {
    init();
    //        $("<div id='logAction' style='display:none'></div>").appendTo(parent).append(createButton('log_debug'));
    //        function createButton(type){
    //            return $('<input type="button" value="' + type + '" />').click(function(){
    //                logSwitch.call(this);
    //            });
    //        }
    //        
    //        $(document).bind('keydown', function(e){
    //            if (e.ctrlKey && e.keyCode == 192) 
    //                $("#logAction").toggle();
    //        });
  });
})(jQuery);
