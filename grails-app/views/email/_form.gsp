<%@ page import="com.tim.hundreds.Email" %>

<div class="form-group fieldcontain ${hasErrors(bean: emailInstance, field: 'address', 'error')} required">
	<label class="${session.labelWidth} control-label" for="address">
		<g:message code="email.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
  		<g:field type="email" name="address" maxlength="200" required="" value="${emailInstance?.address}"/>
	</div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: emailInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="email.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
  	<div class="${session.inputWidth}">
		<g:select name="type" from="${com.tim.hundreds.EmailType?.values()}" keys="${com.tim.hundreds.EmailType.values()*.name()}" required="" value="${emailInstance?.type?.name()}" />
	</div>
</div>

<g:hiddenField name="contact.id" value="${emailInstance?.contact?.id}" />
<g:hiddenField name="uuid" value="${emailInstance?.uuid}" />

<div class="form-group fieldcontain ${hasErrors(bean: emailInstance, field: 'contact', 'error')} required">
	<label class="${session.labelWidth} control-label" for="contact">
		<g:message code="email.contact.label" default="Contact" />
		<span class="required-indicator">*</span>
	</label>
		<g:select id="contact" name="contact.id" from="${com.tim.hundreds.Contact.list()}" optionKey="id" required="" value="${emailInstance?.contact?.id}" class="many-to-one"/>

</div>


<div class="form-group fieldcontain ${hasErrors(bean: emailInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="email.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="uuid" required="" value="${emailInstance?.uuid}"/>

</div>

