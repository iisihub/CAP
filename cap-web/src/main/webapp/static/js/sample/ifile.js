pageInit(function() {
  $(document).ready(function() {
    $("#upload").click(function() {
      $.capFileUpload({
        url : url("samplehandler/upload"),
        fileElementId : "ufile",
        // fileCheck: ["jpg", "jpeg", "png", "gif", "txt"],
        successMsg : false,
        limitSize : 1 * 1024 * 1024,
        fileEncoding : 'UTF-8',
        data : {
          testStr : "test!!test!!"
        },
        success : function(data) {
          //API.showMessage(data.mktMatlType, data.mktMatl, $("#showMessage"), data.size);
        }
      });
    });
    $("#dwnload").click(function() {
      $.capFileDownload({
        url : url("samplehandler/dwnload"),
        data : {
          fileName : "我是log.log"
        }
      });
    });
    $("#dwnloadPdf").click(function() {
      $.capFileDownload({
        url : url("samplehandler/dwnloadPdf"),
        data : {
          password : "1"
        }
      });
    });
  });
});