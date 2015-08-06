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

<g:hiddenField id="uuid" name="uuid" value="${photoInstance?.uuid}" />
<g:hiddenField id="musicianUuid" name="musicianUuid" value="${photoInstance?.musician?.uuid}" />
<g:hiddenField id="contactUuid" name="contactUuid" value="${photoInstance?.contact?.uuid}" />