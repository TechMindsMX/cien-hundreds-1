<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><g:layoutTitle default="100Hundreds" /></title>

    <asset:stylesheet src="css/bootstrap.min.css"/>
    <asset:stylesheet src="font-awesome/css/font-awesome.css"/>
    <asset:stylesheet src="theme.css"/>
    <asset:stylesheet src="jquery-ui.css"/>

    <asset:javascript src="js/jquery-2.1.1.js" />
    <asset:javascript src="js/jquery-ui-1.10.4.min.js" />

    <g:layoutHead/>

</head>

<g:set var="btnOffset" scope="session" value="col-md-offset-3" />
<g:set var="labelWidth" scope="session" value="col-sm-12 col-md-3" />
<g:set var="inputWidth" scope="session" value="col-sm-12 col-md-6" />

<body role="document">

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <g:link class="navbar-brand" uri="/"><asset:image src="logo_talentua_blanco.png"/></g:link>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <sec:ifLoggedIn>
                    <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN,ROLE_MUSICIAN_VIEWER,ROLE_FACILITATOR,ROLE_USER">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${message(code: 'musician.label')} <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><g:link controller="musician" action="index"><g:message code="list.label" default="Listado" /></g:link></li>

                                <sec:ifAnyGranted roles="ROLE_USER">
                                    <li><g:link controller="musician" action="create">${message(code: 'default.add.label', args: [message(code: 'musician.label')])}</g:link></li>
                                </sec:ifAnyGranted>
                            </ul>
                        </li>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN,ROLE_COMPANY_VIEWER,ROLE_BUYER,ROLE_USER">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${message(code: 'company.label')} <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><g:link controller="company" action="index"><g:message code="list.label" default="Listado" /></g:link></li>

                                <sec:ifAnyGranted roles="ROLE_USER">
                                    <li><g:link controller="company" action="create">${message(code: 'default.add.label', args: [message(code: 'company.label')])}</g:link></li>
                                </sec:ifAnyGranted>
                            </ul>
                        </li>
                    </sec:ifAnyGranted>
                </sec:ifLoggedIn>

                <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN,ROLE_COMPANY_ADMIN">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${message(code: 'admin.label', default: 'Admin')} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <sec:ifAnyGranted roles="ROLE_ADMIN">
                                <li><g:link controller="musicianRole" action="index">${message(code: 'default.list.label', args: [message(code: 'musicianRole.label')])}</g:link></li>
                                <li><g:link controller="musicianRole" action="create">${message(code: 'default.add.label', args: [message(code: 'musicianRole.label')])}</g:link></li>
                                <li role="separator" class="divider"></li>
                            </sec:ifAnyGranted>
                            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN">
                                <li><g:link controller="genre" action="index">${message(code: 'default.list.label', args: [message(code: 'genre.label')])}</g:link></li>
                                <li><g:link controller="genre" action="create">${message(code: 'default.add.label', args: [message(code: 'genre.label')])}</g:link></li>
                                <li role="separator" class="divider"></li>
                            </sec:ifAnyGranted>
                            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN">
                                <li><g:link controller="businessActivity" action="index">${message(code: 'default.list.label', args: [message(code: 'businessActivity.label')])}</g:link></li>
                                <li><g:link controller="businessActivity" action="create">${message(code: 'default.add.label', args: [message(code: 'businessActivity.label')])}</g:link></li>
                            </sec:ifAnyGranted>
                        </ul>
                    </li>
                </sec:ifAnyGranted>

                <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN,ROLE_MUSICIAN_ADMIN">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${message(code: 'userManagement.label', default: 'User Mgmt')} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN">
                                <li><g:link controller="companyValidation" action="index">${message(code: 'default.list.label', args: [message(code: 'companyValidation.label')])}</g:link></li>
                                <li><g:link controller="companyValidation" action="create">${message(code: 'default.add.label', args: [message(code: 'companyValidation.label')])}</g:link></li>
                                <li role="separator" class="divider"></li>
                            </sec:ifAnyGranted>
                            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN">
                                <li><g:link controller="musicianValidation" action="index">${message(code: 'default.list.label', args: [message(code: 'musicianValidation.label')])}</g:link></li>
                                <li><g:link controller="musicianValidation" action="create">${message(code: 'default.add.label', args: [message(code: 'musicianValidation.label')])}</g:link></li>
                                <li role="separator" class="divider"></li>
                            </sec:ifAnyGranted>
                            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN,ROLE_COMPANY_ADMIN">
                                <li><g:link controller="userManagement" action="index">${message(code: 'default.list.label', args: [message(code: 'userManagement.label')])}</g:link></li>
                                <li><g:link controller="admin" action="create">${message(code: 'default.create.label', args: [message(code: 'facilitator.label')])}</g:link></li>
                                <li role="separator" class="divider"></li>
                            </sec:ifAnyGranted>
                        </ul>
                    </li>
                </sec:ifAnyGranted>

                <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN,ROLE_MUSICIAN_ADMIN">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${message(code: 'reports.label', default: 'User Mgmt')} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN">
                                <li><g:link controller="musician" action="creationReportView">${message(code: 'creation.report.label', args: [message(code: 'musician.label')])}</g:link></li>
                            </sec:ifAnyGranted>
                            <sec:ifAnyGranted roles="ROLE_ADMIN">
                                <li role="separator" class="divider"></li>
                            </sec:ifAnyGranted>
                            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN">
                                <li><g:link controller="company" action="creationReportView">${message(code: 'creation.report.label', args: [message(code: 'company.label')])}</g:link></li>
                            </sec:ifAnyGranted>
                        </ul>
                    </li>
                </sec:ifAnyGranted>

            </ul>

            <div class="nav navbar-nav navbar-right">
                <sec:ifNotLoggedIn>
                    <li><g:link controller="login">${message(code: 'springSecurity.login.link')}</g:link></li>
                </sec:ifNotLoggedIn>
                <sec:ifLoggedIn>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><strong class="font-bold"><sec:loggedInUserInfo field="username"/></strong> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <sec:access expression="!hasRole('ROLE_ADMIN')" >
                            <li><g:link id="${applicationContext.springSecurityService.currentUser.id}" controller="user" action="show" >${message(code: 'default.show.label', args: [message(code: 'profile.label')])}</g:link></li>
                        </sec:access>
                        <li><g:link class="logout" controller="logout"><g:message code="springSecurity.logout.link"/></g:link></li>
                    </ul>
                </sec:ifLoggedIn>
            </li>
            </div>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container theme-showcase" role="main">


    <div id="page-wrapper" class="">
        <g:if test="${flash.message}">
            <div class="alert alert-info" style="display: block">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="alert alert-danger" style="display: block">${flash.error}</div>
        </g:if>

        <div id="content-wrapper">
            <g:layoutBody/>
        </div>

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
                                <g:link controller="static" params="[content:'terms']">${message(code: 'terms.label', default: 'T�rminos y condiciones')}</g:link>
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
    <asset:javascript src="js/bootstrap.min.js" />
    %{-- <asset:javascript src="js/plugins/slimscroll/jquery.slimscroll.min.js" /> --}%

    <!-- Flot -->
    %{-- <asset:javascript src="js/plugins/flot/jquery.flot.js" /> --}%
    %{-- <asset:javascript src="js/plugins/flot/jquery.flot.tooltip.min.js" /> --}%
    %{-- <asset:javascript src="js/plugins/flot/jquery.flot.spline.js" /> --}%
    %{-- <asset:javascript src="js/plugins/flot/jquery.flot.resize.js" /> --}%
    %{-- <asset:javascript src="js/plugins/flot/jquery.flot.pie.js" /> --}%

    <!-- Peity -->
    %{-- <asset:javascript src="js/plugins/peity/jquery.peity.min.js" /> --}%
    %{-- <asset:javascript src="js/demo/peity-demo.js" /> --}%

    <!-- Custom and plugin javascript -->
    %{-- <asset:javascript src="js/plugins/pace/pace.min.js" /> --}%

    <!-- jQuery UI -->
    <asset:javascript src="js/file_validation.js" />

    <!-- jQuery UI -->

    <!-- GITTER -->

    <!-- Sparkline -->


    <!-- Sparkline demo data  -->

    <!-- ChartJS-->

    <!-- Toastr -->

    <asset:javascript src="js/analytics-code.js" />

<script type="text/javascript">
    $(function() {
        $('button[type="reset"]').after('<input class="btn btn-danger" type="button" value="Cancelar" onclick="window.history.back()" />').remove()
    });
</script>

</body>
</html>
