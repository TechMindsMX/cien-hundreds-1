
<%@ page import="com.tim.hundreds.ProductComment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productComment.label', default: 'ProductComment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-productComment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-productComment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="general" title="${message(code: 'productComment.general.label', default: 'General')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'productComment.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="benefits" title="${message(code: 'productComment.benefits.label', default: 'Benefits')}" />
					
						<g:sortableColumn property="target" title="${message(code: 'productComment.target.label', default: 'Target')}" />
					
						<g:sortableColumn property="competence" title="${message(code: 'productComment.competence.label', default: 'Competence')}" />
					
						<g:sortableColumn property="discountModel" title="${message(code: 'productComment.discountModel.label', default: 'Discount Model')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productCommentInstanceList}" status="i" var="productCommentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${productCommentInstance.id}">${fieldValue(bean: productCommentInstance, field: "general")}</g:link></td>
					
						<td>${fieldValue(bean: productCommentInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: productCommentInstance, field: "benefits")}</td>
					
						<td>${fieldValue(bean: productCommentInstance, field: "target")}</td>
					
						<td>${fieldValue(bean: productCommentInstance, field: "competence")}</td>
					
						<td>${fieldValue(bean: productCommentInstance, field: "discountModel")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productCommentInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
