<%@ page import="com.tim.hundreds.Photo" %>



<div class="form-group fieldcontain ${hasErrors(bean: photoInstance, field: 'path', 'error')} required">
	<label class="${session.labelWidth} control-label" for="path">
		<g:message code="photo.path.label" default="Path" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<input class="form-control" type="file" id="file" name="file" />
    		<g:if test="${photoInstance?.path}">
				<img class="img-responsive max300" src="${grailsApplication.config.base.logo.url}${photoInstance.path}" />
			</g:if>
		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: photoInstance, field: 'musician', 'error')} required">
	<label class="${session.labelWidth} control-label" for="musician">
		<g:message code="photo.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${photoInstance?.musician?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: photoInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="photo.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" required="" value="${photoInstance?.uuid}"/>

		</div>
</div>

