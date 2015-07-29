
<%@ page import="com.tim.hundreds.Complement" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'complement.label', default: 'Complement')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-complement" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="show-complement" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>

			<ul class="property-list complement">
			
				<g:if test="${complementInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="${session.labelWidth} property-label"><g:message code="complement.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${complementInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complementInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="${session.labelWidth} property-label"><g:message code="complement.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${complementInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complementInstance?.product}">
				<li class="fieldcontain">
					<span id="product-label" class="${session.labelWidth} property-label"><g:message code="complement.product.label" default="Product" /></span>
					
						<span class="property-value" aria-labelledby="product-label"><g:link controller="product" action="show" id="${complementInstance?.product?.id}">${complementInstance?.product?.name.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ul>

			<sec:ifAnyGranted roles="ROLE_USER">
				<g:form url="[resource:complementInstance, action:'delete']" method="DELETE">
					<fieldset class="buttons">
						<g:link class="btn btn-primary edit" action="edit" resource="${complementInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
						<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</fieldset>
				</g:form>
			</sec:ifAnyGranted>
		</div>
	</body>
</html>
