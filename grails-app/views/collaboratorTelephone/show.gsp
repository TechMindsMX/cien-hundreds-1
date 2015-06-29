
<%@ page import="com.tim.hundreds.CollaboratorTelephone" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'collaboratorTelephone.label', default: 'CollaboratorTelephone')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-collaboratorTelephone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-collaboratorTelephone" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list collaboratorTelephone">
			
				<g:if test="${collaboratorTelephoneInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="${session.labelWidth} property-label"><g:message code="collaboratorTelephone.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${collaboratorTelephoneInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${collaboratorTelephoneInstance?.collaborator}">
				<li class="fieldcontain">
					<span id="collaborator-label" class="${session.labelWidth} property-label"><g:message code="collaborator.label" default="Collaborator" /></span>
					
						<span class="property-value" aria-labelledby="collaborator-label"><g:link controller="collaborator" action="show" id="${collaboratorTelephoneInstance?.collaborator?.id}">${collaboratorTelephoneInstance?.collaborator?.firstName?.encodeAsHTML()} ${collaboratorTelephoneInstance?.collaborator?.lastName?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${collaboratorTelephoneInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="collaboratorTelephone.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${collaboratorTelephoneInstance}" field="type"/></span>
					
				</li>
				</g:if>
						
			</ul>
			<g:form url="[resource:collaboratorTelephoneInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${collaboratorTelephoneInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
