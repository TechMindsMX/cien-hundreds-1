<%@ page import="com.tim.hundreds.Role" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'user.label', default: 'Usuario')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul class="nav nav-pills">
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="hide list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-user" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
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
            <g:form id="userForm" url="[resource:user, action:'save']"  class="form-horizontal">
                <fieldset class="form">
                    <g:render template="form" />
                </fieldset>
                <fieldset class="buttons">
                    <div class="${session.btnOffset}">
                        <g:submitButton name="create" class="btn btn-success save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        <button class="btn btn-danger" type="reset"><g:message code="cancel.label" /></button>
                    </div>
                </fieldset>
            </g:form>
        </div>

        <div id="terms_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title"><g:message code="terminos.title" /></h4>
                    </div>
                    <div class="modal-body">
                        <g:render template="terms" />
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
