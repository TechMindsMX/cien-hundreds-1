<%@ page import="com.tim.hundreds.Product" %>

<script>
	function enableDisableTextAreas() {
		var checkbox = $(this);
		var idDescription = checkbox.prop('id')+'Description';

		if( checkbox.prop('checked') ){
			$('#'+idDescription).prop('disabled', false);
		}else{
			$('#'+idDescription).prop('disabled', true);
		}
	}

	$(document).ready(function(){
		$('input:checkbox').on('change', enableDisableTextAreas);
		$('input:checkbox').each(enableDisableTextAreas);

	});
</script>


<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} required">
	<label class="${session.labelWidth} control-label" for="name">
		<g:message code="product.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="name" id="name" maxlength="100" required="" value="${productInstance?.name}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} required">
	<label class="${session.labelWidth} control-label" for="description">
		<g:message code="product.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="description" id="description" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.description}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'benefits', 'error')} required">
	<label class="${session.labelWidth} control-label" for="benefits">
		<g:message code="product.benefits.label" default="Benefits" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="benefits" id="benefits" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.benefits}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'target', 'error')} required">
	<label class="${session.labelWidth} control-label" for="target">
		<g:message code="product.target.label" default="Target" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="target" id="target" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.target}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'competence', 'error')} required">
	<label class="${session.labelWidth} control-label" for="competence">
		<g:message code="product.competence.label" default="Competence" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="competence" id="competence" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.competence}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'videoLink', 'error')} required">
	<label class="${session.labelWidth} control-label" for="videoLink">
		<g:message code="product.videoLink.label" default="Video Link" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="videoLink" id="videoLink" maxlength="100" required="" value="${productInstance?.videoLink}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'discountModel', 'error')} ">
	<label class="${session.labelWidth} control-label" for="discountModel">
		<g:message code="product.discountModel.label" default="Discount Model" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="discountModel" id="discountModel" cols="40" rows="5" maxlength="10000" value="${productInstance?.discountModel}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'clients', 'error')} required">
	<label class="${session.labelWidth} control-label" for="clients">
		<g:message code="product.clients.label" default="Clients" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="clients" id="clients" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.clients}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'distributionModel', 'error')} ">
	<label class="${session.labelWidth} control-label" for="distributionModel">
		<g:message code="product.distributionModel.label" default="Distribution Model" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="distributionModel" id="distributionModel" cols="40" rows="5" maxlength="10000" value="${productInstance?.distributionModel}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'salesModel', 'error')} ">
	<label class="${session.labelWidth} control-label" for="salesModel">
		<g:message code="product.salesModel.label" default="Sales Model" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="salesModel" id="salesModel" cols="40" rows="5" maxlength="10000" value="${productInstance?.salesModel}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'customerModel', 'error')} required">
	<label class="${session.labelWidth} control-label" for="customerModel">
		<g:message code="product.customerModel.label" default="Customer Model" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="customerModel" id="customerModel" cols="40" rows="5" maxlength="10000" required="" value="${productInstance?.customerModel}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'postSaleModel', 'error')} ">
	<label class="${session.labelWidth} control-label" for="postSaleModel">
		<g:message code="product.postSaleModel.label" default="Post Sale Model" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="postSaleModel" id="postSaleModel" cols="40" rows="5" maxlength="10000" value="${productInstance?.postSaleModel}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'notes', 'error')} ">
	<label class="${session.labelWidth} control-label" for="notes">
		<g:message code="product.notes.label" default="Notes" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="notes" id="notes" cols="40" rows="5" maxlength="10000" value="${productInstance?.notes}"/>

	</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: productInstance, field: 'company', 'error')} required">
	<label class="${session.labelWidth} control-label" for="company">
		<g:message code="product.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:select id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionKey="id" optionValue="name" required="" value="${productInstance?.company?.id}" class="form-control many-to-one"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'campaign', 'error')} ">
	<label class="${session.labelWidth} control-label" for="campaign">
		<g:message code="product.campaign.label" default="Campaign" />

	</label>
	<div class="${session.inputWidth}">
		<g:checkBox class="form-control" name="campaign" value="${productInstance?.campaign}" />

	</div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'campaignDescription', 'error')} ">
	<label class="${session.labelWidth} control-label" for="campaignDescription">
		<g:message code="product.campaignDescription.label" default="Campaign Description" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="campaignDescription" id="campaignDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.campaignDescription}" disabled="disabled"/>

	</div>
</div>


<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'event', 'error')} ">
	<label class="${session.labelWidth} control-label" for="event">
		<g:message code="product.event.label" default="Event" />

	</label>
	<div class="${session.inputWidth}">
		<g:checkBox class="form-control" name="event" value="${productInstance?.event}" />

	</div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'eventDescription', 'error')} ">
	<label class="${session.labelWidth} control-label" for="eventDescription">
		<g:message code="product.eventDescription.label" default="Event Description" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="eventDescription" id="eventDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.eventDescription}" disabled="disabled"/>

	</div>
</div>


<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'other', 'error')} ">
	<label class="${session.labelWidth} control-label" for="other">
		<g:message code="product.other.label" default="Other" />

	</label>
	<div class="${session.inputWidth}">
		<g:checkBox class="form-control" name="other" value="${productInstance?.other}" />

	</div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'otherDescription', 'error')} ">
	<label class="${session.labelWidth} control-label" for="otherDescription">
		<g:message code="product.otherDescription.label" default="Other Description" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="otherDescription" id="otherDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.otherDescription}" disabled="disabled"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'telephone', 'error')} ">
	<label class="${session.labelWidth} control-label" for="telephone">
		<g:message code="product.telephone.label" default="Telephone" />

	</label>
	<div class="${session.inputWidth}">
		<g:checkBox class="form-control" name="telephone" value="${productInstance?.telephone}" />

	</div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'telephoneDescription', 'error')} ">
	<label class="${session.labelWidth} control-label" for="telephoneDescription">
		<g:message code="product.telephoneDescription.label" default="Telephone Description" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="telephoneDescription" id="telephoneDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.telephoneDescription}" disabled="disabled"/>

	</div>
</div>


<div class="hide form-group fieldcontain ${hasErrors(bean: productInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="product.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="uuid" id="uuid" required="" value="${productInstance?.uuid}"/>

	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'web', 'error')} ">
	<label class="${session.labelWidth} control-label" for="web">
		<g:message code="product.web.label" default="Web" />

	</label>
	<div class="${session.inputWidth}">
		<g:checkBox class="form-control" name="web" value="${productInstance?.web}" />

	</div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: productInstance, field: 'webDescription', 'error')} ">
	<label class="${session.labelWidth} control-label" for="webDescription">
		<g:message code="product.webDescription.label" default="Web Description" />

	</label>
	<div class="${session.inputWidth}">
		<g:textArea class="form-control" name="webDescription" id="webDescription" cols="40" rows="5" maxlength="10000" value="${productInstance?.webDescription}" disabled="disabled"/>

	</div>
</div>


