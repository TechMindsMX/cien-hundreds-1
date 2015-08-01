<%@ page import="com.tim.hundreds.Complement" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'complement.label', default: 'Complement')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-complement" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="edit-complement" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:hasErrors bean="${complementInstance}">
			<div class="alert alert-danger">
				<ul class="errors" role="alert">
					<g:eachError bean="${complementInstance}" var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:eachError>
				</ul>
			</div>
			</g:hasErrors>

			<g:form url="[resource:complementInstance, action:'update']" method="PUT"  class="form-horizontal" id="complement-edit">
				<g:hiddenField name="version" value="${complementInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<div class="${session.btnOffset}">
						<g:actionSubmit class="btn btn-primary save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
						<button class="btn btn-danger" type="reset"><g:message code="cancel.label" /></button>
					</div>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
