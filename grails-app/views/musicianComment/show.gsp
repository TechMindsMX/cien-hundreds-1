
<%@ page import="com.tim.hundreds.MusicianComment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musicianComment.label', default: 'MusicianComment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-musicianComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-musicianComment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			
			<h4>
				<g:message code="general.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
						<label><g:message code="name.label" /></label>
							${musicianCommentInstance?.musician?.name}
						</li>
						<li>
						<label><g:message code="web.label" /></label>
							<a href="${musicianCommentInstance?.musician?.web}">${musicianCommentInstance?.musician?.web}</a>
						</li>
						<li>
							<label><g:message code="dateCreate.label" /></label>			
							<g:formatDate format="dd-MM-yyyy" date="${musicianCommentInstance?.musician?.formed}" />
			    		</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="general-label"><g:fieldValue bean="${musicianCommentInstance}" field="general"/></span>
				</div>
			</div>

			<h4>
				<g:message code="musician.history.placeholder" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>		
							${musicianCommentInstance?.musician?.history}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="history-label"><g:fieldValue bean="${musicianCommentInstance}" field="history"/></span>
				</div>
			</div>

			<h4>
				<g:message code="datosFiscales.label" default="Datos Fiscales" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>		
							<div>${musicianCommentInstance?.musician?.datosFiscales?.razonSocial}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.rfc}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.personaJuridica}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.street}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.neighborhood}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.county}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.town}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.state}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.country}</div>
							<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.zipcode}</div>
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="datosFiscales-label"><g:fieldValue bean="${musicianCommentInstance}" field="datosFiscales"/></span>
				</div>
			</div>

			<h4>
				<g:message code="musicianComment.activities.label" default="Actividades Relevantes" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<g:each in="${musicianCommentInstance?.musician?.activities}">
							<li>		
								${it.activity}
							</li>
						</g:each>	
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="activities-label"><g:fieldValue bean="${musicianCommentInstance}" field="activities"/></span>
				</div>
			</div>

			<h4>
				<g:message code="musicianComment.medias.label" default="Actividades Relevantes" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							<h4>
								<label>
									<g:message code="photo.label" default="Fotos" />
								</label>
							</h4>
							<g:each in="${musicianCommentInstance?.musician?.photos}">
								<li>		
									<div class="img pad-bottom">
									<img class="img-responsive img-thumbnail max300" src="${grailsApplication.config.base.photo.url}${it.path}" />
									</div>
								</li>
							</g:each>		
						</li>		
						<li>
							<h4>
								<label>
									<g:message code="video.label" default="Videos" />
								</label>
							</h4>		
							<ul>
								<g:each in="${musicianCommentInstance?.musician?.videos}">
									<li>
										<a href="${it.url}">${it.url}</a>
									</li>
								</g:each>
							</ul>
						</li>		
						<li>
							<h4>
								<label>
									<g:message code="audios.label" default="Audios" />	
								</label>
							</h4>		
							<ul>
								<g:each in="${musicianCommentInstance?.musician?.audios}">
									<li>
										<a href="${it.url}">${it.url}</a>
									</li>
								</g:each>
							</ul>	
						</li>		
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="medias-label"><g:fieldValue bean="${musicianCommentInstance}" field="medias"/></span>
				</div>
			</div>

			<h4>
				<g:message code="musicianComment.suggestions.label" default="Actividades Relevantes" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					 <ul>
						<g:each in="${musicianCommentInstance?.musician?.suggestions}">
								<li>		
									${it.name}
								</li>
						</g:each>		
					</ul>

				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="suggestions-label"><g:fieldValue bean="${musicianCommentInstance}" field="suggestions"/></span>
				</div>
			</div>	

			<h4>
				<g:message code="musicianComment.notes.label" default="Actividades Relevantes" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>		
							${musicianCommentInstance?.musician?.notes}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${musicianCommentInstance}" field="notes"/></span>
				</div>
			</div>

			<h4>
				<g:message code="musicianComment.contacts.label" default="Contactos" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					 <ul>
						<g:each in="${musicianCommentInstance?.musician?.contacts}">
								<li>		
									${it.firstName} ${it.lastName} <g:link target="_blank" controller="contact" action="show" params="['uuid': it.uuid ]">${message(code: 'default.show.label', args: [message(code: 'contact.label')])}</g:link>
								</li>
						</g:each>		
					</ul>

				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="contacts-label"><g:fieldValue bean="${musicianCommentInstance}" field="contacts"/></span>
				</div>
			</div>	

			<div class="row">
				<div class="col-md-12">
					<p class="fieldcontain">
						<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="musician.label" /></span>
						
							<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" params="[uuid: musicianCommentInstance?.musician?.uuid]">${musicianCommentInstance?.musician?.name.encodeAsHTML()}</g:link></span>
					</p>
				</div>
			</div>

      <sec:ifAnyGranted roles="ROLE_FACILITATOR">
				<g:form url="[resource:musicianCommentInstance, action:'delete']" method="DELETE">
					<fieldset class="buttons">
						<g:link class="btn btn-primary edit" action="edit" resource="${musicianCommentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
						<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</fieldset>
				</g:form>
      </sec:ifAnyGranted>

		</div>
	</body>
</html>
