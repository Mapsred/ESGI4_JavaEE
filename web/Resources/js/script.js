$(document).ready(function () {
    $('#secured').click(function () {
        $(this).is(':checked') ? $('#passwordBlock').show() : $('#passwordBlock').hide();
    })
});