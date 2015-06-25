<%@ page import="com.tim.hundreds.BusinessActivity" %>



<div class="form-group fieldcontain ${hasErrors(bean: businessActivityInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="businessActivity.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="name" maxlength="50" required="" value="${businessActivityInstance?.name}"/>

		</div>
</div>

