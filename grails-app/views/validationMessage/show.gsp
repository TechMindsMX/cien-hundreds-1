
<%@ page import="com.tim.hundreds.ValidationMessage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'validationMessage.label', default: 'ValidationMessage')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-validationMessage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-validationMessage" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list validationMessage">
			
				<g:if test="${validationMessageInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="${session.labelWidth} property-label"><g:message code="validationMessage.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${validationMessageInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${validationMessageInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="validationMessage.musician.label" default="Musician" /></span>
					
						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" id="${validationMessageInstance?.musician?.id}">${validationMessageInstance?.musician?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${validationMessageInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="${session.labelWidth} property-label"><g:message code="validationMessage.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${validationMessageInstance?.user?.id}">${validationMessageInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${validationMessageInstance?.uuid}">
				<li class="fieldcontain">
					<span id="uuid-label" class="${session.labelWidth} property-label"><g:message code="validationMessage.uuid.label" default="Uuid" /></span>
					
						<span class="property-value" aria-labelledby="uuid-label"><g:fieldValue bean="${validationMessageInstance}" field="uuid"/></span>
					
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:validationMessageInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${validationMessageInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
