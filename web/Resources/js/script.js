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

    if (document.getElementById("linkTable")) {
        $('#linkTable').DataTable({
            "order": [[0, "desc"]],
            "scrollX": true,
            'language': {
                "sProcessing": "Traitement en cours...",
                "sSearch": "Rechercher selon n'importe quel critère&nbsp;:",
                "sLengthMenu": "Afficher _MENU_ &eacute;l&eacute;ments",
                "sInfo": "Affichage de l'&eacute;l&eacute;ment _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
                "sInfoEmpty": "Affichage de l'&eacute;l&eacute;ment 0 &agrave; 0 sur 0 &eacute;l&eacute;ment",
                "sInfoFiltered": "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
                "sInfoPostFix": "",
                "sLoadingRecords": "Chargement en cours...",
                "sZeroRecords": "Aucun &eacute;l&eacute;ment &agrave; afficher",
                "sEmptyTable": "Aucune donn&eacute;e disponible dans le tableau",
                "oPaginate": {
                    "sFirst": "Premier",
                    "sPrevious": "Pr&eacute;c&eacute;dent",
                    "sNext": "Suivant",
                    "sLast": "Dernier"
                },
                "oAria": {
                    "sSortAscending": ": activer pour trier la colonne par ordre croissant",
                    "sSortDescending": ": activer pour trier la colonne par ordre d&eacute;croissant"
                }
            },
            "sPaginationType": "full_numbers",
        });

    }

});