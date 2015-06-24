
<%@ page import="com.tim.hundreds.Company" %>
<%@ page import="com.tim.hundreds.ApplicationState" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-company" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list company">
			
				<g:if test="${companyInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="${session.labelWidth} property-label"><g:message code="company.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${companyInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="${session.labelWidth} property-label"><g:message code="company.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${companyInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.web}">
				<li class="fieldcontain">
					<span id="web-label" class="${session.labelWidth} property-label"><g:message code="company.web.label" default="Web" /></span>
					
						<span class="property-value" aria-labelledby="web-label"><g:fieldValue bean="${companyInstance}" field="web"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="${session.labelWidth} property-label"><g:message code="company.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${companyInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.tags}">
				<li class="fieldcontain">
					<span id="tags-label" class="${session.labelWidth} property-label"><g:message code="company.tags.label" default="Tags" /></span>
					
						<span class="property-value" aria-labelledby="tags-label"><g:fieldValue bean="${companyInstance}" field="tags"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.logo}">
				<li class="fieldcontain">
					<span id="logo-label" class="${session.labelWidth} property-label"><g:message code="company.logo.label" default="Logo" /></span>
					
						<span class="property-value" aria-labelledby="logo-label">
						<g:if test="${companyInstance?.logo}">
							<img class="img-responsive max300" src="${ApplicationState.LOGO_URL_BASE}${companyInstance.logo}" />
						</g:if>
						</span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.corporatePress}">
				<li class="fieldcontain">
					<span id="corporatePress-label" class="${session.labelWidth} property-label"><g:message code="company.corporatePress.label" default="Corporate Press" /></span>
					
						<span class="property-value" aria-labelledby="corporatePress-label"><g:fieldValue bean="${companyInstance}" field="corporatePress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="${session.labelWidth} property-label"><g:message code="company.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${companyInstance?.address?.id}">${companyInstance?.address?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.social}">
				<li class="fieldcontain">
					<span id="social-label" class="${session.labelWidth} property-label"><g:message code="company.social.label" default="Social" /></span>
					
						<span class="property-value" aria-labelledby="social-label"><g:link controller="social" action="show" id="${companyInstance?.social?.id}">${companyInstance?.social?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.datosFiscales}">
				<li class="fieldcontain">
					<span id="datosFiscales-label" class="${session.labelWidth} property-label"><g:message code="company.datosFiscales.label" default="Datos Fiscales" /></span>
					
						<span class="property-value" aria-labelledby="datosFiscales-label"><g:link controller="datosFiscales" action="show" id="${companyInstance?.datosFiscales?.id}">${companyInstance?.datosFiscales?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.references}">
				<li class="fieldcontain">
					<span id="references-label" class="${session.labelWidth} property-label"><g:message code="company.references.label" default="References" /></span>
					
						<g:each in="${companyInstance.references}" var="r">
						<span class="property-value" aria-labelledby="references-label"><g:link controller="reference" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.events}">
				<li class="fieldcontain">
					<span id="events-label" class="${session.labelWidth} property-label"><g:message code="company.events.label" default="Events" /></span>
					
						<g:each in="${companyInstance.events}" var="e">
						<span class="property-value" aria-labelledby="events-label"><g:link controller="event" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.collaborators}">
				<li class="fieldcontain">
					<span id="collaborators-label" class="${session.labelWidth} property-label"><g:message code="company.collaborators.label" default="Collaborators" /></span>
					
						<g:each in="${companyInstance.collaborators}" var="c">
						<span class="property-value" aria-labelledby="collaborators-label"><g:link controller="collaborator" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.products}">
				<li class="fieldcontain">
					<span id="products-label" class="${session.labelWidth} property-label"><g:message code="company.products.label" default="Products" /></span>
					
						<g:each in="${companyInstance.products}" var="p">
						<span class="property-value" aria-labelledby="products-label"><g:link controller="product" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${companyInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="company.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${companyInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:companyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${companyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
