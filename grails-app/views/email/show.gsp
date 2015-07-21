
<%@ page import="com.tim.hundreds.Email" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'email.label', default: 'Email')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-email" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-email" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list email">
			
				<g:if test="${emailInstance?.mail}">
				<li class="fieldcontain">
					<span id="address-label" class="${session.labelWidth} property-label"><g:message code="email.address.label" default="Address" /></span>
					<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${emailInstance}" field="mail"/></span>
				</li>
				</g:if>
			
				<g:if test="${emailInstance?.emailType}">
				<li class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="email.type.label" default="Type" /></span>
					<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${emailInstance}" field="email.type"/></span>
				</li>
				</g:if>
				
				<g:if test="${emailInstance?.contact}">
				<li class="fieldcontain">
					<span id="contact-label" class="${session.labelWidth} property-label"><g:message code="email.contact.label" default="Contact" /></span>
					<span class="property-value" aria-labelledby="contact-label"><g:link controller="contact" action="show" id="${emailInstance?.contact?.id}">${emailInstance?.contact?.firstName?.encodeAsHTML()} ${emailInstance?.contact?.lastName?.encodeAsHTML()}</g:link></span>
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:emailInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${emailInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
