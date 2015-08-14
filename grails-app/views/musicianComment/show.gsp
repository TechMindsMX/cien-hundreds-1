
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
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list musicianComment">
			
				<g:if test="${musicianCommentInstance?.general}">
				<li class="fieldcontain">
					<span id="general-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.general.label" default="General" /></span>
					
						<span class="property-value" aria-labelledby="general-label"><g:fieldValue bean="${musicianCommentInstance}" field="general"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianCommentInstance?.history}">
				<li class="fieldcontain">
					<span id="history-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.history.label" default="History" /></span>
					
						<span class="property-value" aria-labelledby="history-label"><g:fieldValue bean="${musicianCommentInstance}" field="history"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianCommentInstance?.datosFiscales}">
				<li class="fieldcontain">
					<span id="datosFiscales-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.datosFiscales.label" default="Datos Fiscales" /></span>
					
						<span class="property-value" aria-labelledby="datosFiscales-label"><g:fieldValue bean="${musicianCommentInstance}" field="datosFiscales"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianCommentInstance?.activities}">
				<li class="fieldcontain">
					<span id="activities-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.activities.label" default="Activities" /></span>
					
						<span class="property-value" aria-labelledby="activities-label"><g:fieldValue bean="${musicianCommentInstance}" field="activities"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianCommentInstance?.medias}">
				<li class="fieldcontain">
					<span id="medias-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.medias.label" default="Medias" /></span>
					
						<span class="property-value" aria-labelledby="medias-label"><g:fieldValue bean="${musicianCommentInstance}" field="medias"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianCommentInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${musicianCommentInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianCommentInstance?.suggestions}">
				<li class="fieldcontain">
					<span id="suggestions-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.suggestions.label" default="Suggestions" /></span>
					
						<span class="property-value" aria-labelledby="suggestions-label"><g:fieldValue bean="${musicianCommentInstance}" field="suggestions"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianCommentInstance?.contacts}">
				<li class="fieldcontain">
					<span id="contacts-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.contacts.label" default="Contacts" /></span>
					
						<span class="property-value" aria-labelledby="contacts-label"><g:fieldValue bean="${musicianCommentInstance}" field="contacts"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${musicianCommentInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="musicianComment.musician.label" default="Musician" /></span>
						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" params="['uuid': musicianCommentInstance?.musician?.uuid]">${musicianCommentInstance?.musician?.name}</g:link></span>			
				</li>
				</g:if>
			
			</ul>

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
