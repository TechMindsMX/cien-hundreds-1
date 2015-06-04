<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.png')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
		<!-- Bootstrap core CSS -->
        <link href="/cien-hundreds/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Bootstrap theme -->
        <link href="/cien-hundreds/assets/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="/cien-hundreds/assets/theme.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>	
		<div class="container theme-showcase">
            <div class="well">
                <div class="row">
                    <div class="col-xs-12 col-md-8">
                        <a href="#"><asset:image src="cien_logo.gif" alt="Grails"/></a>
                    </div>
                    <div class="col-xs-6 col-md-4 text-right">
                        <button class="btn btn-default" type="button">Ingresar</button>
                    </div>
                </div>
            </div>
            <g:layoutBody/>           
        
            <div class="well">
                <p>Copyright 2015 100 Hundreds.</p>
            </div>            
        </div>
	</body>
</html>
