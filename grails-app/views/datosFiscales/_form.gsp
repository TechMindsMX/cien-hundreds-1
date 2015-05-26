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

<div class="fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="datosFiscales.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${datosFiscalesInstance?.musician?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'tipoPersona', 'error')} ">
	<label for="tipoPersona">
		<g:message code="datosFiscales.tipoPersona.label" default="Tipo Persona" />
		
	</label>
	<g:checkBox name="tipoPersona" value="${datosFiscalesInstance?.tipoPersona}" />

</div>

