<%@ page import="com.tim.hundreds.Role" %>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'status', 'error')} required">
    <label class="${session.labelWidth} control-label" for="status"><g:message code="status.label" default="Estado"/></label>

    <div class="${session.inputWidth}">
        <g:select value="${model?.status}" name="status" class="form-control" from="${['true': 'Hablilitado', 'false': 'Deshabilitado']}" optionKey="key" optionValue="value" />
    </div>
</div>

<h4>Datos de Ingreso</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'username', 'error')} required">
  <label class="${session.labelWidth} control-label" for="username">
    <g:message code="admin.username.label" default="Usuario"/><span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <g:textField value="${model?.username}" name="username" class="form-control" size="46"/>
  </div>
</div>

<g:if test="${!edit}">
  <div class="form-group fieldcontain ${hasErrors(bean: model, field: 'password', 'error')} ">
    <label class="${session.labelWidth} control-label" for="password">
      <g:message code="admin.password.label" default="Contraseña"/><span class="required-indicator">*</span>
    </label>
    <div class="${session.inputWidth}">
        <g:passwordField name="password" class="form-control" />
    </div>
  </div>
  <div class="form-group fieldcontain ${hasErrors(bean: model, field: 'passwordCheck', 'error')}">
      <label class="${session.labelWidth} control-label" for="passwordCheck"><g:message code="admin.passwordCheck.label" default="Confirme su contraseña"/><span class="required-indicator">*</span></label>

      <div class="${session.inputWidth}">
          <g:passwordField name="passwordCheck" class="form-control" />
      </div>
  </div>
</g:if>

<h4>Datos de contacto</h4>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'firstName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="firstName"><g:message code="firstName.label" default="Nombre(s)"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.firstName}" name="firstName" class="form-control" size="60"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'lastName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="lastName"><g:message code="lastName.label" default="Apellido materno"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.lastName}" name="lastName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'motherLastName', 'error')} required">
    <label class="${session.labelWidth} control-label" for="motherLastName"><g:message code="motherLastName.label" default="Apellido paterno"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.motherLastName}" name="motherLastName" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'phone', 'error')}">
    <label class="${session.labelWidth} control-label" for="phone"><g:message code="phone.label" default="Teléfono"/></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.phone}" name="phone" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'email', 'error')} required">
    <label class="${session.labelWidth} control-label" for="email"><g:message code="admin.email.label" default="Correo electrónico"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.email}" name="email" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'emailCheck', 'error')} required">
    <label class="${session.labelWidth} control-label" for="emailCheck"><g:message code="admin.emailCheck.label" default="Confirme su correo electrónico"/><span class="required-indicator">*</span></label>

    <div class="${session.inputWidth}">
        <g:textField value="${model?.email}" name="emailCheck" class="form-control" />
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'role', 'error')} required">
    <label class="${session.labelWidth} control-label" for="role"><g:message code="admin.role.label" default="Tipo de Alta"/></label>

    <div class="${session.inputWidth}">
      <g:select value="${model?.role}" name="role" from="${Role.findAll({authority!='ROLE_USER' && authority!='ROLE_ADMIN'})}" optionKey="authority" optionValue="authority" class="form-control"/>
    </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'photo', 'error')}">
    <label class="${session.labelWidth} control-label" for="photo"><g:message code="admin.photo.label" default="Foto(png)"/></label>

      <div class="${session.inputWidth}">
          <input value="${model?.photoPath}" type='file' name="photo" id="photo" class="form-control" />
      </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: model, field: 'resume', 'error')}">
    <label class="${session.labelWidth} control-label" for="resume"><g:message code="admin.resume.label" default="Curriculum Personal(pdf)"/></label>

     <div class="${session.inputWidth}">
          <input value="${model?.resumePath}" type='file' name="resume" id="resume" class="form-control" />
      </div>
</div>

<g:hiddenField name="terms" value="on" />
