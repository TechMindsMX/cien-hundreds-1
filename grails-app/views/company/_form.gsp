<%@ page import="com.tim.hundreds.Company" %>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="company.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="name" maxlength="100" required="" value="${companyInstance?.name}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'description', 'error')} required">
	<label class="${session.labelWidth} control-label" for="description">
		<g:message code="company.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="description" cols="40" rows="5" maxlength="10000" required="" value="${companyInstance?.description}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'web', 'error')} ">
	<label class="${session.labelWidth} control-label" for="web">
		<g:message code="company.web.label" default="Web" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="web" maxlength="100" value="${companyInstance?.web}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'notes', 'error')} ">
	<label class="${session.labelWidth} control-label" for="notes">
		<g:message code="company.notes.label" default="Notes" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="notes" cols="40" rows="5" maxlength="10000" value="${companyInstance?.notes}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'tags', 'error')} ">
	<label class="${session.labelWidth} control-label" for="tags">
		<g:message code="company.tags.label" default="Tags" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="tags" cols="40" rows="5" maxlength="10000" value="${companyInstance?.tags}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'logo', 'error')} ">
	<label class="${session.labelWidth} control-label" for="logo">
		<g:message code="company.logo.label" default="Logo" />
		
	</label>
		<div class="${session.inputWidth}">
			<input type="file" class="form-control" name="logo" value="${companyInstance?.logo}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'corporatePress', 'error')} ">
	<label class="${session.labelWidth} control-label" for="corporatePress">
		<g:message code="company.corporatePress.label" default="Corporate Press" />
		
	</label>
		<div class="${session.inputWidth}">
			<input type="file" class="form-control" name="corporatePress" value="${companyInstance?.corporatePress}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="company.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="type" from="${com.tim.hundreds.ActivityType?.values()}" keys="${com.tim.hundreds.ActivityType.values()*.name()}" required="" value="${companyInstance?.type?.name()}" />

		</div>
</div>


<g:hiddenField name="uuid" value="${companyInstance?.uuid}"/>

