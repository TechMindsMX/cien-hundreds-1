
<%@ page import="com.tim.hundreds.Collaborator" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'collaborator.label', default: 'Collaborator')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-collaborator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-collaborator" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="firstName" title="${message(code: 'collaborator.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="middleName" title="${message(code: 'collaborator.middleName.label', default: 'Middle Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'collaborator.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="position" title="${message(code: 'collaborator.position.label', default: 'Position')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'collaborator.notes.label', default: 'Notes')}" />
					
						<th><g:message code="collaborator.company.label" default="Company" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${collaboratorInstanceList}" status="i" var="collaboratorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${collaboratorInstance.id}">${fieldValue(bean: collaboratorInstance, field: "firstName")}</g:link></td>
					
						<td>${fieldValue(bean: collaboratorInstance, field: "middleName")}</td>
					
						<td>${fieldValue(bean: collaboratorInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: collaboratorInstance, field: "position")}</td>
					
						<td>${fieldValue(bean: collaboratorInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: collaboratorInstance, field: "company")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${collaboratorInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
