<%@ page import="com.tim.hundreds.Email" %>



<div class="form-group fieldcontain ${hasErrors(bean: emailInstance, field: 'address', 'error')} required">
	<label class="${session.labelWidth} control-label" for="address">
		<g:message code="email.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:field class="form-control" type="email" name="address" id="address" maxlength="200" required="" value="${emailInstance?.address}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: emailInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="email.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="type" from="${com.tim.hundreds.EmailType?.values()}" keys="${com.tim.hundreds.EmailType.values()*.name()}" required="" value="${emailInstance?.type?.name()}" />

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: emailInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="email.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" id="uuid" required="" value="${emailInstance?.uuid}"/>

		</div>
</div>

