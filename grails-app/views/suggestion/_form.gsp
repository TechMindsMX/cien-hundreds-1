<%@ page import="com.tim.hundreds.Suggestion" %>

<g:set var="labelWidth" value="col-sm-2" />
<g:set var="inputWidth" value="col-sm-10 col-lg-6" /> 

<div class="form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'name', 'error')} required">
	<label class="${labelWidth} control-label" for="name">
		<g:message code="suggestion.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField class="form-control" name="name" maxlength="100" required="" value="${suggestionInstance?.name}"/>
	</div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'contactName', 'error')} required">
	<label class="${labelWidth} control-label" for="contactName">
		<g:message code="suggestion.contactName.label" default="Contact Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField class="form-control" name="contactName" maxlength="100" required="" value="${suggestionInstance?.contactName}"/>
	</div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'email', 'error')} required">
	<label class="${labelWidth} control-label" for="email">
		<g:message code="suggestion.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:field class="form-control" type="email" name="email" maxlength="200" required="" value="${suggestionInstance?.email}"/>
	</div>

</div>

<div class="form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'phone', 'error')} required">
	<label class="${labelWidth} control-label" for="phone">
		<g:message code="suggestion.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField class="form-control" name="phone" maxlength="10" pattern="${suggestionInstance.constraints.phone.matches}" required="" value="${suggestionInstance?.phone}"/>
	</div>

</div>

<g:hiddenField name="musician.id" value="${params?.musicianId}"/>

