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

<g:hiddenField name="musician.id" value="${params?.musicianId}"/>

