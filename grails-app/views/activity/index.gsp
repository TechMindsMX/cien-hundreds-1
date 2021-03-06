
<%@ page import="com.tim.hundreds.Activity" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'activity.label', default: 'Activity')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-activity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-activity" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="activity" title="${message(code: 'activity.label', default: 'Activity')}" />
					
						<g:sortableColumn property="place" title="${message(code: 'place.label', default: 'Place')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'date.label', default: 'Date')}" />
					
						<g:sortableColumn property="musician" title="${message(code: 'musician.label', default: 'Musician')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${activityInstanceList}" status="i" var="activityInstance">

					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${activityInstance.id}">${fieldValue(bean: activityInstance, field: "activity")}</g:link></td>
					
						<td>${fieldValue(bean: activityInstance, field: "place")}</td>
					
						<td><g:formatDate format="dd-MM-yyyy"  date="${activityInstance.date}" /></td>
					
						<td>${fieldValue(bean: activityInstance, field: "musician.name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${activityInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
