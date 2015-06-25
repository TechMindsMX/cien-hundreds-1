<%@ page import="com.tim.hundreds.Genre" %>



<div class="form-group fieldcontain ${hasErrors(bean: genreInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="genre.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="name" maxlength="50" required="" value="${genreInstance?.name}"/>

		</div>
</div>

