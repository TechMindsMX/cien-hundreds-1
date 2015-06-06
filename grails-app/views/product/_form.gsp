<%@ page import="com.tim.hundreds.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="product.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${productInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="product.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'benefits', 'error')} required">
	<label for="benefits">
		<g:message code="product.benefits.label" default="Benefits" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="benefits" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.benefits}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'target', 'error')} required">
	<label for="target">
		<g:message code="product.target.label" default="Target" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="target" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.target}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'competence', 'error')} required">
	<label for="competence">
		<g:message code="product.competence.label" default="Competence" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="competence" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.competence}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'videoLink', 'error')} required">
	<label for="videoLink">
		<g:message code="product.videoLink.label" default="Video Link" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="videoLink" maxlength="100" required="" value="${productInstance?.videoLink}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'discountModel', 'error')} ">
	<label for="discountModel">
		<g:message code="product.discountModel.label" default="Discount Model" />
		
	</label>
	<g:textArea name="discountModel" cols="40" rows="5" maxlength="10000" value="${productInstance?.discountModel}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'clients', 'error')} required">
	<label for="clients">
		<g:message code="product.clients.label" default="Clients" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="clients" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.clients}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'distributionModel', 'error')} ">
	<label for="distributionModel">
		<g:message code="product.distributionModel.label" default="Distribution Model" />
		
	</label>
	<g:textArea name="distributionModel" cols="40" rows="5" maxlength="10000" value="${productInstance?.distributionModel}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'salesModel', 'error')} ">
	<label for="salesModel">
		<g:message code="product.salesModel.label" default="Sales Model" />
		
	</label>
	<g:textArea name="salesModel" cols="40" rows="5" maxlength="10000" value="${productInstance?.salesModel}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'customerModel', 'error')} required">
	<label for="customerModel">
		<g:message code="product.customerModel.label" default="Customer Model" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="customerModel" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.customerModel}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'postSaleModel', 'error')} ">
	<label for="postSaleModel">
		<g:message code="product.postSaleModel.label" default="Post Sale Model" />
		
	</label>
	<g:textArea name="postSaleModel" cols="40" rows="5" maxlength="10000" value="${productInstance?.postSaleModel}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="product.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="10000" value="${productInstance?.notes}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'webDescription', 'error')} ">
	<label for="webDescription">
		<g:message code="product.webDescription.label" default="Web Description" />
		
	</label>
	<g:textArea name="webDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.webDescription}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'telephoneDescription', 'error')} ">
	<label for="telephoneDescription">
		<g:message code="product.telephoneDescription.label" default="Telephone Description" />
		
	</label>
	<g:textArea name="telephoneDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.telephoneDescription}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'campaingDescription', 'error')} ">
	<label for="campaingDescription">
		<g:message code="product.campaingDescription.label" default="Campaing Description" />
		
	</label>
	<g:textArea name="campaingDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.campaingDescription}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'eventDescription', 'error')} ">
	<label for="eventDescription">
		<g:message code="product.eventDescription.label" default="Event Description" />
		
	</label>
	<g:textArea name="eventDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.eventDescription}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'otherDescription', 'error')} ">
	<label for="otherDescription">
		<g:message code="product.otherDescription.label" default="Other Description" />
		
	</label>
	<g:textArea name="otherDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.otherDescription}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'campaing', 'error')} ">
	<label for="campaing">
		<g:message code="product.campaing.label" default="Campaing" />
		
	</label>
	<g:checkBox name="campaing" value="${productInstance?.campaing}" />

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'company', 'error')} required">
	<label for="company">
		<g:message code="product.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionKey="id" required="" value="${productInstance?.company?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'complements', 'error')} ">
	<label for="complements">
		<g:message code="product.complements.label" default="Complements" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${productInstance?.complements?}" var="c">
    <li><g:link controller="complement" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="complement" action="create" params="['product.id': productInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'complement.label', default: 'Complement')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'event', 'error')} ">
	<label for="event">
		<g:message code="product.event.label" default="Event" />
		
	</label>
	<g:checkBox name="event" value="${productInstance?.event}" />

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'other', 'error')} ">
	<label for="other">
		<g:message code="product.other.label" default="Other" />
		
	</label>
	<g:checkBox name="other" value="${productInstance?.other}" />

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'telephone', 'error')} ">
	<label for="telephone">
		<g:message code="product.telephone.label" default="Telephone" />
		
	</label>
	<g:checkBox name="telephone" value="${productInstance?.telephone}" />

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'web', 'error')} ">
	<label for="web">
		<g:message code="product.web.label" default="Web" />
		
	</label>
	<g:checkBox name="web" value="${productInstance?.web}" />

</div>

