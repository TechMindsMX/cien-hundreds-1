<%@ page import="com.tim.hundreds.DatosFiscales" %>



<div class="fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'razonSocial', 'error')} required">
	<label for="razonSocial">
		<g:message code="datosFiscales.razonSocial.label" default="Razon Social" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="razonSocial" maxlength="100" required="" value="${datosFiscalesInstance?.razonSocial}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'rfc', 'error')} required">
	<label for="rfc">
		<g:message code="datosFiscales.rfc.label" default="Rfc" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rfc" maxlength="50" required="" value="${datosFiscalesInstance?.rfc}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="datosFiscales.address.label" default="Address" />

	</label>
	<g:select id="address" name="address.id" from="${com.tim.hundreds.Address.list()}" optionKey="id" value="${datosFiscalesInstance?.address?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'personaMoral', 'error')} ">
	<label for="personaMoral">
		<g:message code="datosFiscales.personaMoral.label" default="Persona Moral" />

	</label>
	<g:checkBox name="personaMoral" value="${datosFiscalesInstance?.personaMoral}" />

</div>

<div class="fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'personaFisica', 'error')} ">
	<label for="personaFisica">
		<g:message code="datosFiscales.personaFisica.label" default="Persona Fisica" />

	</label>
	<g:checkBox name="personaFisica" value="${datosFiscalesInstance?.personaFisica}" />

</div>

<g:hiddenField name="musicianUuid" value="${params?.musicianUuid}"/>
<g:hiddenField name="companyId" value="${params?.companyId}"/>
