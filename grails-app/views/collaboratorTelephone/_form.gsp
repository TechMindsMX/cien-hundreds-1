<%@ page import="com.tim.hundreds.CollaboratorTelephone" %>



<div class="form-group fieldcontain ${hasErrors(bean: collaboratorTelephoneInstance, field: 'phone', 'error')} ">
	<label class="${session.labelWidth} control-label" for="phone">
		<g:message code="telephone.label" default="Phone" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="phone" id="phone" maxlength="10" pattern="${collaboratorTelephoneInstance?.constraints?.phone?.matches}" value="${collaboratorTelephoneInstance?.phone}"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorTelephoneInstance, field: 'collaborator', 'error')} required">
	<label class="${session.labelWidth} control-label" for="collaborator">
		<g:message code="collaboratorTelephone.collaborator.label" default="Collaborator" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="collaborator" name="collaborator.id" from="${com.tim.hundreds.Collaborator.list()}" optionKey="id" required="" value="${collaboratorTelephoneInstance?.collaborator?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: collaboratorTelephoneInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="type" from="${com.tim.hundreds.TelephoneType?.values()}" keys="${com.tim.hundreds.TelephoneType.values()*.name()}" required="" value="${collaboratorTelephoneInstance?.type?.name()}" />

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: collaboratorTelephoneInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="collaboratorTelephone.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" id="uuid" required="" value="${collaboratorTelephoneInstance?.uuid}"/>

		</div>
</div>

