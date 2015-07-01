<%@ page import="com.tim.hundreds.MusicianValidation" %>



<div class="form-group fieldcontain ${hasErrors(bean: musicianValidationInstance, field: 'message', 'error')} ">
	<label class="${session.labelWidth} control-label" for="message">
		<g:message code="musicianValidation.message.label" default="Message" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="message" id="message" cols="40" rows="5" maxlength="10000" value="${musicianValidationInstance?.message}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: musicianValidationInstance, field: 'musician', 'error')} required">
	<label class="${session.labelWidth} control-label" for="musician">
		<g:message code="musicianValidation.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${musicianValidationInstance?.musician?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: musicianValidationInstance, field: 'status', 'error')} ">
	<label class="${session.labelWidth} control-label" for="status">
		<g:message code="musicianValidation.status.label" default="Status" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:checkBox class="form-control" name="status" value="${musicianValidationInstance?.status}" />

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: musicianValidationInstance, field: 'user', 'error')} required">
	<label class="${session.labelWidth} control-label" for="user">
		<g:message code="musicianValidation.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="user" name="user.id" from="${com.tim.hundreds.User.list()}" optionKey="id" required="" value="${musicianValidationInstance?.user?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: musicianValidationInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="musicianValidation.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" id="uuid" required="" value="${musicianValidationInstance?.uuid}"/>

		</div>
</div>

