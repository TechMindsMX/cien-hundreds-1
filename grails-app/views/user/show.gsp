
<%@ page import="com.tim.hundreds.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'user')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list user">
			
			<g:if test="${userInstance?.profile?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="${session.labelWidth} property-label"><g:message code="firstName.label" default="firstName" /></span>
					<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${userInstance}" field="profile.firstName"/></span>
				</li>
			</g:if>
			
			<g:if test="${userInstance?.profile?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="${session.labelWidth} property-label"><g:message code="lastName.label" default="lastName" /></span>
					<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${userInstance}" field="profile.lastName"/></span>
				</li>
			</g:if>

			<g:if test="${userInstance?.profile?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="${session.labelWidth} property-label"><g:message code="email.label" default="email" /></span>
					<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${userInstance}" field="profile.email"/></span>
				</li>
			</g:if>

			<g:if test="${userInstance?.profile?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="${session.labelWidth} property-label"><g:message code="phone.label" default="phone" /></span>
					<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${userInstance}" field="profile.phone"/></span>
				</li>
			</g:if>

			<g:if test="${userInstance?.profile?.photoPath}">
				<li class="fieldcontain">
					<span id="photoPath-label" class="${session.labelWidth} property-label"><g:message code="user.photoPath.label" default="photoPath" /></span>
					<img class="img-responsive max300" src="${grailsApplication.config.photo.url.base}${userInstance.profile.photosPath}" />
				</li>
			</g:if>

			<g:if test="${userInstance?.profile?.resumePath}">
				<li class="fieldcontain">
					<span id="resumePath-label" class="${session.labelWidth} property-label"><g:message code="user.resumePath.label" default="resumePath" /></span>
					<span class="property-value" aria-labelledby="resumePath-label"><g:fieldValue bean="${userInstance}" field="profile.resumePath"/></span>
				</li>
			</g:if>

			<li class="fieldcontain">
				<span id="accountExpired-label" class="${session.labelWidth} property-label"><g:message code="user.status.isBlocked.label" default="accountExpired" /></span>
				<span class="property-value" aria-labelledby="accountExpired-label"><g:message code="default.boolean.${userInstance.accountExpired}"/></span>
			</li>
			
			</ul>
			<g:form url="[resource:userInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edi disabled" action="edit" resource="${userInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
