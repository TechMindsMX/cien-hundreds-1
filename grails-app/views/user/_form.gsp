<%@ page import="com.tim.hundreds.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${userInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="user.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${userInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="user.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${userInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="user.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${userInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="user.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${userInstance?.passwordExpired}" />

</div>
<fieldset class="embedded"><legend><g:message code="user.profile.label" default="Profile" /></legend>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'profile.email', 'error')} required">
	<label for="profile.email">
		<g:message code="user.profile.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${profileInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'profile.firstName', 'error')} required">
	<label for="profile.firstName">
		<g:message code="user.profile.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" maxlength="100" required="" value="${profileInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'profile.id', 'error')} required">
	<label for="profile.id">
		<g:message code="user.profile.id.label" default="Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="id" type="number" value="${profileInstance?.id}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'profile.lastName', 'error')} required">
	<label for="profile.lastName">
		<g:message code="user.profile.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" maxlength="100" required="" value="${profileInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'profile.middleName', 'error')} required">
	<label for="profile.middleName">
		<g:message code="user.profile.middleName.label" default="Middle Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="middleName" maxlength="100" required="" value="${profileInstance?.middleName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'profile.phone', 'error')} ">
	<label for="profile.phone">
		<g:message code="user.profile.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" maxlength="10" pattern="${profileInstance.constraints.phone.matches}" value="${profileInstance?.phone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'profile.version', 'error')} required">
	<label for="profile.version">
		<g:message code="user.profile.version.label" default="Version" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="version" type="number" value="${profileInstance?.version}" required=""/>

</div>
</fieldset>
