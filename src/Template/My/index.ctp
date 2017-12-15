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
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" sizes="16x16" href="../plugins/images/favicon.png">
        <title>My Account</title>

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css"  href="/css/diminishedStyle.css">

        <link href="/css/demo.css" rel="stylesheet">
        <link href="/css/stapel.css" rel="stylesheet">
        <link href="/css/custom.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="/css/tabDemo.css" />
        <link rel="stylesheet" type="text/css" href="/css/tabs.css" />
        <link rel="stylesheet" type="text/css" href="/css/tabstyles.css" />
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,200' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap-iso.css" />
        <link rel="stylesheet" type="text/css" href="/css/profileCard.css" />

        <script src="/js/modernizr.custom.js" type="text/javascript"></script>
        <script src="/js/modernizr.custom.63321.js" type="text/javascript"></script>

        <style>
            .resize-pic {
                height: 188px;
                width: 250px;
                max-width: 250px;
                max-height: 188px;
            }
            legend {font-weight: bold;}
        </style>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div id="holder">
            <div id="body">
                <svg class="hidden">
                    <defs>
                        <path id="tabshape" d="M80,60C34,53.5,64.417,0,0,0v60H80z"/>
                    </defs>
                </svg>
                <div class="container">
                    <div class="codrops-top clearfix">
                        <a style="left" href="/home"><strong>&laquo; </strong><span>Back to Home</span></a>
                    </div>
                    <div class="codrops-icon codrops-arrow">
                    </div>
                    <header class="codrops-header">
                        <h1>Your account <span>Contains all your content sent til now</span></h1>
                        <p class="support">Your browser does not support <strong>flexbox</strong>! <br />Please view this demo with a <strong>modern browser</strong>.</p>
                    </header>

                    <section>
                        <div class="tabs tabs-style-circle">
                            <nav>
                                <ul>
                                    <li><a href="#section-circle-1" class="icon icon-user"><span>Your Data</span></a></li>
                                    <li><a href="#section-circle-2" onclick="loadGallery()" class="icon icon-gallery"><span>Public Gallery</span></a></li>
                                    <li><a href="#section-circle-3" onclick="loadPendingGallery()" class="icon icon-box"><span>Pended Gallery</span></a></li>
                                </ul>
                            </nav>
                            <div class="content-wrap">
                                <section id="section-circle-1">
                                    <br/>
                                    <br/>
                                    <?php if(empty($user) || !isset($user)){ ?>
                                        <p>Problem while retrieving your data, please try again later :/</p>
                                    <?php } else { ?>
                                        <div class="bootstrap-iso">
                                            <div style="" class="row center">
                                                <div class="topbar">
                                                    <span id="close" class="back">&larr;</span>
                                                    <h2>Here is your personal data.<br>Change field's value to automatically change your data</h2>
                                                </div>
                                                <form role="form">
                                                    <fieldset>
                                                        <legend style="color: #2CC185;">Your data</legend>
                                                        <div class="form-group col-md-6">
                                                            <label style="font-size: 75%" for="lastname">Name : </label>
                                                            <input disabled="true" type="text" <?php if(isset($user) && !empty($user)) { ?>value="<?= $user->name ?>"<?php } ?> class="form-control" placeholder="Name">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label style="font-size: 75%" for="firstname">First Name : </label>
                                                            <input disabled="true" type="email" <?php if(isset($user) && !empty($user)) { ?>value="<?= $user->forname ?>"<?php } ?> class="form-control" placeholder="First Name">
                                                        </div>

                                                        <div class="form-group col-md-6">
                                                            <label style="font-size: 75%" for="username">Username : </label>
                                                            <input type="text" <?php if(isset($user) && !empty($user)) { ?>value="<?= $user->pseudo ?>"<?php } ?> class="form-control" placeholder="Username">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label style="font-size: 75%" for="mail">Email : </label>
                                                            <input type="email" <?php if(isset($user) && !empty($user)) { ?>value="<?= $user->mail ?>"<?php } ?> class="form-control" placeholder="Email">
                                                        </div>
                                                    </fieldset>
                                                    <hr>
                                                    <fieldset>
                                                        <legend style="color: #2CC185;">Change your password</legend>
                                                        <div class="form-group col-md-6">
                                                            <label style="font-size: 75%" for="username">Old password </label>
                                                            <input type="password" class="form-control" placeholder="Your old password">
                                                        </div>
                                                        <div class="form-group col-md-7"></div>
                                                        <div class="form-group col-md-6">
                                                            <label style="font-size: 75%" for="username">New password </label>
                                                            <input type="password" class="form-control" placeholder="Your new password">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label style="font-size: 75%" for="mail">Enter it again </label>
                                                            <input type="password" class="form-control" placeholder="Type it again to be sure ;)">
                                                        </div>
                                                    </fieldset>
                                                    <hr>
                                                    <div class="form-group col-md-7">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <a class="btn btn-green waves-effect waves-light">Remove Your link with Facebook</a>
                                                    </div>
                                                    <div class="form-group col-md-2">
                                                        <a class="btn btn-green waves-effect waves-light"><i class="fa fa-exclamation-triangle fa-fw"></i>Delete your account</a>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    <?php } ?>
                                </section>
                                <section id="section-circle-2">
                                    <br/>
                                    <br/>
                                        <div class="wrapper">
                                            <div class="topbar">
                                                <span id="close" class="back">&larr;</span>
                                                <h2>Your Public Sessions</h2><h3 id="name"></h3>
                                            </div>
                                            <?php if(empty($sessions)){ ?>
                                                <p>You haven't any sessions yet :(</p>
                                            <?php } else { ?>
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
                                                <?php }
                                            } ?>
                                            </ul>
                                        </div>
                                </section>
                                <section id="section-circle-3">
                                    <br/>
                                    <br/>
                                    <div class="wrapper">
                                        <div class="topbar">
                                            <span id="close2" class="back">&larr;</span>
                                            <h2>Your Pended Gallery</h2><h3 id="name2"></h3>
                                        </div>
                                        <?php if(empty($pendings)){ ?>
                                            <p>No pending's sessions to be shown :)</p>
                                        <?php } else { ?>
                                        <ul id="tp-grid2" class="tp-grid">
                                            <?php foreach ($pendings as $pending) { ?>
                                                <?php foreach ($pending['observations'] as $pObs) { ?>
                                                    <li data-pile="<?= $pending['comment'] ?>">
                                                        <a href="#">
                                                            <span class="tp-info"><span><?= $pObs['media']['name'] ?></span></span>
                                                            <img class="resize-pic" src="<?= $pObs['media']['url'] ?>"/>
                                                        </a>
                                                    </li>
                                                <?php } ?>
                                            <?php }
                                        } ?>
                                        </ul>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <!-- Shared Footer -->
            <div id="alwaysBottom">
                <div id="social-section">
                    <div class="container">
                        <div class="social">
                            <ul>
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-github"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div id="footer">
                    <div class="container">
                        <div class="fnav">
                            <p>Copyright &copy; Natagora Designed by <a href="http://www.helmo.be" rel="nofollow">HELMo</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End footer -->
        </div>
        <script type="text/javascript" src="/js/jquery.1.11.1.js"></script>
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        <script type="text/javascript" src="/js/waves.js"></script>

        <script type="text/javascript" src="/js/jquery.stapel.js"></script>
        <script type="text/javascript" src="/js/cbpFWTabs.js"></script>
        <script type="text/javascript" src="/js/profileCard.js"></script>
        <script type="text/javascript">
            (function() {
                [].slice.call(document.querySelectorAll('.tabs')).forEach(function(el) {
                    new CBPFWTabs(el);
                });
            })();
        </script>

        <script type="text/javascript">
            function loadGallery() {

                var $grid = $( '#tp-grid' ), $name = $( '#name' ), $close = $( '#close' ), $loader = $( '<div class="loader"><i></i><i></i><i></i><i></i><i></i><i></i><span>Loading...</span></div>' ).insertBefore( $grid ),
                    stapel = $grid.stapel( {randomAngle : true, delay : 50, gutter : 70, pileAngles : 5,
                        onLoad : function() {$loader.remove(); },
                        onBeforeOpen : function( pileName ) {$name.html( pileName ); },
                        onAfterOpen : function( pileName ) {$close.show(); }
                    });
                $close.on('click', function() { $close.hide(); $name.empty(); stapel.closePile(); });
            }

            function loadPendingGallery() {
                var $grid2 = $( '#tp-grid2' ), $name2 = $( '#name2' ), $close2 = $( '#close2' ), $loader2 = $( '<div class="loader"><i></i><i></i><i></i><i></i><i></i><i></i><span>Loading...</span></div>' ).insertBefore( $grid2 ),
                    stapel2 = $grid2.stapel( { randomAngle : true, delay : 50, gutter : 70, pileAngles : 5,
                        onLoad : function() { $loader2.remove(); },
                        onBeforeOpen : function( pileName ) { $name2.html( pileName ); },
                        onAfterOpen : function( pileName ) { $close2.show(); }
                    });
                $close2.on('click', function() { $close2.hide(); $name2.empty(); stapel2.closePile(); });
            }
        </script>
    </body>

</html>

