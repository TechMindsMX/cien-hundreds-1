<%@ page import="com.tim.hundreds.CollaboratorEmail" %>



<div class="form-group fieldcontain ${hasErrors(bean: collaboratorEmailInstance, field: 'address', 'error')} required">
	<label class="${session.labelWidth} control-label" for="address">
		<g:message code="email.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:field class="form-control" type="email" name="address" id="address" maxlength="200" required="" value="${collaboratorEmailInstance?.address}"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorEmailInstance, field: 'collaborator', 'error')} required">
	<label class="${session.labelWidth} control-label" for="collaborator">
		<g:message code="collaboratorEmail.collaborator.label" default="Collaborator" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="collaborator" name="collaborator.id" from="${com.tim.hundreds.Collaborator.list()}" optionKey="id" required="" value="${collaboratorEmailInstance?.collaborator?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: collaboratorEmailInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="email.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="type" from="${com.tim.hundreds.EmailType?.values()}" keys="${com.tim.hundreds.EmailType.values()*.name()}" required="" value="${collaboratorEmailInstance?.type?.name()}" />

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorEmailInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="collaboratorEmail.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" id="uuid" required="" value="${collaboratorEmailInstance?.uuid}"/>

		</div>
</div>

