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

<div class="form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'lastName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="lastName">
		<g:message code="collaborator.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="lastName" id="lastName" maxlength="100" required="" value="${collaboratorInstance?.lastName}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: collaboratorInstance, field: 'motherLastName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="motherLastName">
		<g:message code="collaborator.motherLastName.label" default="Middle Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="motherLastName" id="motherLastName" maxlength="100" required="" value="${collaboratorInstance?.motherLastName}"/>

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

<g:hiddenField id="uuid" name="uuid" value="${collaboratorInstance?.uuid}" class="form-control" />
<g:hiddenField id="companyUuid" name="companyUuid" value="${collaboratorInstance?.company?.uuid}" class="form-control many-to-one" />