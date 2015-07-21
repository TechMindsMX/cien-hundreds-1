
<%@ page import="com.tim.hundreds.Reference" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reference.label', default: 'Reference')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-reference" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
			</ul>
		</div>
		<div id="show-reference" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list reference">
			
				<g:if test="${referenceInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="${session.labelWidth} property-label"><g:message code="reference.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${referenceInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceInstance?.contactName}">
				<li class="fieldcontain">
					<span id="contactName-label" class="${session.labelWidth} property-label"><g:message code="reference.contactName.label" default="Contact Name" /></span>
					
						<span class="property-value" aria-labelledby="contactName-label"><g:fieldValue bean="${referenceInstance}" field="contactName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="${session.labelWidth} property-label"><g:message code="reference.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${referenceInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="${session.labelWidth} property-label"><g:message code="reference.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${referenceInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="${session.labelWidth} property-label"><g:message code="reference.company.label" default="Company" /></span>
					
						<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" id="${referenceInstance?.company?.id}">${referenceInstance?.company?.name?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="reference.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:link controller="businessActivity" action="show" id="${referenceInstance?.type?.id}">${referenceInstance?.type?.name?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceInstance?.uuid}">
				<li class="hide fieldcontain">
					<span id="uuid-label" class="${session.labelWidth} property-label"><g:message code="reference.uuid.label" default="Uuid" /></span>
					
						<span class="property-value" aria-labelledby="uuid-label"><g:fieldValue bean="${referenceInstance}" field="uuid"/></span>
					
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:referenceInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${referenceInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
