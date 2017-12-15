$(document).ready(function() {
    var getProductHeight = $('.product.active').height();
    $('.products').css({height: getProductHeight});

    function calcProductHeight() {
      getProductHeight = $('.product.active').height();
      $('.products').css({height: getProductHeight});
    }

    function animateContentColor() {
        var getProductColor = getRandomColor();
        $('body').css({background: getProductColor});
        $('.title').css({color: getProductColor});
        $('.btn').css({color: getProductColor});
    }

    var productItem = $('.product'), productCurrentItem = productItem.filter('.active');

    $('#next').on('click', function(e) {
        e.preventDefault();
        var nextItem = productCurrentItem.next();
        productCurrentItem.removeClass('active');
        productCurrentItem = (nextItem.length) ? nextItem.addClass('active') : productItem.first().addClass('active');
        calcProductHeight();
        animateContentColor();
    });

    $('#prev').on('click', function(e) {
        e.preventDefault();
        var prevItem = productCurrentItem.prev();
        productCurrentItem.removeClass('active');
        productCurrentItem = (prevItem.length) ? productCurrentItem = prevItem.addClass('active') : productCurrentItem = productItem.last().addClass('active');
        calcProductHeight();
        animateContentColor();
    });

    // Ripple
    $('[ripple]').on('click', function(e) {
        var rippleDiv = $('<div class="ripple" />'),
        rippleSize = 60,
        rippleOffset = $(this).offset(),
        rippleY = e.pageY - rippleOffset.top,
        rippleX = e.pageX - rippleOffset.left,
        ripple = $('.ripple');

        rippleDiv.css({
            top: rippleY - (rippleSize / 2),
            left: rippleX - (rippleSize / 2),
            background: $(this).attr("ripple-color")
        }).appendTo($(this));

        window.setTimeout(function() {
            rippleDiv.remove();
        }, 1900);
    });
});

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}