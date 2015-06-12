<%@ page import="com.tim.hundreds.PhotoCommand" %>

<div class="form-group fieldcontain ${hasErrors(bean: photoInstance, field: 'file', 'error')} ">
  <label class="${session.labelWidth} control-label" for="file">
    <g:message code="musician.file.label" default="File" />
  </label>

  <div class="${session.inputWidth}">
  	<input class="form-control" type="file" id="file" name="file" />
  </div>

</div>

<g:hiddenField name="musician.id" value="${params?.musicianId}"/>

