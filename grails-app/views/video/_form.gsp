<%@ page import="com.tim.hundreds.Video" %>



<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'path', 'error')} required">
	<label for="path">
		<g:message code="video.path.label" default="Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="path" maxlength="100" required="" value="${videoInstance?.path}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="video.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${videoInstance?.musician?.id}" class="many-to-one"/>

</div>

