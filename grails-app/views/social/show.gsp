
<%@ page import="com.tim.hundreds.Social" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'social.label', default: 'Social')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-social" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-social" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list social">
			
				<g:if test="${socialInstance?.facebook}">
				<li class="fieldcontain">
					<span id="facebook-label" class="property-label"><g:message code="social.facebook.label" default="Facebook" /></span>
					
						<span class="property-value" aria-labelledby="facebook-label"><g:fieldValue bean="${socialInstance}" field="facebook"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socialInstance?.twitter}">
				<li class="fieldcontain">
					<span id="twitter-label" class="property-label"><g:message code="social.twitter.label" default="Twitter" /></span>
					
						<span class="property-value" aria-labelledby="twitter-label"><g:fieldValue bean="${socialInstance}" field="twitter"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socialInstance?.googlePlus}">
				<li class="fieldcontain">
					<span id="googlePlus-label" class="property-label"><g:message code="social.googlePlus.label" default="Google Plus" /></span>
					
						<span class="property-value" aria-labelledby="googlePlus-label"><g:fieldValue bean="${socialInstance}" field="googlePlus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socialInstance?.instagram}">
				<li class="fieldcontain">
					<span id="instagram-label" class="property-label"><g:message code="social.instagram.label" default="Instagram" /></span>
					
						<span class="property-value" aria-labelledby="instagram-label"><g:fieldValue bean="${socialInstance}" field="instagram"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socialInstance?.youtube}">
				<li class="fieldcontain">
					<span id="youtube-label" class="property-label"><g:message code="social.youtube.label" default="Youtube" /></span>
					
						<span class="property-value" aria-labelledby="youtube-label"><g:fieldValue bean="${socialInstance}" field="youtube"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socialInstance?.linkedin}">
				<li class="fieldcontain">
					<span id="linkedin-label" class="property-label"><g:message code="social.linkedin.label" default="Linkedin" /></span>
					
						<span class="property-value" aria-labelledby="linkedin-label"><g:fieldValue bean="${socialInstance}" field="linkedin"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socialInstance?.other}">
				<li class="fieldcontain">
					<span id="other-label" class="property-label"><g:message code="social.other.label" default="Other" /></span>
					
						<span class="property-value" aria-labelledby="other-label"><g:fieldValue bean="${socialInstance}" field="other"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socialInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="property-label"><g:message code="social.musician.label" default="Musician" /></span>
					
						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" id="${socialInstance?.musician?.id}">${socialInstance?.musician?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:socialInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${socialInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
