<%@ page import="com.tim.hundreds.Company" %>



<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="company.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${companyInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="company.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1000" required="" value="${companyInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'web', 'error')} ">
	<label for="web">
		<g:message code="company.web.label" default="Web" />
		
	</label>
	<g:textField name="web" maxlength="100" value="${companyInstance?.web}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'references', 'error')} ">
	<label for="references">
		<g:message code="company.references.label" default="References" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${companyInstance?.references?}" var="r">
    <li><g:link controller="reference" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reference" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reference.label', default: 'Reference')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="company.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${com.tim.hundreds.ActivityType?.values()}" keys="${com.tim.hundreds.ActivityType.values()*.name()}" required="" value="${companyInstance?.type?.name()}" />

</div>

