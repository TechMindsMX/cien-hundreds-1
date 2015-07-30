
<%@ page import="com.tim.hundreds.Contact" %>
<%@ page import="com.tim.hundreds.ApplicationState" %>

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

    </ul>
  </div>
  <div id="show-contact" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>

  <div class="property-list contact">

    <g:if test="${contactInstance?.firstName}">
    <div class="fieldcontain">
      <span id="firstName-label" class="${session.labelWidth} property-label"><g:message code="contact.firstName.label" default="First Name" /></span>

      <span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${contactInstance}" field="firstName"/></span>

    </div>
  </g:if>

  <g:if test="${contactInstance?.lastName}">
  <div class="fieldcontain">
    <span id="lastName-label" class="${session.labelWidth} property-label"><g:message code="contact.lastName.label" default="Last Name" /></span>

    <span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${contactInstance}" field="lastName"/></span>

  </div>
</g:if>

<g:if test="${contactInstance?.motherLastName}">
<div class="fieldcontain">
  <span id="motherLastName-label" class="${session.labelWidth} property-label"><g:message code="contact.motherLastName.label" default="Middle Name" /></span>

  <span class="property-value" aria-labelledby="motherLastName-label"><g:fieldValue bean="${contactInstance}" field="motherLastName"/></span>

</div>
</g:if>

<g:if test="${contactInstance?.other}">
<div class="fieldcontain">
  <span id="other-label" class="${session.labelWidth} property-label"><g:message code="contact.other.label" default="Other" /></span>

  <span class="property-value" aria-labelledby="other-label"><g:fieldValue bean="${contactInstance}" field="other"/></span>

</div>
</g:if>

<g:if test="${contactInstance?.web}">
<div class="fieldcontain">
  <span id="web-label" class="${session.labelWidth} property-label"><g:message code="contact.web.label" default="Web" /></span>

  <span class="property-value" aria-labelledby="web-label"><g:fieldValue bean="${contactInstance}" field="web"/></span>

</div>
</g:if>

<g:if test="${contactInstance?.nationality}">
<div class="fieldcontain">
  <span id="nationality-label" class="${session.labelWidth} property-label"><g:message code="contact.nationality.label" default="Nationality" /></span>

  <span class="property-value" aria-labelledby="nationality-label"><g:country code="${contactInstance.nationality}" /></span>

</div>
</g:if>

<g:if test="${contactInstance?.biography}">
<div class="fieldcontain">
  <span id="biography-label" class="${session.labelWidth} property-label"><g:message code="contact.biography.label" default="Biography" /></span>

  <span class="property-value" aria-labelledby="biography-label"><g:fieldValue bean="${contactInstance}" field="biography"/></span>

</div>
</g:if>

<g:if test="${contactInstance?.style}">
<div class="fieldcontain">
  <span id="style-label" class="${session.labelWidth} property-label"><g:message code="contact.style.label" default="Style" /></span>

  <span class="property-value" aria-labelledby="style-label"><g:fieldValue bean="${contactInstance}" field="style"/></span>

</div>
</g:if>

<g:if test="${contactInstance?.photoPath}">
<div class="fieldcontain">
  <span id="photoPath-label" class="${session.labelWidth} property-label"><g:message code="contact.photo.label" default="Photo" /></span>

  <img class="img-responsive max300" src="${grailsApplication.config.base.photo.url}${contactInstance.photoPath}" />

</div>
</g:if>

<g:if test="${contactInstance?.social}">
<div class="fieldcontain">
  <span id="social-label" class="${session.labelWidth} property-label"><g:message code="social.label" default="Social" /></span>
  <span class="property-value" aria-labelledby="social-label"><g:link controller="social" action="show" id="${contactInstance?.social?.id}"><g:message code="default.show.label" args=" " /></g:link></span>

</div>
</g:if>

<g:if test="${contactInstance?.address}">
<div class="fieldcontain">
  <span id="address-label" class="${session.labelWidth} property-label"><g:message code="address.label" default="Address" /></span>

  <span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${contactInstance?.address?.id}"><g:message code="default.show.label" args=" " /></g:link></span>

</div>
</g:if>

<g:if test="${contactInstance?.birthDate}">
<div class="fieldcontain">
  <span id="birthDate-label" class="${session.labelWidth} property-label"><g:message code="contact.birthDate.label" default="Birth Date" /></span>

  <span class="property-value" aria-labelledby="birthDate-label"><g:formatDate format="dd-MM-yyyy"  date="${contactInstance?.birthDate}" /></span>

</div>
</g:if>

<g:if test="${contactInstance?.emails}">
<div class="fieldcontain">
  <span id="emails-label" class="${session.labelWidth} property-label"><g:message code="contact.emails.label" default="Emails" /></span>
  <g:each in="${contactInstance.emails}" var="e">
  <span class="property-value" aria-labelledby="emails-label"><g:link controller="email" action="show" id="${e.id}">${e?.mail?.encodeAsHTML()}</g:link></span>
</g:each>

</div>
</g:if>

<g:if test="${contactInstance?.entryDate}">
<div class="fieldcontain">
  <span id="entryDate-label" class="${session.labelWidth} property-label"><g:message code="contact.entryDate.label" default="Entry Date" /></span>

  <span class="property-value" aria-labelledby="entryDate-label"><g:formatDate format="dd-MM-yyyy"  date="${contactInstance?.entryDate}" /></span>

</div>
</g:if>

<g:if test="${contactInstance?.role}">
<div class="fieldcontain">
  <span id="role-label" class="${session.labelWidth} property-label"><g:message code="contact.role.label" default="Role" /></span>

  <span class="property-value" aria-labelledby="role-label"><g:fieldValue bean="${contactInstance}" field="role.name"/></span>

</div>
</g:if>

<g:if test="${contactInstance?.telephones}">
<div class="fieldcontain">
  <span id="telephones-label" class="${session.labelWidth} property-label"><g:message code="contact.telephones.label" default="Telephones" /></span>

  <g:each in="${contactInstance.telephones}" var="t">
  <span class="property-value" aria-labelledby="telephones-label"><g:link controller="telephone" action="show" id="${t.id}">${t?.phone.encodeAsHTML()}</g:link></span>
</g:each>

</div>
</g:if>

<g:if test="${contactInstance?.type}">
<div class="fieldcontain">
  <span id="type-label" class="${session.labelWidth} property-label"><g:message code="contact.type.label" default="Type" /></span>

  <span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${contactInstance}" field="type"/></span>

</div>
</g:if>

<g:if test="${contactInstance?.musician}">
<div class="fieldcontain">
  <span id="musician-label" class="${session.labelWidth} property-label"><g:message code="musician.label" default="Musician" /></span>

  <span class="property-value" aria-labelledby="musician-label"><g:link controller="musician" action="show" id="${contactInstance?.musician?.id}">${contactInstance?.musician?.name.encodeAsHTML()}</g:link></span>

</div>
</g:if>

<sec:ifAnyGranted roles="ROLE_USER">
  <g:if test="${contactInstance.address == null}">
  <div>
    <g:link controller="address" action="create" params="['contact.id': contactInstance.id]">${message(code: 'default.add.label', args: [message(code: 'address.label')])}</g:link>
  </div>
  </g:if>

  <g:if test="${!contactInstance?.social}">
  <div>
    <g:link controller="social" action="create" params="['contactUuid': contactInstance.uuid, 'contact.id': contactInstance.id]">${message(code: 'default.add.label', args: [message(code: 'social.label')])}</g:link>
  </div>
  </g:if>

  <g:if test="${!contactInstance.telephones || contactInstance.telephones?.size() < ApplicationState.MAX_TELEPHONES}">
  <div>
    <g:link controller="contact" action="prepareTelephone" params="[contactUuid: contactInstance?.uuid]">${message(code: 'default.add.label', args: [message(code: 'telephone.label')])}</g:link>
  </div>
  </g:if>

  <g:if test="${!contactInstance.emails || contactInstance.emails?.size() < ApplicationState.MAX_EMAILS}">
  <div>
    <g:link controller="contact" action="prepareEmail" params="[contactUuid: contactInstance?.uuid]">${message(code: 'default.add.label', args: [message(code: 'email.label')])}</g:link>
  </div>
  </g:if>

  </div>
  <g:form url="[resource:contactInstance, action:'delete']" method="DELETE">
  <fieldset class="buttons">
    <g:link class="btn btn-primary edit" action="edit" resource="${contactInstance}" params="['musician.id': musicianInstance?.id]" ><g:message code="default.button.edit.label" default="Edit" /></g:link>
    <g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
  </fieldset>
  </g:form>
</sec:ifAnyGranted>
</div>
</body>
</html>
