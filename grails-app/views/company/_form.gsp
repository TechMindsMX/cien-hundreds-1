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
			<g:textField class="form-control" name="logo" value="${companyInstance?.logo}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'corporatePress', 'error')} ">
	<label class="${session.labelWidth} control-label" for="corporatePress">
		<g:message code="company.corporatePress.label" default="Corporate Press" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="corporatePress" value="${companyInstance?.corporatePress}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'address', 'error')} ">
	<label class="${session.labelWidth} control-label" for="address">
		<g:message code="company.address.label" default="Address" />
	</label>
		<div class="${session.inputWidth}">
			<g:link controller="address" action="show" value="${companyInstance?.address?.id}">${message(code: 'default.show.label', args: [message(code: 'address.label')])}</g:link>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'social', 'error')} ">
	<label class="${session.labelWidth} control-label" for="social">
		<g:message code="company.social.label" default="Social" />
	</label>
		<div class="${session.inputWidth}">
			<g:link controller="social" action="show" value="${companyInstance?.social?.id}">${message(code: 'default.show.label', args: [message(code: 'social.label')])}</g:link>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'datosFiscales', 'error')} ">
	<label class="${session.labelWidth} control-label" for="datosFiscales">
		<g:message code="company.datosFiscales.label" default="Datos Fiscales" />
	</label>
		<div class="${session.inputWidth}">
			<g:link controller="datosFiscales" action="show" value="${companyInstance?.datosFiscales?.id}">${message(code: 'default.show.label', args: [message(code: 'datosFiscales.label')])}</g:link>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'references', 'error')} ">
	<label class="${session.labelWidth} control-label" for="references">
		<g:message code="company.references.label" default="References" />
		
	</label>
		<div class="${session.inputWidth}">
			
<ul class="one-to-many">
<g:each in="${companyInstance?.references}" var="r">
    <li><g:link controller="reference" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reference" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reference.label', default: 'Reference')])}</g:link>
</li>
</ul>


		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'events', 'error')} ">
	<label class="${session.labelWidth} control-label" for="events">
		<g:message code="company.events.label" default="Events" />
		
	</label>
		<div class="${session.inputWidth}">
			
<ul class="one-to-many">
<g:each in="${companyInstance?.events}" var="e">
    <li><g:link controller="event" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="event" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'event.label', default: 'Event')])}</g:link>
</li>
</ul>


		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'collaborators', 'error')} ">
	<label class="${session.labelWidth} control-label" for="collaborators">
		<g:message code="company.collaborators.label" default="Collaborators" />
		
	</label>
		<div class="${session.inputWidth}">
			
<ul class="one-to-many">
<g:each in="${companyInstance?.collaborators}" var="c">
    <li><g:link controller="collaborator" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="collaborator" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'collaborator.label', default: 'Collaborator')])}</g:link>
</li>
</ul>


		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'products', 'error')} ">
	<label class="${session.labelWidth} control-label" for="products">
		<g:message code="company.products.label" default="Products" />
		
	</label>
		<div class="${session.inputWidth}">
			
<ul class="one-to-many">
<g:each in="${companyInstance?.products}" var="p">
    <li><g:link controller="product" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="product" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'product.label', default: 'Product')])}</g:link>
</li>
</ul>


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

