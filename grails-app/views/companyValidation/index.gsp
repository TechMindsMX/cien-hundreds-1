
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
					
						<g:sortableColumn property="message" title="${message(code: 'companyValidation.id.label', default: 'id')}" />

						<th><g:message code="companyValidation.message.label" default="Message" /></th>
					
						<th><g:message code="companyValidation.company.label" default="Company" /></th>
					
						<th><g:message code="companyValidation.type.label" default="Type" /></th>
					
						<th><g:message code="companyValidation.user.label" default="User" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${companyValidationInstanceList}" status="i" var="companyValidationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${companyValidationInstance.id}">${fieldValue(bean: companyValidationInstance, field: "id")}</g:link></td>

						<td>${fieldValue(bean: companyValidationInstance, field: "message")}</td>
					
						<td>${companyValidationInstance?.company?.name?.encodeAsHTML()}</td>
					
						<td>${fieldValue(bean: companyValidationInstance, field: "type")}</td>
					
						<td>${companyValidationInstance?.user?.profile?.firstName?.encodeAsHTML()} ${companyValidationInstance?.user?.profile?.lastName?.encodeAsHTML()}</td>
					
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
