
<%@ page import="com.tim.hundreds.Video" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'video.label', default: 'Video')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-video" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

			</ul>
		</div>
		<div id="show-video" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<ul class="property-list video">

				<g:if test="${videoInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="${session.labelWidth} property-label"><g:message code="video.url.label" default="Url" /></span>

						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${videoInstance}" field="url"/></span>

				</li>
				</g:if>

				<g:if test="${videoInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="video.musician.label" default="Musician" /></span>

						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" params="['uuid' : videoInstance?.musician?.uuid]">${videoInstance?.musician?.name.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${videoInstance?.contact}">
				<li class="fieldcontain">
					<span id="contact-label" class="${session.labelWidth} property-label"><g:message code="contact.label" default="Contact" /></span>

          <span class="property-value" aria-labelledby="contact-label"><g:link controller="contact" action="show" params="['uuid' : videoInstance?.contact?.uuid]">${videoInstance?.contact?.firstName.encodeAsHTML()} ${videoInstance?.contact?.lastName.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

			</ul>
			<g:form url="[resource:videoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" params="['uuid' : videoInstance?.uuid]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
