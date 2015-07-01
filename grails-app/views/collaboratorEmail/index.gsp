
<%@ page import="com.tim.hundreds.CollaboratorEmail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'collaboratorEmail.label', default: 'CollaboratorEmail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-collaboratorEmail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-collaboratorEmail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="address" title="${message(code: 'collaboratorEmail.address.label', default: 'Address')}" />
						<th><g:message code="collaboratorEmail.collaborator.label" default="Collaborator" /></th>
						<g:sortableColumn property="type" title="${message(code: 'collaboratorEmail.type.label', default: 'Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${collaboratorEmailInstanceList}" status="i" var="collaboratorEmailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${collaboratorEmailInstance.id}">${fieldValue(bean: collaboratorEmailInstance, field: "address")}</g:link></td>
						<td>${collaboratorEmailInstance?.collaborator?.firstName} ${collaboratorEmailInstance?.collaborator?.lastName}</td>
						<td>${fieldValue(bean: collaboratorEmailInstance, field: "type")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${collaboratorEmailInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
