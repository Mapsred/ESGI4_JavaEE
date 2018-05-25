$(document).ready(function () {

    var checkBoxSelector = ['secured', 'captcha', 'click', 'daterange', 'datemax'];

    function disableCheck(object){
        for (var i = 0; i < checkBoxSelector.length; i++) {
            if(checkBoxSelector[i] !== object){
                $("#"+checkBoxSelector[i]).attr("disabled", true);
            }
        }
    }

    function enableCheck(){
        for (var i = 0; i < checkBoxSelector.length; i++) {
            $("#"+checkBoxSelector[i]).removeAttr("disabled");
        }
    }
    
    $('#secured').on('click', function () {
        if($(this).is(':checked')){
            $('#passwordBlock').show();
            disableCheck("secured");
        }
        else{
            $('#passwordBlock').hide();
            enableCheck();
        }
    });

    $('#captcha').on('click', function () {
        if($(this).is(':checked')) {
            disableCheck("captcha");
            $("#captcha").removeAttr("disabled");
        }
        else{
            enableCheck();
        }
    });
    $('#click').on('click', function () {
        if($(this).is(':checked')) {
            $('#clickBlock').show();
            disableCheck("click");
            $("#click").removeAttr("disabled");
        }
        else{
            $('#clickBlock').hide();
            enableCheck();
        }
    });
    $('#daterange').on('click', function () {
        if($(this).is(':checked')) {
            $('#dateDebutBlock').show();
            $('#dateFinBlock').show();
            disableCheck("daterange");
            $("#daterange").removeAttr("disabled");
        }
        else{
            $('#dateDebutBlock').hide();
            $('#dateFinBlock').hide();
            enableCheck();
        }
    });
    $('#datemax').on('click', function () {
        if($(this).is(':checked')) {
            $('#dateMaxBlock').show();
            disableCheck("datemax");
            $("#datemax").removeAttr("disabled");
        }
        else{
            $('#dateMaxBlock').hide();
            enableCheck();
        }
    });

});