
<%@ page import="com.tim.hundreds.UserTelephone" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userTelephone.label', default: 'UserTelephone')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-userTelephone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-userTelephone" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list userTelephone">
			
				<g:if test="${userTelephoneInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="${session.labelWidth} property-label"><g:message code="userTelephone.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${userTelephoneInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userTelephoneInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="userTelephone.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${userTelephoneInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userTelephoneInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="${session.labelWidth} property-label"><g:message code="userTelephone.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${userTelephoneInstance?.user?.id}">${userTelephoneInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${userTelephoneInstance?.uuid}">
				<li class="fieldcontain">
					<span id="uuid-label" class="${session.labelWidth} property-label"><g:message code="userTelephone.uuid.label" default="Uuid" /></span>
					
						<span class="property-value" aria-labelledby="uuid-label"><g:fieldValue bean="${userTelephoneInstance}" field="uuid"/></span>
					
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:userTelephoneInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${userTelephoneInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
