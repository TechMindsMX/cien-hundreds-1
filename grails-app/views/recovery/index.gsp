x<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" lang="">
    <title><g:message code="recovery.password.label" /></title>
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

      <g:if test="${flash.message}">
        <div class="alert alert-info" style="display: block">${flash.message}</div>
      </g:if>

      <g:if test="${flash.error}">
        <div class="alert alert-danger" style="display: block">${flash.error}</div>
      </g:if>

      <div class="row">
        <div class="col-lg-12">
          <div class="page-header">
            <h1><g:message code="recovery.password.title" /></h1>
          </div>

          <p>
            <g:message code="recovery.password.intro" />
          </p>

          <g:form name="recovery" action="save" class="form-signin">
            <div class="form-group">
              <label for="email" class="sr-only">Email</label>
              <input type="email" class="form-control" name="email" placeholder="${message(code:'recovery.password.text.placeholder')}">
            </div>

            <button type="submit" class="btn btn-primary btn-block btn-lg"><g:message code="recovery.password.button.label" /></button>
          </g:form>
        </div>
      </div>

      <footer class="footer">
      </footer>
    </div>
  </body>
</html>
