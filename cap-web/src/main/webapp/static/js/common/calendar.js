$(document).ready(
    function() {

      // var date = new Date();
      // var d = date.getDate();
      // var m = date.getMonth();
      // var y = date.getFullYear();

      var monthNames = [ i18n.calendar.Jan, i18n.calendar.Feb, i18n.calendar.Mar, i18n.calendar.Apr, i18n.calendar.May, i18n.calendar.Jun, i18n.calendar.Jul, i18n.calendar.Aug, i18n.calendar.Sep,
          i18n.calendar.Oct, i18n.calendar.Nov, i18n.calendar.Dec ];
      var monthNamesShort = [ i18n.calendar.sJan, i18n.calendar.sFeb, i18n.calendar.sMar, i18n.calendar.sApr, i18n.calendar.sMay, i18n.calendar.sJun, i18n.calendar.sJul, i18n.calendar.sAug,
          i18n.calendar.sSep, i18n.calendar.sOct, i18n.calendar.sNov, i18n.calendar.sDec ];
      var dayNames = [ i18n.calendar.Sun, i18n.calendar.Mon, i18n.calendar.Tue, i18n.calendar.Wed, i18n.calendar.Thu, i18n.calendar.Fri, i18n.calendar.Sat ];
      var dayNamesShort = [ i18n.calendar.sSun, i18n.calendar.sMon, i18n.calendar.sTue, i18n.calendar.sWed, i18n.calendar.sThu, i18n.calendar.sFri, i18n.calendar.sSat ];

      var calendar = $('#calendar').fullCalendar({
        header : {
          left : 'prev,next today',
          center : 'title',
          right : 'month,agendaWeek,agendaDay'
        },
        eventDurationEditable : false,
        eventStartEditable : false,
        monthNames : monthNames,
        monthNamesShort : monthNamesShort,
        dayNames : dayNames,
        dayNamesShort : dayNamesShort,
        buttonText : {
          today : i18n.calendar.today,
          month : i18n.calendar.month,
          week : i18n.calendar.week,
          day : i18n.calendar.day
        },
        events : function(start, end, callback) {
          $.ajax({
            url : url('calendarhandler/getCalendarData'),
            data : {
              start : start.getTime(),
              end : end.getTime()
            },
            success : function(data) {
              var events = [];
              var items = data.events;
              for (item in items) {
                events.push({
                  title : items[item]['content'],
                  start : Math.round(items[item]['startDate']["time"] / 1000),
                  end : Math.round(items[item]['endDate']["time"] / 1000),
                  allDay : false
                });
              }
              callback(events);
            }
          });
        },
        selectable : true,
        selectHelper : true,
        select : function(start, end, allDay) {
          CommonAPI.formSubmit({
            url : '../admin/remind_Page',
            data : {
              fromCal : true,
              startDate : $.fullCalendar.formatDate(start, 'yyyy-MM-dd'),
              endDate : $.fullCalendar.formatDate(end, 'yyyy-MM-dd')
            },
            target : "_blank"
          });
          calendar.fullCalendar('unselect');
        }
      });
    });
