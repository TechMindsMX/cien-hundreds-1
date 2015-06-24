<%@ page import="com.tim.hundreds.Role" %>

<h4>Datos de Ingreso</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'username', 'error')} required">
    <label class="${session.labelWidth} control-label" for="username">Usuario<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.username}" name="username" class="form-control" placeholder="Ingrese su nombre de Usuario" size="46" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'password', 'error')} required">
    <label class="${session.labelWidth} control-label" for="password">Contraseña<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:passwordField name="password" class="form-control" placeholder="Ingrese una contraseña" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'passwordCheck', 'error')} required">
    <label class="${session.labelWidth} control-label" for="passwordCheck">Confirme su contraseña<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:passwordField name="passwordCheck" class="form-control" placeholder="Ingrese nuevamente la contraseña" />
    </div>
</div>

<h4>Datos de contacto</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'firstName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="firstName">Nombre(s)<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.firstName}" name="firstName" class="form-control" placeholder="Ingrese su(s) nombre(s)" size="60"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'middleName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="middleName">Apellido paterno<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.middleName}" name="middleName" class="form-control" placeholder="Ingrese su apellido paterno" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'lastName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="lastName">Apellido materno<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.lastName}" name="lastName" class="form-control" placeholder="Ingrese su apellido materno" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'phone', 'error')}">
    <label class="${session.labelWidth} control-label" for="phone">Teléfono</label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.phone}" name="phone" class="form-control" placeholder="Ingrese su número telefónico (10 dígitos)" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'email', 'error')} required">
    <label class="${session.labelWidth} control-label" for="email">Correo electrónico<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.email}" name="email" class="form-control" placeholder="Ingrese su correo electrónico"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'emailCheck', 'error')} required">
    <label class="${session.labelWidth} control-label" for="emailCheck">Confirme su correo electrónico<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.emailCheck}" name="emailCheck" class="form-control" placeholder="Ingrese nuevamente su correo electrónico"/>
    </div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: model, field: 'role', 'error')} required">
    <label class="${session.labelWidth} control-label" for="role">Tipo de Alta</label>

    <div class="${session.inputWidth}">
      <g:select value="${model?.role}" name="role" from="${Role.findAll{authority=='ROLE_FACILITATOR'}}" optionKey="authority" optionValue="authority" class="form-control"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'photo', 'error')}">
    <label class="${session.labelWidth} control-label" for="photo">Foto(png):</label>

      <div class="${session.inputWidth}">
          <input value="${model?.photoPath}" type='file' name='photo' class="form-control" placeholder="Ingrese una foto con formato png"/>
      </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'resume', 'error')}">
    <label class="${session.labelWidth} control-label" for="resume">Curriculum Personal(pdf):</label>

     <div class="${session.inputWidth}">
          <input value="${model?.resumePath}" type='file' name='resume' class="form-control" placeholder="Ingrese un archivo PDF"/>
      </div>
</div>

<g:hiddenField name="terms" value="on" />