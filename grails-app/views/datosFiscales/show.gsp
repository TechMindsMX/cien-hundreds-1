
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
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
			</ul>
		</div>
		<div id="show-datosFiscales" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<ul class="property-list datosFiscales">
			
				<g:if test="${datosFiscalesInstance?.razonSocial}">
				<li class="fieldcontain">
					<span id="razonSocial-label" class="${session.labelWidth} property-label"><g:message code="datosFiscales.razonSocial.label" default="Razon Social" /></span>
					
						<span class="property-value" aria-labelledby="razonSocial-label"><g:fieldValue bean="${datosFiscalesInstance}" field="razonSocial"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${datosFiscalesInstance?.rfc}">
				<li class="fieldcontain">
					<span id="rfc-label" class="${session.labelWidth} property-label"><g:message code="datosFiscales.rfc.label" default="Rfc" /></span>
					
						<span class="property-value" aria-labelledby="rfc-label"><g:fieldValue bean="${datosFiscalesInstance}" field="rfc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${datosFiscalesInstance?.personaJuridica}">
				<li class="fieldcontain">
					<span id="personaJuridica-label" class="${session.labelWidth} property-label"><g:message code="datosFiscales.personaJuridica.label" default="Persona Juridica" /></span>
					
						<span class="property-value" aria-labelledby="personaJuridica-label"><g:fieldValue bean="${datosFiscalesInstance}" field="personaJuridica"/></span>
					
				</li>
				</g:if>

				<li class="fieldcontain">
					<span id="address-label" class="${session.labelWidth} property-label"><g:message code="datosFiscales.address.label" default="Address" /></span>
					
				<g:if test="${datosFiscalesInstance?.address}">
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${datosFiscalesInstance?.address?.id}"><g:message code="address.view.label" default="Ver dirección" /></g:link></span>
				</g:if>
				<g:else>
                	<g:link class="glyphicon glyphicon-floppy-disk" controller="address" action="create" params='[datosFiscalesUuid: "${datosFiscalesInstance.uuid}"]'> Dirección</g:link>
				</g:else>
				</li>
			
			</ul>

			<g:form url="[resource:datosFiscalesInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${datosFiscalesInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
