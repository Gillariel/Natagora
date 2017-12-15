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

        <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="/css/tabDemo.css" />
        <link rel="stylesheet" type="text/css" href="/css/tabs.css" />
        <link rel="stylesheet" type="text/css" href="/css/tabstyles.css" />
        <script src="/js/modernizr.custom.tab.js"></script>
    </head>

    <body>
        <svg class="hidden">
            <defs>
                <path id="tabshape" d="M80,60C34,53.5,64.417,0,0,0v60H80z"/>
            </defs>
        </svg>
        <div class="container">
            <div class="codrops-top clearfix">
                <a class="codrops-icon codrops-icon-prev" href="/home"><span>Back to Home</span></a>
            </div>
            <header class="codrops-header">
                <h1>Your account <span>Contains all your content sent til now</span></h1>
                <p class="support">Your browser does not support <strong>flexbox</strong>! <br />Please view this demo with a <strong>modern browser</strong>.</p>
            </header>

            <section>
                <div class="tabs tabs-style-circle">
                    <nav>
                        <ul>
                            <li><a href="#section-circle-1" class="icon icon-plug"><span>Connect</span></a></li>
                            <li><a href="#section-circle-2" class="icon icon-gift"><span>Gifts</span></a></li>
                            <li><a href="#section-circle-3" class="icon icon-box"><span>Boxes</span></a></li>
                            <li><a href="#section-circle-4" class="icon icon-date"><span>Prints</span></a></li>
                            <li><a href="#section-circle-5" class="icon icon-plane"><span>Fun</span></a></li>
                        </ul>
                    </nav>
                    <div class="content-wrap">
                        <section id="section-circle-1"><p>Test</p></section>
                        <section id="section-circle-2"><p>Test 2</p></section>
                        <section id="section-circle-3"><p>Test 3</p></section>
                        <section id="section-circle-4"><p>Test 4</p></section>
                        <section id="section-circle-5"><p>Test 5</p></section>
                    </div>
                </div>
            </section>
        </div>

        <script type="text/javascript" src="/js/cbpFWTabs.js"></script>
        <script>
            (function() {
                [].slice.call( document.querySelectorAll( '.tabs' ) ).forEach( function( el ) {
                    new CBPFWTabs( el );
                });
            })();
        </script>
    </body>
</html>