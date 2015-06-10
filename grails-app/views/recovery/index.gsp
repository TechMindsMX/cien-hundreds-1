x<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <title><g:message code="recovery.password.label" /></title>
  </head>
  <body>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12 col-lg-9">
          <div class="page-header">
            <h1><g:message code="recovery.password.title" /></h1>
          </div>

          <p>
            <g:message code="recovery.password.intro" />
          </p>

          <g:form name="recovery" action="save" class="form-signin">
            <div class="form-group">
              <label for="email">Correo electrónico</label>
              <input type="email" class="form-control" name="email" placeholder="${message(code:'recovery.password.text.placeholder')}">
            </div>

            <button type="submit" class="btn btn-primary"><g:message code="recovery.password.button.label" /></button>
            <button type="reset" class="btn btn-danger"><g:message code="cancel.label" /></button>
          </g:form>
        </div>
      </div>
    </div>
  </body>
</html>
