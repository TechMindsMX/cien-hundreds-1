
<%@ page import="com.tim.hundreds.Address" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'address.label', default: 'Address')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-address" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
			</ul>
		</div>
		<div id="show-address" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list address">
			
				<g:if test="${addressInstance?.street}">
				<li class="fieldcontain">
					<span id="street-label" class="${session.labelWidth} property-label"><g:message code="address.street.label" default="Street" /></span>
					
						<span class="property-value" aria-labelledby="street-label"><g:fieldValue bean="${addressInstance}" field="street"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.zipcode}">
				<li class="fieldcontain">
					<span id="zipcode-label" class="${session.labelWidth} property-label"><g:message code="address.zipcode.label" default="Zipcode" /></span>
					
						<span class="property-value" aria-labelledby="zipcode-label"><g:fieldValue bean="${addressInstance}" field="zipcode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.neighborhood}">
				<li class="fieldcontain">
					<span id="neighborhood-label" class="${session.labelWidth} property-label"><g:message code="address.neighborhood.label" default="Neighborhood" /></span>
					
						<span class="property-value" aria-labelledby="neighborhood-label"><g:fieldValue bean="${addressInstance}" field="neighborhood"/></span>
					
				</li>
				</g:if>

				<g:if test="${addressInstance?.county}">
					<li class="fieldcontain">
						<span id="county-label" class="${session.labelWidth} property-label"><g:message code="address.county.label" default="County" /></span>

						<span class="property-value" aria-labelledby="county-label"><g:fieldValue bean="${addressInstance}" field="county"/></span>

					</li>
				</g:if>
			
				<g:if test="${addressInstance?.town}">
				<li class="fieldcontain">
					<span id="town-label" class="${session.labelWidth} property-label"><g:message code="address.town.label" default="Town" /></span>
					
						<span class="property-value" aria-labelledby="town-label"><g:fieldValue bean="${addressInstance}" field="town"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="${session.labelWidth} property-label"><g:message code="address.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${addressInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.country}">
				<li class="fieldcontain">
					<span id="country-label" class="${session.labelWidth} property-label"><g:message code="address.country.label" default="Country" /></span>
					
						<span class="property-value" aria-labelledby="country-label"><g:country code="${addressInstance.country}" /></span>
					
				</li>
				</g:if>


 				<g:if test="${addressInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="musician.label" default="Musician" /></span>
					
						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" id="${addressInstance?.musician?.id}">${addressInstance?.musician?.name.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
						
				<g:if test="${addressInstance?.contact}">
				<li class="fieldcontain">
					<span id="contact-label" class="${session.labelWidth} property-label"><g:message code="contact.label" default="contact" /></span>
					
						<span class="property-value" aria-labelledby="contact-label"><g:link controller="contact" action="show" id="${addressInstance?.contact?.id}">${addressInstance?.contact?.firstName.encodeAsHTML()} ${addressInstance?.contact?.lastName.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
						
				<g:if test="${addressInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="${session.labelWidth} property-label"><g:message code="company.label" default="Musician" /></span>
					
						<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" id="${addressInstance?.company?.id}">${addressInstance?.company?.name.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>

				<g:if test="${addressInstance?.datosFiscales}">
				<li class="fieldcontain">
					<span id="datosFiscales-label" class="${session.labelWidth} property-label"><g:message code="datosFiscales.label" default="Musician" /></span>
					
						<span class="property-value" aria-labelledby="datosFiscales-label"><g:link controller="datosFiscales" action="show" id="${addressInstance?.datosFiscales?.id}">${addressInstance?.datosFiscales?.razonSocial.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:addressInstance, action:'delete']" method="DELETE">
				<fieldset class="button form-actions">
					<g:link class="btn btn-primary edit" action="edit" resource="${addressInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
