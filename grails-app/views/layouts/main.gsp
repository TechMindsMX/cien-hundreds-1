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

<g:set var="btnOffset" scope="session" value="col-md-offset-2" />
<g:set var="labelWidth" scope="session" value="col-sm-12 col-md-2" />
<g:set var="inputWidth" scope="session" value="col-sm-12 col-md-6" />

<body>
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element"> <span>
                            <asset:image src="cien_logo.gif"/>
                             </span>
                             <sec:ifLoggedIn>
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><sec:loggedInUserInfo field="username"/></strong>
                                <b class="caret"></b> </span> </span>  </a>
                                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                    <li class="divider"></li>
                                    <li><g:remoteLink class="logout" controller="logout">${message(code: 'springSecurity.logout.link')}</g:remoteLink></li>
                                </ul>
                            </sec:ifLoggedIn>
                        </div>
                        <div class="logo-element">
                            IN+
                        </div>
                    </li>
                    <li class="active">
                        <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Menu</span> <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                          <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                            <g:if test="${c.getStaticPropertyValue('showMe', Boolean)}">
                                <li class="controller"><g:link controller="${c.logicalPropertyName}"><g:message code="controller.${c.name}.label" /></g:link></li>
                            </g:if>
                          </g:each>
                          <sec:ifLoggedIn>
                              <li><g:remoteLink class="logout" controller="logout">${message(code: 'springSecurity.logout.link')}</g:remoteLink></li>
                          </sec:ifLoggedIn>
                          <sec:ifNotLoggedIn>
                              <li><g:link controller="login">${message(code: 'springSecurity.login.link')}</g:link></li>
                          </sec:ifNotLoggedIn>
                        </ul>
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
        <footer>
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <h3>Acerca de</h3>
                    <ul>
                        <li>
                            <g:link controller="static" params="[content:'what']">${message(code: 'what.label', default: 'Que son los 100 Hundreds?')}</g:link>
                        </li>
                        <li>
                            <g:link controller="static" params="[content:'how']">${message(code: 'how.label', default: 'Como funciona?')}</g:link>
                        </li>
                        <li>
                            <g:link controller="static" params="[content:'who']">${message(code: 'who.label', default: 'Quienes somos?')}</g:link>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-12 col-md-6">
                    <h3>Ayuda</h3>
                    <ul>
                        <li>
                            <g:link controller="static" params="[content:'faq']">${message(code: 'faq.label', default: 'FAQ')}</g:link>
                        </li>
                        <li>
                            <g:link controller="static" params="[content:'terms']">${message(code: 'terms.label', default: 'Términos y condiciones')}</g:link>
                        </li>
                        <li>
                            <g:link controller="static" params="[content:'privacy']">${message(code: 'privacy.label', default: 'Aviso de privacidad')}</g:link>
                        </li>
                    </ul>
                </div>
            </div>
        </footer>
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

    <asset:javascript src="js/analytics-code.js" />

</body>
</html>
