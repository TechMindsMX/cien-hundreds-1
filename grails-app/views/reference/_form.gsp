<%@ page import="com.tim.hundreds.Reference" %>



<div class="form-group fieldcontain ${hasErrors(bean: referenceInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="reference.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="name" id="name" maxlength="100" required="" value="${referenceInstance?.name}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: referenceInstance, field: 'contactName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="contactName">
		<g:message code="reference.contactName.label" default="Contact Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="contactName" id="contactName" maxlength="100" required="" value="${referenceInstance?.contactName}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: referenceInstance, field: 'email', 'error')} required">
	<label class="${session.labelWidth} control-label" for="email">
		<g:message code="reference.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:field class="form-control" type="email" name="email" id="email" maxlength="200" required="" value="${referenceInstance?.email}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: referenceInstance, field: 'phone', 'error')} ">
	<label class="${session.labelWidth} control-label" for="phone">
		<g:message code="reference.phone.label" default="Phone" />
		
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="phone" id="phone" maxlength="10" value="${referenceInstance?.phone}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: referenceInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="reference.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="type" name="type.id" from="${com.tim.hundreds.BusinessActivity.list()}" optionKey="id" optionValue="name" required="" value="${referenceInstance?.type?.id}" class="form-control many-to-one"/>

		</div>
</div>

<g:hiddenField id="uuid" name="uuid" required="" value="${referenceInstance?.uuid}" class="form-control" />
<g:hiddenField id="companyUuid" name="companyUuid" required="" value="${referenceInstance?.company?.uuid}" class="form-control many-to-one"/>

