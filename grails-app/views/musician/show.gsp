
<%@ page import="com.tim.hundreds.Musician" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musician.label', default: 'Musician')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-musician" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-musician" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list musician">
			
				<g:if test="${musicianInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="musician.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${musicianInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.history}">
				<li class="fieldcontain">
					<span id="history-label" class="property-label"><g:message code="musician.history.label" default="History" /></span>
					
						<span class="property-value" aria-labelledby="history-label"><g:fieldValue bean="${musicianInstance}" field="history"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.web}">
				<li class="fieldcontain">
					<span id="web-label" class="property-label"><g:message code="musician.web.label" default="Web" /></span>
					
						<span class="property-value" aria-labelledby="web-label"><g:fieldValue bean="${musicianInstance}" field="web"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="musician.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${musicianInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.social}">
				<li class="fieldcontain">
					<span id="social-label" class="property-label"><g:message code="musician.social.label" default="Social" /></span>
					
						<span class="property-value" aria-labelledby="social-label"><g:link controller="social" action="show" id="${musicianInstance?.social?.id}">${musicianInstance?.social?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="musician.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${musicianInstance?.address?.id}">${musicianInstance?.address?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.datosFiscales}">
				<li class="fieldcontain">
					<span id="datosFiscales-label" class="property-label"><g:message code="musician.datosFiscales.label" default="Datos Fiscales" /></span>
					
						<span class="property-value" aria-labelledby="datosFiscales-label"><g:link controller="datosFiscales" action="show" id="${musicianInstance?.datosFiscales?.id}">${musicianInstance?.datosFiscales?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.audios}">
				<li class="fieldcontain">
					<span id="audios-label" class="property-label"><g:message code="musician.audios.label" default="Audios" /></span>
					
						<g:each in="${musicianInstance.audios}" var="a">
						<span class="property-value" aria-labelledby="audios-label"><g:link controller="audio" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="musician.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${musicianInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.formed}">
				<li class="fieldcontain">
					<span id="formed-label" class="property-label"><g:message code="musician.formed.label" default="Formed" /></span>
					
						<span class="property-value" aria-labelledby="formed-label"><g:formatDate date="${musicianInstance?.formed}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.genre}">
				<li class="fieldcontain">
					<span id="genre-label" class="property-label"><g:message code="musician.genre.label" default="Genre" /></span>
					
						<span class="property-value" aria-labelledby="genre-label"><g:fieldValue bean="${musicianInstance}" field="genre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.hasManager}">
				<li class="fieldcontain">
					<span id="hasManager-label" class="property-label"><g:message code="musician.hasManager.label" default="Has Manager" /></span>
					
						<span class="property-value" aria-labelledby="hasManager-label"><g:formatBoolean boolean="${musicianInstance?.hasManager}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="musician.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${musicianInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.photos}">
				<li class="fieldcontain">
					<span id="photos-label" class="property-label"><g:message code="musician.photos.label" default="Photos" /></span>
					
						<g:each in="${musicianInstance.photos}" var="p">
						<span class="property-value" aria-labelledby="photos-label"><g:link controller="photo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.suggestions}">
				<li class="fieldcontain">
					<span id="suggestions-label" class="property-label"><g:message code="musician.suggestions.label" default="Suggestions" /></span>
					
						<g:each in="${musicianInstance.suggestions}" var="s">
						<span class="property-value" aria-labelledby="suggestions-label"><g:link controller="suggestion" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${musicianInstance?.videos}">
				<li class="fieldcontain">
					<span id="videos-label" class="property-label"><g:message code="musician.videos.label" default="Videos" /></span>
					
						<g:each in="${musicianInstance.videos}" var="v">
						<span class="property-value" aria-labelledby="videos-label"><g:link controller="video" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:musicianInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${musicianInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
