<%@ page import="com.tim.hundreds.Address" %>

<g:set var="labelWidth" value="col-sm-2" />
<g:set var="inputWidth" value="col-sm-10 col-lg-6" />

<g:javascript src="sepomex.js" />

<div class="form-group fieldcontain ${hasErrors(bean: addressInstance, field: 'country', 'error')} required">
	<label for="country" class="${labelWidth} control-label">
		<g:message code="address.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:countrySelect name="country" id="country" value="${addressInstance?.country}" noSelection="['':'-Seleccione-']" class="form-control" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: addressInstance, field: 'street', 'error')} required">
	<label for="street" class="${labelWidth} control-label">
		<g:message code="address.street.label" default="Street" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField name="street" id="street" maxlength="200" required="" value="${addressInstance?.street}" class="form-control" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: addressInstance, field: 'zipcode', 'error')} required">
	<label for="zipcode" class="${labelWidth} control-label">
		<g:message code="address.zipcode.label" default="Zipcode" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField name="zipcode" id="zipcode" maxlength="5" required="" value="${addressInstance?.zipcode}" class="form-control" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: addressInstance, field: 'neighborhood', 'error')} required">
	<label for="neighborhood" class="${labelWidth} control-label">
		<g:message code="address.neighborhood.label" default="Neighborhood" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField name="neighborhood" id="neighborhood" maxlength="100" required="" value="${addressInstance?.neighborhood}" class="form-control" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: addressInstance, field: 'county', 'error')} required">
	<label for="county" class="${labelWidth} control-label">
		<g:message code="address.county.label" default="County" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField name="county" id="county" maxlength="100" required="" value="${addressInstance?.county}" class="form-control" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: addressInstance, field: 'town', 'error')} required">
	<label for="town" class="${labelWidth} control-label">
		<g:message code="address.town.label" default="Town" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField name="town" id="town" maxlength="100" required="" value="${addressInstance?.town}" class="form-control" />
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: addressInstance, field: 'state', 'error')} required">
	<label for="state" class="${labelWidth} control-label">
		<g:message code="address.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${inputWidth}">
		<g:textField name="state" id="state" maxlength="100" required="" value="${addressInstance?.state}" class="form-control" />
	</div>
</div>

<g:hiddenField name="musicianUuid" value="${addressInstance.musician?.uuid}"/>
<g:hiddenField name="contactUuid" value="${addressInstance.contact?.uuid}"/>
<g:hiddenField name="companyUuid" value="${addressInstance.company?.uuid}"/>
<g:hiddenField name="datosFiscalesUuid" value="${addressInstance?.datosFiscales?.uuid}"/>


