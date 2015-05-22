
<%@ page import="com.tim.hundreds.Suggestion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'suggestion.label', default: 'Suggestion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-suggestion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-suggestion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list suggestion">
			
				<g:if test="${suggestionInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="suggestion.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${suggestionInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${suggestionInstance?.contactName}">
				<li class="fieldcontain">
					<span id="contactName-label" class="property-label"><g:message code="suggestion.contactName.label" default="Contact Name" /></span>
					
						<span class="property-value" aria-labelledby="contactName-label"><g:fieldValue bean="${suggestionInstance}" field="contactName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${suggestionInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="suggestion.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${suggestionInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${suggestionInstance?.telephone}">
				<li class="fieldcontain">
					<span id="telephone-label" class="property-label"><g:message code="suggestion.telephone.label" default="Telephone" /></span>
					
						<span class="property-value" aria-labelledby="telephone-label"><g:link controller="telephone" action="show" id="${suggestionInstance?.telephone?.id}">${suggestionInstance?.telephone?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:suggestionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${suggestionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
