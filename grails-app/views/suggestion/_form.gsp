<%@ page import="com.tim.hundreds.Suggestion" %>



<div class="form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="suggestion.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="name" maxlength="100" required="" value="${suggestionInstance?.name}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'contactName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="contactName">
		<g:message code="suggestion.contactName.label" default="Contact Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="contactName" maxlength="100" required="" value="${suggestionInstance?.contactName}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'email', 'error')} required">
	<label class="${session.labelWidth} control-label" for="email">
		<g:message code="suggestion.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:field class="form-control" type="email" name="email" maxlength="200" required="" value="${suggestionInstance?.email}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'phone', 'error')} required">
	<label class="${session.labelWidth} control-label" for="phone">
		<g:message code="suggestion.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="phone" maxlength="10" pattern="${suggestionInstance?.constraints?.phone?.matches}" required="" value="${suggestionInstance?.phone}"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'musician', 'error')} required">
	<label class="${session.labelWidth} control-label" for="musician">
		<g:message code="suggestion.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${suggestionInstance?.musician?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: suggestionInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="suggestion.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" required="" value="${suggestionInstance?.uuid}"/>

		</div>
</div>

