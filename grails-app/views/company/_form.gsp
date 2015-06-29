<%@ page import="com.tim.hundreds.Company" %>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="name" maxlength="100" required="" value="${companyInstance?.name}" placeholder="${message(code:'name.placeholder')}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'description', 'error')} required">
	<label class="${session.labelWidth} control-label" for="description">
		<g:message code="description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="description" cols="40" rows="5" maxlength="10000" required="" value="${companyInstance?.description}" placeholder="${message(code:'description.placeholder')}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'web', 'error')} ">
	<label class="${session.labelWidth} control-label" for="web">
		<g:message code="web.label" default="Web" />

	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="web" maxlength="100" value="${companyInstance?.web}" placeholder="${message(code:'web.placeholder')}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'notes', 'error')} ">
	<label class="${session.labelWidth} control-label" for="notes">
		<g:message code="notes.label" default="Notes" />

	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="notes" cols="40" rows="5" maxlength="10000" value="${companyInstance?.notes}" placeholder="${message(code:'notes.placeholder')}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'tags', 'error')} ">
	<label class="${session.labelWidth} control-label" for="tags">
		<g:message code="tags.label" default="Tags" />

	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="tags" cols="40" rows="5" maxlength="10000" value="${companyInstance?.tags}" placeholder="${message(code:'tags.placeholder')}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'logo', 'error')} ">
	<label class="${session.labelWidth} control-label" for="logo">
		<g:message code="logo.label" default="Logo" />

	</label>
		<div class="${session.inputWidth}">
			<input type="file" class="form-control" name="logo" value="${companyInstance?.logo}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'corporatePress', 'error')} ">
	<label class="${session.labelWidth} control-label" for="corporatePress">
		<g:message code="corporatePress.label" default="Corporate Press" />

	</label>
		<div class="${session.inputWidth}">
			<input type="file" class="form-control" name="corporatePress" value="${companyInstance?.corporatePress}"/>
		</div>
</div>


<g:if test="${companyInstance?.id}">
<div class="hide form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'address', 'error')} ">
	<label class="${session.labelWidth} control-label" for="address">
		<g:message code="address.label" default="Address" />
	</label>
	<div class="${session.inputWidth}">
		<g:if test="${companyInstance.address}">
			<g:link controller="address" action="show" value="${companyInstance?.address?.id}">${message(code: 'default.show.label', args: [message(code: 'address.label')])}</g:link>
		</g:if>
		<g:else>
			<g:link controller="address" action="create" params="[companyUuid: companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'address.label')])}</g:link>
		</g:else>
	</div>
</div>
</g:if>

<g:if test="${companyInstance.id}">
<div class="hide form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'social', 'error')} ">
	<label class="${session.labelWidth} control-label" for="social">
		<g:message code="social.label" default="Social" />
	</label>
	<div class="${session.inputWidth}">
		<g:if test="${companyInstance.social}">
			<g:link controller="social" action="show" value="${companyInstance?.social?.id}">${message(code: 'default.show.label', args: [message(code: 'social.label')])}</g:link>
		</g:if>
		<g:else>
			<g:link controller="social" action="create" params="[companyUuid: companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'social.label')])}</g:link>
		</g:else>
	</div>
</div>
</g:if>

<g:if test="${companyInstance.id}">
<div class="hide form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'datosFiscales', 'error')} ">
	<label class="${session.labelWidth} control-label" for="datosFiscales">
		<g:message code="datosFiscales.label" default="Datos Fiscales" />
	</label>
	<div class="${session.inputWidth}">
		<g:if test="${companyInstance.datosFiscales}">
			<g:link controller="datosFiscales" action="show" value="${companyInstance?.datosFiscales?.id}">${message(code: 'default.show.label', args: [message(code: 'datosFiscales.label')])}</g:link>
		</g:if>
		<g:else>
			<g:link controller="datosFiscales" action="create" params="[companyUuid: companyInstance.uuid]" >${message(code: 'default.add.label', args: [message(code: 'datosFiscales.label')])}</g:link>
		</g:else>
	</div>
</div>
</g:if>

<g:if test="${companyInstance.id}">
<div class="hide form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'references', 'error')} ">
	<label class="${session.labelWidth} control-label" for="references">
		<g:message code="references.label" default="References" />
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
</g:if>

<g:if test="${companyInstance.id}">
<div class="hide form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'events', 'error')} ">
	<label class="${session.labelWidth} control-label" for="events">
		<g:message code="events.label" default="Events" />
	</label>
	<div class="${session.inputWidth}">
		<ul class="one-to-many">
		<g:each in="${companyInstance?.events}" var="e">
		    <li><g:link controller="event" action="show" id="${e.id}">${e?.date?.encodeAsHTML()} ${e?.activity?.encodeAsHTML()} ${e?.place?.encodeAsHTML()}</g:link></li>
		</g:each>
		<li class="add">
		<g:link controller="event" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'event.label', default: 'Event')])}</g:link>
		</li>
		</ul>
	</div>
</div>
</g:if>

<g:if test="${companyInstance.id}">
<div class="hide form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'collaborators', 'error')} ">
	<label class="${session.labelWidth} control-label" for="collaborators">
		<g:message code="collaborators.label" default="Collaborators" />
	</label>
	<div class="${session.inputWidth}">
		<ul class="one-to-many">
		<g:each in="${companyInstance?.collaborators}" var="c">
		    <li><g:link controller="collaborator" action="show" id="${c.id}">${c?.firstName?.encodeAsHTML()} ${c?.lastName?.encodeAsHTML()}</g:link></li>
		</g:each>
		<li class="add">
		<g:link controller="collaborator" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'collaborator.label', default: 'Collaborator')])}</g:link>
		</li>
		</ul>
	</div>
</div>
</g:if>

<g:if test="${companyInstance.id}">
<div class="hide form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'products', 'error')} ">
	<label class="${session.labelWidth} control-label" for="products">
		<g:message code="products.label" default="Products" />
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
</g:if>

<div class="form-group fieldcontain ${hasErrors(bean: companyInstance, field: 'type', 'error')} required">
  <label class="${session.labelWidth} control-label" for="type">
    <g:message code="company.type.label" default="Type" />
    <span class="required-indicator">*</span>
  </label>
  <div class="${session.inputWidth}">
    <g:select id="type" name="type.id" from="${com.tim.hundreds.BusinessActivity.list()}" optionValue="name" optionKey="id" required="" value="${companyInstance?.type?.id}" class="form-control many-to-one"/>
  </div>
</div>


<g:hiddenField name="uuid" value="${companyInstance?.uuid}"/>

