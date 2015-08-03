<%@ page import="com.tim.hundreds.Complement" %>



<div class="form-group fieldcontain ${hasErrors(bean: complementInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="complement.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="name" id="name" maxlength="100" required="" value="${complementInstance?.name}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: complementInstance, field: 'price', 'error')} required">
	<label class="${session.labelWidth} control-label" for="price">
		<g:message code="complement.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:field class="form-control" name="price" value="${fieldValue(bean: complementInstance, field: 'price')}" required=""/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: complementInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="complement.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">

		</div>
</div>

<g:hiddenField name="uuid" id="uuid" required="" value="${complementInstance?.uuid}" class="form-control" />
<g:hiddenField name="productUuid" id="productUuid" required="" value="${complementInstance?.product?.uuid}" class="form-control many-to-one"/>
