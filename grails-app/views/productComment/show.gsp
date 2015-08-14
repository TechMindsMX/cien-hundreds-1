<%@ page import="com.tim.hundreds.ProductComment" %>

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

			<h4>
				<g:message code="general.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.name}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="general-label"><g:fieldValue bean="${productCommentInstance}" field="general"/></span>
				</div>
			</div>

			<h4>
				<g:message code="description.label" default="Descripción" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.description}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${productCommentInstance}" field="description"/></span>
				</div>
			</div>

			<h4>
				<g:message code="benefits.label" default="Beneficios" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.benefits}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="benefits-label"><g:fieldValue bean="${productCommentInstance}" field="benefits"/></span>
				</div>
			</div>

			<h4>
				<g:message code="target.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.target}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="target-label"><g:fieldValue bean="${productCommentInstance}" field="target"/></span>
				</div>
			</div>

			<h4>
				<g:message code="competence.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.competence}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="competence-label"><g:fieldValue bean="${productCommentInstance}" field="competence"/></span>
				</div>
			</div>

			<h4>
				<g:message code="discountModel.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.discountModel}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="discountModel-label"><g:fieldValue bean="${productCommentInstance}" field="discountModel"/></span>
				</div>
			</div>

			<h4>
				<g:message code="distributionModel.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.distributionModel}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="distributionModel-label"><g:fieldValue bean="${productCommentInstance}" field="distributionModel"/></span>
				</div>
			</div>

			<h4>
				<g:message code="customerModel.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.customerModel}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="customerModel-label"><g:fieldValue bean="${productCommentInstance}" field="customerModel"/></span>
				</div>
			</div>

			<h4>
				<g:message code="notes.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
						<li>
							${productCommentInstance.product?.notes}
						</li>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${productCommentInstance}" field="notes"/></span>
				</div>
			</div>

			<h4>
				<g:message code="complements.label" default="General" />
			</h4>
			<div class="row">
				<div class="col-md-4">
					<ul>
					<g:each in="${productCommentInstance.product?.complements}" var="c" >
						<li>
							${c.name} - precio: ${c.price}
						</li>
					</g:each>
					</ul>
				</div>
				<div class="col-md-8 form-group well">
					<span class="property-value" aria-labelledby="complements-label"><g:fieldValue bean="${productCommentInstance}" field="complements"/></span>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<p class="fieldcontain">
						<span id="product-label" class="${session.labelWidth} property-label"><g:message code="product.label" /></span>
						
							<span class="property-value" aria-labelledby="product-label"><g:link controller="product" action="show" params="[uuid: productCommentInstance?.product?.uuid]">${companyCommentInstance?.product?.name.encodeAsHTML()}</g:link></span>
						
					</p>
				</div>
			</div>

			<g:form url="[resource:productCommentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-primary edit" action="edit" params="['uuid': productCommentInstance.uuid]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
