<%@ page import="com.tim.hundreds.UserEmail" %>



<div class="form-group fieldcontain ${hasErrors(bean: userEmailInstance, field: 'address', 'error')} required">
	<label class="${session.labelWidth} control-label" for="address">
		<g:message code="userEmail.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:field class="form-control" type="email" name="address" maxlength="200" required="" value="${userEmailInstance?.address}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userEmailInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="userEmail.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="type" from="${com.tim.hundreds.EmailType?.values()}" keys="${com.tim.hundreds.EmailType.values()*.name()}" required="" value="${userEmailInstance?.type?.name()}" />

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userEmailInstance, field: 'user', 'error')} required">
	<label class="${session.labelWidth} control-label" for="user">
		<g:message code="userEmail.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="user" name="user.id" from="${com.tim.hundreds.User.list()}" optionKey="id" required="" value="${userEmailInstance?.user?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userEmailInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="userEmail.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" required="" value="${userEmailInstance?.uuid}"/>

		</div>
</div>

