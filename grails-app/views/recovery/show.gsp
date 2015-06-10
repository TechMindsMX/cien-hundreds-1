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

      <div class="row">
        <div class="col-lg-12">
          <div class="page-header">
            <h1><g:message code="change.password.title" /></h1>
          </div>

          <g:form name="recovery" action="update" id="${params.id}" class="form-signin">
            <div class="form-group">
              <label for="password"><g:message code="recovery.password.label" /></label>
              <input type="password" class="form-control" name="password">
            </div>

            <div class="form-group">
              <label for="confirmPassword"><g:message code="recovery.confirm.password.label" /></label>
              <input type="password" class="form-control" name="confirmPassword">
            </div>

            <button type="submit" class="btn btn-primary btn-block btn-lg"><g:message code="change.password.button.label" /></button>
          </g:form>
        </div>
      </div>

      <footer class="footer">
      </footer>
    </div>
  </body>
</html>
