<%@ page import="com.tim.hundreds.Social" %>



<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'facebook', 'error')} ">
	<label for="facebook">
		<g:message code="social.facebook.label" default="Facebook" />

	</label>
	<g:textField name="facebook" maxlength="100" value="${socialInstance?.facebook}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'twitter', 'error')} ">
	<label for="twitter">
		<g:message code="social.twitter.label" default="Twitter" />

	</label>
	<g:textField name="twitter" maxlength="100" value="${socialInstance?.twitter}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'googlePlus', 'error')} ">
	<label for="googlePlus">
		<g:message code="social.googlePlus.label" default="Google Plus" />

	</label>
	<g:textField name="googlePlus" maxlength="100" value="${socialInstance?.googlePlus}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'instagram', 'error')} ">
	<label for="instagram">
		<g:message code="social.instagram.label" default="Instagram" />

	</label>
	<g:textField name="instagram" maxlength="100" value="${socialInstance?.instagram}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'youtube', 'error')} ">
	<label for="youtube">
		<g:message code="social.youtube.label" default="Youtube" />

	</label>
	<g:textField name="youtube" maxlength="100" value="${socialInstance?.youtube}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'linkedin', 'error')} ">
	<label for="linkedin">
		<g:message code="social.linkedin.label" default="Linkedin" />

	</label>
	<g:textField name="linkedin" maxlength="100" value="${socialInstance?.linkedin}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'other', 'error')} ">
	<label for="other">
		<g:message code="social.other.label" default="Other" />

	</label>
	<g:textField name="other" maxlength="100" value="${socialInstance?.other}"/>

</div>

<input type="hidden" name="musicianId" value="${musicianId}"/>
