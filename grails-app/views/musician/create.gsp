<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musician.label', default: 'Musician')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-musician" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-musician" class="content scaffold-create" role="main">
			<h1 class="text-head-color">Formulario de Músico</h1>
			<g:if test="${flash.message}">
				<div class="alert alert-info message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${musicianInstance}">
			<ul class="alert alert-danger errors" role="alert">
				<g:eachError bean="${musicianInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</div>
		</g:hasErrors>
			<g:uploadForm url="[resource:musicianInstance, action:'save']" class="form-horizontal">
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>

				<div class="${session.btnOffset} fieldcontain ${hasErrors(bean: musicianInstance, field: 'logo', 'error')} ">
				  <label for="buttons">
				  </label>
				   <g:submitButton name="create" class="btn btn-success" value="${message(code: 'default.button.create.label', default: 'Create')}" />
					<button class="btn btn-danger" type="reset"><g:message code="cancel.label" /></button>
				</div>

			</g:uploadForm>
		</div>
	</body>
</html>
