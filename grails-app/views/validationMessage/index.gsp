
<%@ page import="com.tim.hundreds.ValidationMessage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'validationMessage.label', default: 'ValidationMessage')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-validationMessage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-validationMessage" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="message" title="${message(code: 'validationMessage.message.label', default: 'Message')}" />
					
						<th><g:message code="validationMessage.musician.label" default="Musician" /></th>
					
						<th><g:message code="validationMessage.user.label" default="User" /></th>
					
						<g:sortableColumn property="uuid" title="${message(code: 'validationMessage.uuid.label', default: 'Uuid')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${validationMessageInstanceList}" status="i" var="validationMessageInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${validationMessageInstance.id}">${fieldValue(bean: validationMessageInstance, field: "message")}</g:link></td>
					
						<td>${fieldValue(bean: validationMessageInstance, field: "musician")}</td>
					
						<td>${fieldValue(bean: validationMessageInstance, field: "user")}</td>
					
						<td>${fieldValue(bean: validationMessageInstance, field: "uuid")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${validationMessageInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
