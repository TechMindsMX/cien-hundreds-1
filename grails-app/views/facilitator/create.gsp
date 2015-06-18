<%@ page import="com.tim.hundreds.Role" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'facilitator.label', default: 'Facilitator')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>

        <script type="text/javascript">
            jQuery(document).ready(function(){
                jQuery('#role').children('option[value="ROLE_ADMIN"]').hide();
                jQuery('#role').children('option[value="ROLE_USER"]').hide();
                jQuery('#role').append('<option style=" display: none;"  value="..." selected="selected" disabled="disabled">Selecciona una opcion...</option>');
                jQuery('#role option:contains("ROLE_FACILITATOR")').text('Facilitador');
                jQuery('#role option:contains("ROLE_BUYER")').text('Comprador');            
                });
        </script>

    </head>
    <body>
        <a href="#create-facilitator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul class="nav nav-pills">
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-facilitator" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${model}">
            <div class="alert alert-danger">
                <ul class="errors" role="alert">
                <g:eachError bean="${model}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </div>
        </g:hasErrors>
            <g:uploadForm url="[resource:model, action:'save']"  class="form-horizontal">
                <fieldset class="form">
                    <g:render template="form" model="[model:UserCommand]" />
                </fieldset>
                <fieldset class="buttons">
                    <div class="${session.btnOffset}">
                        <g:submitButton name="create" class="btn btn-success save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        <button class="btn btn-danger" type="reset"><g:message code="cancel.label" /></button>
                    </div>
                </fieldset>
            </g:uploadForm>
        </div>
    </body>
</html>
