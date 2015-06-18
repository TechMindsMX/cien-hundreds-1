<%@ page import="com.tim.hundreds.UserTelephone" %>



<div class="form-group fieldcontain ${hasErrors(bean: userTelephoneInstance, field: 'phone', 'error')} ">
	<label class="${session.labelWidth} control-label" for="phone">
		<g:message code="userTelephone.phone.label" default="Phone" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="phone" maxlength="10" value="${userTelephoneInstance?.phone}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userTelephoneInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="userTelephone.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="type" from="${com.tim.hundreds.TelephoneType?.values()}" keys="${com.tim.hundreds.TelephoneType.values()*.name()}" required="" value="${userTelephoneInstance?.type?.name()}" />

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userTelephoneInstance, field: 'user', 'error')} required">
	<label class="${session.labelWidth} control-label" for="user">
		<g:message code="userTelephone.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="user" name="user.id" from="${com.tim.hundreds.User.list()}" optionKey="id" required="" value="${userTelephoneInstance?.user?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userTelephoneInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="userTelephone.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" required="" value="${userTelephoneInstance?.uuid}"/>

		</div>
</div>

