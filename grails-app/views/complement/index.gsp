
<%@ page import="com.tim.hundreds.Complement" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'complement.label', default: 'Complement')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-complement" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-complement" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'complement.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'complement.price.label', default: 'Price')}" />
					
						<th><g:message code="complement.product.label" default="Product" /></th>
					
						<g:sortableColumn property="uuid" title="${message(code: 'complement.uuid.label', default: 'Uuid')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${complementInstanceList}" status="i" var="complementInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" params="['uuid': complementInstance.uuid]">${fieldValue(bean: complementInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: complementInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: complementInstance, field: "product")}</td>
					
						<td>${fieldValue(bean: complementInstance, field: "uuid")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${complementInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
