<%@ page import="com.tim.hundreds.Role" %>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'status', 'error')} required">
    <label class="${session.labelWidth} control-label" for="status"><g:message code="status.label" default="Estado"/></label>

    <div class="${session.inputWidth}">
        <g:select value="${model?.status}" name="status" class="form-control" from="${['true': 'Hablilitado', 'false': 'Deshabilitado']}" optionKey="key" optionValue="value" />
    </div>
</div>

<h4>Datos de Ingreso</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'username', 'error')} required">
    <label class="${session.labelWidth} control-label" for="username"><g:message code="facilitator.username.label" default="Usuario"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.username}" name="username" class="form-control" size="46"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'password', 'error')} required">
    <label class="${session.labelWidth} control-label" for="password"><g:message code="facilitator.password.label" default="Contraseña"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:passwordField name="password" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'passwordCheck', 'error')} required">
    <label class="${session.labelWidth} control-label" for="passwordCheck"><g:message code="facilitator.passwordCheck.label" default="Confirme su contraseña"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:passwordField name="passwordCheck" class="form-control" />
    </div>
</div>

<h4>Datos de contacto</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'firstName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="firstName"><g:message code="firstName.label" default="Nombre(s)"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.firstName}" name="firstName" class="form-control" size="60"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'middleName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="middleName"><g:message code="middleName.label" default="Apellido paterno"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.middleName}" name="middleName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'lastName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="lastName"><g:message code="lastName.label" default="Apellido materno"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.lastName}" name="lastName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'phone', 'error')}">
    <label class="${session.labelWidth} control-label" for="phone"><g:message code="phone.label" default="Teléfono"/></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.phone}" name="phone" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'email', 'error')} required">
    <label class="${session.labelWidth} control-label" for="email"><g:message code="email.label" default="Correo electrónico"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.email}" name="email" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'emailCheck', 'error')} required">
    <label class="${session.labelWidth} control-label" for="emailCheck"><g:message code="facilitator.emailCheck.label" default="Confirme su correo electrónico"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.emailCheck}" name="emailCheck" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'role', 'error')} required">
    <label class="${session.labelWidth} control-label" for="role"><g:message code="facilitator.role.label" default="Tipo de Alta"/></label>

    <div class="${session.inputWidth}">
      <g:select value="${model?.role}" name="role" from="${Role.findAll({authority!='ROLE_USER' && authority!='ROLE_ADMIN'})}" optionKey="authority" optionValue="authority" class="form-control"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'photo', 'error')}">
    <label class="${session.labelWidth} control-label" for="photo"><g:message code="photo.label" default="Foto(png)"/></label>

      <div class="${session.inputWidth}">
          <input value="${model?.photoPath}" type='file' name='photo' class="form-control" />
      </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'resume', 'error')}">
    <label class="${session.labelWidth} control-label" for="resume"><g:message code="facilitator.resume.label" default="Curriculum Personal(pdf)"/></label>

     <div class="${session.inputWidth}">
          <input value="${model?.resumePath}" type='file' name='resume' class="form-control" />
      </div>
</div>

<g:hiddenField name="terms" value="on" />
