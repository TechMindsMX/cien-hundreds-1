<%@ page import="com.tim.hundreds.Audio" %>

<div class="form-group fieldcontain ${hasErrors(bean: audioInstance, field: 'url', 'error')} required">
	<label class="${session.labelWidth} control-label" for="url">
		<g:message code="audio.url.label" default="Url" />
		<span class="required-indicator">*</span>
	</label>

  <div class="${session.inputWidth}">
	<g:textField class="form-control" name="url" maxlength="100" required="" value="${audioInstance?.url}"/>
  </div>

</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: audioInstance, field: 'musician', 'error')} required">
	<label class="${session.labelWidth} control-label" for="musician">
		<g:message code="audio.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician?.list()}" optionKey="id" required="" value="${audioInstance?.musician?.id}" class="form-control many-to-one"/>

		</div>
</div>

