
<%@ page import="com.tim.hundreds.DatosFiscales" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'datosFiscales.label', default: 'DatosFiscales')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-datosFiscales" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-datosFiscales" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list datosFiscales">
			
				<g:if test="${datosFiscalesInstance?.razonSocial}">
				<li class="fieldcontain">
					<span id="razonSocial-label" class="property-label"><g:message code="datosFiscales.razonSocial.label" default="Razon Social" /></span>
					
						<span class="property-value" aria-labelledby="razonSocial-label"><g:fieldValue bean="${datosFiscalesInstance}" field="razonSocial"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${datosFiscalesInstance?.rfc}">
				<li class="fieldcontain">
					<span id="rfc-label" class="property-label"><g:message code="datosFiscales.rfc.label" default="Rfc" /></span>
					
						<span class="property-value" aria-labelledby="rfc-label"><g:fieldValue bean="${datosFiscalesInstance}" field="rfc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${datosFiscalesInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="datosFiscales.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${datosFiscalesInstance?.address?.id}">${datosFiscalesInstance?.address?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${datosFiscalesInstance?.personaMoral}">
				<li class="fieldcontain">
					<span id="personaMoral-label" class="property-label"><g:message code="datosFiscales.personaMoral.label" default="Persona Moral" /></span>
					
						<span class="property-value" aria-labelledby="personaMoral-label"><g:formatBoolean boolean="${datosFiscalesInstance?.personaMoral}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${datosFiscalesInstance?.personaFisica}">
				<li class="fieldcontain">
					<span id="personaFisica-label" class="property-label"><g:message code="datosFiscales.personaFisica.label" default="Persona Fisica" /></span>
					
						<span class="property-value" aria-labelledby="personaFisica-label"><g:formatBoolean boolean="${datosFiscalesInstance?.personaFisica}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${datosFiscalesInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="property-label"><g:message code="datosFiscales.musician.label" default="Musician" /></span>
					
						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" id="${datosFiscalesInstance?.musician?.id}">${datosFiscalesInstance?.musician?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:datosFiscalesInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${datosFiscalesInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
