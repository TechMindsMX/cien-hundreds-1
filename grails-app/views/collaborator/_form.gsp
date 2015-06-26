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

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'emails', 'error')} ">
	<label class="${session.labelWidth} control-label" for="emails">
		<g:message code="collaborator.emails.label" default="Emails" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:select name="emails" id="emails" from="${com.tim.hundreds.Email.list()}" multiple="multiple" optionKey="id" size="5" value="${collaboratorInstance?.emails*.id}" class="form-control many-to-many"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'telephones', 'error')} ">
	<label class="${session.labelWidth} control-label" for="telephones">
		<g:message code="collaborator.telephones.label" default="Telephones" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:select name="telephones" id="telephones" from="${com.tim.hundreds.Telephone.list()}" multiple="multiple" optionKey="id" size="5" value="${collaboratorInstance?.telephones*.id}" class="form-control many-to-many"/>

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

