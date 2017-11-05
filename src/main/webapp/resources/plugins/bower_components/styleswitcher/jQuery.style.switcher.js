// Theme color settings
$(document).ready(function () {    
    $("*[data-theme]").click(function (e) {
        e.preventDefault();
        var currentStyle = $(this).attr('data-theme');
        $.cookie("theme", currentStyle, { expires : 365 } );
        $('#theme').attr({
            href: '/NatAdmin/resources/ample/css/colors/' + currentStyle + '.css'
        });
    });

    var currentTheme = get('theme');
    if (currentTheme) {
        $('#theme').attr({
            href: '/NatAdmin/resources/ample/css/colors/' + currentTheme + '.css'
        });
    }
    // color selector
    $('#themecolors').on('click', 'a', function () {
        $('#themecolors li a').removeClass('working');
        $(this).addClass('working');
    });

});

function get(name) {
    return $.cookie(name);
}
