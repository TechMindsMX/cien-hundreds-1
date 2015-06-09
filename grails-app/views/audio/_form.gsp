<%@ page import="com.tim.hundreds.Audio" %>



<div class="fieldcontain ${hasErrors(bean: audioInstance, field: 'url', 'error')} required">
	<label for="url">
		<g:message code="audio.url.label" default="Url" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="url" maxlength="100" required="" value="${audioInstance?.url}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: audioInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="audio.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${audioInstance?.musician?.id}" class="many-to-one"/>

</div>

