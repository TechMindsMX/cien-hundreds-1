
<%@ page import="com.tim.hundreds.UserEmail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userEmail.label', default: 'UserEmail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-userEmail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-userEmail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list userEmail">
			
				<g:if test="${userEmailInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="${session.labelWidth} property-label"><g:message code="userEmail.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${userEmailInstance}" field="address"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userEmailInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="userEmail.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${userEmailInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userEmailInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="${session.labelWidth} property-label"><g:message code="userEmail.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${userEmailInstance?.user?.id}">${userEmailInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${userEmailInstance?.uuid}">
				<li class="fieldcontain">
					<span id="uuid-label" class="${session.labelWidth} property-label"><g:message code="userEmail.uuid.label" default="Uuid" /></span>
					
						<span class="property-value" aria-labelledby="uuid-label"><g:fieldValue bean="${userEmailInstance}" field="uuid"/></span>
					
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:userEmailInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${userEmailInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
