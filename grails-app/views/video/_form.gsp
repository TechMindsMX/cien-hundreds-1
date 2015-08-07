<%@ page import="com.tim.hundreds.Video" %>



<div class="form-group fieldcontain ${hasErrors(bean: videoInstance, field: 'url', 'error')} required">
	<label class="${session.labelWidth} control-label" for="url">
		<g:message code="video.url.label" default="Url" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="url" maxlength="100" required="" value="${videoInstance?.url}"/>

		</div>
</div>

<g:hiddenField id="uuid" name="uuid" value="${videoInstance?.uuid}" />
<g:hiddenField id="musicianUuid" name="musicianUuid" value="${videoInstance?.musician?.uuid}" />
<g:hiddenField id="contactUuid" name="contactUuid" value="${videoInstance?.contact?.uuid}" />