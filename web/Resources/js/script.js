var ShortenerForm = {
    checkBoxSelector: ['secured', 'captcha', 'click', 'daterange', 'datemax'],

    init: function () {
        $('#secured').on('click', function () {
            if ($(this).is(':checked')) {
                $('#passwordBlock').show();
                ShortenerForm.disableCheck("secured");
            }
            else {
                $('#passwordBlock').hide();
                ShortenerForm.enableCheck();
            }
        });

        $('#captcha').on('click', function () {
            if ($(this).is(':checked')) {
                ShortenerForm.disableCheck("captcha");
                $("#captcha").removeAttr("disabled");
            }
            else {
                ShortenerForm.enableCheck();
            }
        });
        $('#click').on('click', function () {
            if ($(this).is(':checked')) {
                $('#clickBlock').show();
                ShortenerForm.disableCheck("click");
                $("#click").removeAttr("disabled");
            }
            else {
                $('#clickBlock').hide();
                ShortenerForm.enableCheck();
            }
        });
        $('#daterange').on('click', function () {
            if ($(this).is(':checked')) {
                $('#dateDebutBlock').show();
                $('#dateFinBlock').show();
                ShortenerForm.disableCheck("daterange");
                $("#daterange").removeAttr("disabled");
            }
            else {
                $('#dateDebutBlock').hide();
                $('#dateFinBlock').hide();
                ShortenerForm.enableCheck();
            }
        });
        $('#datemax').on('click', function () {
            if ($(this).is(':checked')) {
                $('#dateMaxBlock').show();
                ShortenerForm.disableCheck("datemax");
                $("#datemax").removeAttr("disabled");
            }
            else {
                $('#dateMaxBlock').hide();
                ShortenerForm.enableCheck();
            }
        });

    },

    disableCheck: function (object) {
        for (var i = 0; i < ShortenerForm.checkBoxSelector.length; i++) {
            if (ShortenerForm.checkBoxSelector[i] !== object) {
                $("#" + ShortenerForm.checkBoxSelector[i]).attr("disabled", true);
            }
        }
    },

    enableCheck: function () {
        for (var i = 0; i < ShortenerForm.checkBoxSelector.length; i++) {
            $("#" + ShortenerForm.checkBoxSelector[i]).removeAttr("disabled");
        }
    }
};

$(document).ready(function () {
    ShortenerForm.init();

});