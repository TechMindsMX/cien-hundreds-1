
<%@ page import="com.tim.hundreds.MusicianComment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musicianComment.label', default: 'MusicianComment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-musicianComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-musicianComment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="general" title="${message(code: 'musicianComment.general.label', default: 'General')}" />
					
						<g:sortableColumn property="history" title="${message(code: 'musicianComment.history.label', default: 'History')}" />
					
						<g:sortableColumn property="datosFiscales" title="${message(code: 'musicianComment.datosFiscales.label', default: 'Datos Fiscales')}" />
					
						<g:sortableColumn property="activities" title="${message(code: 'musicianComment.activities.label', default: 'Activities')}" />
					
						<g:sortableColumn property="medias" title="${message(code: 'musicianComment.medias.label', default: 'Medias')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'musicianComment.notes.label', default: 'Notes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${musicianCommentInstanceList}" status="i" var="musicianCommentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${musicianCommentInstance.id}">${fieldValue(bean: musicianCommentInstance, field: "general")}</g:link></td>
					
						<td>${fieldValue(bean: musicianCommentInstance, field: "history")}</td>
					
						<td>${fieldValue(bean: musicianCommentInstance, field: "datosFiscales")}</td>
					
						<td>${fieldValue(bean: musicianCommentInstance, field: "activities")}</td>
					
						<td>${fieldValue(bean: musicianCommentInstance, field: "medias")}</td>
					
						<td>${fieldValue(bean: musicianCommentInstance, field: "notes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${musicianCommentInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
