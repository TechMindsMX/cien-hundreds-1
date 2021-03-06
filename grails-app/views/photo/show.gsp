
<%@ page import="com.tim.hundreds.Photo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'photo.label', default: 'Photo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-photo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>

			</ul>
		</div>
		<div id="show-photo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<ul class="property-list photo">

				<g:if test="${photoInstance?.path}">
					<img class="img-responsive max300" src="${grailsApplication.config.base.photo.url}${photoInstance.path}" />
				</g:if>

				<g:if test="${photoInstance?.musician}">
					<li class="fieldcontain">
						<span id="musician-label" class="${session.labelWidth} property-label"><g:message code="photo.musician.label" default="Musician" /></span>

							<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" params="['uuid' : photoInstance?.musician?.uuid]">${photoInstance?.musician?.name?.encodeAsHTML()}</g:link></span>

					</li>
				</g:if>

				<g:if test="${photoInstance?.contact}">
					<li class="fieldcontain">
						<span id="contact-label" class="${session.labelWidth} property-label"><g:message code="photo.contact.label" default="Contact" /></span>

							<span class="property-value" aria-labelledby="contact-label"><g:link controller="contact" action="show" params="['uuid' : photoInstance?.contact?.uuid]">${photoInstance?.contact?.firstName?.encodeAsHTML()} ${photoInstance?.contact?.lastName?.encodeAsHTML()}</g:link></span>

					</li>
				</g:if>

			</ul>

			<sec:ifAnyGranted roles="ROLE_USER">
				<g:form url="[resource:photoInstance, action:'delete']" method="DELETE">
					<fieldset class="buttons">
						<g:link class="btn btn-primary edit" action="edit" params="['uuid' : photoInstance?.uuid]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
						<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</fieldset>
				</g:form>
			</sec:ifAnyGranted>
		</div>
	</body>
</html>
