<%@ page import="com.tim.hundreds.Suggestion" %>



<div class="fieldcontain ${hasErrors(bean: suggestionInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="suggestion.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${suggestionInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: suggestionInstance, field: 'contactName', 'error')} required">
	<label for="contactName">
		<g:message code="suggestion.contactName.label" default="Contact Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="contactName" maxlength="100" required="" value="${suggestionInstance?.contactName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: suggestionInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="suggestion.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" maxlength="200" required="" value="${suggestionInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: suggestionInstance, field: 'telephone', 'error')} ">
	<label for="telephone">
		<g:message code="suggestion.telephone.label" default="Telephone" />
		
	</label>
	<g:select id="telephone" name="telephone.id" from="${com.tim.hundreds.Telephone.list()}" optionKey="id" value="${suggestionInstance?.telephone?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: suggestionInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="suggestion.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${suggestionInstance?.musician?.id}" class="many-to-one"/>

</div>

