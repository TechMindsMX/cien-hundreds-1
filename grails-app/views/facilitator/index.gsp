
<%@ page import="com.tim.hundreds.Facilitator" %>
<!DOCTYPE html>

<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'email.label', default: 'Facilitator')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-email" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-email" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="lastName" title="${message(code: 'model.lastName.label', default: 'Apellido')}" />
					
						<g:sortableColumn property="firstName" title="${message(code: 'model.firstName.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'model.middleName.label', default: 'Correo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${modelList}" status="i" var="model">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${model.lastName}">${fieldValue(bean: model, field: "lastName")}</g:link></td>
					
						<td>${fieldValue(bean: model, field: "firstName")}</td>
					
						<td>${fieldValue(bean: model, field: "email")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${modelCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
