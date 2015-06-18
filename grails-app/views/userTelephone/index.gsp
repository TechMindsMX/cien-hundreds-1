
<%@ page import="com.tim.hundreds.UserTelephone" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userTelephone.label', default: 'UserTelephone')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-userTelephone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-userTelephone" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="phone" title="${message(code: 'userTelephone.phone.label', default: 'Phone')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'userTelephone.type.label', default: 'Type')}" />
					
						<th><g:message code="userTelephone.user.label" default="User" /></th>
					
						<g:sortableColumn property="uuid" title="${message(code: 'userTelephone.uuid.label', default: 'Uuid')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userTelephoneInstanceList}" status="i" var="userTelephoneInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userTelephoneInstance.id}">${fieldValue(bean: userTelephoneInstance, field: "phone")}</g:link></td>
					
						<td>${fieldValue(bean: userTelephoneInstance, field: "type")}</td>
					
						<td>${fieldValue(bean: userTelephoneInstance, field: "user")}</td>
					
						<td>${fieldValue(bean: userTelephoneInstance, field: "uuid")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userTelephoneInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
