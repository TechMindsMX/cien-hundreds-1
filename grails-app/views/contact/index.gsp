
<%@ page import="com.tim.hundreds.Contact" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-contact" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-contact" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="firstName" title="${message(code: 'contact.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="motherLastName" title="${message(code: 'contact.motherLastName.label', default: 'Middle Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'contact.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="other" title="${message(code: 'contact.other.label', default: 'Other')}" />
					
						<g:sortableColumn property="nationality" title="${message(code: 'contact.nationality.label', default: 'Nationality')}" />
					
						<g:sortableColumn property="biography" title="${message(code: 'contact.biography.label', default: 'Biography')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${contactInstanceList}" status="i" var="contactInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${contactInstance.id}">${fieldValue(bean: contactInstance, field: "firstName")}</g:link></td>
					
						<td>${fieldValue(bean: contactInstance, field: "motherLastName")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "other")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "nationality")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "biography")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${contactInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
