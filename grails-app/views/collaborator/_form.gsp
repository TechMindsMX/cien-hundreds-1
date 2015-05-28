<%@ page import="com.tim.hundreds.Collaborator" %>



<div class="fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="collaborator.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" maxlength="100" required="" value="${collaboratorInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'middleName', 'error')} required">
	<label for="middleName">
		<g:message code="collaborator.middleName.label" default="Middle Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="middleName" maxlength="100" required="" value="${collaboratorInstance?.middleName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="collaborator.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" maxlength="100" required="" value="${collaboratorInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="collaborator.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="1000" value="${collaboratorInstance?.notes}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'company', 'error')} required">
	<label for="company">
		<g:message code="collaborator.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionKey="id" required="" value="${collaboratorInstance?.company?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'emails', 'error')} ">
	<label for="emails">
		<g:message code="collaborator.emails.label" default="Emails" />
		
	</label>
	<g:select name="emails" from="${com.tim.hundreds.Email.list()}" multiple="multiple" optionKey="id" size="5" value="${collaboratorInstance?.emails*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'position', 'error')} required">
	<label for="position">
		<g:message code="collaborator.position.label" default="Position" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="position" required="" value="${collaboratorInstance?.position}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'telephones', 'error')} ">
	<label for="telephones">
		<g:message code="collaborator.telephones.label" default="Telephones" />
		
	</label>
	<g:select name="telephones" from="${com.tim.hundreds.Telephone.list()}" multiple="multiple" optionKey="id" size="5" value="${collaboratorInstance?.telephones*.id}" class="many-to-many"/>

</div>

