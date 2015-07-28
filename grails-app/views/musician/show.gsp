<%@ page import="com.tim.hundreds.Musician" %>
<%@ page import="com.tim.hundreds.ApplicationState" %>

<!DOCTYPE html>
<html>
    <head>
    	<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musician.label', default: 'Musician')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <!-- Fixed navbar -->
        <div class="nav nav-pills" role="navigation">
			<div class="container theme-showcase">
				<ul class="nav nav-pills">
					<li><a class="home" href="${createLink(uri: '/')}">Inicio</a></li>
					<li><g:link class="list" action="index">Listado de Músicos</g:link></li>
					<li><g:link class="create" action="create">Nuevo Músico</g:link></li>
				</ul>
			</div>
		</div>

        <div id="show-musician" class="content scaffold-show" role="main">
            <div class="page-header">
                <h2 class="text-head-color text-center"><g:message code="${musicianInstance.name}" /></h2>
            </div>

        	<div class="row">
	        	<div class="col-xs-12 col-md-4">
					<g:if test="${musicianInstance?.logoPath}">
						<div class="img pad-bottom">
						<img class="img-responsive img-thumbnail max300" src="${grailsApplication.config.base.logo.url}${musicianInstance.logoPath}" />
						</div>
					</g:if>
					<g:if test="${musicianInstance?.photos}">
						<div class="img pad-bottom">
						<img class="img-responsive img-thumbnail max300" src="${grailsApplication.config.base.photo.url}${musicianInstance.photos[0].path}" />
						</div>
					</g:if>
	        	</div>

	        	<div class="col-xs-12 col-md-8">
					<g:if test="${musicianInstance?.formed}">
					<div class="fieldcontain">
						<span id="formed-label" class="property-label"><b>${message(code: 'musician.formed.label')}:</b></span>
							<span class="property-value" aria-labelledby="formed-label"><g:formatDate format="dd-MM-yyyy"  format="dd-MM-yyyy" date="${musicianInstance?.formed}" /></span>
					</div>
					</g:if>

					<div class="fieldcontain">
				    	<g:link class="" controller="contact" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Contactos</g:link>

				    	<g:if test="${musicianInstance?.contacts}">
					    	<ol>
								<g:each in="${musicianInstance.contacts}" var="c">
									<div>
										<g:link controller="contact" action="show" id="${c.id}">${c.firstName} ${c.lastName} (${c.role.name})</g:link>
									</div>
								</g:each>
					    	</ol>
					    </g:if>
				    </div>

					<g:if test="${musicianInstance?.genre}">
					<div class="fieldcontain">
						<span id="genre-label" class="property-label"><b>Genero:</b></span>

							<span class="property-value" aria-labelledby="genre-label"><g:fieldValue bean="${musicianInstance}" field="genre.name"/></span>

					</div>
					</g:if>

					<g:if test="${musicianInstance?.web}">
					<div class="fieldcontain">
						<span id="web-label" class="property-label"><b>Web:</b></span>

							<span class="property-value" aria-labelledby="web-label"><g:fieldValue bean="${musicianInstance}" field="web"/></span>

					</div>
					</g:if>

					<div class="fieldcontain">
		                <g:if test="${!musicianInstance?.social}">
		                	<g:link class="" controller="social" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> <g:message code="social.label" /></g:link>
	                	</g:if>
	                	<g:else>
							<g:link class="" controller="social" action="edit" id="${musicianInstance?.social.id}"> <g:message code="social.label"/></g:link>
	                	</g:else>

	                	<g:if test="${musicianInstance?.social}">
							<ol>
								<g:if test="${musicianInstance?.social?.facebook}">
									<div>
										Facebook: ${musicianInstance?.social.facebook}
									</div>
								</g:if>
								<g:if test="${musicianInstance?.social?.googlePlus}">
									<div>
										g+: ${musicianInstance?.social.googlePlus}
									</div>
								</g:if>
								<g:if test="${musicianInstance?.social?.instagram}">
									<div>
										Instagram: ${musicianInstance?.social.instagram}
									</div>
								</g:if>
								<g:if test="${musicianInstance?.social?.linkedin}">
									<div>
										Linkedin: ${musicianInstance?.social.linkedin}
									</div>
								</g:if>
								<g:if test="${musicianInstance?.social?.twitter}">
									<div>
										Twitter: ${musicianInstance?.social.twitter}
									</div>
								</g:if>
								<g:if test="${musicianInstance?.social?.youtube}">
									<div>
										Youtube: ${musicianInstance?.social.youtube}
									</div>
								</g:if>
								<g:if test="${musicianInstance?.social?.other}">
									<div>
										Otra: ${musicianInstance?.social.other}
									</div>
								</g:if>
							</ol>
						</g:if>
					</div>
		        </div>

	        </div>
	        <div class="row">
	        	<div class="col-xs-12">

					<g:if test="${musicianInstance?.history}">
					<div class="fieldcontain well">
						<span id="history-label" class="property-label"><b>Historia:</b></span>
						<span class="property-value" aria-labelledby="history-label"><g:fieldValue bean="${musicianInstance}" field="history"/></span>
					</div>
					</g:if>

					<div class="fieldcontain well">
                		<g:link class="" controller="activity" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Actividades</g:link>

 						<g:if test="${musicianInstance?.activities}">
							<ol>
								<g:each in="${musicianInstance.activities}" var="a">
									<li>
										<g:link controller="activity" action="show" id="${a.id}">${a.activity}</g:link>
									</li>
								</g:each>
							</ol>
						</g:if>
                	</div>

                	<div class="fieldcontain well">
                		<div class="row">
	       					<div class="col-xs-12">
		       					<g:if test="${musicianInstance.videos == null || musicianInstance.videos.size() < ApplicationState.MAX_VIDEOS }">
		       						<g:link class="" controller="video" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Videos</g:link>
		       					</g:if>
		       					<g:elseif test="${musicianInstance.videos.size() >= ApplicationState.MAX_VIDEOS}">
		       						Videos
				                </g:elseif>
			       				<g:if test="${musicianInstance?.videos}">
									<ol>
										<g:each in="${musicianInstance.videos}" var="v">
											<div>
												<g:link url="${v.url}" target="_blank">${v.url}</g:link>
												<sec:link expression="hasRole('ROLE_USER')" controller="video" action="edit" id="${v.id}">${message(code: 'default.edit.label', args:[message(code: 'video.label')])}</sec:link>
											</div>
										</g:each>
									</ol>
								</g:if>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<g:if test="${musicianInstance.audios == null || musicianInstance.audios?.size() < ApplicationState.MAX_AUDIOS}">
		   							<g:link class="" controller="audio" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Audios</g:link>
		       					</g:if>
		       					<g:elseif test="${musicianInstance.audios.size() >= ApplicationState.MAX_AUDIOS}">
				                	Audios
				                </g:elseif>
								<g:if test="${musicianInstance?.audios}">
									<ol>
										<g:each in="${musicianInstance.audios}" var="a">
											<div>
												<g:link url="${a.url}" target="_blank">${a.url}</g:link>
												<sec:link expression="hasRole('ROLE_USER')" controller="audio" action="edit" id="${a.id}">${message(code: 'default.edit.label', args:[message(code: 'audio.label')])}</sec:link>
											</div>
										</g:each>
									</ol>
								</g:if>
							</div>
						</div>

						<div class="row">
			                <div class="col-xs-12">
			                	<p>
					                <g:if test="${musicianInstance.photos == null || musicianInstance.photos.size() < ApplicationState.MAX_PHOTOS }">
			       						<g:link class="" controller="photo" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Fotos</g:link>
			       					</g:if>
			       					<g:elseif test="${musicianInstance.photos.size() >= ApplicationState.MAX_PHOTOS}">
					                	Fotos
					                </g:elseif>
				                </p>
				                <g:if test="${musicianInstance?.photos}">
									<g:each in="${musicianInstance.photos}" var="p">
										<div class="img-tumbnail cols-5">
											<g:link controller="photo" action="show" id="${p.id}"><img class="img-responsive max100pct" src="${grailsApplication.config.base.photo.url}${p.path}" /></g:link>
										</div>
									</g:each>
								</g:if>
							</div>
						</div>
                	</div>


					<g:if test="${musicianInstance?.notes}">
					<div class="fieldcontain well">
						<span id="notes-label" class="property-label"><b>Notas:</b></span>
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${musicianInstance}" field="notes"/></span>
					</div>
					</g:if>

					<sec:access expression="hasRole('ROLE_FACILITATOR')">
			        	<div class="row">
			        		<div class="col-sm-12">
								<div class="fieldcontain well">
									<p id="notes-label" class=""><g:message code="musician.message.label" default="Reviews" /></p>
									<g:if test="${musicianInstance?.musicianValidation}">
										<g:each in="${musicianInstance?.musicianValidation}" var="m">
											<span class="property-value" aria-labelledby="musicianValidation-label">${m.message}</span>
										</g:each>
									</g:if>
								</div>
			        		</div>
			        	</div>
			        </sec:access>

			    </div>
  			</div>
        </div>

        <div class="row">
	       <div class="col-sm-12">
                <div class="well">
     				<div>
		        		<g:if test="${musicianInstance.suggestions == null || musicianInstance.suggestions.size() < ApplicationState.MAX_SUGGESTIONS }">
							<g:link class="" controller="suggestion" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Sugerencias</g:link>
						</g:if>
						<g:elseif test="${musicianInstance.suggestions.size() >= ApplicationState.MAX_SUGGESTIONS}">
		                	Sugerencias
		                </g:elseif>

						<g:if test="${musicianInstance?.suggestions}">
							<ol>
								<g:each in="${musicianInstance.suggestions}" var="s">
									<div>
										<g:link controller="suggestion" action="show" id="${s.id}">${s.name}</g:link>
									</div>
								</g:each>
							</ol>
						</g:if>
					</div>

					<div>
		            	<g:if test="${!musicianInstance?.datosFiscales}">
		                	<g:link class="" controller="datosFiscales" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Datos Fiscales</g:link>
		                </g:if>
		                <g:else>
		                	<g:link class="" controller="datosFiscales" action="edit" id="${musicianInstance.datosFiscales?.id}"> Datos Fiscales</g:link>
		                </g:else>
		            	<g:if test="${musicianInstance?.datosFiscales}">
							<ol>
								<div class="fieldcontain">
									<g:link controller="datosFiscales" action="show" id="${musicianInstance?.datosFiscales?.id}">${musicianInstance?.datosFiscales?.razonSocial}</g:link>
								</div>
							</ol>
						</g:if>
					</div>

					<div>
		            	<g:if test="${!musicianInstance?.address}">
		                	<g:link class="text-capitalize" controller="address" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"><g:message code="address.label" /></g:link>
		                </g:if>
		                <g:else>
		                	<g:link class="text-capitalize" controller="address" action="edit" id="${musicianInstance.address?.id}"><g:message code="address.label" /></g:link>
		                </g:else>
		            	<g:if test="${musicianInstance?.address}">
							<ol>
								<div class="fieldcontain">
									<g:link controller="address" action="show" id="${musicianInstance?.address?.id}">${message(code: 'default.show.label', args: [message(code: 'address.label')])}</g:link>
								</div>
							</ol>
						</g:if>
					</div>
				</div>
			</div>
       	</div>

       	<div class="clearfix">
    		<g:form url="[resource:musicianInstance, action:'delete']" method="DELETE">
				<div class="aling-center">
					<g:link class="btn btn-success blank" action="edit" resource="${musicianInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>

					<sec:access expression="hasRole('ROLE_ADMIN') || hasRole('ROLE_MUSICIAN_ADMIN')">
						<g:if test="${!musicianInstance?.musicianValidation}" >
							<g:link class="btn btn-success" controller="musicianValidation" action="create" params="['musician.id': musicianInstance.id]" >${message(code: 'default.add.label', args: [message(code: 'musicianValidation.label')])}</g:link>
						</g:if>
					</sec:access>
					<sec:access expression="hasRole('ROLE_ADMIN') || hasRole('ROLE_MUSICIAN_ADMIN') || hasRole('ROLE_FACILITATOR')">
						<g:if test="${musicianInstance?.musicianValidation}" >
							<g:link class="btn btn-success" controller="musicianValidation" action="edit" id="${musicianInstance?.musicianValidation?.id}">${message(code: 'default.edit.label', args: [message(code: 'musicianValidation.label')])}</g:link>
						</g:if>
					</sec:access>

					<sec:ifAnyGranted roles="ROLE_FACILITATOR">
						<g:if test="${!musicianInstance?.musicianComment}">
							<g:link class="btn btn-success" controller="musicianComment" action="create" params="['musician.id': musicianInstance.id]" >${message(code: 'default.add.label', args: [message(code: 'musicianComment.label')])}</g:link>
						</g:if>
						<g:else>
							<g:link class="btn btn-success" controller="musicianComment" action="edit" id="${musicianInstance.musicianComment.id}" >${message(code: 'default.edit.label', args: [message(code: 'musicianComment.label')])}</g:link>
						</g:else>
					</sec:ifAnyGranted>

					<sec:ifAnyGranted roles="ROLE_MUSICIAN_VIEWER">
						<g:if test="${musicianInstance?.musicianComment}">
							<g:link class="btn btn-success" controller="musicianComment" action="show" id="${musicianInstance.musicianComment.id}" >${message(code: 'default.show.label', args: [message(code: 'musicianComment.label')])}</g:link>
						</g:if>
					</sec:ifAnyGranted>

					<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</div>
			</g:form>
		</div>

    </body>
</html>
