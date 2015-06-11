
<%@ page import="com.tim.hundreds.Suggestion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'suggestion.label', default: 'Suggestion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-suggestion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-suggestion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'suggestion.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="contactName" title="${message(code: 'suggestion.contactName.label', default: 'Contact Name')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'suggestion.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="phone" title="${message(code: 'suggestion.phone.label', default: 'Phone')}" />
					
						<th><g:message code="suggestion.musician.label" default="Musician" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${suggestionInstanceList}" status="i" var="suggestionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${suggestionInstance.id}">${fieldValue(bean: suggestionInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: suggestionInstance, field: "contactName")}</td>
					
						<td>${fieldValue(bean: suggestionInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: suggestionInstance, field: "phone")}</td>
					
						<td>${fieldValue(bean: suggestionInstance, field: "musician")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${suggestionInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
