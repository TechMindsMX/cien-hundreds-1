<%@ page import="com.tim.hundreds.Musician" %>

<h4>Datos de Ingreso</h4>

       <div class="form-group">
        <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'name', 'error')} required">
         <g:message code="musician.name.label" class="text-right" data-pg-id="34" default="Nombre(s)" />
         <span class="required-indicator">*</span>
     </label>
     <div class="${session.inputWidth}">
        <g:textField name="name" maxlength="100" class="form-control" placeholder="${message(code:'musician.name.placeholder')}" required="" value="${musicianInstance?.name}"/>
    </div>
</div>

<div class="form-group">
    <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'history', 'error')} required">
      <g:message code="musician.history.label" default="Biografía" />
      <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <g:textArea name="history" class="form-control" cols="40" rows="5" maxlength="10000" required="" value="${musicianInstance?.history}" placeholder="${message(code:'musician.history.placeholder')}"/>
</div>
</div>

<div class="form-group">
    <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'web', 'error')} ">
     <g:message code="musician.web.label" default="Página Web" />
 </label>
 <div class="${session.inputWidth}">
  <g:textField class="form-control" name="web" maxlength="100" value="${musicianInstance?.web}" placeholder="${message(code:'musician.web.placeholder')}"/>
</div>
</div>

<div class="form-group">
 <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'notes', 'error')} ">
     <g:message code="musician.notes.label" default="Notas" />
 </label>
 <div class="${session.inputWidth}">
    <g:textArea name="notes" class="form-control" cols="40" rows="5" maxlength="10000" value="${musicianInstance?.notes}" placeholder="${message(code:'musician.notes.placeholder')}"/>
</div>
</div>

<div class="form-group">
    <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'tags', 'error')} ">
      <g:message code="musician.tags.label" default="Etiquetas" />
  </label>
  <div class="${session.inputWidth}">
    <g:textArea name="tagsComma" class="form-control" placeholder="${message(code: 'musician.tags.placeholder')}" cols="40" rows="5" maxlength="10000" value="${musicianInstance?.tags.join(", ")}"/>
</div>
</div>

<div class="form-group">
    <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'formed', 'error')} required">
     <g:message code="musician.formed.label" default="Fecha de formación" />
     <span class="required-indicator">*</span>
 </label>
 <div class="${session.inputWidth}">
    <div class="input-group">
        <g:timDatePicker name="formed" minDate="01-01-1900" maxDate="-0D" changeMonth="true" changeYear="true" yearRange="-100:+0" value="${musicianInstance?.formed}" required="true"></g:timDatePicker>
        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
    </div>
</div>
</div>

<div class="form-group">
    <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'genre', 'error')} required">
     <g:message code="musician.genre.label" default="Genero" />
     <span class="required-indicator">*</span>
 </label>
 <div class="${session.inputWidth}">
    <g:select id="genre" name="genre.id" from="${com.tim.hundreds.Genre.list()}" optionValue='name' optionKey="id" required="" value="${musicianInstance?.genre?.id}" class="form-control many-to-one"/>
</div>
</div>

<div class="form-group">
    <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'hasManager', 'error')} ">
     <g:message code="musician.hasManager.label" default="tiene Manager" />
 </label>
 <div class="${session.inputWidth}">
   <g:checkBox class="form-control" name="hasManager" value="${musicianInstance?.hasManager}" />
</div>
</div>

<div class="form-group">
    <label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: musicianInstance, field: 'logo', 'error')} ">
      <g:message code="musician.logo.label" default="Logo" />
  </label>
  <div class="${session.inputWidth}">
      <input type="file" id="logo" name="logo" class="form-control"/>
      <g:if test="${musicianInstance?.logoPath}">
        <div class="img pad-bottom">
            <img class="img-responsive img-thumbnail max300" src="${grailsApplication.config.base.logo.url}${musicianInstance.logoPath}" />
        </div>
    </g:if>
  </div>
</div>



<div class=" hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'logoPath', 'error')} ">
	<label for="logoPath">
		<g:message code="musician.logoPath.label" default="Logo Path" />

	</label>
	<g:textField name="logoPath" value="${musicianInstance?.logoPath}"/>

</div>

<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'social', 'error')} ">
	<label for="social">
		<g:message code="musician.social.label" default="Social" />

	</label>
	<g:select id="social" name="social.id" from="${com.tim.hundreds.Social.list()}" optionKey="id" value="${musicianInstance?.social?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="musician.address.label" default="Address" />

	</label>
	<g:select id="address" name="address.id" from="${com.tim.hundreds.Address.list()}" optionKey="id" value="${musicianInstance?.address?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'datosFiscales', 'error')} ">
	<label for="datosFiscales">
		<g:message code="musician.datosFiscales.label" default="Datos Fiscales" />

	</label>
	<g:select id="datosFiscales" name="datosFiscales.id" from="${com.tim.hundreds.DatosFiscales.list()}" optionKey="id" value="${musicianInstance?.datosFiscales?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'activities', 'error')} ">
	<label for="activities">
		<g:message code="musician.activities.label" default="Activities" />

	</label>

    <ul class="one-to-many">
        <g:each in="${musicianInstance?.activities}" var="a">
        <li><g:link controller="activity" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
    </g:each>
    <li class="add">
        <g:link controller="activity" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'activity.label', default: 'Activity')])}</g:link>
    </li>
</ul>


</div>

<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'audios', 'error')} ">
	<label for="audios">
		<g:message code="musician.audios.label" default="Audios" />

	</label>

    <ul class="one-to-many">
        <g:each in="${musicianInstance?.audios}" var="a">
        <li><g:link controller="audio" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
    </g:each>
    <li class="add">
        <g:link controller="audio" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'audio.label', default: 'Audio')])}</g:link>
    </li>
</ul>


</div>

<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'contacts', 'error')} ">
	<label for="contacts">
		<g:message code="musician.contacts.label" default="Contacts" />

	</label>

    <ul class="one-to-many">
        <g:each in="${musicianInstance?.contacts}" var="c">
        <li><g:link controller="contact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
    </g:each>
    <li class="add">
        <g:link controller="contact" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'contact.label', default: 'Contact')])}</g:link>
    </li>
</ul>


</div>


<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'photos', 'error')} ">
	<label for="photos">
		<g:message code="musician.photos.label" default="Photos" />

	</label>
	<ul class="one-to-many">
		<g:each in="${musicianInstance?.photos}" var="p">
      <li><g:link controller="photo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
  </g:each>
  <li class="add">
     <g:link controller="photo" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'photo.label', default: 'Photo')])}</g:link>
 </li>
</ul>
</div>

<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'suggestions', 'error')} ">
	<label for="suggestions">
		<g:message code="musician.suggestions.label" default="Suggestions" />

	</label>

    <ul class="one-to-many">
        <g:each in="${musicianInstance?.suggestions}" var="s">
        <li><g:link controller="suggestion" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
    </g:each>
    <li class="add">
        <g:link controller="suggestion" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'suggestion.label', default: 'Suggestion')])}</g:link>
    </li>
</ul>

</div>


<div class="hide fieldcontain ${hasErrors(bean: musicianInstance, field: 'videos', 'error')} ">
	<label for="videos">
		<g:message code="musician.videos.label" default="Videos" />

	</label>

    <ul class="one-to-many">
        <g:each in="${musicianInstance?.videos}" var="v">
        <li><g:link controller="video" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></li>
    </g:each>
    <li class="add">
        <g:link controller="video" action="create" params="['musician.id': musicianInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'video.label', default: 'Video')])}</g:link>
    </li>
    </ul>
</div>

<g:hiddenField name="uuid" value="${musicianInstance.uuid}"/>
<g:hiddenField name="id" value="${musicianInstance.id}"/>
