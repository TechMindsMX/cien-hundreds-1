<%@ page import="com.tim.hundreds.PhotoCommand" %>



<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'file', 'error')} ">
  <label for="file">
    <g:message code="musician.file.label" default="File" />

  </label>
  <input type="file" id="file" name="file" />

</div>

<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="photo.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${photoInstance?.musician?.id}" class="many-to-one"/>

</div>

