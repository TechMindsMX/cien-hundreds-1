
<%@ page import="com.tim.hundreds.CompanyValidation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'companyValidation.label', default: 'CompanyValidation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-companyValidation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-companyValidation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="message" title="${message(code: 'companyValidation.message.label', default: 'Message')}" />
					
						<th><g:message code="companyValidation.company.label" default="Company" /></th>
					
						<g:sortableColumn property="type" title="${message(code: 'companyValidation.type.label', default: 'Type')}" />
					
						<th><g:message code="companyValidation.user.label" default="User" /></th>
					
						<g:sortableColumn property="uuid" title="${message(code: 'companyValidation.uuid.label', default: 'Uuid')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${companyValidationInstanceList}" status="i" var="companyValidationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${companyValidationInstance.id}">${fieldValue(bean: companyValidationInstance, field: "message")}</g:link></td>
					
						<td>${fieldValue(bean: companyValidationInstance, field: "company")}</td>
					
						<td>${fieldValue(bean: companyValidationInstance, field: "type")}</td>
					
						<td>${fieldValue(bean: companyValidationInstance, field: "user")}</td>
					
						<td>${fieldValue(bean: companyValidationInstance, field: "uuid")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${companyValidationInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
