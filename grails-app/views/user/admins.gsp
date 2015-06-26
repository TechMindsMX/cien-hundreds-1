<%@ page import="com.tim.hundreds.User" %>
<%@ page import="com.tim.hundreds.ApplicationState" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-user" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
						<th>${message(code: 'user.photo.label', default: 'Foto')}</th>
						<g:sortableColumn property="name" title="${message(code: 'user.name.label', default: 'Name')}" />
						<g:sortableColumn property="role" title="${message(code: 'user.role.label', default: 'Rol')}" />
						<g:sortableColumn property="userEmails" title="${message(code: 'user.userEmails.label', default: 'Correos electrónicos')}" />
						<g:sortableColumn property="userTelephone" title="${message(code: 'user.userTelephone.label', default: 'Telefonos')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
 							<g:if test="${!userInstance?.profile?.photoPath}">
								<img class="img-responsive max300" src="${ApplicationState.PHOTO_URL_BASE}${userInstance.profile.photoPath}" />
							</g:if>
						</td>
						<td><g:link action="show" id="${userInstance.id}">
							<g:if test="${userInstance?.profile?.firstName}">
	 						${userInstance?.profile?.firstName?.encodeAsHTML()}
	 						</g:if> 
							<g:if test="${userInstance?.profile?.lastName}">
	 						${userInstance?.profile?.lastName?.encodeAsHTML()}
	 						</g:if>
 						</g:link></td>
						<td>${userInstance?.profile?.role?.encodeAsHtml()}</td>
						<td>
							<g:if test="${!userInstance?.userEmails.isEmpty()}">
							<g:each in="${userInstance?.userEmails}" var="e"><p>${e.address?.encodeAsHtml()}</p></g:each>
							</g:if>
						</td>
						<td>
							<g:if test="${!userInstance?.userTelephone.isEmpty()}">
							<g:each in="${userInstance?.userTelephone}" var="t"><p>${t.phone?.encodeAsHtml()}</p></g:each>
							</g:if>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
