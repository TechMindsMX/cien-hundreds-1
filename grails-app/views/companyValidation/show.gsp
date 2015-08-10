
<%@ page import="com.tim.hundreds.CompanyValidation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'companyValidation.label', default: 'CompanyValidation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-companyValidation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-companyValidation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list companyValidation">

				<g:if test="${companyValidationInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="${session.labelWidth} property-label"><g:message code="companyValidation.message.label" default="Message" /></span>

						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${companyValidationInstance}" field="message"/></span>

				</li>
				</g:if>

				<g:if test="${companyValidationInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="${session.labelWidth} property-label"><g:message code="companyValidation.company.label" default="Company" /></span>

						<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" params="['uuid' : companyValidationInstance?.company?.uuid]">${companyValidationInstance?.company?.name?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${companyValidationInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="companyValidation.type.label" default="Type" /></span>

						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${companyValidationInstance}" field="type"/></span>

				</li>
				</g:if>

				<g:if test="${companyValidationInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="${session.labelWidth} property-label"><g:message code="companyValidation.user.label" default="User" /></span>

						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${companyValidationInstance?.user?.id}">${companyValidationInstance?.user?.profile?.firstName?.encodeAsHTML()} ${companyValidationInstance?.user?.profile?.lastName?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>


			</ul>
			<g:form url="[resource:companyValidationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${companyValidationInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
