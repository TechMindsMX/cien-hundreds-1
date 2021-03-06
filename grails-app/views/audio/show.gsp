
<%@ page import="com.tim.hundreds.Audio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'audio.label', default: 'Audio')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-audio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

			</ul>
		</div>
		<div id="show-audio" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<ul class="property-list audio">

				<g:if test="${audioInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="${session.labelWidth} property-label"><g:message code="audio.url.label" default="Url" /></span>

						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${audioInstance}" field="url"/></span>

				</li>
				</g:if>

				<g:if test="${audioInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="audio.musician.label" default="Musician" /></span>

          <span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" params="['uuid' : audioInstance?.musician?.uuid]">${audioInstance?.musician?.name.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${audioInstance?.contact}">
				<li class="fieldcontain">
					<span id="contact-label" class="${session.labelWidth} property-label"><g:message code="contact.label" default="Contact" /></span>

          <span class="property-value" aria-labelledby="contact-label"><g:link controller="contact" action="show" params="['uuid' : audioInstance?.contact?.uuid]">${audioInstance?.contact?.firstName.encodeAsHTML()} ${audioInstance?.contact?.lastName.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

			</ul>
			<g:form url="[resource:audioInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" params="['uuid' : audioInstance?.uuid]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
