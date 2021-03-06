<%@ page import="com.tim.hundreds.Role" %>

<h4>Datos de Ingreso</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'username', 'error')} required">
	<label class="${session.labelWidth} control-label" for="username">Usuario<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${model?.username}" name="username" class="form-control" maxlength="46" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'password', 'error')} required">
	<label class="${session.labelWidth} control-label" for="password">Contraseña<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:passwordField name="password" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'passwordCheck', 'error')} required">
	<label class="${session.labelWidth} control-label" for="passwordCheck">Confirme su contraseña<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:passwordField name="passwordCheck" class="form-control" />
    </div>
</div>

<h4>Datos de contacto</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'firstName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="firstName">Nombre(s)<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${model?.firstName}" name="firstName" class="form-control" maxlength="60"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'lastName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="lastName"><g:message code="lastName.label" /><span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${model?.lastName}" name="lastName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'motherLastName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="motherLastName"><g:message code="motherLastName.label" /><span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${model?.motherLastName}" name="motherLastName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'phone', 'error')} required">
	<label class="${session.labelWidth} control-label" for="phone">Teléfono</label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.phone}" name="phone" class="form-control" maxlength="10" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'email', 'error')} required">
	<label class="${session.labelWidth} control-label" for="email">Correo electrónico<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${model?.email}" name="email" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'emailCheck', 'error')} required">
	<label class="${session.labelWidth} control-label" for="emailCheck">Confirme su correo electrónico<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="" name="emailCheck" class="form-control" />
    </div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: model, field: 'role', 'error')} required">
	<label class="${session.labelWidth} control-label" for="role">Tipo de Alta<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
      <g:select value="${model?.role}" name="role" from="${Role.findAll()}" optionKey="authority" optionValue="authority" class="form-control"/>
    </div>
</div>

<g:if test="${model?.hasProperty('photo')}">
    <div class="form-group fieldcontain ${hasErrors(bean: model, field: 'photo', 'error')} required">
    	<label class="${session.labelWidth} control-label" for="photo">Foto(png):</label>

        <div class="${session.inputWidth}">
            <input value="${model?.photo}" type='file' name='photo' class="form-control" />
        </div>
    </div>
</g:if>

<g:if test="${model?.hasProperty('resume')}">
    <div class="form-group fieldcontain ${hasErrors(bean: model, field: 'resume', 'error')} required">
       <label class="${session.labelWidth} control-label" for="resume">Curriculum Personal(pdf):</label>

       <div class="${session.inputWidth}">
            <input value="${model?.resume}" type='file' name='resume' class="form-control" />
        </div>
    </div>
</g:if>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'role', 'terms')} required">
    <div class="${session.inputWidth} ${session.btnOffset}">
        <input id="terms" type="checkbox" name="terms">&nbsp;Acepto los <a class="" data-toggle="modal" data-target="#terms_modal">Términos y condiciones</a>
    <div>
</div>

<g:hiddenField name="status" value="true" />
