<%@ page import="com.tim.hundreds.Role" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'user.label', default: 'Usuario')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul class="nav nav-pills">
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="hide list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-user" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors>
            <div class="alert alert-danger">
                <ul class="errors" role="alert">
                <g:eachError var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </div>
        </g:hasErrors>
            <g:form id="userForm" url="[action:'statusUpdate']"  class="form-horizontal">
                <fieldset class="form">
                    <g:render template="formStatus" />
                </fieldset>
                <fieldset class="buttons">
                    <div class="${session.btnOffset}">
                        <g:submitButton name="save" class="btn btn-success statusUpdate" value="${message(code: 'default.button.update.label', default: 'Actualizar')}" />
                        <button class="btn btn-danger" type="reset"><g:message code="cancel.label" /></button>
                    </div>
                </fieldset>
            </g:form>
        </div>

    </body>
</html>
