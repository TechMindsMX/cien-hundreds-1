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

           	<div class="page-header">
                <h2 class="text-head-color text-center"><g:message code="${companyInstance.name}" /></h2>
            </div>
            <div class="dropdown theme-dropdown clearfix">
	        <div class="col-xs-12 ">
	        	<div class="row">
		        	<div class="col-xs-12 col-md-4">
						<img class="img-responsive max300" src="${ApplicationState.LOGO_URL_BASE}${companyInstance.logo}" />
		        	</div>
		        	<div class="col-xs-12 col-md-8">
				<g:if test="${companyInstance?.type}">
				<div class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="company.type.label" default="Type" /></span>
					<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${companyInstance}" field="type.name"/></span>
				</div>
				</g:if>

				<div class="fieldcontain">
					<g:link controller="product" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'product.label', default: 'Product')])}</g:link>
					<g:if test="${companyInstance?.products}">
						<ul class="one-to-many">
						<g:each in="${companyInstance?.products}" var="p">
						    <li><g:link controller="product" action="show" id="${p.id}">${p?.name?.encodeAsHTML()}</g:link></li>
						</g:each>
						</ul>
					</g:if>
				</div>

				<g:if test="${companyInstance?.web}">
				<div class="fieldcontain">
					<span id="web-label" class="${session.labelWidth} property-label"><g:message code="company.web.label" default="web" /></span>
					<span class="property-value" aria-labelledby="web-label"><g:fieldValue bean="${companyInstance}" field="web"/></span>
				</div>
				</g:if>

				<div class="fieldcontain">
					<g:if test="${!companyInstance?.social}">
						<g:link controller="social" action="create" params="[companyUuid: companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'social.label')])}</g:link>
					</g:if>
					<g:if test="${companyInstance?.social}">
						<g:message code="social.label" default="Social" />
						<g:link controller="social" action="edit" id="${companyInstance?.social?.id}">
							<ul>
								<g:if test="${companyInstance?.social?.facebook}"><li>${companyInstance?.social.facebook}</li></g:if>
								<g:if test="${companyInstance?.social?.twitter}"><li>${companyInstance?.social.twitter}</li></g:if>
								<g:if test="${companyInstance?.social?.googlePlus}"><li>${companyInstance?.social.googlePlus}</li></g:if>
								<g:if test="${companyInstance?.social?.instagram}"><li>${companyInstance?.social.instagram}</li></g:if>
								<g:if test="${companyInstance?.social?.youtube}"><li>${companyInstance?.social.youtube}</li></g:if>
								<g:if test="${companyInstance?.social?.linkedin}"><li>${companyInstance?.social.linkedin}</li></g:if>
								<g:if test="${companyInstance?.social?.other}"><li>${companyInstance?.social.other}</li></g:if>
							</ul>
						</g:link>
					</g:if>
				</div>
		        	</div>
	        	</div>

	        	<div class="row">
	        		<div class="col-sm-12">
				<div class="fieldcontain well">
				<p id="description-label" class=""><g:message code="company.description.label" default="Description" /></p>
				<g:if test="${companyInstance?.description}">
					<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${companyInstance}" field="description"/></span>
				</g:if>
				</div>
	        		</div>
	        	</div>

	        	<div class="row">
	        		<div class="col-sm-12">
				<div class="fieldcontain well">
				<p id="events-label" class="">
					<g:link controller="event" action="create" params="['company.id': companyInstance?.id]">${message(code: 'event.label', default: 'Actividades')}</g:link>
				</p>
				<g:if test="${companyInstance?.events}">
					<ul>
						<g:each in="${companyInstance?.events}" var="e"> 
						<li><g:link controller="activity" action="edit" id="${e.id}" params="['company.id': companyInstance?.id]"><g:formatDate format="dd-MM-yyyy" date="${e.date}"/> ${e.activity} ${e.place}</g:link></li>
						</g:each>
					</ul>
				</g:if>
				</div>
	        		</div>
	        	</div>

	        	<div class="row">
	        		<div class="col-sm-12">
				<div class="fieldcontain well">
				<p id="references-label" class="">
					<g:link controller="reference" action="create" params="['company.id': companyInstance?.id]">${message(code: 'references.label', default: 'Recomendaciones')}</g:link>
				</p>
				<g:if test="${companyInstance?.references}">
					<ul>
						<g:each in="${companyInstance?.references}" var="r"> 
						<li><g:link controller="reference" action="edit" id="${r.id}" >${r.name} - ${r.contactName} - ${r.type.name} - ${r.email} - ${r.phone}</g:link></li>
						</g:each>
					</ul>
				</g:if>
				</div>
	        		</div>
	        	</div>

	        	<div class="row">
	        		<div class="col-sm-12">
				<div class="fieldcontain well">
				<p id="notes-label" class=""><g:message code="company.notes.label" default="Notes" /></p>
				<g:if test="${companyInstance?.notes}">
					<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${companyInstance}" field="notes"/></span>
				</g:if>
				</div>
	        		</div>
	        	</div>

    	</div>
			
		<div class="row">
			<div class="col-sm-12">
				<div class="fieldcontain">
					<label for="address">
						<g:message code="company.address.label" default="Address" />
					</label>
						<div class="">
							<g:if test="${companyInstance.address}">
								<g:link controller="address" action="show" id="${companyInstance?.address?.id}">${message(code: 'default.show.label', args: [message(code: 'address.label')])}</g:link>
							</g:if>
							<g:else>
								<g:link controller="address" action="create" params="[companyUuid: companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'address.label')])}</g:link>
							</g:else>
						</div>
				</div>


				<div class="fieldcontain">
					<label for="datosFiscales">
						<g:message code="company.datosFiscales.label" default="Datos Fiscales" />
					</label>
						<div class="">
							<g:if test="${companyInstance.datosFiscales}">
								<g:link controller="datosFiscales" action="show" id="${companyInstance?.datosFiscales?.id}">${message(code: 'default.show.label', args: [message(code: 'datosFiscales.label')])}</g:link>
							</g:if>
							<g:else>
								<g:link controller="datosFiscales" action="create" params="[companyUuid: companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'datosFiscales.label')])}</g:link>
							</g:else>
						</div>
				</div>

				<div class="fieldcontain">
					<label for="collaborators">
						<g:message code="collaborators.label" default="Collaborators" />
						
					</label>
						<div class="">
							<ul>
								<g:each in="${companyInstance.collaborators}" var="c">
									<li>
									<g:link controller="collaborator" action="show" id="${c?.id}">${c.firstName} ${c.lastName}</g:link>
									</li>
								</g:each>
							</ul>
							<div>
								<g:link controller="collaborator" action="create" params="['company.id': companyInstance.id]" >${message(code: 'default.add.label', args: [message(code: 'collaborator.label')])}</g:link>
							</div>
						</div>
				</div>

			</div>
		</div>

		<p></p>
		
		<g:form url="[resource:companyInstance, action:'delete']" method="DELETE">
			<fieldset class="buttons">
				<g:link class="btn btn-primary edit" action="edit" resource="${companyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
				<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
	</body>
</html>
