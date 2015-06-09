<%@ page import="com.tim.hundreds.Video" %>



<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'url', 'error')} required">
	<label for="url">
		<g:message code="video.url.label" default="Url" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="url" maxlength="100" required="" value="${videoInstance?.url}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="video.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${videoInstance?.musician?.id}" class="many-to-one"/>

</div>

