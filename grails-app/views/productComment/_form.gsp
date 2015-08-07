<%@ page import="com.tim.hundreds.ProductComment" %>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.name}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'general', 'error')} ">
		<label class="${session.labelWidth} control-label" for="general">
			<g:message code="productComment.general.label" default="General" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="general" id="general" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.general}"/>

			</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.description}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'description', 'error')} ">
		<label class="${session.labelWidth} control-label" for="description">
			<g:message code="productComment.description.label" default="Description" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="description" id="description" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.description}"/>

			</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.benefits}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'benefits', 'error')} ">
		<label class="${session.labelWidth} control-label" for="benefits">
			<g:message code="productComment.benefits.label" default="Benefits" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="benefits" id="benefits" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.benefits}"/>

			</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.target}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'target', 'error')} ">
		<label class="${session.labelWidth} control-label" for="target">
			<g:message code="productComment.target.label" default="Target" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="target" id="target" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.target}"/>

			</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.competence}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'competence', 'error')} ">
		<label class="${session.labelWidth} control-label" for="competence">
			<g:message code="productComment.competence.label" default="Competence" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="competence" id="competence" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.competence}"/>

			</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.discountModel}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'discountModel', 'error')} ">
		<label class="${session.labelWidth} control-label" for="discountModel">
			<g:message code="productComment.discountModel.label" default="Discount Model" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="discountModel" id="discountModel" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.discountModel}"/>

			</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.distributionModel}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'distributionModel', 'error')} ">
		<label class="${session.labelWidth} control-label" for="distributionModel">
			<g:message code="productComment.distributionModel.label" default="Distribution Model" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="distributionModel" id="distributionModel" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.distributionModel}"/>

			</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.customerModel}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'customerModel', 'error')} ">
		<label class="${session.labelWidth} control-label" for="customerModel">
			<g:message code="productComment.customerModel.label" default="Customer Model" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="customerModel" id="customerModel" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.customerModel}"/>

			</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${productCommentInstance.product?.notes}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: productCommentInstance, field: 'notes', 'error')} ">
		<label class="${session.labelWidth} control-label" for="notes">
			<g:message code="productComment.notes.label" default="Notes" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="notes" id="notes" cols="40" rows="5" maxlength="10000" value="${productCommentInstance?.notes}"/>

			</div>
	</div>
</div>

<g:hiddenField name="product.id" value="${productCommentInstance?.product?.id}" required="" />
