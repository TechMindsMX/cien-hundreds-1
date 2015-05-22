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

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'social', 'error')} ">
	<label for="social">
		<g:message code="musician.social.label" default="Social" />
		
	</label>
	<g:select id="social" name="social.id" from="${com.tim.hundreds.Social.list()}" optionKey="id" value="${musicianInstance?.social?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="musician.address.label" default="Address" />
		
	</label>
	<g:select id="address" name="address.id" from="${com.tim.hundreds.Address.list()}" optionKey="id" value="${musicianInstance?.address?.id}" class="many-to-one" noSelection="['null': '']"/>

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

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'formed', 'error')} required">
	<label for="formed">
		<g:message code="musician.formed.label" default="Formed" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="formed" precision="day"  value="${musicianInstance?.formed}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'genre', 'error')} required">
	<label for="genre">
		<g:message code="musician.genre.label" default="Genre" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="genre" from="${com.tim.hundreds.Genre?.values()}" keys="${com.tim.hundreds.Genre.values()*.name()}" required="" value="${musicianInstance?.genre?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'hasManager', 'error')} ">
	<label for="hasManager">
		<g:message code="musician.hasManager.label" default="Has Manager" />
		
	</label>
	<g:checkBox name="hasManager" value="${musicianInstance?.hasManager}" />

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

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'suggestions', 'error')} ">
	<label for="suggestions">
		<g:message code="musician.suggestions.label" default="Suggestions" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${musicianInstance?.suggestions?}" var="s">
    <li><g:link controller="suggestion" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="suggestion" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'suggestion.label', default: 'Suggestion')])}</g:link>
</li>
</ul>


</div>

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

