<%@ page import="com.tim.hundreds.Social" %>

<div class="form-group fieldcontain ${hasErrors(bean: socialInstance, field: 'facebook', 'error')} ">
	<label class="${session.labelWidth} control-label" for="facebook">
		<g:message code="social.facebook.label" default="Facebook" />

	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="facebook" maxlength="100" value="${socialInstance?.facebook}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: socialInstance, field: 'twitter', 'error')} ">
	<label class="${session.labelWidth} control-label" for="twitter">
		<g:message code="social.twitter.label" default="Twitter" />

	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="twitter" maxlength="100" value="${socialInstance?.twitter}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: socialInstance, field: 'googlePlus', 'error')} ">
	<label class="${session.labelWidth} control-label" for="googlePlus">
		<g:message code="social.googlePlus.label" default="Google Plus" />

	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="googlePlus" maxlength="100" value="${socialInstance?.googlePlus}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: socialInstance, field: 'instagram', 'error')} ">
	<label class="${session.labelWidth} control-label" for="instagram">
		<g:message code="social.instagram.label" default="Instagram" />

	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="instagram" maxlength="100" value="${socialInstance?.instagram}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: socialInstance, field: 'youtube', 'error')} ">
	<label class="${session.labelWidth} control-label" for="youtube">
		<g:message code="social.youtube.label" default="Youtube" />

	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="youtube" maxlength="100" value="${socialInstance?.youtube}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: socialInstance, field: 'linkedin', 'error')} ">
	<label class="${session.labelWidth} control-label" for="linkedin">
		<g:message code="social.linkedin.label" default="Linkedin" />

	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="linkedin" maxlength="100" value="${socialInstance?.linkedin}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: socialInstance, field: 'other', 'error')} ">
	<label class="${session.labelWidth} control-label" for="other">
		<g:message code="social.other.label" default="Other" />

	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="other" maxlength="100" value="${socialInstance?.other}"/>
	</div>
</div>

<g:hiddenField name="musicianUuid" value="${socialInstance.musician?.uuid}"/>
<g:hiddenField name="contactUuid" value="${socialInstance.contact?.uuid}"/>
<g:hiddenField name="companyUuid" value="${socialInstance.company?.uuid}"/>
