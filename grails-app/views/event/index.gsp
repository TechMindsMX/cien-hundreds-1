
<%@ page import="com.tim.hundreds.Event" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-event" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-event" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="activity" title="${message(code: 'event.activity.label', default: 'Activity')}" />
					
						<g:sortableColumn property="place" title="${message(code: 'event.place.label', default: 'Place')}" />
					
						<th><g:message code="event.company.label" default="Company" /></th>
					
						<g:sortableColumn property="date" title="${message(code: 'event.date.label', default: 'Date')}" />
										
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventInstanceList}" status="i" var="eventInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" params="['uuid': eventInstance.uuid]">${fieldValue(bean: eventInstance, field: "activity")}</g:link></td>
					
						<td>${fieldValue(bean: eventInstance, field: "place")}</td>
					
						<td>${fieldValue(bean: eventInstance, field: "company")}</td>
					
						<td><g:formatDate date="${eventInstance.date}" /></td>
										
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
