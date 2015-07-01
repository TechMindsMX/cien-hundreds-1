<%@ page import="com.tim.hundreds.ValidationMessage" %>



<div class="form-group fieldcontain ${hasErrors(bean: validationMessageInstance, field: 'message', 'error')} required">
	<label class="${session.labelWidth} control-label" for="message">
		<g:message code="validationMessage.message.label" default="Message" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="message" id="message" cols="40" rows="5" maxlength="10000" required="" value="${validationMessageInstance?.message}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: validationMessageInstance, field: 'musician', 'error')} required">
	<label class="${session.labelWidth} control-label" for="musician">
		<g:message code="validationMessage.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${validationMessageInstance?.musician?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: validationMessageInstance, field: 'user', 'error')} required">
	<label class="${session.labelWidth} control-label" for="user">
		<g:message code="validationMessage.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="user" name="user.id" from="${com.tim.hundreds.User.list()}" optionKey="id" required="" value="${validationMessageInstance?.user?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: validationMessageInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="validationMessage.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" id="uuid" required="" value="${validationMessageInstance?.uuid}"/>

		</div>
</div>

