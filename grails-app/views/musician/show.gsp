<%@ page import="com.tim.hundreds.Musician" %>
<%@ page import="com.tim.hundreds.ApplicationState" %>

<!DOCTYPE html>
<html lang="en">
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
            <div class="dropdown theme-dropdown clearfix">
	        <div class="col-xs-12 ">

        	<div class="row">
	        	<div class="col-xs-12 col-md-4">
					<g:if test="${musicianInstance?.logoPath}">
						<span class="property-value" aria-labelledby="logoPath-label">
						<img class="img-responsive max300" src="${ApplicationState.LOGO_URL_BASE}${musicianInstance.logoPath}" />
						</span>
					</g:if>
					<g:if test="${musicianInstance?.photos}">
						<span class="property-value" aria-labelledby="photos-label">
						<img class="img-responsive max300" src="${ApplicationState.PHOTO_URL_BASE}${musicianInstance.photos[0].path}" />
						</span>
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
				    	<g:link class="glyphicon" controller="contact" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Contactos</g:link>

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
		                	<g:link class="glyphicon" controller="social" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> <g:message code="social.label" /></g:link>
	                	</g:if>
	                	<g:else>
							<g:link class="glyphicon" controller="social" action="edit" id="${musicianInstance?.social.id}"> <g:message code="social.label"/></g:link>
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
                		<g:link class="glyphicon" controller="activity" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Actividades</g:link>
 
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
		       						<g:link class="glyphicon" controller="video" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Videos</g:link>
		       					</g:if>
		       					<g:elseif test="${musicianInstance.videos.size() >= ApplicationState.MAX_VIDEOS}">
		       						Videos
				                </g:elseif>
			       				<g:if test="${musicianInstance?.videos}">
									<ol>
										<g:each in="${musicianInstance.videos}" var="v">
											<div>
												<a href="${v.url}" target="_blank">${v.url}</a>
												<g:link controller="video" action="edit" id="${v.id}" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]">${message(code:'default.edit.label', args: [message(code:'video.label')] )}</g:link>
											</div>
										</g:each>
									</ol>
								</g:if>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<g:if test="${musicianInstance.audios == null || musicianInstance.audios?.size() < ApplicationState.MAX_AUDIOS}">
		   							<g:link class="glyphicon" controller="audio" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Audios</g:link>
		       					</g:if>
		       					<g:elseif test="${musicianInstance.audios.size() >= ApplicationState.MAX_AUDIOS}">
				                	Audios
				                </g:elseif>
								<g:if test="${musicianInstance?.audios}">
									<ol>
										<g:each in="${musicianInstance.audios}" var="a">
											<div>
												<g:link controller="audio" action="show" id="${a.id}">${a.url}</g:link>
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
			       						<g:link class="glyphicon" controller="photo" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Fotos</g:link>
			       					</g:if>
			       					<g:elseif test="${musicianInstance.photos.size() >= ApplicationState.MAX_PHOTOS}">
					                	Fotos
					                </g:elseif>
				                </p>
				                <g:if test="${musicianInstance?.photos}">
									<g:each in="${musicianInstance.photos}" var="p">
										<div class="img-tumbnail cols-5">
											<g:link controller="photo" action="show" id="${p.id}"><img class="img-responsive max100pct" src="${ApplicationState.PHOTO_URL_BASE}${p.path}" /></g:link>
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

  			</div>
        </div>

        <div class="row">
	       <div class="col-sm-12">
                <div class="well">
     				<div>
		        		<g:if test="${musicianInstance.suggestions == null || musicianInstance.suggestions.size() < ApplicationState.MAX_SUGGESTIONS }">
							<g:link class="glyphicon" controller="suggestion" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Sugerencias</g:link>
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
					<div>

					<div>
		            	<g:if test="${!musicianInstance?.datosFiscales}">
		                	<g:link class="glyphicon" controller="datosFiscales" action="create" params="['musicianUuid': musicianInstance?.uuid, 'musician.id': musicianInstance?.id]"> Datos Fiscales</g:link>
		                </g:if>
		                <g:else>
		                	<g:link class="glyphicon" controller="datosFiscales" action="edit" id="${musicianInstance.datosFiscales?.id}"> Datos Fiscales</g:link>
		                </g:else>
		            	<g:if test="${musicianInstance?.datosFiscales}">
							<ol>
								<div class="fieldcontain">
										<g:link controller="datosFiscales" action="show" id="${musicianInstance?.datosFiscales?.id}">${musicianInstance?.datosFiscales?.razonSocial}</g:link>

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
						<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</div>
				</g:form>
				</div>
				</div>
				</div>
	    <!-- /container -->
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    </body>
</html>
