<%@ page import="com.tim.hundreds.Company" %>
<%@ page import="com.tim.hundreds.CompanyValidation" %>

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
				<sec:ifAnyGranted roles="ROLE_USER">
					<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				</sec:ifAnyGranted>
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
		        		<g:if test="${companyInstance?.logoPath}">
							<img class="img-responsive max300" src="${grailsApplication.config.base.logo.url}${companyInstance.logoPath}" />
						</g:if>
		        	</div>
		        	<div class="col-xs-12 col-md-8">
				<g:if test="${companyInstance?.type}">
				<div class="fieldcontain">
					<span id="type-label" class="${session.labelWidth} property-label"><g:message code="company.type.label" default="Type" /></span>
					<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${companyInstance}" field="type.name"/></span>
				</div>
				</g:if>

				<g:if test="${companyInstance?.corporatePressPath}">
					<div class="fieldcontain">
						<span id="corporatePress-label" class="${session.labelWidth} property-label"><g:message code="corporatePress.label" default="corporatePress" /></span>
						<span class="property-value" aria-labelledby="corporatePress-label"><g:link target="_blank" url="${grailsApplication.config.base.press.url}${companyInstance.corporatePressPath}">${message(code: 'default.show.label', args: [message(code: 'corporatePress.label')])}</g:link></span>
					</div>
				</g:if>

				<div class="fieldcontain">
				<sec:ifAnyGranted roles="ROLE_USER">
					<g:link controller="product" action="create" params="['companyUuid': companyInstance?.uuid]">${message(code: 'default.add.label', args: [message(code: 'product.label', default: 'Product')])}</g:link>
				</sec:ifAnyGranted>
					<g:if test="${companyInstance?.products}">
						<ul class="one-to-many">
						<g:each in="${companyInstance?.products}" var="p">
						    <li><g:link controller="product" action="show" params="['uuid': p.uuid]">${p?.name?.encodeAsHTML()}</g:link></li>
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
				<sec:ifAnyGranted roles="ROLE_USER">
					<g:if test="${!companyInstance?.social}">
						<g:link controller="social" action="create" params="['companyUuid': companyInstance?.uuid]" >${message(code: 'default.add.label', args: [message(code: 'social.label')])}</g:link>
					</g:if>
				</sec:ifAnyGranted>
					<g:if test="${companyInstance?.social}">
						<g:message code="social.label" default="Social" />
						<sec:ifAnyGranted roles="ROLE_USER">
							<g:link controller="social" action="edit" params="['uuid': companyInstance?.social?.uuid]">${message(code: 'default.edit.label', args: [message(code: 'social.label')])}</g:link>
						</sec:ifAnyGranted>
							<ul>
								<g:if test="${companyInstance?.social?.facebook}"><li>${companyInstance?.social.facebook}</li></g:if>
								<g:if test="${companyInstance?.social?.twitter}"><li>${companyInstance?.social.twitter}</li></g:if>
								<g:if test="${companyInstance?.social?.googlePlus}"><li>${companyInstance?.social.googlePlus}</li></g:if>
								<g:if test="${companyInstance?.social?.instagram}"><li>${companyInstance?.social.instagram}</li></g:if>
								<g:if test="${companyInstance?.social?.youtube}"><li>${companyInstance?.social.youtube}</li></g:if>
								<g:if test="${companyInstance?.social?.linkedin}"><li>${companyInstance?.social.linkedin}</li></g:if>
								<g:if test="${companyInstance?.social?.other}"><li>${companyInstance?.social.other}</li></g:if>
							</ul>
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
					${message(code: 'event.label', default: 'Actividades')}
				<sec:ifAnyGranted roles="ROLE_USER">
					<g:link controller="event" action="create" params="['companyUuid': companyInstance?.uuid]">${message(code: 'default.add.label', args:[message(code: 'event.label')])}</g:link>
				</sec:ifAnyGranted>
				</p>
				<g:if test="${companyInstance?.events}">
					<ul>
						<g:each in="${companyInstance?.events}" var="e">
						<li><g:link controller="event" action="show" params="['uuid': e.uuid]"><g:formatDate format="dd-MM-yyyy" date="${e.date}"/> ${e.activity} ${e.place}</g:link></li>
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
					${message(code: 'references.label', default: 'Recomendaciones')}
				<sec:ifAnyGranted roles="ROLE_USER">
					<g:link controller="reference" action="create" params="['companyUuid': companyInstance?.uuid]">${message(code: 'default.add.label', args:[message(code: 'reference.label')])}</g:link>
				</sec:ifAnyGranted>
				</p>
				<g:if test="${companyInstance?.references}">
					<ul>
						<g:each in="${companyInstance?.references}" var="r">
						<li><g:link controller="reference" action="show" params="['uuid': r.uuid]" >${r.name} - ${r.contactName} - ${r.type.name} - ${r.email} - ${r.phone}</g:link></li>
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

	        	<sec:access expression="hasRole('ROLE_ADMIN') || hasRole('ROLE_COMPANY_ADMIN') || hasRole('ROLE_BUYER')">
		        	<div class="row">
		        		<div class="col-sm-12">
							<div class="fieldcontain well">
								<p id="notes-label" class=""><g:message code="company.message.label" default="Reviews" /></p>
								<g:if test="${companyInstance?.companyValidation}">
									<g:each in="${companyInstance?.companyValidation}" var="cv">
										<span class="property-value" aria-labelledby="companyValidation-label">${cv.message}</span>
									</g:each>
								</g:if>
							</div>
		        		</div>
		        	</div>
		        </sec:access>
    	</div>

		<div class="row">
			<div class="col-sm-12">
				<div class="fieldcontain">
					<label for="address">
						<g:message code="company.address.label" default="Address" />
					</label>
						<div class="">
							<g:if test="${companyInstance.address}">
								<g:link controller="address" action="show" params="['uuid': companyInstance?.address?.uuid]">${message(code: 'default.show.label', args: [message(code: 'address.label')])}</g:link>
							</g:if>
							<g:else>
				<sec:ifAnyGranted roles="ROLE_USER">
								<g:link controller="address" action="create" params="['companyUuid': companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'address.label')])}</g:link>
				</sec:ifAnyGranted>
							</g:else>
						</div>
				</div>


				<div class="fieldcontain">
					<label for="datosFiscales">
						<g:message code="company.datosFiscales.label" default="Datos Fiscales" />
					</label>
						<div class="">
							<g:if test="${companyInstance.datosFiscales}">
								<g:link controller="datosFiscales" action="show" params="['uuid': companyInstance?.datosFiscales?.uuid]">${message(code: 'default.show.label', args: [message(code: 'datosFiscales.label')])}</g:link>
							</g:if>
							<g:else>
				<sec:ifAnyGranted roles="ROLE_USER">
								<g:link controller="datosFiscales" action="create" params="['companyUuid': companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'datosFiscales.label')])}</g:link>
				</sec:ifAnyGranted>
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
									<g:link controller="collaborator" action="show" params="['uuid': c?.uuid]">${c.firstName} ${c.lastName}</g:link>
									</li>
								</g:each>
							</ul>
				<sec:ifAnyGranted roles="ROLE_USER">
							<div>
								<g:link controller="collaborator" action="create" params="['companyUuid': companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'collaborator.label')])}</g:link>
							</div>
				</sec:ifAnyGranted>
						</div>
				</div>

			</div>
		</div>

		<p></p>

		<g:form url="[resource:companyInstance, action:'delete']" method="DELETE">
			<fieldset class="buttons">
				<sec:ifAnyGranted roles="ROLE_USER">
					<g:link class="btn btn-primary edit" action="edit" params="['uuid': companyInstance.uuid]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</sec:ifAnyGranted>

				<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN">
					<g:if test="${!companyInstance?.companyValidation}" >
						<g:link class="btn btn-success" controller="companyValidation" action="create" params="['uuid': companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'companyValidation.label')])}</g:link>
					</g:if>
				</sec:ifAnyGranted>
				<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_COMPANY_ADMIN,ROLE_BUYER">
					<g:if test="${companyInstance?.companyValidation}" >
						<g:link class="btn btn-success" controller="companyValidation" action="edit" params="['uuid': companyInstance?.companyValidation?.uuid]">${message(code: 'default.edit.label', args: [message(code: 'companyValidation.label')])}</g:link>
					</g:if>
				</sec:ifAnyGranted>

			<sec:ifAnyGranted roles="ROLE_BUYER">
				<g:if test="${!companyInstance?.companyComment}">
					<g:link class="btn btn-success" controller="companyComment" action="create" params="['companyUuid': companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'companyComment.label')])}</g:link>
				</g:if>
			</sec:ifAnyGranted>

			<sec:ifAnyGranted roles="ROLE_COMPANY_VIEWER,ROLE_BUYER">
				<g:if test="${companyInstance?.companyComment}">
					<g:link class="btn btn-success" controller="companyComment" action="show" params="['uuid': companyInstance.companyComment.uuid]" >${message(code: 'default.show.label', args: [message(code: 'companyComment.label')])}</g:link>
				</g:if>
			</sec:ifAnyGranted>

			</fieldset>
		</g:form>
	</div>
	</body>
</html>
