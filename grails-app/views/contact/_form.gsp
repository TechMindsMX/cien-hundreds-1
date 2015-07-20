<%@ page import="com.tim.hundreds.Contact" %>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'firstName', 'error')} required">
  <label class="${session.labelWidth} control-label" for="firstName">
    <g:message code="contact.firstName.label" default="First Name" />
    <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <g:textField class="form-control" name="firstName" maxlength="100" required="" value="${contactInstance?.firstName}"/>
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'lastName', 'error')} required">
  <label class="${session.labelWidth} control-label" for="lastName">
    <g:message code="contact.lastName.label" default="Last Name" />
    <span class="required-indicator">*</span>
    </label>
  <div class="${session.inputWidth}">
    <g:textField class="form-control" name="lastName" maxlength="100" required="" value="${contactInstance?.lastName}"/>
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'motherLastName', 'error')} required">
  <label class="${session.labelWidth} control-label" for="motherLastName">
    <g:message code="contact.motherLastName.label" default="Mother Last Name" />
    <span class="required-indicator">*</span>
    </label>
  <div class="${session.inputWidth}">
    <g:textField class="form-control" name="motherLastName" maxlength="100" required="" value="${contactInstance?.motherLastName}"/>
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'other', 'error')} ">
  <label class="${session.labelWidth} control-label" for="other">
    <g:message code="contact.other.label" default="Other" />
  </label>
  <div class="${session.inputWidth}">
    <g:textField class="form-control" name="other" maxlength="50" value="${contactInstance?.other}"/>
  </div>
</div>


<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'nationality', 'error')} ">
  <label class="${session.labelWidth} control-label" for="nationality">
    <g:message code="contact.nationality.label" default="Nationality" />
  </label>
  <div class="${session.inputWidth}">
    <g:countrySelect name="nationality" value="${contactInstance?.nationality}" noSelection="['':'-Seleccione-']" class="form-control" />
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'telefono', 'error')} required">
  <label class="${session.labelWidth} control-label" for="telefono">
    <g:message code="contact.telefono.label" default="Telephone" />
    <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <input type="tel" class="form-control" name="telefono" required="" value="${contactInstance?.telefono}"/>
  </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'email', 'error')} required">
  <label class="${session.labelWidth} control-label" for="email">
    <g:message code="contact.email.label" default="Email" />
    <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <input type="email" class="form-control" name="email" value="${contactInstance?.email}">
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'biography', 'error')} ">
  <label class="${session.labelWidth} control-label" for="biography">
    <g:message code="contact.biography.label" default="Biography" />
  </label>
  <div class="${session.inputWidth}">
    <g:textArea class="form-control" name="biography" cols="40" rows="5" maxlength="10000" value="${contactInstance?.biography}"/>
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'style', 'error')} ">
  <label class="${session.labelWidth} control-label" for="style">
    <g:message code="contact.style.label" default="Style" />
  </label>
  <div class="${session.inputWidth}">
    <g:textArea class="form-control" name="style" cols="40" rows="5" maxlength="10000" value="${contactInstance?.style}"/>
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'birthDate', 'error')} required">
  <label class="${session.labelWidth} control-label" for="birthDate">
    <g:message code="contact.birthDate.label" default="Birth Date" />
    <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <g:timDatePicker name="birthDate" minDate="-10Y" maxDate="-0D" value="${contactInstance?.birthDate}" required="true"></g:timDatePicker>
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'entryDate', 'error')} required" relativeYears="[-100..0]">
  <label class="${session.labelWidth} control-label" for="entryDate">
    <g:message code="contact.entryDate.label" default="Entry Date" />
    <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <g:timDatePicker name="entryDate" minDate="-10Y" maxDate="-0D" value="${contactInstance?.entryDate}" required="true"></g:timDatePicker>
  </div>
</div>


<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'role', 'error')} required">
  <label class="${session.labelWidth} control-label" for="role">
    <g:message code="contact.role.label" default="Role" />
    <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <g:select id="role" name="role.id" from="${com.tim.hundreds.MusicianRole.list()}" optionKey="id" optionValue="name" required="" value="${contactInstance?.role?.id}" class="form-control many-to-one"/>
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'type', 'error')} required">
  <label class="${session.labelWidth} control-label" for="type">
    <g:message code="contact.type.label" default="Type" />
    <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <g:select class="form-control" name="type" from="${com.tim.hundreds.GenderType?.values()}" keys="${com.tim.hundreds.GenderType.values()*.name()}" required="" value="${contactInstance?.type?.name()}" />
  </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'photoPath', 'error')} ">

  <label class="${session.labelWidth} control-label" for="photoPath">
    <g:message code="contact.photo.label" default="Photo" />
  </label>
  <div class="${session.inputWidth}">
      <input type="file" id="file" name="file" class="form-control" />
  </div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'musician', 'error')} required">
  <label class="${session.labelWidth} control-label" for="musician">
    <g:message code="contact.musician.label" default="Musician" />
    <span class="required-indicator">*</span>
  </label>
    <div class="${session.inputWidth}">
      <g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician?.list()}" optionKey="id" required="" value="${contactInstance?.musician?.id ?: params?.musician?.id}" class="form-control many-to-one"/>

    </div>
</div>
