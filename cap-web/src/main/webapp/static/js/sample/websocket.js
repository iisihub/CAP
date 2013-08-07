pageInit(function() {
    $(document).ready(function() {"use strict";

        var userName = 'user' + Math.floor((Math.random() * 1000) + 1);

        var socket = io.connect('http://192.168.221.92:9092' ,{
            "":""
        });

        socket.on('connect', function() {
            console.log(arguments);
            output('<span class="connect-msg">Client has connected to the server!</span>');
        });

        socket.on('chatevent', function(data) {
            output('<span class="username-msg">' + data.userName + ':</span> ' + data.message);
        });

        socket.on('disconnect', function() {
            output('<span class="disconnect-msg">The client has disconnected!</span>');
        });
        
        socket.on("reconnect_failed",function(){
           output('<span class="disconnect-msg">The client has reconnect_failed!</span>');
        });

        $("#disconnect").click(function() {
            socket.disconnect();
        });

        $("#send").click(function() {
            var message = $('#msg').val();
            $('#msg').val('');
            socket.emit('chatevent', {
                userName : userName,
                message : message
            });
        });

        function output(message) {
            var currentTime = "<span class='time'>" + "ss" + "</span>";
            var element = $("<div>" + currentTime + " " + message + "</div>");
            $('#console').prepend(element);
        }

    });
});
