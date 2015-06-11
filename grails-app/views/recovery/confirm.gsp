<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><g:message code="recovery.password.show.label" /></title>
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
  </head>
  <body>
    <div class="container">
      <div class="well">
        <div class="row">
          <div class="col-xs-12 col-md-8">
          </div>
        </div>
      </div>

      <g:renderErrors />

      ${recovery.confirm.message}

      <footer class="footer">
      </footer>
    </div>
  </body>
</html>
