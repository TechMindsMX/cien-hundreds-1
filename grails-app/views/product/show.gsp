
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
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-product" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list product">
			
				<g:if test="${productInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="${session.labelWidth} property-label"><g:message code="product.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${productInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="${session.labelWidth} property-label"><g:message code="product.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${productInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.benefits}">
				<li class="fieldcontain">
					<span id="benefits-label" class="${session.labelWidth} property-label"><g:message code="product.benefits.label" default="Benefits" /></span>
					
						<span class="property-value" aria-labelledby="benefits-label"><g:fieldValue bean="${productInstance}" field="benefits"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.target}">
				<li class="fieldcontain">
					<span id="target-label" class="${session.labelWidth} property-label"><g:message code="product.target.label" default="Target" /></span>
					
						<span class="property-value" aria-labelledby="target-label"><g:fieldValue bean="${productInstance}" field="target"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.competence}">
				<li class="fieldcontain">
					<span id="competence-label" class="${session.labelWidth} property-label"><g:message code="product.competence.label" default="Competence" /></span>
					
						<span class="property-value" aria-labelledby="competence-label"><g:fieldValue bean="${productInstance}" field="competence"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.videoLink}">
				<li class="fieldcontain">
					<span id="videoLink-label" class="${session.labelWidth} property-label"><g:message code="product.videoLink.label" default="Video Link" /></span>
					
						<span class="property-value" aria-labelledby="videoLink-label"><g:fieldValue bean="${productInstance}" field="videoLink"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.discountModel}">
				<li class="fieldcontain">
					<span id="discountModel-label" class="${session.labelWidth} property-label"><g:message code="product.discountModel.label" default="Discount Model" /></span>
					
						<span class="property-value" aria-labelledby="discountModel-label"><g:fieldValue bean="${productInstance}" field="discountModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.clients}">
				<li class="fieldcontain">
					<span id="clients-label" class="${session.labelWidth} property-label"><g:message code="product.clients.label" default="Clients" /></span>
					
						<span class="property-value" aria-labelledby="clients-label"><g:fieldValue bean="${productInstance}" field="clients"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.distributionModel}">
				<li class="fieldcontain">
					<span id="distributionModel-label" class="${session.labelWidth} property-label"><g:message code="product.distributionModel.label" default="Distribution Model" /></span>
					
						<span class="property-value" aria-labelledby="distributionModel-label"><g:fieldValue bean="${productInstance}" field="distributionModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.salesModel}">
				<li class="fieldcontain">
					<span id="salesModel-label" class="${session.labelWidth} property-label"><g:message code="product.salesModel.label" default="Sales Model" /></span>
					
						<span class="property-value" aria-labelledby="salesModel-label"><g:fieldValue bean="${productInstance}" field="salesModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.customerModel}">
				<li class="fieldcontain">
					<span id="customerModel-label" class="${session.labelWidth} property-label"><g:message code="product.customerModel.label" default="Customer Model" /></span>
					
						<span class="property-value" aria-labelledby="customerModel-label"><g:fieldValue bean="${productInstance}" field="customerModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.postSaleModel}">
				<li class="fieldcontain">
					<span id="postSaleModel-label" class="${session.labelWidth} property-label"><g:message code="product.postSaleModel.label" default="Post Sale Model" /></span>
					
						<span class="property-value" aria-labelledby="postSaleModel-label"><g:fieldValue bean="${productInstance}" field="postSaleModel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="${session.labelWidth} property-label"><g:message code="product.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${productInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.webDescription}">
				<li class="fieldcontain">
					<span id="webDescription-label" class="${session.labelWidth} property-label"><g:message code="product.webDescription.label" default="Web Description" /></span>
					
						<span class="property-value" aria-labelledby="webDescription-label"><g:fieldValue bean="${productInstance}" field="webDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.telephoneDescription}">
				<li class="fieldcontain">
					<span id="telephoneDescription-label" class="${session.labelWidth} property-label"><g:message code="product.telephoneDescription.label" default="Telephone Description" /></span>
					
						<span class="property-value" aria-labelledby="telephoneDescription-label"><g:fieldValue bean="${productInstance}" field="telephoneDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.campaignDescription}">
				<li class="fieldcontain">
					<span id="campaignDescription-label" class="${session.labelWidth} property-label"><g:message code="product.campaignDescription.label" default="Campaign Description" /></span>
					
						<span class="property-value" aria-labelledby="campaignDescription-label"><g:fieldValue bean="${productInstance}" field="campaignDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.eventDescription}">
				<li class="fieldcontain">
					<span id="eventDescription-label" class="${session.labelWidth} property-label"><g:message code="product.eventDescription.label" default="Event Description" /></span>
					
						<span class="property-value" aria-labelledby="eventDescription-label"><g:fieldValue bean="${productInstance}" field="eventDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.otherDescription}">
				<li class="fieldcontain">
					<span id="otherDescription-label" class="${session.labelWidth} property-label"><g:message code="product.otherDescription.label" default="Other Description" /></span>
					
						<span class="property-value" aria-labelledby="otherDescription-label"><g:fieldValue bean="${productInstance}" field="otherDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.campaign}">
				<li class="fieldcontain">
					<span id="campaign-label" class="${session.labelWidth} property-label"><g:message code="product.campaign.label" default="Campaign" /></span>
					
						<span class="property-value" aria-labelledby="campaign-label"><g:formatBoolean boolean="${productInstance?.campaign}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="${session.labelWidth} property-label"><g:message code="product.company.label" default="Company" /></span>
					
						<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" id="${productInstance?.company?.id}">${productInstance?.company?.name?.encodeAsHTML()}</g:link></span>

				</li>
				</g:if>

				<g:if test="${productInstance?.event}">
				<li class="fieldcontain">
					<span id="event-label" class="${session.labelWidth} property-label"><g:message code="product.event.label" default="Event" /></span>

						<span class="property-value" aria-labelledby="event-label"><g:formatBoolean boolean="${productInstance?.event}" /></span>

				</li>
				</g:if>

				<g:if test="${productInstance?.other}">
				<li class="fieldcontain">
					<span id="other-label" class="${session.labelWidth} property-label"><g:message code="product.other.label" default="Other" /></span>

						<span class="property-value" aria-labelledby="other-label"><g:formatBoolean boolean="${productInstance?.other}" /></span>

				</li>
				</g:if>

				<g:if test="${productInstance?.telephone}">
				<li class="fieldcontain">
					<span id="telephone-label" class="${session.labelWidth} property-label"><g:message code="product.telephone.label" default="Telephone" /></span>

						<span class="property-value" aria-labelledby="telephone-label"><g:formatBoolean boolean="${productInstance?.telephone}" /></span>

				</li>
				</g:if>

				<g:if test="${productInstance?.uuid}">
				<li class="fieldcontain">
					<span id="uuid-label" class="${session.labelWidth} property-label"><g:message code="product.uuid.label" default="Uuid" /></span>

						<span class="property-value" aria-labelledby="uuid-label"><g:fieldValue bean="${productInstance}" field="uuid"/></span>

				</li>
				</g:if>

				<g:if test="${productInstance?.web}">
				<li class="fieldcontain">
					<span id="web-label" class="${session.labelWidth} property-label"><g:message code="product.web.label" default="Web" /></span>

						<span class="property-value" aria-labelledby="web-label"><g:formatBoolean boolean="${productInstance?.web}" /></span>

				</li>
				</g:if>

			</ul>
			<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'complements', 'error')} ">
				<label class="${session.labelWidth} control-label" for="complements">
					<g:message code="product.complements.label" default="Complements" />

				</label>
				<div class="${session.inputWidth}">

					<ul class="one-to-many">
						<g:each in="${productInstance?.complements}" var="c">
							<li><g:link controller="complement" action="show" id="${c.id}">${c?.name?.encodeAsHTML()}</g:link></li>
						</g:each>
						<li class="add">
							<g:link controller="complement" action="create" params="['product.id': productInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'complement.label', default: 'Complement')])}</g:link>
						</li>
					</ul>


				</div>
			</div>
			<div class="clearfix"> </div>
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
		</div>
	</body>
</html>
