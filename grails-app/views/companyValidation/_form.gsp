<%@ page import="com.tim.hundreds.CompanyValidation" %>

<div class="form-group fieldcontain ${hasErrors(bean: companyValidationInstance, field: 'message', 'error')} ">
	<label class="${session.labelWidth} control-label" for="message">
		<g:message code="companyValidation.message.label" default="Message" />

	</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="message" id="message" cols="40" rows="5" maxlength="10000" value="${companyValidationInstance?.message}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: companyValidationInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="companyValidation.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="type" from="${com.tim.hundreds.ValidationType?.values()}" keys="${com.tim.hundreds.ValidationType.values()*.name()}" required="" value="${companyValidationInstance?.type?.name()}" />

		</div>
</div>

<sec:access expression="hasRole('ROLE_ADMIN') || hasRole('ROLE_COMPANY_ADMIN')" >
	<div class="form-group fieldcontain ${hasErrors(bean: companyValidationInstance, field: 'company', 'error')} required">
		<label class="${session.labelWidth} control-label" for="company">
			<g:message code="companyValidation.company.label" default="Company" />
			<span class="required-indicator">*</span>
		</label>
		<div class="${session.inputWidth}">
			<g:select id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionValue="name" optionKey="id" required="" value="${companyValidationInstance?.company?.id}" class="form-control many-to-one"/>
		</div>
	</div>

	<div class="form-group fieldcontain ${hasErrors(bean: companyValidationInstance, field: 'user', 'error')} required">
		<label class="${session.labelWidth} control-label" for="user">
			<g:message code="companyValidation.user.label" default="User" />
			<span class="required-indicator">*</span>
		</label>
			<div class="${session.inputWidth}">
				<g:select id="user" name="user.id" from="${buyers}" optionValue="username" optionKey="id" required="" value="${companyValidationInstance?.user?.id}" class="form-control many-to-one"/>
			</div>
	</div>
</sec:access>

<sec:access expression="hasRole('ROLE_BUYER')" >
			<g:if test="${companyValidationInstance?.company?.id}">
				<div class="form-group">
					<label class="${session.labelWidth} control-label" for="company-name" ><g:message code="company.label" /></label>
					<div class="${session.inputWidth}">
						<span class="form-control">${companyValidationInstance?.company?.name?.encodeAsHTML()}</span>
					</div>
				</div>
			</g:if>
			<g:hiddenField id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionValue="name" optionKey="id" required="" value="${companyValidationInstance?.company?.id}" class="form-control many-to-one"/>
			<g:hiddenField id="user" name="user.id" from="${buyers}" optionValue="username" optionKey="id" required="" value="${companyValidationInstance?.user?.id}" class="form-control many-to-one"/>
</sec:access>

<div class="hide form-group fieldcontain ${hasErrors(bean: companyValidationInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="companyValidation.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" id="uuid" required="" value="${companyValidationInstance?.uuid}"/>

		</div>
</div>

