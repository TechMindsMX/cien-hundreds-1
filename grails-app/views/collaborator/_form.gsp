<%@ page import="com.tim.hundreds.Collaborator" %>



<div class="form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'firstName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="firstName">
		<g:message code="collaborator.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="firstName" id="firstName" maxlength="100" required="" value="${collaboratorInstance?.firstName}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'middleName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="middleName">
		<g:message code="collaborator.middleName.label" default="Middle Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="middleName" id="middleName" maxlength="100" required="" value="${collaboratorInstance?.middleName}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'lastName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="lastName">
		<g:message code="collaborator.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="lastName" id="lastName" maxlength="100" required="" value="${collaboratorInstance?.lastName}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'position', 'error')} required">
	<label class="${session.labelWidth} control-label" for="position">
		<g:message code="collaborator.position.label" default="Position" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="position" id="position" maxlength="100" required="" value="${collaboratorInstance?.position}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'notes', 'error')} ">
	<label class="${session.labelWidth} control-label" for="notes">
		<g:message code="collaborator.notes.label" default="Notes" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="notes" id="notes" cols="40" rows="5" maxlength="10000" value="${collaboratorInstance?.notes}"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'company', 'error')} required">
	<label class="${session.labelWidth} control-label" for="company">
		<g:message code="collaborator.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionKey="id" required="" value="${collaboratorInstance?.company?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'collaboratorEmails', 'error')} ">
	<label class="${session.labelWidth} control-label" for="collaboratorEmails">
		<g:message code="collaborator.collaboratorEmails.label" default="collaboratorEmails" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:select name="collaboratorEmails" id="collaboratorEmails" from="${com.tim.hundreds.CollaboratorEmail.list()}" multiple="multiple" optionKey="id" size="5" value="${collaboratorInstance?.collaboratorEmails*.id}" class="form-control one-to-many"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'collaboratorTelephones', 'error')} ">
	<label class="${session.labelWidth} control-label" for="collaboratorTelephones">
		<g:message code="collaborator.collaboratorTelephones.label" default="collaboratorTelephones" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:select name="collaboratorTelephones" id="collaboratorTelephones" from="${com.tim.hundreds.CollaboratorTelephone.list()}" multiple="multiple" optionKey="id" size="5" value="${collaboratorInstance?.collaboratorTelephones*.id}" class="form-control one-to-many"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="collaborator.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" id="uuid" required="" value="${collaboratorInstance?.uuid}"/>

		</div>
</div>

