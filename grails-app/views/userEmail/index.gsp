
<%@ page import="com.tim.hundreds.UserEmail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userEmail.label', default: 'UserEmail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-userEmail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-userEmail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="address" title="${message(code: 'userEmail.address.label', default: 'Address')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'userEmail.type.label', default: 'Type')}" />
					
						<th><g:message code="userEmail.user.label" default="User" /></th>
					
						<g:sortableColumn property="uuid" title="${message(code: 'userEmail.uuid.label', default: 'Uuid')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userEmailInstanceList}" status="i" var="userEmailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userEmailInstance.id}">${fieldValue(bean: userEmailInstance, field: "address")}</g:link></td>
					
						<td>${fieldValue(bean: userEmailInstance, field: "type")}</td>
					
						<td>${fieldValue(bean: userEmailInstance, field: "user")}</td>
					
						<td>${fieldValue(bean: userEmailInstance, field: "uuid")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userEmailInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
