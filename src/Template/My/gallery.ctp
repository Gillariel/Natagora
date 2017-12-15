<?php
use Cake\Cache\Cache;
use Cake\Core\Configure;
use Cake\Core\Plugin;
use Cake\Datasource\ConnectionManager;
use Cake\Error\Debugger;
use Cake\Network\Exception\NotFoundException;
use Cake\View\Helper\SessionHelper;

?>

<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nicest Gallery</title>
    <meta name="description" content="Thumbnail Pile Effect with Automatic Grouping" />
    <meta name="keywords" content="jquery, pile, effect, images, grid, thumbnails, css3, grouping, albums" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="/css/stapel.css" />
    <link rel="stylesheet" type="text/css" href="/css/custom.css" />
    <script src="/js/modernizr.custom.63321.js"></script>
    <style>
        .resize-pic {
            height: 188px;
            width: 250px;
            max-width: 250px;
            max-height: 188px;
        }
    </style>
    <!--[if lte IE 7]><style>.support-note .note-ie{display:block;}</style><![endif]-->
</head>
<body>
<div class="container">
    <section class="main">
        <div class="wrapper">

            <div class="topbar">
                <span id="close" class="back">&larr;</span>
                <h2>All Gallery</h2><h3 id="name"></h3>
            </div>

            <ul id="tp-grid" class="tp-grid">
                <?php foreach ($sessions as $session){ ?>
                    <?php foreach($session['observations'] as $obs) { ?>
                        <li data-pile="<?= $session['comment'] ?>">
                            <a href="#">
                                <span class="tp-info"><span><?= $obs['media']['name'] ?></span></span>
                                <img class="resize-pic" src="<?= $obs['media']['url'] ?>" />
                            </a>
                        </li>
                    <?php } ?>
                <?php } ?>
            </ul>
        </div>
    </section>

</div><!-- /container -->
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.stapel.js"></script>
<script type="text/javascript">
    $(function() {

        var $grid = $( '#tp-grid' ),
            $name = $( '#name' ),
            $close = $( '#close' ),
            $loader = $( '<div class="loader"><i></i><i></i><i></i><i></i><i></i><i></i><span>Loading...</span></div>' ).insertBefore( $grid ),
            stapel = $grid.stapel( {
                randomAngle : true,
                delay : 50,
                gutter : 70,
                pileAngles : 5,
                onLoad : function() {
                    $loader.remove();
                },
                onBeforeOpen : function( pileName ) {
                    $name.html( pileName );
                },
                onAfterOpen : function( pileName ) {
                    $close.show();
                }
            } );

        $close.on( 'click', function() {
            $close.hide();
            $name.empty();
            stapel.closePile();
        } );

    } );
</script>
</body>
</html>
