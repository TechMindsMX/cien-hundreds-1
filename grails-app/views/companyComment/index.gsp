
<%@ page import="com.tim.hundreds.CompanyComment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'companyComment.label', default: 'CompanyComment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-companyComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-companyComment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="general" title="${message(code: 'companyComment.general.label', default: 'General')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'companyComment.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="datosFiscales" title="${message(code: 'companyComment.datosFiscales.label', default: 'Datos Fiscales')}" />
					
						<g:sortableColumn property="events" title="${message(code: 'companyComment.events.label', default: 'Events')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'companyComment.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="refs" title="${message(code: 'companyComment.refs.label', default: 'refs')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${companyCommentInstanceList}" status="i" var="companyCommentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${companyCommentInstance.id}">${fieldValue(bean: companyCommentInstance, field: "general")}</g:link></td>
					
						<td>${fieldValue(bean: companyCommentInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: companyCommentInstance, field: "datosFiscales")}</td>
					
						<td>${fieldValue(bean: companyCommentInstance, field: "events")}</td>
					
						<td>${fieldValue(bean: companyCommentInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: companyCommentInstance, field: "refs")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${companyCommentInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
