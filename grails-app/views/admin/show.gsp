
<%@ page import="com.tim.hundreds.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list user">

				<g:if test="${userInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="${session.labelWidth} property-label"><g:message code="user.username.label" default="Username" /></span>

						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userInstance}" field="username"/></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="${session.labelWidth} property-label"><g:message code="user.password.label" default="Password" /></span>

						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}" field="password"/></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="${session.labelWidth} property-label"><g:message code="user.accountExpired.label" default="Account Expired" /></span>

						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${userInstance?.accountExpired}" /></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="${session.labelWidth} property-label"><g:message code="user.accountLocked.label" default="Account Locked" /></span>

						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${userInstance?.accountLocked}" /></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.companies}">
				<li class="fieldcontain">
					<span id="companies-label" class="${session.labelWidth} property-label"><g:message code="user.companies.label" default="Companies" /></span>

						<g:each in="${userInstance.companies}" var="c">
						<span class="property-value" aria-labelledby="companies-label"><g:link controller="company" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${userInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="${session.labelWidth} property-label"><g:message code="user.enabled.label" default="Enabled" /></span>

						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${userInstance?.enabled}" /></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.musicians}">
				<li class="fieldcontain">
					<span id="musicians-label" class="${session.labelWidth} property-label"><g:message code="user.musicians.label" default="Musicians" /></span>

						<g:each in="${userInstance.musicians}" var="m">
						<span class="property-value" aria-labelledby="musicians-label"><g:link controller="musician" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${userInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="${session.labelWidth} property-label"><g:message code="user.passwordExpired.label" default="Password Expired" /></span>

						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${userInstance?.passwordExpired}" /></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.profile}">
				<li class="fieldcontain">
					<span id="profile-label" class="${session.labelWidth} property-label"><g:message code="user.profile.label" default="Profile" /></span>

						<span class="property-value" aria-labelledby="profile-label"><g:link controller="profile" action="show" id="${userInstance?.profile?.id}">${userInstance?.profile?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.userEmails}">
				<li class="fieldcontain">
					<span id="userEmails-label" class="${session.labelWidth} property-label"><g:message code="user.userEmails.label" default="User Emails" /></span>

						<g:each in="${userInstance.userEmails}" var="u">
						<span class="property-value" aria-labelledby="userEmails-label"><g:link controller="userEmail" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${userInstance?.userTelephone}">
				<li class="fieldcontain">
					<span id="userTelephone-label" class="${session.labelWidth} property-label"><g:message code="user.userTelephone.label" default="User Telephone" /></span>

						<g:each in="${userInstance.userTelephone}" var="u">
						<span class="property-value" aria-labelledby="userTelephone-label"><g:link controller="userTelephone" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${userInstance?.uuid}">
				<li class="fieldcontain">
					<span id="uuid-label" class="${session.labelWidth} property-label"><g:message code="user.uuid.label" default="Uuid" /></span>

						<span class="property-value" aria-labelledby="uuid-label"><g:fieldValue bean="${userInstance}" field="uuid"/></span>

				</li>
				</g:if>

			</ul>
			<g:form url="[resource:userInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${userInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
