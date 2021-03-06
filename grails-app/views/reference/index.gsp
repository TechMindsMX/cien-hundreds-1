
<%@ page import="com.tim.hundreds.Reference" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reference.label', default: 'Reference')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-reference" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-reference" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'reference.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="contactName" title="${message(code: 'reference.contactName.label', default: 'Contact Name')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'reference.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="phone" title="${message(code: 'reference.phone.label', default: 'Phone')}" />
					
						<th><g:message code="reference.company.label" default="Company" /></th>
					
						<th><g:message code="reference.type.label" default="Type" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${referenceInstanceList}" status="i" var="referenceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" params="['uuid': referenceInstance.uuid]">${fieldValue(bean: referenceInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: referenceInstance, field: "contactName")}</td>
					
						<td>${fieldValue(bean: referenceInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: referenceInstance, field: "phone")}</td>
					
						<td>${fieldValue(bean: referenceInstance, field: "company")}</td>
					
						<td>${fieldValue(bean: referenceInstance, field: "type")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${referenceInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
