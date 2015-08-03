<%@ page import="com.tim.hundreds.ProductComment" %>
${}
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productComment.label', default: 'ProductComment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-productComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-productComment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list productComment">
			
				<g:if test="${productCommentInstance?.general}">
				<li class="row fieldcontain">
					<span id="general-label" class="${session.labelWidth} property-label"><g:message code="productComment.general.label" default="General" /></span>
					
						<span class="property-value" aria-labelledby="general-label"><g:fieldValue bean="${productCommentInstance}" field="general"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productCommentInstance?.description}">
				<li class="row fieldcontain">
					<span id="description-label" class="${session.labelWidth} property-label"><g:message code="productComment.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${productCommentInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productCommentInstance?.benefits}">
				<li class="row fieldcontain">
					<span id="benefits-label" class="${session.labelWidth} property-label"><g:message code="productComment.benefits.label" default="Benefits" /></span>
					
						<span class="property-value" aria-labelledby="benefits-label"><g:fieldValue bean="${productCommentInstance}" field="benefits"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productCommentInstance?.target}">
				<li class="row fieldcontain">
					<span id="target-label" class="${session.labelWidth} property-label"><g:message code="productComment.target.label" default="Target" /></span>
					
						<span class="property-value" aria-labelledby="target-label"><g:fieldValue bean="${productCommentInstance}" field="target"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productCommentInstance?.competence}">
				<li class="row fieldcontain">
					<span id="competence-label" class="${session.labelWidth} property-label"><g:message code="productComment.competence.label" default="Competence" /></span>
					
						<span class="property-value" aria-labelledby="competence-label"><g:fieldValue bean="${productCommentInstance}" field="competence"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productCommentInstance?.discountModel}">
				<li class="row fieldcontain">
					<span id="discountModel-label" class="${session.labelWidth} property-label"><g:message code="productComment.discountModel.label" default="Discount Model" /></span>
					
						<span class="property-value" aria-labelledby="discountModel-label"><g:fieldValue bean="${productCommentInstance}" field="discountModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productCommentInstance?.distributionModel}">
				<li class="row fieldcontain">
					<span id="distributionModel-label" class="${session.labelWidth} property-label"><g:message code="productComment.distributionModel.label" default="Distribution Model" /></span>
					
						<span class="property-value" aria-labelledby="distributionModel-label"><g:fieldValue bean="${productCommentInstance}" field="distributionModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productCommentInstance?.customerModel}">
				<li class="row fieldcontain">
					<span id="customerModel-label" class="${session.labelWidth} property-label"><g:message code="productComment.customerModel.label" default="Customer Model" /></span>
					
						<span class="property-value" aria-labelledby="customerModel-label"><g:fieldValue bean="${productCommentInstance}" field="customerModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productCommentInstance?.notes}">
				<li class="row fieldcontain">
					<span id="notes-label" class="${session.labelWidth} property-label"><g:message code="productComment.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${productCommentInstance}" field="notes"/></span>
					
				</li>
				</g:if>
				<g:if test="${productCommentInstance?.product}">
				<li class="row fieldcontain">
					<span id="product-label" class="${session.labelWidth} property-label"><g:message code="productComment.product.label" default="Product" /></span>
					
						<span class="property-value" aria-labelledby="product-label"><g:link controller="product" action="show" id="${productCommentInstance?.product?.id}">${productCommentInstance?.product?.name.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ul>
			<g:form url="[resource:productCommentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" resource="${productCommentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
