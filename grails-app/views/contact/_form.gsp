<%@ page import="com.tim.hundreds.Contact" %>



<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="contact.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" maxlength="100" required="" value="${contactInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'middleName', 'error')} required">
	<label for="middleName">
		<g:message code="contact.middleName.label" default="Middle Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="middleName" maxlength="100" required="" value="${contactInstance?.middleName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="contact.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" maxlength="100" required="" value="${contactInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'other', 'error')} ">
	<label for="other">
		<g:message code="contact.other.label" default="Other" />
		
	</label>
	<g:textField name="other" maxlength="50" value="${contactInstance?.other}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'social', 'error')} ">
	<label for="social">
		<g:message code="contact.social.label" default="Social" />
		
	</label>
	<g:select id="social" name="social.id" from="${com.tim.hundreds.Social.list()}" optionKey="id" value="${contactInstance?.social?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'emails', 'error')} ">
	<label for="emails">
		<g:message code="contact.emails.label" default="Emails" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${contactInstance?.emails?}" var="e">
    <li><g:link controller="email" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="email" action="create" params="['contact.id': contactInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'email.label', default: 'Email')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="contact.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${contactInstance?.musician?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="contact.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="role" from="${com.tim.hundreds.Role?.values()}" keys="${com.tim.hundreds.Role.values()*.name()}" required="" value="${contactInstance?.role?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'telephones', 'error')} ">
	<label for="telephones">
		<g:message code="contact.telephones.label" default="Telephones" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${contactInstance?.telephones?}" var="t">
    <li><g:link controller="telephone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="telephone" action="create" params="['contact.id': contactInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'telephone.label', default: 'Telephone')])}</g:link>
</li>
</ul>


</div>

