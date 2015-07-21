<%@ page import="com.tim.hundreds.Telephone" %>

<div class="form-group fieldcontain ${hasErrors(bean: telephoneInstance, field: 'phone', 'error')} ">
	<label class="${session.labelWidth} control-label" for="phone">
		<g:message code="telephone.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="phone" maxlength="10" pattern="${new Telephone().constraints.phone.matches}" value="${telephoneInstance?.phone}" required="" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: telephoneInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="telephone.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:select class="form-control" name="phoneType" from="${com.tim.hundreds.TelephoneType?.values()}" keys="${com.tim.hundreds.TelephoneType.values()*.name()}" required="" value="${telephoneInstance?.phoneType?.name()}" />
	</div>
</div>

<g:hiddenField name="uuid" value="${telephoneInstance?.uuid}" />