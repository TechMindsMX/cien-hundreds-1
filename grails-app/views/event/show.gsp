
<%@ page import="com.tim.hundreds.Event" %>
${eventInstance.dump()}
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-event" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

			</ul>
		</div>
		<div id="show-event" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<ul class="property-list event">
			
				<g:if test="${eventInstance?.activity}">
				<li class="fieldcontain">
					<span id="activity-label" class="${session.labelWidth} property-label"><g:message code="event.activity.label" default="Activity" /></span>
					
						<span class="property-value" aria-labelledby="activity-label"><g:fieldValue bean="${eventInstance}" field="activity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.place}">
				<li class="fieldcontain">
					<span id="place-label" class="${session.labelWidth} property-label"><g:message code="event.place.label" default="Place" /></span>
					
						<span class="property-value" aria-labelledby="place-label"><g:fieldValue bean="${eventInstance}" field="place"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="${session.labelWidth} property-label"><g:message code="event.company.label" default="Company" /></span>
					
						<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" params="['uuid': eventInstance?.company?.uuid]">${eventInstance?.company?.name.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="${session.labelWidth} property-label"><g:message code="event.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate format="dd-MM-yyyy" date="${eventInstance?.date}" /></span>
					
				</li>
				</g:if>

			</ul>

			<sec:ifAnyGranted roles="ROLE_USER">
				<g:form url="[resource:eventInstance, action:'delete']" method="DELETE">
					<fieldset class="buttons">
						<g:link class="btn btn-primary edit" action="edit" params="['uuid': eventInstance.uuid]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
						<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</fieldset>
				</g:form>
			</sec:ifAnyGranted>
		</div>
	</body>
</html>
