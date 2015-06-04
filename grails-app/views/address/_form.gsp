<%@ page import="com.tim.hundreds.Address" %>



<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'street', 'error')} required">
	<label for="street">
		<g:message code="address.street.label" default="Street" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="street" maxlength="200" required="" value="${addressInstance?.street}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'zipcode', 'error')} required">
	<label for="zipcode">
		<g:message code="address.zipcode.label" default="Zipcode" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="zipcode" maxlength="5" required="" value="${addressInstance?.zipcode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'neighborhood', 'error')} required">
	<label for="neighborhood">
		<g:message code="address.neighborhood.label" default="Neighborhood" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="neighborhood" maxlength="100" required="" value="${addressInstance?.neighborhood}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'town', 'error')} required">
	<label for="town">
		<g:message code="address.town.label" default="Town" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="town" maxlength="100" required="" value="${addressInstance?.town}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="address.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="state" maxlength="100" required="" value="${addressInstance?.state}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="address.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="country" maxlength="100" required="" value="${addressInstance?.country}"/>

</div>

<g:hiddenField name="musicianId" value="${params?.musicianId}"/>
<g:hiddenField name="contactId" value="${params?.contactId}"/>
<g:hiddenField name="datosFiscalesId" value="${params?.datosFiscalesId}"/>


