
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
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-suggestion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list suggestion">
			
				<g:if test="${suggestionInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="${session.labelWidth} property-label"><g:message code="suggestion.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${suggestionInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${suggestionInstance?.contactName}">
				<li class="fieldcontain">
					<span id="contactName-label" class="${session.labelWidth} property-label"><g:message code="suggestion.contactName.label" default="Contact Name" /></span>
					
						<span class="property-value" aria-labelledby="contactName-label"><g:fieldValue bean="${suggestionInstance}" field="contactName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${suggestionInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="${session.labelWidth} property-label"><g:message code="suggestion.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${suggestionInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${suggestionInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="${session.labelWidth} property-label"><g:message code="suggestion.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${suggestionInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${suggestionInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="suggestion.musician.label" default="Musician" /></span>
					
						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" id="${suggestionInstance?.musician?.id}">${suggestionInstance?.musician?.name?.encodeAsHTML()}</g:link></span>
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:suggestionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<div class="form-actions">
						<g:link class="btn btn-primary edit" action="edit" resource="${suggestionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
						<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</div>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
