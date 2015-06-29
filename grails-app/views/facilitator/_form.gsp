<%@ page import="com.tim.hundreds.Role" %>

<h4>Datos de Ingreso</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'username', 'error')} required">
    <label class="${session.labelWidth} control-label" for="username">Usuario<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.username}" name="username" class="form-control" size="46"/>
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
        <g:textField value="${model?.firstName}" name="firstName" class="form-control" size="60"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'middleName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="middleName">Apellido paterno<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.middleName}" name="middleName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'lastName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="lastName">Apellido materno<span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.lastName}" name="lastName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'phone', 'error')}">
    <label class="${session.labelWidth} control-label" for="phone">Teléfono</label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.phone}" name="phone" class="form-control" />
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
        <g:textField value="${model?.emailCheck}" name="emailCheck" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'role', 'error')} required">
    <label class="${session.labelWidth} control-label" for="role">Tipo de Alta</label>

    <div class="${session.inputWidth}">
      <g:select value="${model?.role}" name="role" from="${Role.findAll({authority!='ROLE_USER' && authority!='ROLE_ADMIN'})}" optionKey="authority" optionValue="authority" class="form-control"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'photo', 'error')}">
    <label class="${session.labelWidth} control-label" for="photo">Foto(png):</label>

      <div class="${session.inputWidth}">
          <input value="${model?.photoPath}" type='file' name='photo' class="form-control" />
      </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'resume', 'error')}">
    <label class="${session.labelWidth} control-label" for="resume">Curriculum Personal(pdf):</label>

     <div class="${session.inputWidth}">
          <input value="${model?.resumePath}" type='file' name='resume' class="form-control" />
      </div>
</div>

<g:hiddenField name="terms" value="on" />
