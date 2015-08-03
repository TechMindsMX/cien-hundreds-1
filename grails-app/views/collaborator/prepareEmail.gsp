<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'email.label', default: 'Email')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-prepareEmail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
			</ul>
		</div>
		<div id="create-prepareEmail" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:hasErrors bean="${collaboratorInstance}">
			<div class="alert alert-danger">
				<ul class="errors" role="alert">
					<g:eachError bean="${collaboratorInstance}" var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:eachError>
				</ul>
			</div>
			</g:hasErrors>
  			<g:form url="[controller:'collaborator', action:'saveEmail', params:[collaboratorUuid: collaboratorInstance.uuid, emailInstance: '${emailInstance}']]"  class="form-horizontal email-form">
				<fieldset class="form">
					<g:render template="/email/form"/>
				</fieldset>
				<fieldset class="buttons">
					<div class="${session.btnOffset}">
						<g:submitButton name="create" class="btn btn-success save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
						<button class="btn btn-danger" type="reset"><g:message code="cancel.label" /></button>
					</div>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
