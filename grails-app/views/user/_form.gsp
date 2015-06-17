<%@ page import="com.tim.hundreds.Role" %>

<h1>FACILITATOR</h1>
<h4>Datos de Ingreso</h4>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'username', 'error')} required">
	<label class="${session.labelWidth} control-label" for="username">Usuario</label>

    <div class="${session.inputWidth}">
        <g:textField name="username" class="form-control" placeholder="Ingrese su nombre de Usuario" size="46" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'password', 'error')} required">
	<label class="${session.labelWidth} control-label" for="password">Contraseña</label>

    <div class="${session.inputWidth}">
        <g:passwordField name="password" class="form-control" placeholder="Ingrese una contraseña" />                                       
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'passwordCheck', 'error')} required">
	<label class="${session.labelWidth} control-label" for="passwordCheck">Confirme su contraseña</label>

    <div class="${session.inputWidth}">
        <g:passwordField name="passwordCheck" class="form-control" placeholder="Ingrese nuevamente la contraseña" />
    </div>
</div>

<h4>Datos de contacto</h4>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'firstName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="firstName">Nombre(s)</label>

    <div class="${session.inputWidth}">
        <g:textField name="firstName" class="form-control" placeholder="Ingrese su(s) nombre(s)" size="60"/>                                       
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'middleName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="middleName">Apellido paterno</label>

    <div class="${session.inputWidth}">
        <g:textField name="middleName" class="form-control" placeholder="Ingrese su apellido paterno" />                                        
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'lastName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="lastName">Apellido materno</label>

    <div class="${session.inputWidth}">
        <g:textField name="lastName" class="form-control" placeholder="Ingrese su apellido materno" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'phone', 'error')} required">
	<label class="${session.labelWidth} control-label" for="phone">Teléfono</label>

    <div class="${session.inputWidth}">
        <g:textField name="phone" class="form-control" placeholder="Ingrese su número telefónico (10 dígitos)" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'email', 'error')} required">
	<label class="${session.labelWidth} control-label" for="email">Correo electrónico</label>

    <div class="${session.inputWidth}">
        <g:textField name="email" class="form-control" placeholder="Ingrese su correo electrónico"/>                                       
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'emailCheck', 'error')} required">
	<label class="${session.labelWidth} control-label" for="emailCheck">Confirme su correo electrónico</label>

    <div class="${session.inputWidth}">
        <g:textField name="emailCheck" class="form-control" placeholder="Ingrese nuevamente su correo electrónico"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'role', 'error')} required">
	<label class="${session.labelWidth} control-label" for="role">Tipo de Alta</label>

    <div class="${session.inputWidth}">
        <g:select name="role" from="${Role.findAll()}" optionKey="authority" optionValue="authority" class="form-control"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'photo', 'error')} required">
	<label class="${session.labelWidth} control-label" for="photo">Foto(png):</label>

    <div class="${session.inputWidth}">
        <input type='file' name='photo' class="form-control" placeholder="Ingrese una foto con formato png"/>                                       
    </div>
</div>

    <div class="form-group fieldcontain ${hasErrors(bean: entity, field: 'resume', 'error')} required">
       <label class="${session.labelWidth} control-label" for="resume">Curriculum Personal(pdf):</label>

       <div class="${session.inputWidth}">
        <input type='file' name='resume' class="form-control" placeholder="Ingrese un archivo PDF"/>
    </div>
</div>
