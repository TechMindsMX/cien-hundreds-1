<%@ page import="com.tim.hundreds.Musician" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    	<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musician.label', default: 'Musician')}" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>100 Hundreds</title>
        <!-- Bootstrap core CSS -->
        <link href="/cien-hundreds/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Bootstrap theme -->
        <link href="/cien-hundreds/assets/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="/cien-hundreds/assets/theme.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
        <!-- Fixed navbar -->
        <div class="nav" role="navigation">
			<div class="container theme-showcase">
				<ul>
					<li><a class="home" href="${createLink(uri: '/')}">Inicio</a></li>
					<li><g:link class="list" action="index">Listado de Músicos</g:link></li>
					<li><g:link class="create" action="create">Nuevo Músico</g:link></li>
				</ul>
			</div>
		</div>
        <div class="container theme-showcase">
            <div class="page-header">
                <h2>Datos de Músico</h2>
                <p>Por favor ingrese la informacion faltante en la plataforma 100  Hundreds</p>
            </div>
            <div class="dropdown theme-dropdown clearfix">
	        <div class="col-xs-8 col-md-9 ">
		        <table class="table">
		            <thead>
						<tr style="display: table-row;">
							<th class="text-head-color">
								<h4>Datos de Ingreso</h4>
							</th>
							<th></th>
						</tr>
					</thead>
		        </table>
                <ol class="property-list musician">

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

						<span class="property-value" aria-labelledby="tags-label"><g:fieldValue bean="${musicianInstance}" field="tags"/></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.logoPath}">
				<li class="fieldcontain">
					<span id="logoPath-label" class="property-label"><b>Logo:</b></span>

						<span class="property-value" aria-labelledby="logoPath-label"><g:fieldValue bean="${musicianInstance}" field="logoPath"/></span>

				</li>
				</g:if>
				<g:if test="${musicianInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><b>Dirección:</b></span>

						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${musicianInstance?.address?.id}">${musicianInstance?.address?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.datosFiscales}">
				<li class="fieldcontain">
					<span id="datosFiscales-label" class="property-label"><b>Datos Fiscales:</b></span>

						<span class="property-value" aria-labelledby="datosFiscales-label"><g:link controller="datosFiscales" action="show" id="${musicianInstance?.datosFiscales?.id}">${musicianInstance?.datosFiscales?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.activities}">
				<li class="fieldcontain">
					<span id="activities-label" class="property-label"><b>Actividades:</b></span>

						<g:each in="${musicianInstance.activities}" var="a">
						<span class="property-value" aria-labelledby="activities-label"><g:link controller="activity" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>



				<g:if test="${musicianInstance?.contacts}">
				<li class="fieldcontain">
					<span id="contacts-label" class="property-label"><b>Contacto:</b></span>

						<g:each in="${musicianInstance.contacts}" var="c">
						<span class="property-value" aria-labelledby="contacts-label"><g:link controller="contact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><b>Fecha de Creación:</b></span>

						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${musicianInstance?.dateCreated}" /></span>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.emails}">
				<li class="fieldcontain">
					<span id="emails-label" class="property-label"><b>Correo:</b></span>

						<g:each in="${musicianInstance.emails}" var="e">
						<span class="property-value" aria-labelledby="emails-label"><g:link controller="email" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.formed}">
				<li class="fieldcontain">
					<span id="formed-label" class="property-label"><b>Creado:</b></span>

						<span class="property-value" aria-labelledby="formed-label"><g:formatDate date="${musicianInstance?.formed}" /></span>

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

						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${musicianInstance?.lastUpdated}" /></span>

				</li>
				</g:if>


				<g:if test="${musicianInstance?.suggestions}">
				<li class="fieldcontain">
					<span id="suggestions-label" class="property-label"><b>Sugerencias:</b></span>

						<g:each in="${musicianInstance.suggestions}" var="s">
						<span class="property-value" aria-labelledby="suggestions-label"><g:link controller="suggestion" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${musicianInstance?.telephones}">
				<li class="fieldcontain">
					<span id="telephones-label" class="property-label"><b>Teléfonos:</b></span>

						<g:each in="${musicianInstance.telephones}" var="t">
						<span class="property-value" aria-labelledby="telephones-label"><g:link controller="telephone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>


      </ol>

       <div class="navbar-collapse collapse">
       	<div class="table">
       		<div class="row">
       			<div class="col-xs-6 col-sm-3">

       			</div>
       			<div>

       			</div>
       		</div>
       	</div>



    <table class="table">

        <thead>

            <tr>

                <th><g:link class="btn btn-info btn-lg" controller="social" action="create" params='[musicianId: "${musicianInstance.id}"]'>Agregar Redes Sociales</g:link></th>

                <th><g:link class="btn btn-info btn-lg" controller="video" action="create" params='[musicianId: "${musicianInstance.id}"]'>Agregar Videos</g:link></th>

                <th><g:link class="btn btn-info btn-lg" controller="photo" action="create" params='[musicianId: "${musicianInstance.id}"]'>Agregar Fotos</g:link></th>

                <th><g:link class="btn btn-info btn-lg" controller="audio" action="create" params='[musicianId: "${musicianInstance.id}"]'>Agregar Audio</g:link></th>

            </tr>

        </thead>

        <tbody>

            <tr>

                <td><span class="property-value" aria-labelledby="social-label"><g:link controller="social" action="show" id="${musicianInstance?.social?.id}">${musicianInstance?.social?.encodeAsHTML()}</g:link></span></td>

                <td>
                	<g:if test="${musicianInstance?.videos}">
						<g:each in="${musicianInstance.videos}" var="v">
						<span class="property-value" aria-labelledby="videos-label"><g:link controller="video" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					</g:if>
                </td>

                <td>
                	<g:if test="${musicianInstance?.photos}">
						<g:each in="${musicianInstance.photos}" var="p">
						<span class="property-value" aria-labelledby="photos-label"><g:link controller="photo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					</g:if>
                </td>
                <td>
 					<g:if test="${musicianInstance?.audios}">
							<g:each in="${musicianInstance.audios}" var="a">
							<span class="property-value" aria-labelledby="audios-label"><g:link controller="audio" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
							</g:each>
					</g:if>
				</td>

        <td>
        <g:link controller="social" action="create" params='[musicianId: "${musicianInstance.id}"]'>Add Social</g:link>
        </td>
        <td>
        <g:link controller="datosFiscales" action="create" params='[musicianId: "${musicianInstance.id}"]'>Add Datos Fiscales</g:link>
        </td>
            </tr>

        </tbody>

    </table>
</div>
   </div>
            </div>
        </div>
        <div class="nav" role="navigation">
        	<div class="container theme-showcase">
        		<g:form url="[resource:musicianInstance, action:'delete']" method="DELETE">
					<fieldset class="buttons">
						<g:link class="edit" action="edit" resource="${musicianInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
						<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</fieldset>
				</g:form>
			</div>
		</div>
        <!-- /container -->
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    </body>
</html>
