
<%@ page import="com.tim.hundreds.Contact" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-contact" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-contact" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list contact">

				<g:if test="${contactInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="contact.firstName.label" default="First Name" /></span>

						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${contactInstance}" field="firstName"/></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="contact.lastName.label" default="Last Name" /></span>

						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${contactInstance}" field="lastName"/></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.motherLastName}">
				<li class="fieldcontain">
					<span id="motherLastName-label" class="property-label"><g:message code="contact.motherLastName.label" default="Middle Name" /></span>

						<span class="property-value" aria-labelledby="motherLastName-label"><g:fieldValue bean="${contactInstance}" field="motherLastName"/></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.other}">
				<li class="fieldcontain">
					<span id="other-label" class="property-label"><g:message code="contact.other.label" default="Other" /></span>

						<span class="property-value" aria-labelledby="other-label"><g:fieldValue bean="${contactInstance}" field="other"/></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.nationality}">
				<li class="fieldcontain">
					<span id="nationality-label" class="property-label"><g:message code="contact.nationality.label" default="Nationality" /></span>

						<span class="property-value" aria-labelledby="nationality-label"><g:country code="${contactInstance.nationality}" /></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.biography}">
				<li class="fieldcontain">
					<span id="biography-label" class="property-label"><g:message code="contact.biography.label" default="Biography" /></span>

						<span class="property-value" aria-labelledby="biography-label"><g:fieldValue bean="${contactInstance}" field="biography"/></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.style}">
				<li class="fieldcontain">
					<span id="style-label" class="property-label"><g:message code="contact.style.label" default="Style" /></span>

						<span class="property-value" aria-labelledby="style-label"><g:fieldValue bean="${contactInstance}" field="style"/></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.photoPath}">
				<li class="fieldcontain">
					<span id="photoPath-label" class="property-label"><g:message code="contact.photoPath.label" default="Photo Path" /></span>

						<span class="property-value" aria-labelledby="photoPath-label"><g:fieldValue bean="${contactInstance}" field="photoPath"/></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.social}">
				<li class="fieldcontain">
					<span id="social-label" class="property-label"><g:message code="contact.social.label" default="Social" /></span>

						<span class="property-value" aria-labelledby="social-label"><g:link controller="social" action="show" id="${contactInstance?.social?.id}">${contactInstance?.social?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="contact.address.label" default="Address" /></span>

						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${contactInstance?.address?.id}">${contactInstance?.address?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.birthDate}">
				<li class="fieldcontain">
					<span id="birthDate-label" class="property-label"><g:message code="contact.birthDate.label" default="Birth Date" /></span>

						<span class="property-value" aria-labelledby="birthDate-label"><g:formatDate date="${contactInstance?.birthDate}" /></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.emails}">
				<li class="fieldcontain">
					<span id="emails-label" class="property-label"><g:message code="contact.emails.label" default="Emails" /></span>

						<g:each in="${contactInstance.emails}" var="e">
						<span class="property-value" aria-labelledby="emails-label"><g:link controller="email" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${contactInstance?.entryDate}">
				<li class="fieldcontain">
					<span id="entryDate-label" class="property-label"><g:message code="contact.entryDate.label" default="Entry Date" /></span>

						<span class="property-value" aria-labelledby="entryDate-label"><g:formatDate date="${contactInstance?.entryDate}" /></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.musician}">
				<li class="fieldcontain">
					<span id="musician-label" class="property-label"><g:message code="contact.musician.label" default="Musician" /></span>

						<span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" id="${contactInstance?.musician?.id}">${contactInstance?.musician?.name}</g:link></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.role}">
				<li class="fieldcontain">
					<span id="role-label" class="property-label"><g:message code="contact.role.label" default="Role" /></span>

						<span class="property-value" aria-labelledby="role-label"><g:fieldValue bean="${contactInstance}" field="role"/></span>

				</li>
				</g:if>

				<g:if test="${contactInstance?.telephones}">
				<li class="fieldcontain">
					<span id="telephones-label" class="property-label"><g:message code="contact.telephones.label" default="Telephones" /></span>

						<g:each in="${contactInstance.telephones}" var="t">
						<span class="property-value" aria-labelledby="telephones-label"><g:link controller="telephone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${contactInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="contact.type.label" default="Type" /></span>

						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${contactInstance}" field="type"/></span>

				</li>
				</g:if>

        <g:if test="${contactInstance.address == null}">
          <li>
          <g:link controller="address" action="create" params='[contactUuid: "${contactInstance.uuid}"]'>Agregar Dirección</g:link>
          </li>
        </g:if>
        <g:if test="${contactInstance.social == null}">
         <li>
         <g:link controller="social" action="create" params='[contactId: "${contactInstance.id}"]'>Agregar Redes Sociales</g:link>
         </li>
        </g:if>
        <li>
          <g:link controller="telephone" action="create" params='[contactId: "${contactInstance.id}"]'>Agregar Teléfono</g:link>
        </li>
        <li>
          <g:link controller="email" action="create" params='[contactId: "${contactInstance.id}"]'>Agregar Email</g:link>
        </li>


			</ul>
			<g:form url="[resource:contactInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${contactInstance}" params='[musicianId: "${contactInstance.musician.id}"]'><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
