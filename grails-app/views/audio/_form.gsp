<%@ page import="com.tim.hundreds.Audio" %>



<div class="fieldcontain ${hasErrors(bean: audioInstance, field: 'path', 'error')} required">
	<label for="path">
		<g:message code="audio.path.label" default="Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="path" cols="40" rows="5" maxlength="255" required="" value="${audioInstance?.path}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: audioInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="audio.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${audioInstance?.musician?.id}" class="many-to-one"/>

</div>

