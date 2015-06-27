<%@ page import="com.tim.hundreds.Role" %>

<h4>Datos de Ingreso</h4>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'username', 'error')} required">
	<label class="${session.labelWidth} control-label" for="username">Usuario<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${command?.username}" name="username" class="form-control" size="46" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'password', 'error')} required">
	<label class="${session.labelWidth} control-label" for="password">Contraseña<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:passwordField name="password" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'passwordCheck', 'error')} required">
	<label class="${session.labelWidth} control-label" for="passwordCheck">Confirme su contraseña<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:passwordField name="passwordCheck" class="form-control" />
    </div>
</div>

<h4>Datos de contacto</h4>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'firstName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="firstName">Nombre(s)<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${command?.firstName}" name="firstName" class="form-control" size="60"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'middleName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="middleName">Apellido paterno<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${command?.middleName}" name="middleName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'lastName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="lastName">Apellido materno<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${command?.lastName}" name="lastName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'phone', 'error')} required">
	<label class="${session.labelWidth} control-label" for="phone">Teléfono</label>

    <div class="${session.inputWidth}">
        <g:textField value="${command?.phone}" name="phone" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'email', 'error')} required">
	<label class="${session.labelWidth} control-label" for="email">Correo electrónico<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${command?.email}" name="email" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'emailCheck', 'error')} required">
	<label class="${session.labelWidth} control-label" for="emailCheck">Confirme su correo electrónico<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:textField value="${command?.emailCheck}" name="emailCheck" class="form-control" />
    </div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: command, field: 'role', 'error')} required">
	<label class="${session.labelWidth} control-label" for="role">Tipo de Alta<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
      <g:select value="${command?.role}" name="role" from="${Role.findAll()}" optionKey="authority" optionValue="authority" class="form-control"/>
    </div>
</div>

<g:if test="${command?.hasProperty('photo')}">
    <div class="form-group fieldcontain ${hasErrors(bean: command, field: 'photo', 'error')} required">
    	<label class="${session.labelWidth} control-label" for="photo">Foto(png):</label>

        <div class="${session.inputWidth}">
            <input value="${command?.photo}" type='file' name='photo' class="form-control" />
        </div>
    </div>
</g:if>

<g:if test="${command?.hasProperty('resume')}">
    <div class="form-group fieldcontain ${hasErrors(bean: command, field: 'resume', 'error')} required">
       <label class="${session.labelWidth} control-label" for="resume">Curriculum Personal(pdf):</label>

       <div class="${session.inputWidth}">
            <input value="${command?.resume}" type='file' name='resume' class="form-control" />
        </div>
    </div>
</g:if>

<div class="form-group fieldcontain ${hasErrors(bean: command, field: 'role', 'terms')} required">
    <div class="${session.inputWidth} ${session.btnOffset}">
        <input id="terms" type="checkbox" name="terms">&nbsp;Acepto los <a class="" data-toggle="modal" data-target="#terms_modal">Términos y condiciones</a>
    <div>
</div>
