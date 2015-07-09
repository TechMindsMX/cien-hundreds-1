<%@ page import="com.tim.hundreds.User" %>
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
				<sec:access expression="hasRole('ROLE_ADMIN')"><li><g:link action="admins"><g:message code="userManagement.adminList.label"/></g:link></li></sec:access>
				<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN"><li><g:link action="mucicianAdmins"><g:message code="userManagement.mucicianAdminsList.label"/></g:link></li></sec:ifAnyGranted>
				<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN"><li><g:link action="companyAdmins"><g:message code="userManagement.companyAdminsList.label"/></g:link></li></sec:ifAnyGranted>
				<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN"><li><g:link action="musicianViewers"><g:message code="userManagement.musicianViewersList.label"/></g:link></li></sec:ifAnyGranted>
				<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN"><li><g:link action="companyViewers"><g:message code="userManagement.companyViewersList.label"/></g:link></li></sec:ifAnyGranted>
				<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MUSICIAN_ADMIN"><li><g:link action="facilitator"><g:message code="userManagement.facilitatorList.label"/></g:link></li></sec:ifAnyGranted>
				<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN"><li><g:link action="buyer"><g:message code="userManagement.buyerList.label"/></g:link></li></sec:ifAnyGranted>
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
						<th>${message(code: 'user.place.label', default: 'Foto')}</th>
						<g:sortableColumn property="profile.firstName" title="${message(code: 'user.name.label', default: 'Nombre completo')}" />
						<th>${message(code: 'user.place.label', default: 'rol')}</th>
						<g:sortableColumn property="profile.firstName" title="${message(code: 'user.date.label', default: 'Correos electrónicos')}" />
						<th>${message(code: 'user.date.label', default: 'Teléfonos')}</th>
						<th>${message(code: 'user.date.label', default: 'Estatus')}</th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><img class="img-responsive max300" src="${grailsApplication.config.base.photo.url}${userInstance.profile?.photoPath}" /></td>
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