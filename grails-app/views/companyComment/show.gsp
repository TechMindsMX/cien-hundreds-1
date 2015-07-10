
<%@ page import="com.tim.hundreds.CompanyComment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'companyComment.label', default: 'CompanyComment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-companyComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-companyComment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list companyComment">
			
				<g:if test="${companyCommentInstance?.general}">
				<li class="fieldcontain">
					<span id="general-label" class="${session.labelWidth} property-label"><g:message code="companyComment.general.label" default="General" /></span>
					
						<span class="property-value" aria-labelledby="general-label"><g:fieldValue bean="${companyCommentInstance}" field="general"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyCommentInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="${session.labelWidth} property-label"><g:message code="companyComment.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${companyCommentInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyCommentInstance?.datosFiscales}">
				<li class="fieldcontain">
					<span id="datosFiscales-label" class="${session.labelWidth} property-label"><g:message code="companyComment.datosFiscales.label" default="Datos Fiscales" /></span>
					
						<span class="property-value" aria-labelledby="datosFiscales-label"><g:fieldValue bean="${companyCommentInstance}" field="datosFiscales"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyCommentInstance?.events}">
				<li class="fieldcontain">
					<span id="events-label" class="${session.labelWidth} property-label"><g:message code="companyComment.events.label" default="Events" /></span>
					
						<span class="property-value" aria-labelledby="events-label"><g:fieldValue bean="${companyCommentInstance}" field="events"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyCommentInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="${session.labelWidth} property-label"><g:message code="companyComment.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${companyCommentInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyCommentInstance?.references}">
				<li class="fieldcontain">
					<span id="references-label" class="${session.labelWidth} property-label"><g:message code="companyComment.references.label" default="References" /></span>
					
						<span class="property-value" aria-labelledby="references-label"><g:fieldValue bean="${companyCommentInstance}" field="references"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyCommentInstance?.collaborators}">
				<li class="fieldcontain">
					<span id="collaborators-label" class="${session.labelWidth} property-label"><g:message code="companyComment.collaborators.label" default="Collaborators" /></span>
					
						<span class="property-value" aria-labelledby="collaborators-label"><g:fieldValue bean="${companyCommentInstance}" field="collaborators"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyCommentInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="${session.labelWidth} property-label"><g:message code="companyComment.company.label" default="Company" /></span>
					
						<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" id="${companyCommentInstance?.company?.id}">${companyCommentInstance?.company?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:companyCommentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${companyCommentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
