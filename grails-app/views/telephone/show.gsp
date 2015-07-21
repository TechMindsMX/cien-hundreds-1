
<%@ page import="com.tim.hundreds.Telephone" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'telephone.label', default: 'Telephone')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
  </head>
  <body>
    <a href="#show-telephone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
      <ul class="nav nav-pills">
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        
      </ul>
    </div>
    <div id="show-telephone" class="content scaffold-show" role="main">
      <h1><g:message code="default.show.label" args="[entityName]" /></h1>
      <g:if test="${flash.message}">
      <div class="message" role="status">${flash.message}</div>
      </g:if>
      <ul class="property-list telephone">
      
        <g:if test="${telephoneInstance?.phone}">
        <li class="fieldcontain">
          <span id="phone-label" class="${session.labelWidth} property-label"><g:message code="telephone.phone.label" default="Phone" /></span>
          <span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${telephoneInstance}" field="phone"/></span>
        </li>
        </g:if>
      
        <g:if test="${telephoneInstance?.type}">
        <li class="fieldcontain">
          <span id="type-label" class="${session.labelWidth} property-label"><g:message code="telephone.type.label" default="Type" /></span>
          <span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${telephoneInstance}" field="phoneType"/></span>
        </li>
        </g:if>
      
      </ul>
      <g:form url="[resource:telephoneInstance, action:'delete']" method="DELETE">
        <fieldset class="buttons">
          <g:link class="btn btn-primary edit" action="edit" resource="${telephoneInstance}" params="[contactId: telephoneInstance.contact.id]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
          <g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
        </fieldset>
      </g:form>
    </div>
  </body>
</html>
