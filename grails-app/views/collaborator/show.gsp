
<%@ page import="com.tim.hundreds.Collaborator" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'collaborator.label', default: 'Collaborator')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-collaborator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-collaborator" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list collaborator">

				<g:if test="${collaboratorInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="${session.labelWidth} property-label"><g:message code="collaborator.firstName.label" default="First Name" /></span>

						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${collaboratorInstance}" field="firstName"/></span>

				</li>
				</g:if>

				<g:if test="${collaboratorInstance?.middleName}">
				<li class="fieldcontain">
					<span id="middleName-label" class="${session.labelWidth} property-label"><g:message code="collaborator.middleName.label" default="Middle Name" /></span>

						<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${collaboratorInstance}" field="middleName"/></span>

				</li>
				</g:if>

				<g:if test="${collaboratorInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="${session.labelWidth} property-label"><g:message code="collaborator.lastName.label" default="Last Name" /></span>

						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${collaboratorInstance}" field="lastName"/></span>

				</li>
				</g:if>

				<g:if test="${collaboratorInstance?.position}">
				<li class="fieldcontain">
					<span id="position-label" class="${session.labelWidth} property-label"><g:message code="collaborator.position.label" default="Position" /></span>

						<span class="property-value" aria-labelledby="position-label"><g:fieldValue bean="${collaboratorInstance}" field="position"/></span>

				</li>
				</g:if>

				<g:if test="${collaboratorInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="${session.labelWidth} property-label"><g:message code="collaborator.notes.label" default="Notes" /></span>

						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${collaboratorInstance}" field="notes"/></span>

				</li>
				</g:if>

				<g:if test="${collaboratorInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="${session.labelWidth} property-label"><g:message code="collaborator.company.label" default="Company" /></span>

						<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" id="${collaboratorInstance?.company?.id}">${collaboratorInstance?.company?.name.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${collaboratorInstance?.emails}">
				<li class="fieldcontain">
					<span id="emails-label" class="${session.labelWidth} property-label"><g:message code="collaborator.emails.label" default="Emails" /></span>

						<g:each in="${collaboratorInstance.emails}" var="e">
						<span class="property-value" aria-labelledby="emails-label"><g:link controller="email" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${collaboratorInstance?.telephones}">
				<li class="fieldcontain">
					<span id="telephones-label" class="${session.labelWidth} property-label"><g:message code="collaborator.telephones.label" default="Telephones" /></span>

						<g:each in="${collaboratorInstance.telephones}" var="t">
						<span class="property-value" aria-labelledby="telephones-label"><g:link controller="telephone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

        <g:link controller="collaborator" action="prepareEmailForCollaborator" params="[collaboratorUuid: collaboratorInstance?.uuid]">${message(code: 'default.add.label', args: [message(code: 'email.label')])}</g:link>

			</ul>
			<g:form url="[resource:collaboratorInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${collaboratorInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
