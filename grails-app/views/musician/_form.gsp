<%@ page import="com.tim.hundreds.Musician" %>



<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="musician.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${musicianInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'history', 'error')} required">
	<label for="history">
		<g:message code="musician.history.label" default="History" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="history" cols="40" rows="5" maxlength="1000" required="" value="${musicianInstance?.history}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'web', 'error')} ">
	<label for="web">
		<g:message code="musician.web.label" default="Web" />
		
	</label>
	<g:textField name="web" maxlength="100" value="${musicianInstance?.web}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'audios', 'error')} ">
	<label for="audios">
		<g:message code="musician.audios.label" default="Audios" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${musicianInstance?.audios?}" var="a">
    <li><g:link controller="audio" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="audio" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'audio.label', default: 'Audio')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'photos', 'error')} ">
	<label for="photos">
		<g:message code="musician.photos.label" default="Photos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${musicianInstance?.photos?}" var="p">
    <li><g:link controller="photo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="photo" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'photo.label', default: 'Photo')])}</g:link>
</li>
</ul>


</div>
<fieldset class="embedded"><legend><g:message code="musician.social.label" default="Social" /></legend>
<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'social.facebook', 'error')} required">
	<label for="social.facebook">
		<g:message code="musician.social.facebook.label" default="Facebook" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="facebook" required="" value="${socialInstance?.facebook}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'social.googlePlus', 'error')} required">
	<label for="social.googlePlus">
		<g:message code="musician.social.googlePlus.label" default="Google Plus" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="googlePlus" required="" value="${socialInstance?.googlePlus}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'social.instagram', 'error')} required">
	<label for="social.instagram">
		<g:message code="musician.social.instagram.label" default="Instagram" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="instagram" required="" value="${socialInstance?.instagram}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'social.linkedin', 'error')} required">
	<label for="social.linkedin">
		<g:message code="musician.social.linkedin.label" default="Linkedin" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="linkedin" required="" value="${socialInstance?.linkedin}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'social.other', 'error')} required">
	<label for="social.other">
		<g:message code="musician.social.other.label" default="Other" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="other" required="" value="${socialInstance?.other}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'social.twitter', 'error')} required">
	<label for="social.twitter">
		<g:message code="musician.social.twitter.label" default="Twitter" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="twitter" required="" value="${socialInstance?.twitter}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'social.youtube', 'error')} required">
	<label for="social.youtube">
		<g:message code="musician.social.youtube.label" default="Youtube" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="youtube" required="" value="${socialInstance?.youtube}"/>

</div>
</fieldset>
<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'videos', 'error')} ">
	<label for="videos">
		<g:message code="musician.videos.label" default="Videos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${musicianInstance?.videos?}" var="v">
    <li><g:link controller="video" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="video" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'video.label', default: 'Video')])}</g:link>
</li>
</ul>


</div>

