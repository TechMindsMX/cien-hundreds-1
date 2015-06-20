<%@ page import="com.tim.hundreds.Musician" %>
<%@ page import="com.tim.hundreds.ApplicationState" %>

<!DOCTYPE html>
<html lang="en">
    <head>
    	<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musician.label', default: 'Musician')}" />
    </head>
    <body>
        <!-- Fixed navbar -->
        <div class="nav" role="navigation">
			<div class="container theme-showcase">
				<ul class="nav nav-pills">
					<li><a class="home" href="${createLink(uri: '/')}">Inicio</a></li>
					<li><g:link class="list" action="index">Listado de Músicos</g:link></li>
					<li><g:link class="create" action="create">Nuevo Músico</g:link></li>
				</ul>
			</div>
		</div>
        <div class="container theme-showcase">
            <div class="page-header">
                <h2 class="text-head-color">Datos de Músico</h2>
            </div>
            <div class="dropdown theme-dropdown clearfix">
	        <div class="col-xs-12 ">
		 	<div class="col-md-4">
                <ul class="property-list musician">

				<g:if test="${musicianInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><b>Nombre:</b></span>

						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${musicianInstance}" field="name"/></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.history}">
				<li class="fieldcontain">
					<span id="history-label" class="property-label"><b>Historia:</b></span>

						<span class="property-value" aria-labelledby="history-label"><g:fieldValue bean="${musicianInstance}" field="history"/></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.web}">
				<li class="fieldcontain">
					<span id="web-label" class="property-label"><b>Web:</b></span>

						<span class="property-value" aria-labelledby="web-label"><g:fieldValue bean="${musicianInstance}" field="web"/></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><b>Notas:</b></span>

						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${musicianInstance}" field="notes"/></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.tags}">
				<li class="fieldcontain">
					<span id="tags-label" class="property-label"><g:message code="musician.tags.label" default="Tags" /></span>

					<g:each in="${musicianInstance.tags}" var="t">
						<span class="property-value" aria-labelledby="tags-label">${t?.value?.encodeAsHTML()},</span>
					</g:each>
				</li>
				</g:if>

				<g:if test="${musicianInstance?.logoPath}">
				<li class="fieldcontain">
					<span id="logoPath-label" class="property-label"><b>Logo:</b></span>

						<span class="property-value" aria-labelledby="logoPath-label">
						<img class="img-responsive" src="${ApplicationState.LOGO_URL_BASE}${musicianInstance.logoPath}" />

				</li>
				</g:if>
				<g:if test="${musicianInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><b>Dirección:</b></span>
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${musicianInstance?.address?.id}"><g:message code="address.view.label" default="Ver dirección" /></g:link></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><b>Fecha de Creación:</b></span>

						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate format="dd-MM-yyyy"  format="dd-MM-yyyy" date="${musicianInstance?.dateCreated}" /></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.formed}">
				<li class="fieldcontain">
					<span id="formed-label" class="property-label"><b>Creado:</b></span>

						<span class="property-value" aria-labelledby="formed-label"><g:formatDate format="dd-MM-yyyy"  format="dd-MM-yyyy" date="${musicianInstance?.formed}" /></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.genre}">
				<li class="fieldcontain">
					<span id="genre-label" class="property-label"><b>Genero:</b></span>

						<span class="property-value" aria-labelledby="genre-label"><g:fieldValue bean="${musicianInstance}" field="genre"/></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.hasManager}">
				<li class="fieldcontain">
					<span id="hasManager-label" class="property-label"><b>Manager</b></span>

						<span class="property-value" aria-labelledby="hasManager-label"><g:formatBoolean boolean="${musicianInstance?.hasManager}" /></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><b>Última Actualización</b></span>

						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate format="dd-MM-yyyy"  format="dd-MM-yyyy" date="${musicianInstance?.lastUpdated}" /></span>

				</li>
				</g:if>



      </ul>
    </div>

       <div class="col-md-8">
					<table class="table table-striped">
				       		<tbody>
				       			<tr>
				       				<th>
				       					<g:if test="${musicianInstance.videos == null || musicianInstance.videos.size() < 5 }">
				       						<g:link class="glyphicon glyphicon-floppy-disk" controller="video" action="create" > Videos</g:link>
				       					</g:if>
				       					<g:elseif test="${musicianInstance.videos.size() >= 5}">
						                	<g:link class="glyphicon glyphicon-floppy-remove not-active" disable controller="social" action="create" params='[musicianUuid: "${musicianInstance.uuid}"]'>  Redes Sociales</g:link>
						                </g:elseif>

				       				</th>
				       				<th>
					       				<g:if test="${musicianInstance?.videos}">
											<ol>
												<g:each in="${musicianInstance.videos}" var="v">
													<li>
															<g:link controller="video" action="show" id="${v.id}">${v.url}</g:link>
													</li>
												</g:each>
											<ol>
										</g:if>
				       				</th>

				       				</tr>

					                <tr>
						                <th>
						                <g:if test="${musicianInstance.photos == null || musicianInstance.photos.size() < ApplicationState.MAX_PHOTOS }">
				       						<g:link class="glyphicon glyphicon-floppy-disk" controller="photo" action="create"> Fotos</g:link>
				       					</g:if>
				       					<g:elseif test="${musicianInstance.photos.size() >= ApplicationState.MAX_PHOTOS}">
						                	<g:link class="glyphicon glyphicon-floppy-remove not-active" controller="photo" action="index" > Fotos</g:link>
						                </g:elseif>

						                </th>
						                <th>
							                <g:if test="${musicianInstance?.photos}">
												<ol>
													<g:each in="${musicianInstance.photos}" var="p">
														<li>
															<g:link controller="photo" action="show" id="${p.id}">${p.path}</g:link>
														</li>
													</g:each>
												</ol>
											</g:if>

						                </th>
									</tr>

									<tr>
										<th>
											<g:if test="${musicianInstance.audios == null || musicianInstance.audios?.size() < ApplicationState.MAX_AUDIOS}">
				       							<g:link class="glyphicon glyphicon-floppy-disk" controller="audio" action="create" params='[musicianId: "${musicianInstance.id}"]'> Audios</g:link>
					       					</g:if>
					       					<g:elseif test="${musicianInstance.audios.size() >= ApplicationState.MAX_AUDIOS}">
							                	<g:link class="glyphicon glyphicon-floppy-remove not-active" controller="audio" action="create" > Audios</g:link>
							                </g:elseif>
										</th>
										<th>
											<g:if test="${musicianInstance?.audios}">
												<ol>
													<g:each in="${musicianInstance.audios}" var="a">
														<li>
															<g:link controller="audio" action="show" id="${a.id}">${a.url}</g:link>
														</li>
													</g:each>
												</ol>
											</g:if>

										</th>
									</tr>
					                <tr>
					                	<th>
					                		<g:if test="${musicianInstance.suggestions == null || musicianInstance.suggestions.size() < ApplicationState.MAX_SUGGESTIONS }">
				       							<g:link class="glyphicon glyphicon-floppy-disk" controller="suggestion" action="create" > Sugerencias</g:link>
					       					</g:if>
					       					<g:elseif test="${musicianInstance.suggestions.size() >= ApplicationState.MAX_SUGGESTIONS}">
							                	<g:link class="glyphicon glyphicon-floppy-remove not-active" controller="suggestion" action="index" > Sugerencias</g:link>
							                </g:elseif>

			       						</th>
					                	<th>
											<g:if test="${musicianInstance?.suggestions}">
												<ol>
													<g:each in="${musicianInstance.suggestions}" var="s">
														<li>
															<g:link controller="suggestion" action="show" id="${s.id}">${s.name}</g:link>
														</li>
													</g:each>
												</ol>
											</g:if>
					                	</th>
									</tr>
									<tr>
									    <th>
									    	<g:link class="glyphicon glyphicon-floppy-disk" controller="contact" action="create"> Contactos</g:link>
									    </th>
									    <th>
									    	<g:if test="${musicianInstance?.contacts}">
										    	<ol>
													<g:each in="${musicianInstance.contacts}" var="c">
														<li>
															<g:link controller="contact" action="show" id="${c.id}">${c.firstName} ${c.lastName}</g:link>
														</li>
													</g:each>
										    	</ol>
										    </g:if>
									    </th>
									</tr>
									<tr>
					                	<th>
					                		<g:link class="glyphicon glyphicon-floppy-disk" controller="activity" action="create" params='[musicianId: "${musicianInstance.id}"]'> Actividades</g:link>
					                	</th>
					                	<th>
											<g:if test="${musicianInstance?.activities}">
												<ol>
													<g:each in="${musicianInstance.activities}" var="a">
														<li>
															<g:link controller="activity" action="show" id="${a.id}">${a.activity}</g:link>
														</li>
													</g:each>
												</ol>
											</g:if>
					                	</th>
									</tr>
									<tr>
						                <th>
							                <g:if test="${musicianInstance.social == null}">
							                	<g:link class="glyphicon glyphicon-floppy-disk" controller="social" action="create" params='[musicianUuid: "${musicianInstance.uuid}"]'> Redes Sociales</g:link>
						                	</g:if>
						                	<g:elseif test="${musicianInstance.social != null}">
							                	<g:link class="glyphicon glyphicon-floppy-remove not-active" disable controller="social" action="create" params='[musicianId: "${musicianInstance.id}"]'>  Redes Sociales</g:link>
							                </g:elseif>
						                </th>
						                <th>
						                	<g:if test="${musicianInstance?.social}">
												<ol>
														<li>
															Facebook: ${musicianInstance?.social.facebook}
														</li>
														<li>
															g+: ${musicianInstance?.social.googlePlus}
														</li>
														<li>
															Instagram: ${musicianInstance?.social.instagram}
														</li>
														<li>
															Linkedin: ${musicianInstance?.social.linkedin}
														</li>
														<li>
															Twitter: ${musicianInstance?.social.twitter}
														</li>
														<li>
															Youtube: ${musicianInstance?.social.youtube}
														</li>
														<li>
															Otra: ${musicianInstance?.social.other}
														</li>
												</ol>
												<g:link controller="social" action="edit" id="${musicianInstance?.social.id}"><g:message code="default.button.edit.label"/></g:link>

											</g:if>
						                </th>
					                </tr>
					                <tr>
					                <th>
						                <g:if test="${musicianInstance.address == null}">
						                	<g:link class="glyphicon glyphicon-floppy-disk" controller="address" action="create" params='[musicianUuid: "${musicianInstance.uuid}"]'> Dirección</g:link>
						                </g:if>
					                </th>
					                </tr>
					                <tr>
					                <th>
						                <g:if test="${musicianInstance.datosFiscales == null}">
						                	<g:link class="glyphicon glyphicon-floppy-disk" controller="datosFiscales" action="create" params='[musicianUuid: "${musicianInstance.uuid}"]'> Datos Fiscales</g:link>
						                </g:if>
						                <g:else test="${musicianInstance.datosFiscales == null}">
						                	<g:link class="glyphicon glyphicon-floppy-remove not-active" controller="datosFiscales" action="create" params='[musicianUuid: "${musicianInstance.uuid}"]'> Datos Fiscales</g:link>
						                </g:else>
					                </th>
					                <th>
					                	<g:if test="${musicianInstance?.datosFiscales}">
											<ol>
												<li class="fieldcontain">
														<g:link controller="datosFiscales" action="show" id="${musicianInstance?.datosFiscales?.id}">${musicianInstance?.datosFiscales?.razonSocial}</g:link>

												</li>
											</ol>
										</g:if>
					                </th>
				       				</tr>
				       		</tbody>
				       	</table>
       	</div>

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
