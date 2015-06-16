
<%@ page import="com.tim.hundreds.Telephone" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'telephone.label', default: 'Telephone')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-telephone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-telephone" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="phone" title="${message(code: 'telephone.phone.label', default: 'Phone')}" />
					
						<th><g:message code="telephone.contact.label" default="Contact" /></th>
					
						<g:sortableColumn property="type" title="${message(code: 'telephone.type.label', default: 'Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${telephoneInstanceList}" status="i" var="telephoneInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${telephoneInstance.id}">${fieldValue(bean: telephoneInstance, field: "phone")}</g:link></td>
					
						<td>${fieldValue(bean: telephoneInstance, field: "contact.firstName")} ${fieldValue(bean: telephoneInstance, field: "contact.lastName")}</td>
					
						<td>${fieldValue(bean: telephoneInstance, field: "type")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${telephoneInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
