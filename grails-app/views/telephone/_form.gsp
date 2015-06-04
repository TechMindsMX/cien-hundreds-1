<%@ page import="com.tim.hundreds.Telephone" %>



<div class="fieldcontain ${hasErrors(bean: telephoneInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="telephone.phone.label" default="Phone" />

	</label>
	<g:textField name="phone" maxlength="10" pattern="${telephoneInstance.constraints.phone.matches}" value="${telephoneInstance?.phone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: telephoneInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="telephone.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${com.tim.hundreds.TelephoneType?.values()}" keys="${com.tim.hundreds.TelephoneType.values()*.name()}" required="" value="${telephoneInstance?.type?.name()}" />

</div>

<g:hiddenField name="contactId" value="${params?.contactId}"/>
