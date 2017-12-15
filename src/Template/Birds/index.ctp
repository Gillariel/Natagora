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
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Helios</title>
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Favicons
            ================================================== -->
        <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">

        <link href="/css/demo.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="/css/cardGallery.css">
    </head>

    <body>
        <div class="codrops-top clearfix">
            <a style="left" href="/home"><strong>&laquo; </strong><span>Back to Home</span></a>
        </div>
        <div class="card">
            <div class="products">
                <?php foreach($birds as $bird) {
                    if (array_search($bird, $birds) == 0) { ?>
                        <div class="product active" product-id="<?= $bird->id ?>" product-color="getRandomColor()">
                            <div class="thumbnail"><img
                                    src="<?= $bird->url ?>"/></div>
                            <h1 class="title"><?= $bird->name ?></h1>
                            <p class="description">Fusce dapibus, tellus ac cursus commodo, tortor mauris
                                condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                        </div>
                    <?php } else { ?>
                        <div class="product" product-id="<?= $bird->id ?>" product-color="getRandomColor()">
                            <div class="thumbnail"><img src="<?= $bird->url ?>"/>
                            </div>
                            <h1 class="title"><?= $bird->name ?></h1>
                            <p class="description">Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                                ut fermentum massa justo sit amet risus.</p>
                        </div>
                    <?php }
                }?>
            </div>
            <div class="footer"><a class="btn" id="prev" href="#" ripple="" ripple-color="#666666">Prev</a><a class="btn" id="next" href="#" ripple="" ripple-color="#666666">Next</a></div>
        </div>

        <script type="text/javascript" src="/js/jquery.1.11.1.js"></script>
        <script src="/js/cardGallery.js" type="text/javascript"></script>
    </body>
</html>
