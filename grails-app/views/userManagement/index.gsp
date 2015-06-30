<%@ page import="com.tim.hundreds.User" %>
<%@ page import="com.tim.hundreds.ApplicationState" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userManagement.label', default: 'userManagement')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
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
						<g:sortableColumn property="place" title="${message(code: 'user.place.label', default: 'Foto')}" />
						<g:sortableColumn property="place" title="${message(code: 'user.place.label', default: 'Nombre completo')}" />
						<g:sortableColumn property="place" title="${message(code: 'user.place.label', default: 'rol')}" />
						<g:sortableColumn property="date" title="${message(code: 'user.date.label', default: 'Correos electrónicos')}" />
						<g:sortableColumn property="date" title="${message(code: 'user.date.label', default: 'Teléfonos')}" />
						<g:sortableColumn property="date" title="${message(code: 'user.date.label', default: 'Estatus')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><img class="img-responsive max300" src="${ApplicationState.PHOTO_URL_BASE}${userInstance.profile?.photoPath}" /></td>
						<td>${fieldValue(bean: userInstance, field: "profile.firstName")} ${fieldValue(bean: userInstance, field: "profile.lastName")}</td>
						<td>${userInstance.getAuthorities().authority}</td>
						<td>${fieldValue(bean: userInstance, field: "profile.email")}</td>
						<td>${fieldValue(bean: userInstance, field: "profile.phone")}</td>
						<td>
							<g:if test="${userInstance.accountExpired}"><g:message code="general.disabled.label" /></g:if>
							<g:else><g:message code="general.enabled.label"/></g:else>
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