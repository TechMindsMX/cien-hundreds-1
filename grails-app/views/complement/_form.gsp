<%@ page import="com.tim.hundreds.Complement" %>



<div class="fieldcontain ${hasErrors(bean: complementInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="complement.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${complementInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: complementInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="complement.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: complementInstance, field: 'price')}" required=""/>

</div>

<div class="hide fieldcontain ${hasErrors(bean: complementInstance, field: 'product', 'error')} required">
	<label for="product">
		<g:message code="complement.product.label" default="Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="product" name="product.id" from="${com.tim.hundreds.Product.list()}" optionKey="id" required="" value="${complementInstance?.product?.id || params?.product?.id}" class="many-to-one"/>

</div>

