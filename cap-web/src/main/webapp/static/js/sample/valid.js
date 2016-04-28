pageInit(function() {
  $(document).ready(function() {
    var form = $("form");

    form.validationEngine('attach', $.extend({
      addFailureCssClassToField : 'input-success',
      addFailureCssClassToField : 'input-error'
    }, Properties.myCustMessages));

    $("#check").click(function() {
      if (form.validationEngine('validate')) {
        logDebug('Valid succes~!');
      } else {
        logDebug('Valid failed~!');
      }
    });
  });
});
