
<%@ page import="com.tim.hundreds.Social" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'social.label', default: 'Social')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-social" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-social" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="facebook" title="${message(code: 'social.facebook.label', default: 'Facebook')}" />
					
						<g:sortableColumn property="twitter" title="${message(code: 'social.twitter.label', default: 'Twitter')}" />
					
						<g:sortableColumn property="googlePlus" title="${message(code: 'social.googlePlus.label', default: 'Google Plus')}" />
					
						<g:sortableColumn property="instagram" title="${message(code: 'social.instagram.label', default: 'Instagram')}" />
					
						<g:sortableColumn property="youtube" title="${message(code: 'social.youtube.label', default: 'Youtube')}" />
					
						<g:sortableColumn property="linkedin" title="${message(code: 'social.linkedin.label', default: 'Linkedin')}" />

						<th><g:message code="index.actions.label" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${socialInstanceList}" status="i" var="socialInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: socialInstance, field: "facebook")}</td>
					
						<td>${fieldValue(bean: socialInstance, field: "twitter")}</td>
					
						<td>${fieldValue(bean: socialInstance, field: "googlePlus")}</td>
					
						<td>${fieldValue(bean: socialInstance, field: "instagram")}</td>
					
						<td>${fieldValue(bean: socialInstance, field: "youtube")}</td>
					
						<td>${fieldValue(bean: socialInstance, field: "linkedin")}</td>

						<td><g:link action="edit" id="${socialInstance.id}"><g:message code="default.button.edit.label" /></g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${socialInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
