<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" sizes="16x16" href="/img/favicon.png">
        <title>Ample Admin Template - The Ultimate Multipurpose admin template</title>
        <!-- Bootstrap Core CSS -->
        <link href="/css/bootstrap.css" rel="stylesheet">
        <!-- animation CSS -->
        <link href="/css/animate.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="/css/loginStyle.css" rel="stylesheet">

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <section id="wrapper" class="login-register">
            <div class="login-box login-sidebar">
                <div class="white-box">
                    <form class="form-horizontal form-material" id="loginform" action="index.html">
                        <a href="javascript:void(0)" class="text-center db"><img src="/img/logo-light.png" alt="Home" /><br/><img src="/img/text-dark.png" alt="Home" /></a>
                        <h3 class="box-title m-t-40 m-b-0">Register Now</h3><small>Create your account and enjoy</small>
                        <div class="form-group m-t-20">
                            <div class="col-xs-12">
                                <input class="form-control" type="text" required="true" value="<?= (isset($name) && isset($forname)) ? $name." ".$forname : "" ?>" placeholder="Pseudo">
                            </div>
                        </div>
                        <div class="form-group m-t-20">
                            <div class="col-xs-12">
                                <input class="form-control" type="text" required="true" value="<?= (isset($name)) ? $name : "" ?>" placeholder="Name">
                            </div>
                        </div>
                        <div class="form-group m-t-20">
                            <div class="col-xs-12">
                                <input class="form-control" type="text" required="true" value="<?= (isset($forname)) ? $forname : "" ?>" placeholder="First Name">
                            </div>
                        </div>
                        <div class="form-group ">
                            <div class="col-xs-12">
                                <input class="form-control" type="text" required="true" value="<?= (isset($mail)) ? $mail : "" ?>" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group ">
                            <div class="col-xs-12">
                                <input class="form-control" type="password" required="true" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <input class="form-control" type="password" required="true" placeholder="Confirm Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="checkbox checkbox-primary p-t-0">
                                    <input id="checkbox-signup" required="true" type="checkbox">
                                    <label for="checkbox-signup"> I agree to all <a href="#">Terms</a></label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group text-center m-t-20">
                            <div class="col-xs-12">
                                <button class="btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light" type="submit">Sign Up</button>
                            </div>
                        </div>
                        <?php if(!isset($fb)) { ?>
                        <div class="form-group m-b-0">
                            <div class="col-sm-12 text-center">
                                <p>Already have an account? <a href="/login" class="text-primary m-l-5"><b>Sign In</b></a></p>
                            </div>
                        </div>
                        <?php } ?>
                    </form>
                </div>
            </div>
        </section>
        <!-- jQuery -->
        <script src="/js/jquery.1.11.1.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="/js/bootstrap.min.js"></script>
        <!--Wave Effects -->
        <script src="/js/waves.js"></script>
        <!-- Custom Theme JavaScript -->
        <script src="/js/custom.min.js"></script>
    </body>
</html>
