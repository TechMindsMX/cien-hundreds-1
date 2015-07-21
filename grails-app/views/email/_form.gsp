<%@ page import="com.tim.hundreds.Email" %>



<div class="form-group required" >
	<label class="${session.labelWidth} control-label" for="address">
		<g:message code="email.address.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:field class="form-control" type="email" name="mail" id="mail" maxlength="200" required="" value="${emailInstance?.mail}"/>

		</div>
</div>

<div class="form-group required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="email.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="emailType" from="${com.tim.hundreds.EmailType?.values()}" keys="${com.tim.hundreds.EmailType.values()*.name()}" required="" value="${emailInstance?.emailType?.toString()}" />

		</div>
</div>

<g:hiddenField name="uuid" id="uuid" required="" value="${emailInstance?.uuid}"/>
