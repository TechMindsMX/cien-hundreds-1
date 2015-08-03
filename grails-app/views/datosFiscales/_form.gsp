<%@ page import="com.tim.hundreds.DatosFiscales" %>


<div class="form-group fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'razonSocial', 'error')} required">
	<label class="${session.labelWidth} control-label" for="razonSocial">
		<g:message code="datosFiscales.razonSocial.label" default="Razon Social" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="razonSocial" maxlength="100" required="" value="${datosFiscalesInstance?.razonSocial}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'rfc', 'error')} required">
	<label class="${session.labelWidth} control-label" for="rfc">
		<g:message code="datosFiscales.rfc.label" default="Rfc" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="rfc" maxlength="50" required="" value="${datosFiscalesInstance?.rfc}"/>
		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: datosFiscalesInstance, field: 'personaJuridica', 'error')} required">
	<label class="${session.labelWidth} control-label" for="personaJuridica">
		<g:message code="datosFiscales.personaJuridica.label" default="Persona Juridica" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select class="form-control" name="personaJuridica" from="${com.tim.hundreds.PersonaJuridicaType?.values()}" keys="${com.tim.hundreds.PersonaJuridicaType.values()*.name()}" required="" value="${datosFiscalesInstance?.personaJuridica?.name()}" />
		</div>
</div>
<g:hiddenField name="address.id" value="${datosFiscalesInstance?.address?.id}"/>

<g:hiddenField name="musician.id" value="${datosFiscalesInstance?.musician?.id}"/>
<g:hiddenField name="company.id" value="${datosFiscalesInstance?.company?.id}"/>
