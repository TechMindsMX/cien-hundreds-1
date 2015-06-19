<%@ page import="com.tim.hundreds.Telephone" %>

<div class="form-group fieldcontain ${hasErrors(bean: telephoneInstance, field: 'phone', 'error')} ">
	<label class="${session.labelWidth} control-label" for="phone">
		<g:message code="telephone.phone.label" default="Phone" />
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="phone" maxlength="10" pattern="${telephoneInstance.constraints.phone.matches}" value="${telephoneInstance?.phone}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: telephoneInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="telephone.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:select class="form-control" name="type" from="${com.tim.hundreds.TelephoneType?.values()}" keys="${com.tim.hundreds.TelephoneType.values()*.name()}" required="" value="${telephoneInstance?.type?.name()}" />
	</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: emailInstance, field: 'contact', 'error')} required">
	<label class="${session.labelWidth} control-label" for="contact">
		<g:message code="email.contact.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:select class="form-control" name="contact.id" from="${com.tim.hundreds.Contact?.list()}" optionKey="id" required="" value="${emailInstance?.contact?.id}" />
	</div>
</div>

<g:hiddenField name="uuid" value="${telephoneInstance?.uuid}" />

