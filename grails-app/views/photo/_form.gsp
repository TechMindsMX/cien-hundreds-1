<%@ page import="com.tim.hundreds.Photo" %>



<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'path', 'error')} required">
	<label for="path">
		<g:message code="photo.path.label" default="Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="path" cols="40" rows="5" maxlength="255" required="" value="${photoInstance?.path}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="photo.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${photoInstance?.musician?.id}" class="many-to-one"/>

</div>

