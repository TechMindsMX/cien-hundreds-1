<%@ page import="com.tim.hundreds.MusicianRole" %>



<div class="form-group fieldcontain ${hasErrors(bean: musicianRoleInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="musicianRole.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="name" maxlength="50" required="" value="${musicianRoleInstance?.name}"/>

		</div>
</div>

