<%@ page import="com.tim.hundreds.CompanyComment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'companyComment.label', default: 'CompanyComment')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-companyComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-companyComment" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${companyCommentInstance}">
			<div class="alert alert-danger">
				<ul class="errors" role="alert">
					<g:eachError bean="${companyCommentInstance}" var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:eachError>
				</ul>
			</div>
			</g:hasErrors>
			<g:form url="[resource:companyCommentInstance, action:'update']" method="PUT"  class="form-horizontal">
				<g:hiddenField name="version" value="${companyCommentInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<div class="">
						<g:actionSubmit class="btn btn-primary save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
						<button class="btn btn-danger" type="reset"><g:message code="cancel.label" /></button>
					</div>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
