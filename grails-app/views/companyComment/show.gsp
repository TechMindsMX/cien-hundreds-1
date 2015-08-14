
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
				
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-companyComment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>

				<h4>
					<g:message code="general.label" default="General" />
				</h4>
				<div class="row">
					<div class="col-md-4">
						<ul>
							<li>
							<label><g:message code="name.label" /></label>
								${companyCommentInstance?.company?.name}
							</li>
							<li>
							<label><g:message code="web.label" /></label>
								${companyCommentInstance?.company?.web}
							</li>
							<li>
							<label><g:message code="businessActivity.label" /></label>
								${companyCommentInstance?.company?.type?.name}
							</li>
				    		<g:if test="${companyInstance?.logo}">
				    		<li>
								<img class="img-responsive max300" src="${grailsApplication.config.base.logo.url}${companyCommentInstance?.company?.logo}" />
							</li>
							</g:if>
						</ul>
					</div>
					<div class="col-md-8 form-group well">
						<span class="property-value" aria-labelledby="general-label"><g:fieldValue bean="${companyCommentInstance}" field="general"/></span>
					</div>
				</div>

				<h4>
					<g:message code="description.label" default="Description" />
				</h4>
				<div class="row">
					<div class="col-md-4">
						<ul>
							<li>
								${companyCommentInstance?.company?.description}
							</li>
						</ul>
					</div>
					<div class="col-md-8 form-group well">
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${companyCommentInstance}" field="description"/></span>
					</div>
				</div>

				<h4>
					<g:message code="datosFiscales.label" default="Datos Fiscales" />
				</h4>
				<div class="row">
					<div class="col-md-4">
						<ul>
							<li>
								${companyCommentInstance?.company?.datosFiscales}
							</li>
						</ul>
					</div>
					<div class="col-md-8 form-group well">
						<span class="property-value" aria-labelledby="datosFiscales-label"><g:fieldValue bean="${companyCommentInstance}" field="datosFiscales"/></span>
					</div>
				</div>

				<h4>
					<g:message code="events.label" default="Events" />
				</h4>
				<div class="row">
					<div class="col-md-4">
						<ul>
							<g:each in="${companyCommentInstance?.company?.events}" var="i">
							<li>
								${i?.activity}
							</li>
							</g:each>
						</ul>
					</div>
					<div class="col-md-8 form-group well">
						<span class="property-value" aria-labelledby="events-label"><g:fieldValue bean="${companyCommentInstance}" field="events"/></span>
					</div>
				</div>

				<h4>
					<g:message code="notes.label" default="Notes" />
				</h4>
				<div class="row">
					<div class="col-md-4">
						<ul>
							<li>
								${companyCommentInstance?.company?.notes}
							</li>
						</ul>
					</div>
					<div class="col-md-8 form-group well">
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${companyCommentInstance}" field="notes"/></span>
					</div>
				</div>

				<h4>
					<g:message code="companyComment.refs.label" default="References" />
				</h4>
				<div class="row">
					<div class="col-md-4">
						<ul>
							<g:each in="${companyCommentInstance?.company?.references}" var="i">
							<li>
								${i?.name}
							</li>
							</g:each>
						</ul>
					</div>
					<div class="col-md-8 form-group well">
						<span class="property-value" aria-labelledby="refs-label"><g:fieldValue bean="${companyCommentInstance}" field="refs"/></span>
					</div>
				</div>

				<h4>
					<g:message code="collaborators.label" default="Collaborators" />
				</h4>
				<div class="row">
					<div class="col-md-4">
						<ul>
							<g:each in="${companyCommentInstance?.company?.collaborators}" var="i">
							<li>
								${i?.firstName} ${i?.lastName}
							</li>
							</g:each>
						</ul>
					</div>
					<div class="col-md-8 form-group well">
						<span class="property-value" aria-labelledby="collaborators-label"><g:fieldValue bean="${companyCommentInstance}" field="collaborators"/></span>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<p class="fieldcontain">
							<span id="company-label" class="${session.labelWidth} property-label"><g:message code="company.label" default="Company" /></span>
							
								<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" params="[uuid: companyCommentInstance?.company?.uuid]">${companyCommentInstance?.company?.name.encodeAsHTML()}</g:link></span>
							
						</p>
					</div>
				</div>

			<sec:ifAnyGranted roles="ROLE_BUYER">
				<g:form url="[resource:companyCommentInstance, action:'delete']" method="DELETE">
					<fieldset class="buttons">
						<g:link class="btn btn-primary edit" action="edit" params="[uuid: companyCommentInstance.uuid]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
						<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</fieldset>
				</g:form>
			</sec:ifAnyGranted>

		</div>
	</body>
</html>
