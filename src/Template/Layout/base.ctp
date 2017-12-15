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
        <title>NataWeb</title>
        <meta name="description" content="Natagora web platform for bird lovers">
        <meta name="author" content="Montis Patrick & Foerster Nathan">

        <!-- Favicons
            ================================================== -->
        <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">

        <!-- Bootstrap -->
        <link rel="stylesheet" type="text/css"  href="/css/bootstrap.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <!-- Stylesheet
            ================================================== -->
        <link rel="stylesheet" type="text/css"  href="/css/style.css">
        <link rel="stylesheet" type="text/css" href="/css/prettyPhoto.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="/js/modernizr.custom.js"></script>

        <style>
            .map-responsive {
                overflow:hidden;
                padding-bottom:56.25%;
                position:relative;
                height:0;
            }

            .map-responsive iframe {
                left:0;
                top:0;
                height:100%;
                width:100%;
                position:absolute;
            }
        </style>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!-- Navigation
            ==========================================-->
        <nav id="menu" class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    <a class="navbar-brand" href="/home"><i class="fa fa-sun-o"></i> Natagora<strong></strong></a> </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#home" class="page-scroll">Home</a></li>
                        <li><a href="#map-section" class="page-scroll">Map</a></li>
                        <li><a href="#obs-section" class="page-scroll">Observations</a></li>
                        <li><a href="#about-section" class="page-scroll">About</a></li>
                        <li><a href="#contact-section" class="page-scroll">Contact</a></li>
                        <li><a href="/birds" class="page-scroll">Birds Card</a></li>
                        <?php if($this->request->session()->check('Username')){ ?>
                            <li><a href="/my" class="page-scroll">My Account</a></li>
                            <li><a href="/login/logout" class="page-scroll">Logout</a></li>
                        <?php } else { ?>
                            <li><a href="/login" class="page-scroll">Login</a></li>
                        <?php } ?>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>

        <!-- Header -->
        <header class="text-center" name="home">
            <div class="intro-text">
                <h1>Welcome to <strong>Natagora</strong></h1>
                <p>This is our web platform to consult observation of users</p>
            </div>
        </header>

        <?= $this->fetch('content') ?>

        <!-- About Section -->
        <div id="about-section">
            <div class="container">
                <div class="section-title text-center center">
                    <h2>About Us</h2>
                    <hr>
                    <div class="clearfix"></div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diamcommodo nibh ante facilisis.</p>
                </div>
                <div class="row">
                    <div class="col-md-6"> <img src="img/about.jpg" class="img-responsive"> </div>
                    <div class="col-md-6">
                        <div class="about-text">
                            <h4>Who We Are</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante facilisis bibendum dolor feugiat at. Duis sed dapibus leo nec ornare diam commodo nibh ante facilisis bibendum.</p>
                            <h4>What We Do</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante facilisis bibendum dolor feugiat at. Duis sed dapibus leo nec ornare diam commodo nibh ante facilisis bibendum.</p>
                            <h4>Why Choose Us</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante facilisis bibendum dolor feugiat at.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Achievements Section -->
        <div id="achievements" class="section dark-bg">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-3">
                        <div class="achievement-box"> <span class="count"><?= $stats['users'] ?></span>
                            <h4>Current users</h4>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <div class="achievement-box"> <span class="count"><?= $stats['obs'] ?></span>
                            <h4>Observation's done</h4>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <div class="achievement-box"> <span class="count"><?= $stats['sessions'] ?></span>
                            <h4>Session's done</h4>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <div class="achievement-box"> <span class="count"><?= $stats['Birds'] ?></span>
                            <h4>Birds seen</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Contact Section -->
        <div id="contact-section" class="text-center">
            <div class="container">
                <div class="section-title center">
                    <h2>Contact Us</h2>
                    <hr>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diamcommodo nibh ante facilisis.</p>
                </div>
                <div class="col-md-8 col-md-offset-2">
                    <div class="col-md-4"> <i class="fa fa-map-marker"></i>
                        <p>Rue de Harlez, 31<br>
                            4000, Liège</p>
                    </div>
                    <div class="col-md-4"> <i class="fa fa-envelope-o"></i>
                        <p>n.foerster@student.helmo.be</p>
                    </div>
                    <div class="col-md-4"> <i class="fa fa-phone"></i>
                        <p> +0 123 456 7890</p>
                    </div>
                    <hr>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-8 col-md-offset-2">
                    <h3>Leave us a message</h3>
                    <form name="sentMessage" id="contactForm" novalidate>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" id="name" class="form-control" placeholder="Name" required="required">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="email" id="email" class="form-control" placeholder="Email" required="required">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <textarea name="message" id="message" class="form-control" rows="4" placeholder="Message" required></textarea>
                            <p class="help-block text-danger"></p>
                        </div>
                        <div id="success"></div>
                        <button type="submit" class="btn btn-default">Send Message</button>
                    </form>
                </div>
            </div>
        </div>
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

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script type="text/javascript" src="/js/jquery.1.11.1.js"></script>
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        <script type="text/javascript" src="/js/SmoothScroll.js"></script>
        <script type="text/javascript" src="/js/jquery.counterup.js"></script>
        <script type="text/javascript" src="/js/waypoints.js"></script>
        <script type="text/javascript" src="/js/jquery.prettyPhoto.js"></script>
        <script type="text/javascript" src="/js/jquery.isotope.js"></script>
        <script type="text/javascript" src="/js/jqBootstrapValidation.js"></script>
        <script type="text/javascript" src="/js/contact_me.js"></script>
        <script src="https://unpkg.com/sweetalert2@7.0.9/dist/sweetalert2.all.js"></script>

        <script type="text/javascript" src="/js/main.js"></script>

        <?= $this->fetch('script') ?>
    </body>
</html>