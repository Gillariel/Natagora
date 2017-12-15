$(document).ready(function() {
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
        center: new google.maps.LatLng(50.55, 5.95),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i, markers = [];

    $('#sessionInfo p').each(function(i) {
        var session = $($(this)[0]);
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(session.data('lat'), session.data('lon'))
            /* To set data on the marker, need if session's name is already set with on click?
            label: session.data('com')
             */
        });

        markers.push(marker);

        google.maps.event.addListener(marker, 'click', (function (marker, i) {
            return function () {
                loadObservations(session.data('id'));
                infowindow.setContent(session.data('com'));
                infowindow.open(map, marker);
            }
        })(marker, i));
    });

    var markerCluster = new MarkerClusterer(map, markers,
        {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});

    function loadObservations(sessionID) {
        var obs;
        $.ajax({
            type: 'GET',
            url: "http://192.168.128.13:8081/NataRest/api/sessions/observationsMedia/" + sessionID,
            contentType: "application/json; charset=utf-8",
            headers: {
                'api-key': "24321d8c-b1b3-45bc-9d21-038dfc33b34c"
            },
            success: function (data, textStatus, xhr) {
                if(xhr.status === 200) {
                    addObsToHtml(data);
                }
            },
            error: function (xhr, status) {
                if(xhr.status === 404) {
                    swal("No sessions found", 'Maybe a bug or it has been deleted recently','question');
                }else{
                    swal("Probleme while contacting the server, try later please.");
                }
            }
        });
    }

    function addObsToHtml(obs) {
        var categories = [
            'Photo',
            'Audio',
            'Video',
            'Text'
        ];

        var htmlCategories = '<li><a href="#" data-filter="*" class="active">All</a></li>';
        categories.forEach(function(element){
            htmlCategories += '<li><a href="#" data-filter=".' + element + '" class="active">' + element +'</a></li>';
        });

        var htmlObs = '';
        obs.forEach(function(element){
            $('#SessionName').find('h2').text(element[4]);
            if(element[1] === 'Text'){
                htmlObs += '<div class="col-sm-6 col-md-3 col-lg-3 Text isotope-item">\n' +
                    '           <div class="portfolio-item">\n' +
                    '               <div class="hover-bg"> <a href="https://dncache-mauganscorp.netdna-ssl.com/thumbseg/809/809932-bigthumbnail.jpg">\n' +
                    '                   <div class="hover-text">\n' +
                    '                       <h4>' + element[1] + '</h4>\n' +
                    '                       <small>' + milisToDate(element[10]) + '</small>\n' +
                    '                       <div class="clearfix"></div>\n' +
                    '                    </div>\n' +
                    '                    <img src="https://dncache-mauganscorp.netdna-ssl.com/thumbseg/809/809932-bigthumbnail.jpg" class="img-responsive" alt="' + element[1] + '"> </img> ' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '        </div>';
            }else {
                htmlObs += '<div class="col-sm-6 col-md-3 col-lg-3 isotope-item ' + element[2] + '">\n' +
                    '           <div class="portfolio-item">\n' +
                    '               <div class="hover-bg"> <a href="' + element[0] + '" rel="prettyPhoto">\n' +
                    '                   <div class="hover-text">\n' +
                    '                       <h4>' + element[5] + '</h4>\n' +
                    '                       <small>' + milisToDate(element[10]) + '</small>\n' +
                    '                       <div class="clearfix"></div>\n' +
                    '                   </div>\n' +
                    '                   <img src="' + element[0] + '" class="img-responsive" alt="' + element[5] + '"> </a>' +
                    '               </div>\n' +
                    '           </div>\n' +
                    '       </div>';
            }
        });

        $('.isotopeCategories').children().remove().end().append(htmlCategories);
        $('.portfolio-items').children().remove().end().append(htmlObs);

        GalleryReset();
        isotopeReset();
    }

    function isotopeReset() {
        'use strict';

        var $container = $('.portfolio-items');
        // Its super important to reload isotope context in order to
        // use filter when new cat/items has been added !
        $container.isotope('reloadItems').isotope({
            layoutMode: 'masonry',
            filter: '*',
            animationOptions: {
                duration: 750,
                easing: 'linear',
                queue: false
            }
        });
        $('.cat a').click(function() {
            $('.cat .active').removeClass('active');
            $(this).addClass('active');
            var selector = $(this).attr('data-filter');
            $container.isotope({
                layoutMode: 'masonry',
                filter: selector,
                animationOptions: {
                    duration: 750,
                    easing: 'linear',
                    queue: false
                }
            });
            return false;
        });
    }

    function GalleryReset() {
        $("a[rel^='prettyPhoto']").prettyPhoto({
            social_tools: false
        });
    }

    function milisToDate(dateInMilis) {
        var date =  new Date(dateInMilis);
        return (date.getFullYear() + '-' +
            (date.getMonth() + 1) + '-' +
            date.getDate() + ' ' +
            date.getHours() + ':' +
            date.getMinutes() + ':' +
            date.getSeconds());
    }

});