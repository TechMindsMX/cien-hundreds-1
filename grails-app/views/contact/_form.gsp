<%@ page import="com.tim.hundreds.Contact" %>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'firstName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="firstName">
		<g:message code="contact.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="firstName" maxlength="100" required="" value="${contactInstance?.firstName}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'lastName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="lastName">
		<g:message code="contact.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
		</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="lastName" maxlength="100" required="" value="${contactInstance?.lastName}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'motherLastName', 'error')} required">
	<label class="${session.labelWidth} control-label" for="motherLastName">
		<g:message code="contact.motherLastName.label" default="Mother Last Name" />
		<span class="required-indicator">*</span>
		</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="motherLastName" maxlength="100" required="" value="${contactInstance?.motherLastName}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'other', 'error')} ">
	<label class="${session.labelWidth} control-label" for="other">
		<g:message code="contact.other.label" default="Other" />
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="other" maxlength="50" value="${contactInstance?.other}"/>
	</div>
</div>


<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'nationality', 'error')} ">
	<label class="${session.labelWidth} control-label" for="nationality">
		<g:message code="contact.nationality.label" default="Nationality" />
	</label>
	<div class="${session.inputWidth}">
		<g:countrySelect name="nationality" value="${contactInstance?.nationality}" noSelection="['':'-Seleccione-']" class="form-control" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'biography', 'error')} ">
	<label class="${session.labelWidth} control-label" for="biography">
		<g:message code="contact.biography.label" default="Biography" />
	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="biography" cols="40" rows="5" maxlength="10000" value="${contactInstance?.biography}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'style', 'error')} ">
	<label class="${session.labelWidth} control-label" for="style">
		<g:message code="contact.style.label" default="Style" />
	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="style" cols="40" rows="5" maxlength="10000" value="${contactInstance?.style}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'social', 'error')} ">
	<label class="${session.labelWidth} control-label" for="social">
		<g:message code="contact.social.label" default="Social" />
	</label>
	<div class="${session.inputWidth}">
		<g:select id="social" name="social.id" from="${com.tim.hundreds.Social.list()}" optionKey="id" value="${contactInstance?.social?.id}" class="form-control many-to-one" noSelection="['null': '']"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'address', 'error')} ">
	<label class="${session.labelWidth} control-label" for="address">
		<g:message code="contact.address.label" default="Address" />
	</label>
	<div class="${session.inputWidth}">
		<g:select id="address" name="address.id" from="${com.tim.hundreds.Address.list()}" optionKey="id" value="${contactInstance?.address?.id}" class="form-control many-to-one" noSelection="['null': '']"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'birthDate', 'error')} required">
	<label class="${session.labelWidth} control-label" for="birthDate">
		<g:message code="contact.birthDate.label" default="Birth Date" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:datePicker class="form-control" name="birthDate" precision="day"  value="${contactInstance?.birthDate}" relativeYears="[-100..0]" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'entryDate', 'error')} required" relativeYears="[-100..0]">
	<label class="${session.labelWidth} control-label" for="entryDate">
		<g:message code="contact.entryDate.label" default="Entry Date" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:datePicker class="form-control" name="entryDate" precision="day"  value="${contactInstance?.entryDate}"  />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'role', 'error')} required">
	<label class="${session.labelWidth} control-label" for="role">
		<g:message code="contact.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:select class="form-control" name="role" from="${com.tim.hundreds.RoleType?.values()}" keys="${com.tim.hundreds.RoleType.values()*.name()}" required="" value="${contactInstance?.role?.name()}" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'emails', 'error')} ">
	<label class="${session.labelWidth} control-label" for="emails">
		<g:message code="contact.emails.label" default="Emails" />
	</label>
	<div class="${session.inputWidth}">
		<g:if test="${contactInstance?.emails?.size() > 0}">
			<g:each in="${contactInstance.emails}" var="e">
				<li>${contactInstance.email.address}-${contactInstance.email.type}  <g:link controller="email" action="edit" id="${e.id}"><g:message code="default.edit.label" /></g:link></li>
			</g:each>
		</g:if>
		<g:if test="${contactInstance && contactInstance?.emails?.size() < 3}">
			<g:link class="" controller="email" action="create" params='[contactId: "${contactInstance.id}"]'><g:message code="create.email.label" default="Nuevo email" /></g:link>
		</g:if>
		<g:else>
			<g:message code="contact.first.label" default="Por favor crear primero el contacto" />
		</g:else>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'telephones', 'error')} ">
	<label class="${session.labelWidth} control-label" for="telephones">
		<g:message code="contact.telephones.label" default="Telephones" />
	</label>
	<div class="${session.inputWidth}">
		<g:if test="${contactInstance?.telephones?.size() > 0}">
			<g:each in="${contactInstance.telephones}" var="t">
				<li>${contactInstance.telephone.phone}-${contactInstance.telephone.type}  <g:link controller="telephone" action="edit" id="${t.id}"><g:message code="default.edit.label" /></g:link></li>
			</g:each>
		</g:if>
		<g:if test="${contactInstance && contactInstance?.telephones?.size() < 3}">
			<g:link class="" controller="telephone" action="create" params='[contactId: "${contactInstance.id}"]'><g:message code="create.phone.label" default="Nuevo teléfono" /></g:link>
		</g:if>
		<g:else>
			<g:message code="contact.first.label" default="Por favor crear primero el contacto" />
		</g:else>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'type', 'error')} required">
	<label class="${session.labelWidth} control-label" for="type">
		<g:message code="contact.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:select class="form-control" name="type" from="${com.tim.hundreds.GenderType?.values()}" keys="${com.tim.hundreds.GenderType.values()*.name()}" required="" value="${contactInstance?.type?.name()}" />
	</div>
</div>

<g:if test="${contactInstance?.photoPath}">
	<g:img folder="" file="${contactInstance?.photoPath}" height="200"/>
</g:if>

<div class="form-group fieldcontain ${hasErrors(bean: contactInstance, field: 'photo', 'error')} ">
 	<label class="${session.labelWidth} control-label" for="photo">
	 	<g:message code="contact.photo.label" default="Photo" />
	</label>
	<div class="${session.inputWidth}">
   		<input class="form-control" type="file" id="photo" name="photo" />
	</div>
</div>

<g:hiddenField name="musicianId" value="${params?.musicianId}" />
