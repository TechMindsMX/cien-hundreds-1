<%@ page import="com.tim.hundreds.Social" %>



<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'facebook', 'error')} ">
	<label for="facebook">
		<g:message code="social.facebook.label" default="Facebook" />
		
	</label>
	<g:textArea name="facebook" cols="40" rows="5" maxlength="255" value="${socialInstance?.facebook}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'twitter', 'error')} ">
	<label for="twitter">
		<g:message code="social.twitter.label" default="Twitter" />
		
	</label>
	<g:textArea name="twitter" cols="40" rows="5" maxlength="255" value="${socialInstance?.twitter}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'googlePlus', 'error')} ">
	<label for="googlePlus">
		<g:message code="social.googlePlus.label" default="Google Plus" />
		
	</label>
	<g:textArea name="googlePlus" cols="40" rows="5" maxlength="255" value="${socialInstance?.googlePlus}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'instagram', 'error')} ">
	<label for="instagram">
		<g:message code="social.instagram.label" default="Instagram" />
		
	</label>
	<g:textArea name="instagram" cols="40" rows="5" maxlength="255" value="${socialInstance?.instagram}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'youtube', 'error')} ">
	<label for="youtube">
		<g:message code="social.youtube.label" default="Youtube" />
		
	</label>
	<g:textArea name="youtube" cols="40" rows="5" maxlength="255" value="${socialInstance?.youtube}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'linkedin', 'error')} ">
	<label for="linkedin">
		<g:message code="social.linkedin.label" default="Linkedin" />
		
	</label>
	<g:textArea name="linkedin" cols="40" rows="5" maxlength="255" value="${socialInstance?.linkedin}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'other', 'error')} ">
	<label for="other">
		<g:message code="social.other.label" default="Other" />
		
	</label>
	<g:textArea name="other" cols="40" rows="5" maxlength="255" value="${socialInstance?.other}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: socialInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="social.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${socialInstance?.musician?.id}" class="many-to-one"/>

</div>

