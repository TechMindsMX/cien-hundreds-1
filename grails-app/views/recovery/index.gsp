<!DOCTYPE html>
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

        <g:renderErrors />

        <p>
          <g:message code="recovery.password.intro" />
        </p>

        <g:form name="recovery" action="save" class="form-signin form-horizontal">
        <div class="form-group">
          <label class="${session.labelWidth} control-label" for="email"><g:message code="email.label" /></label>
          <div class="${session.inputWidth}">
            <input type="email" class="form-control" name="email" placeholder="${message(code:'recovery.password.text.placeholder')}">
          </div>

        </div>

        <button type="submit" class="btn btn-primary"><g:message code="recovery.password.button.label" /></button>
        <button type="reset" class="btn btn-danger"><g:message code="cancel.label" /></button>
      </g:form>
    </div>
  </div>
</div>
</body>
</html>
