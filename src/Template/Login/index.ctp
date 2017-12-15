<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" sizes="16x16" href="../plugins/images/favicon.png">
        <title>Login</title>
        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" type="text/css"  href="/css/bootstrap.css">
        <!-- animation CSS -->
        <link rel="stylesheet" type="text/css"  href="/css/animate.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" type="text/css"  href="/css/loginStyle.css">

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div id="fb-root"></div>
        <script>(function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.11&appId=1577412635658578';
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>

        <section id="wrapper" class="login-register">
            <div class="login-box login-sidebar">
                <div class="white-box">
                    <form class="form-horizontal form-material" id="loginform" action="/home">
                        <a href="javascript:void(0)" class="text-center db"><img src="/img/logo-light.png" alt="Home" /><br/><img src="/img/text-dark.png" alt="Home" /></a>
                        <div class="form-group m-t-40">
                            <div class="col-xs-12">
                                <label id="errorMessage" hidden="true" class="text-danger">Username or Password incorrect</label>
                            </div>
                        </div>
                        <div class="form-group m-t-40">
                            <div class="col-xs-12">
                                <input name="username" id="username" class="form-control" type="text" required="true" placeholder="Username">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <input name="password" id="password" class="form-control" type="password" required="true" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="checkbox checkbox-primary pull-left p-t-0">
                                    <input id="checkbox-signup" type="checkbox">
                                    <label for="checkbox-signup"> Remember me </label>
                                </div>
                                <a href="javascript:void(0)" id="to-recover" class="text-dark pull-right"><i class="fa fa-lock m-r-5"></i> Forgot pwd?</a> </div>
                        </div>
                        <div class="form-group text-center m-t-20">
                            <div class="col-xs-12">
                                <button onclick="login(event)" class="btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light" type="submit">Log In</button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 m-t-10 text-center">
                                Or <br /> <br/>
                                <div class="social"><a onclick="Fblogin()" href="javascript:void(0)" class="btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light btn-facebook" data-toggle="tooltip"  title="Login with Facebook"> Login with <i aria-hidden="true" class="fa fa-facebook"></i> </a>  </div>
                            </div>
                        </div>
                        <div class="form-group m-b-0">
                            <div class="col-sm-12 text-center">
                                <p>Don't have an account? <a href="/login/signin" class="text-primary m-l-5"><b>Sign Up</b></a></p>
                            </div>
                        </div>
                    </form>
                    <form class="form-horizontal" id="recoverform" action="index.html">
                        <div class="form-group ">
                            <div class="col-xs-12">
                                <h3>Recover Password</h3>
                                <p class="text-muted">Enter your Email and instructions will be sent to you! </p>
                            </div>
                        </div>
                        <div class="form-group ">
                            <div class="col-xs-12">
                                <input class="form-control" type="text" required="" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group text-center m-t-20">
                            <div class="col-xs-12">
                                <button class="btn btn-primary btn-lg btn-block text-uppercase waves-effect waves-light" type="submit">Reset</button>
                            </div>
                        </div>
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

        <script src="https://unpkg.com/sweetalert2@7.0.9/dist/sweetalert2.all.js"></script>

        <script>

            function login(event) {
                event.preventDefault();
                var username = $('#username').val();
                var passwd = $('#password').val();
                if(username !== "" && passwd !== "") {
                    $.ajax({
                        type: 'GET',
                        url: "http://192.168.128.13:8081/NataRest/api/users/trylogin/" + username,
                        contentType: "application/json; charset=utf-8",
                        headers: {
                            'api-key': "24321d8c-b1b3-45bc-9d21-038dfc33b34c",
                            'passwd': passwd
                        },
                        success: function (data, textStatus, xhr) {
                            if(xhr.status === 200) {
                                swal({
                                    title: 'Credentials Ok !',
                                    type: 'success',
                                    showConfirmButton: false,
                                    timer: 1500
                                });
                                window.location.replace('http://localhost:8765/login?callback=1&username=' + username);
                            }
                        },
                        error: function (xhr, status) {
                            if(xhr.status === 404) {
                                $('#errorMessage').attr('hidden', false);
                            }else{
                                swal("Probleme while contacting the server, try later please.");
                            }
                        }
                    })
                }
            }

            // Login function work
            // Need to use it with normal login
            function Fblogin() {
                var name, forname, mail;
                FB.login(function (response) {
                    if (response.status === 'connected') {
                        FB.api('/me?fields=id,name,first_name,last_name,email', function (response) {
                            mail = response.email;
                            name = response.last_name;
                            forname = response.first_name;

                            $.ajax({
                                type: 'GET',
                                url: "http://192.168.128.13:8081/NataRest/api/users/check/" + name + "/" + forname,
                                contentType: "application/json; charset=utf-8",
                                headers: {
                                    'api-key': "24321d8c-b1b3-45bc-9d21-038dfc33b34c"
                                },
                                success: function (data, textStatus, xhr) {
                                    if(xhr.status === 200) {
                                        swal("User alreadey have a Natagora Account");
                                    }
                                },
                                error: function (xhr, status) {
                                    if(xhr.status === 404) {
                                        swal("Go to register...");
                                        window.location.replace("http://localhost:8765/login/signin?fb=true&name=" + name + "&forname=" + forname + "&mail=" + mail);
                                    }else{
                                        swal("Probleme while contacting the server, try later please.");
                                    }
                                }
                            });

                        });
                    } else {
                        alert("nok");
                    }
                }, {scope: 'public_profile,email'});
            }
        </script>
    </body>
</html>