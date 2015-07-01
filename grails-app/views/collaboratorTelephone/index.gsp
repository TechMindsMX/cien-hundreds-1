
<%@ page import="com.tim.hundreds.CollaboratorTelephone" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'collaboratorTelephone.label', default: 'CollaboratorTelephone')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-collaboratorTelephone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-collaboratorTelephone" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="phone" title="${message(code: 'collaboratorTelephone.phone.label', default: 'Phone')}" />
						<th><g:message code="collaboratorTelephone.collaborator.label" default="Collaborator" /></th>
						<g:sortableColumn property="type" title="${message(code: 'collaboratorTelephone.type.label', default: 'Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${collaboratorTelephoneInstanceList}" status="i" var="collaboratorTelephoneInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${collaboratorTelephoneInstance.id}">${fieldValue(bean: collaboratorTelephoneInstance, field: "phone")}</g:link></td>
						<td>${collaboratorEmailInstance?.collaborator?.firstName} ${collaboratorEmailInstance?.collaborator?.lastName}</td>
						<td>${fieldValue(bean: collaboratorTelephoneInstance, field: "type")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${collaboratorTelephoneInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
