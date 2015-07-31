
<%@ page import="com.tim.hundreds.Product" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul class="nav nav-pills">
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		
	</ul>
</div>
<div id="show-product" class="content scaffold-show" role="main">
	<h1><g:message code="default.show.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<div class="property-list product">

		<g:if test="${productInstance?.name}">
			<div class="fieldcontain row">
				<span id="name-label" class="${session.labelWidth} property-label"><g:message code="product.name.label" default="Name" /></span>

				<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${productInstance}" field="name"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.description}">
			<div class="fieldcontain row">
				<span id="description-label" class="${session.labelWidth} property-label"><g:message code="product.description.label" default="Description" /></span>

				<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${productInstance}" field="description"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.benefits}">
			<div class="fieldcontain row">
				<span id="benefits-label" class="${session.labelWidth} property-label"><g:message code="product.benefits.label" default="Benefits" /></span>

				<span class="property-value" aria-labelledby="benefits-label"><g:fieldValue bean="${productInstance}" field="benefits"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.target}">
			<div class="fieldcontain row">
				<span id="target-label" class="${session.labelWidth} property-label"><g:message code="product.target.label" default="Target" /></span>

				<span class="property-value" aria-labelledby="target-label"><g:fieldValue bean="${productInstance}" field="target"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.competence}">
			<div class="fieldcontain row">
				<span id="competence-label" class="${session.labelWidth} property-label"><g:message code="product.competence.label" default="Competence" /></span>

				<span class="property-value" aria-labelledby="competence-label"><g:fieldValue bean="${productInstance}" field="competence"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.videoLink}">
			<div class="fieldcontain row">
				<span id="videoLink-label" class="${session.labelWidth} property-label"><g:message code="product.videoLink.label" default="Video Link" /></span>

				<span class="property-value" aria-labelledby="videoLink-label">
					<a href="<g:fieldValue bean="${productInstance}" field="videoLink"/>" target="_blank">
						<g:fieldValue bean="${productInstance}" field="videoLink"/>
					</a>
				</span>

			</div>
		</g:if>

		<g:if test="${productInstance?.discountModel}">
			<div class="fieldcontain row">
				<span id="discountModel-label" class="${session.labelWidth} property-label"><g:message code="product.discountModel.label" default="Discount Model" /></span>

				<span class="property-value" aria-labelledby="discountModel-label"><g:fieldValue bean="${productInstance}" field="discountModel"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.clients}">
			<div class="fieldcontain row">
				<span id="clients-label" class="${session.labelWidth} property-label"><g:message code="product.clients.label" default="Clients" /></span>

				<span class="property-value" aria-labelledby="clients-label"><g:fieldValue bean="${productInstance}" field="clients"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.distributionModel}">
			<div class="fieldcontain row">
				<span id="distributionModel-label" class="${session.labelWidth} property-label"><g:message code="product.distributionModel.label" default="Distribution Model" /></span>

				<span class="property-value" aria-labelledby="distributionModel-label"><g:fieldValue bean="${productInstance}" field="distributionModel"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.salesModel}">
			<div class="fieldcontain row">
				<span id="salesModel-label" class="${session.labelWidth} property-label"><g:message code="product.salesModel.label" default="Sales Model" /></span>

				<span class="property-value" aria-labelledby="salesModel-label"><g:fieldValue bean="${productInstance}" field="salesModel"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.customerModel}">
			<div class="fieldcontain row">
				<span id="customerModel-label" class="${session.labelWidth} property-label"><g:message code="product.customerModel.label" default="Customer Model" /></span>

				<span class="property-value" aria-labelledby="customerModel-label"><g:fieldValue bean="${productInstance}" field="customerModel"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.postSaleModel}">
			<div class="fieldcontain row">
				<span id="postSaleModel-label" class="${session.labelWidth} property-label"><g:message code="product.postSaleModel.label" default="Post Sale Model" /></span>

				<span class="property-value" aria-labelledby="postSaleModel-label"><g:fieldValue bean="${productInstance}" field="postSaleModel"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.notes}">
			<div class="fieldcontain row">
				<span id="notes-label" class="${session.labelWidth} property-label"><g:message code="product.notes.label" default="Notes" /></span>

				<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${productInstance}" field="notes"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.web && productInstance?.webDescription}">
			<div class="fieldcontain row">
				<span id="webDescription-label" class="${session.labelWidth} property-label"><g:message code="product.webDescription.label" default="Web Description" /></span>

				<span class="property-value" aria-labelledby="webDescription-label"><g:fieldValue bean="${productInstance}" field="webDescription"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.telephone && productInstance?.telephoneDescription}">
			<div class="fieldcontain row">
				<span id="telephoneDescription-label" class="${session.labelWidth} property-label"><g:message code="product.telephoneDescription.label" default="Telephone Description" /></span>

				<span class="property-value" aria-labelledby="telephoneDescription-label"><g:fieldValue bean="${productInstance}" field="telephoneDescription"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.campaign && productInstance?.campaignDescription}">
			<div class="fieldcontain row">
				<span id="campaignDescription-label" class="${session.labelWidth} property-label"><g:message code="product.campaignDescription.label" default="Campaign Description" /></span>

				<span class="property-value" aria-labelledby="campaignDescription-label"><g:fieldValue bean="${productInstance}" field="campaignDescription"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.event && productInstance?.eventDescription}">
			<div class="fieldcontain row">
				<span id="eventDescription-label" class="${session.labelWidth} property-label"><g:message code="product.eventDescription.label" default="Event Description" /></span>

				<span class="property-value" aria-labelledby="eventDescription-label"><g:fieldValue bean="${productInstance}" field="eventDescription"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.other && productInstance?.otherDescription}">
			<div class="fieldcontain row">
				<span id="otherDescription-label" class="${session.labelWidth} property-label"><g:message code="product.otherDescription.label" default="Other Description" /></span>

				<span class="property-value" aria-labelledby="otherDescription-label"><g:fieldValue bean="${productInstance}" field="otherDescription"/></span>

			</div>
		</g:if>

		<g:if test="${productInstance?.company}">
			<div class="fieldcontain row">
				<span id="company-label" class="${session.labelWidth} property-label"><g:message code="company.label" default="Company" /></span>

				<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" id="${productInstance?.company?.id}">${productInstance?.company?.name?.encodeAsHTML()}</g:link></span>

			</div>
		</g:if>

	</div>
	<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'complements', 'error')} ">
		<label class="${session.labelWidth} control-label" for="complements">
			<g:message code="product.complements.label" default="Complements" />

		</label>
		<div class="${session.inputWidth}">

			<ul class="one-to-many">
				<g:each in="${productInstance?.complements}" var="c">
					<li><g:link controller="complement" action="show" id="${c.id}">${c?.name?.encodeAsHTML()}</g:link></li>
				</g:each>
				<sec:ifAnyGranted roles="ROLE_USER">
					<li class="add">
						<g:link controller="complement" action="create" params="['product.id': productInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'complement.label', default: 'Complement')])}</g:link>
					</li>
				</sec:ifAnyGranted>
			</ul>


		</div>
	</div>
	<div class="clearfix"> </div>

	<sec:ifAnyGranted roles="ROLE_USER">
		<g:form url="[resource:productInstance, action:'delete']" method="DELETE">
			<fieldset class="buttons">
				<g:link class="btn btn-primary edit" action="edit" resource="${productInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>

				<sec:ifAnyGranted roles="ROLE_BUYER">
					<g:if test="${!productInstance?.productComment}">
						<g:link class="btn btn-success" controller="productComment" action="create" params="['product.id': productInstance.id]" >${message(code: 'default.add.label', args: [message(code: 'productComment.label')])}</g:link>
					</g:if>
					<g:else>
						<g:link class="btn btn-success" controller="productComment" action="edit" id="${productInstance.productComment.id}" >${message(code: 'default.edit.label', args: [message(code: 'productComment.label')])}</g:link>
					</g:else>
				</sec:ifAnyGranted>

				<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</sec:ifAnyGranted>
</div>
</body>
</html>
