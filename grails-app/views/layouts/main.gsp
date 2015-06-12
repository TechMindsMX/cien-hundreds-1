<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>100Hundreds</title>
    
    <asset:stylesheet src="css/bootstrap.min.css"/>
    <asset:stylesheet src="font-awesome/css/font-awesome.css"/>
    <!--link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet"-->

    <!-- Toastr style -->
    <asset:stylesheet src="css/plugins/toastr/toastr.min.css"/>

    <!--link href="css/plugins/toastr/toastr.min.css" rel="stylesheet"-->

    <!-- Gritter -->
    <asset:javascript src="js/plugins/gritter/jquery.gritter.css"/>
    <!--link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet"-->
    <asset:stylesheet src="css/animate.css"/>
    <asset:stylesheet src="css/style.css"/>
    <asset:stylesheet src="theme.css"/>
    <!--link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet"-->
    <g:layoutHead/>

</head>

<g:set var="btnOffset" scope="session" value="col-sm-offset-2" />
<g:set var="labelWidth" scope="session" value="col-sm-2" />
<g:set var="inputWidth" scope="session" value="col-sm-10 col-lg-6" /> 

<body>
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element"> <span>
                            <asset:image src="cien_logo.gif"/>
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="profile.html">Profile</a></li>
                                <li><a href="contacts.html">Contacts</a></li>
                                <li><a href="mailbox.html">Mailbox</a></li>
                                <li class="divider"></li>
                                <li><a href="login.html">Logout</a></li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            IN+
                        </div>
                    </li>
                    <li class="active">
                        <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span> <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                          <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                            <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
                          </g:each>
                        </ul>
                    </li>
                    <li>
                        <a href="layouts.html"><i class="fa fa-diamond"></i> <span class="nav-label">Layouts</span> <span class="label label-primary pull-right">NEW</span></a>
                    </li>
                    
                </ul>

            </div>
        </nav>
    
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <g:if test="${flash.message}">
            <div class="alert alert-info" style="display: block">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="alert alert-danger" style="display: block">${flash.error}</div>
        </g:if>

        <g:layoutBody/>

        <div class="well">
            <p>Copyright 2015 100 Hundreds.</p>
        </div>
    </div>
    

    <!-- Mainly scripts -->
    <asset:javascript src="js/jquery-2.1.1.js" />
    <asset:javascript src="js/bootstrap.min.js" />
    <asset:javascript src="js/plugins/metisMenu/jquery.metisMenu.js" />
    <asset:javascript src="js/plugins/slimscroll/jquery.slimscroll.min.js" />

    <!-- Flot -->
    <asset:javascript src="js/plugins/flot/jquery.flot.js" />
    <asset:javascript src="js/plugins/flot/jquery.flot.tooltip.min.js" />
    <asset:javascript src="js/plugins/flot/jquery.flot.spline.js" />
    <asset:javascript src="js/plugins/flot/jquery.flot.resize.js" />
    <asset:javascript src="js/plugins/flot/jquery.flot.pie.js" />

    <!-- Peity -->
    <asset:javascript src="js/plugins/peity/jquery.peity.min.js" />
    <asset:javascript src="js/demo/peity-demo.js" />

    <!-- Custom and plugin javascript -->
    <asset:javascript src="js/inspinia.js" />
    <asset:javascript src="js/plugins/pace/pace.min.js" />

    <!-- jQuery UI -->

    <!-- GITTER -->

    <!-- Sparkline -->


    <!-- Sparkline demo data  -->

    <!-- ChartJS-->

    <!-- Toastr -->



</body>
</html>
