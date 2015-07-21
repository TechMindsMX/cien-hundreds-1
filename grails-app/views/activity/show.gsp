
<%@ page import="com.tim.hundreds.Activity" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'activity.label', default: 'Activity')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-activity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
			</ul>
		</div>
		<div id="show-activity" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list activity">
			
				<g:if test="${activityInstance?.activity}">
				<li class="fieldcontain">
					<span id="activity-label" class="${session.labelWidth} property-label"><g:message code="activity.label" default="Activity" /></span>
					
						<span class="property-value" aria-labelledby="activity-label"><g:fieldValue bean="${activityInstance}" field="activity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityInstance?.place}">
				<li class="fieldcontain">
					<span id="place-label" class="${session.labelWidth} property-label"><g:message code="place.label" default="Place" /></span>
					
						<span class="property-value" aria-labelledby="place-label"><g:fieldValue bean="${activityInstance}" field="place"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="${session.labelWidth} property-label"><g:message code="date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate format="dd-MM-yyyy"  date="${activityInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="musician.label" default="Musician" /></span>
					
						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" id="${activityInstance?.musician?.id}">${activityInstance?.musician?.name?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:activityInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${activityInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
