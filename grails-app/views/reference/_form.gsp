<%@ page import="com.tim.hundreds.Reference" %>



<div class="fieldcontain ${hasErrors(bean: referenceInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="reference.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${referenceInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: referenceInstance, field: 'contactName', 'error')} required">
	<label for="contactName">
		<g:message code="reference.contactName.label" default="Contact Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="contactName" maxlength="100" required="" value="${referenceInstance?.contactName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: referenceInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="reference.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" maxlength="200" required="" value="${referenceInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: referenceInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="reference.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" maxlength="10" pattern="${referenceInstance.constraints.phone.matches}" value="${referenceInstance?.phone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: referenceInstance, field: 'company', 'error')} required">
	<label for="company">
		<g:message code="reference.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionKey="id" required="" value="${referenceInstance?.company?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: referenceInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="reference.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${com.tim.hundreds.ActivityType?.values()}" keys="${com.tim.hundreds.ActivityType.values()*.name()}" required="" value="${referenceInstance?.type?.name()}" />

</div>

