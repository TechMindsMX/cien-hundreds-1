
<%@ page import="com.tim.hundreds.MusicianValidation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musicianValidation.label', default: 'MusicianValidation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-musicianValidation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-musicianValidation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<table class="table table-stripped">
			<thead>
					<tr>
						<g:sortableColumn property="message" title="${message(code: 'musicianValidation.id.label', default: 'Id')}" />
					
						<g:sortableColumn property="message" title="${message(code: 'musicianValidation.message.label', default: 'Message')}" />
					
						<th><g:message code="musicianValidation.musician.label" default="Musician" /></th>
					
						<th><g:message code="musicianValidation.type.label" default="Type" /></th>
					
						<th><g:message code="musicianValidation.user.label" default="User" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${musicianValidationInstanceList}" status="i" var="musicianValidationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${musicianValidationInstance.id}">${fieldValue(bean: musicianValidationInstance, field: "id")}</g:link></td>
					
						<td>${fieldValue(bean: musicianValidationInstance, field: "message")}</td>

						<td>${musicianValidationInstance?.musician?.name?.encodeAsHTML()}</td>
					
						<td>${fieldValue(bean: musicianValidationInstance, field: "type")}</td>
					
						<td>${musicianValidationInstance?.user?.profile?.firstName?.encodeAsHTML()} ${musicianValidationInstance?.user?.profile?.lastName?.encodeAsHTML()}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${musicianValidationInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
