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

<div class="hide form-group fieldcontain ${hasErrors(bean: videoInstance, field: 'musician', 'error')} required">
	<label class="${session.labelWidth} control-label" for="musician">
		<g:message code="video.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${videoInstance?.musician?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: videoInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="video.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" required="" value="${videoInstance?.uuid}"/>

		</div>
</div>

