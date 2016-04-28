pageInit(function() {
  $(document).ready(function() {
    $("textarea#tt").sceditor({
      plugins : 'xhtml',
      /* toolbar : 'image|source', */
      style : "../static/lib/js/jquery/plugin/sceditor/jquery.sceditor.default.min.css",
      /* emoticonsEnabled : false, */
      emoticonsRoot : "../static/images/"
    });

    var mySCEditor = $("textarea#tt").sceditor("instance");

    $('#ok').click(function() {
      $(mySCEditor.getWysiwygEditorValue()).filter(":not(script)").insertBefore(".preview .script");
      $(".preview .script").html($(mySCEditor.getWysiwygEditorValue()).filter("script"));
    });

    $('#reset').click(function() {
      $(".preview").val('');
      $("<div class=\"script\"></div>").appendTo(".preview");
    });

  });
});