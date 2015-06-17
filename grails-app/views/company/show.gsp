
<%@ page import="com.tim.hundreds.Company" %>
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
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-company" class="ibox float-e-margins" role="main">
			<div class="ibox-title text-head-color">
                <h1><span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${companyInstance}" field="name"/></span></h1>
            </div>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div class="ibox-content">
				<ul class="property-list company">

					<g:if test="${companyInstance?.description}">
					<li class="fieldcontain">
						<strong><span id="description-label" class="${session.labelWidth} property-label"><g:message code="company.description.label" default="Descripción" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${companyInstance}" field="description"/></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.web}">
					<li class="fieldcontain">
						<strong><span id="web-label" class="${session.labelWidth} property-label"><g:message code="company.web.label" default="Web" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="web-label"><g:fieldValue bean="${companyInstance}" field="web"/></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.notes}">
					<li class="fieldcontain">
						<strong><span id="notes-label" class="${session.labelWidth} property-label"><g:message code="company.notes.label" default="Notas Adicionales" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${companyInstance}" field="notes"/></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.tags}">
					<li class="fieldcontain">
						<strong><span id="tags-label" class="${session.labelWidth} property-label"><g:message code="company.tags.label" default="Tags" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="tags-label"><g:fieldValue bean="${companyInstance}" field="tags"/></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.logoPath}">
					<li class="fieldcontain">
						<strong><span id="logoPath-label" class="${session.labelWidth} property-label"><g:message code="company.logoPath.label" default="Logo" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="logoPath-label"><g:fieldValue bean="${companyInstance}" field="logoPath"/></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.corporatePress}">
					<li class="fieldcontain">
						<strong><span id="corporatePress-label" class="${session.labelWidth} property-label"><g:message code="company.corporatePress.label" default="Presentación Corporativa" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="corporatePress-label"><g:fieldValue bean="${companyInstance}" field="corporatePress"/></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.address}">
					<li class="fieldcontain">
						<strong><span id="address-label" class="${session.labelWidth} property-label"><g:message code="company.address.label" default="Address" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${companyInstance?.address?.id}">${companyInstance?.address?.encodeAsHTML()}</g:link></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.social}">
					<li class="fieldcontain">
						<strong><span id="social-label" class="${session.labelWidth} property-label"><g:message code="company.social.label" default="Social" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="social-label"><g:link controller="social" action="show" id="${companyInstance?.social?.id}">${companyInstance?.social?.encodeAsHTML()}</g:link></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.datosFiscales}">
					<li class="fieldcontain">
						<strong><span id="datosFiscales-label" class="${session.labelWidth} property-label"><g:message code="company.datosFiscales.label" default="Datos Fiscales" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="datosFiscales-label"><g:link controller="datosFiscales" action="show" id="${companyInstance?.datosFiscales?.id}">${companyInstance?.datosFiscales?.encodeAsHTML()}</g:link></span>

					</li>
					</g:if>

					<g:if test="${companyInstance?.references}">
					<li class="fieldcontain">
						<strong><span id="references-label" class="${session.labelWidth} property-label"><g:message code="company.references.label" default="References" /></span>

							<g:each in="${companyInstance.references}" var="r">
													</strong	<span class="property-value" aria-labelledby="references-label"><g:link controller="reference" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
							</g:each>

					</li>
					</g:if>

					<g:if test="${companyInstance?.collaborators}">
					<li class="fieldcontain">
						<strong><span id="collaborators-label" class="${session.labelWidth} property-label"><g:message code="company.collaborators.label" default="Collaborators" /></span>

							<g:each in="${companyInstance.collaborators}" var="c">
													</strong	<span class="property-value" aria-labelledby="collaborators-label"><g:link controller="collaborator" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
							</g:each>

					</li>
					</g:if>

					<g:if test="${companyInstance?.events}">
					<li class="fieldcontain">
						<strong><span id="events-label" class="${session.labelWidth} property-label"><g:message code="company.events.label" default="Events" /></span>

							<g:each in="${companyInstance.events}" var="e">
													</strong	<span class="property-value" aria-labelledby="events-label"><g:link controller="event" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
							</g:each>

					</li>
					</g:if>

					<g:if test="${companyInstance?.products}">
					<li class="fieldcontain">
						<strong><span id="products-label" class="${session.labelWidth} property-label"><g:message code="company.products.label" default="Products" /></span>

							<g:each in="${companyInstance.products}" var="p">
													</strong	<span class="property-value" aria-labelledby="products-label"><g:link controller="product" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
							</g:each>

					</li>
					</g:if>

					<g:if test="${companyInstance?.type}">
					<li class="fieldcontain">
						<strong><span id="type-label" class="${session.labelWidth} property-label"><g:message code="company.type.label" default="Giro de la Empresa" /></span>
							: </strong>
							<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${companyInstance}" field="type"/></span>

					</li>
					</g:if>
				</ul>
				<div class="form-horizontal">
					<div class="ibox-content text-center ${hasErrors(bean: musicianInstance, field: 'logo', 'error')} ">
						<g:link class="btn btn-success" action="edit" resource="${companyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>

						<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</div>
				</div>

			</div>

      <g:if test="${companyInstance?.address == null}" >
      <g:link controller="address" action="create" params='[companyUuid : "${companyInstance.uuid}"]'>Agregar Dirección</g:link>
      </g:if>
      <br/>
      <g:if test="${companyInstance?.social == null}" >
      <g:link controller="social" action="create" params='[companyUuid : "${companyInstance.uuid}"]'>Agregar Redes Sociales</g:link>
      </g:if>
      <br/>
      <g:if test="${companyInstance?.datosFiscales == null}" >
      <g:link controller="datosFiscales" action="create" params='[companyUuid : "${companyInstance.uuid}"]'>Agregar Datos Fiscales</g:link>
      </g:if>
      <br/>
      <g:link controller="reference" action="create" params='[companyId: "${companyInstance.id}"]'>Agregar recomendaciones</g:link><br/>
      <g:link controller="event" action="create" params='[companyId: "${companyInstance.id}"]'>Agregar Actividades</g:link><br/>
      <g:link controller="collaborator" action="create" params='[companyId: "${companyInstance.id}"]'>Agregar Contactos</g:link><br/>
      <g:link controller="product" action="create" params='[companyId: "${companyInstance.id}"]'>Agregar Productos</g:link>

			<g:form url="[resource:companyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">


				</fieldset>
			</g:form>
		</div>
	</body>
</html>
