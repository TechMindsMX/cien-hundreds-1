
<%@ page import="com.tim.hundreds.Address" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'address.label', default: 'Address')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-address" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-address" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>

						<g:sortableColumn property="street" title="${message(code: 'address.street.label', default: 'Street')}" />

						<g:sortableColumn property="zipcode" title="${message(code: 'address.zipcode.label', default: 'Zipcode')}" />

						<g:sortableColumn property="neighborhood" title="${message(code: 'address.neighborhood.label', default: 'Neighborhood')}" />

						<g:sortableColumn property="county" title="${message(code: 'address.county.label', default: 'County')}" />

						<g:sortableColumn property="town" title="${message(code: 'address.town.label', default: 'Town')}" />

						<g:sortableColumn property="state" title="${message(code: 'address.state.label', default: 'State')}" />

						<g:sortableColumn property="country" title="${message(code: 'address.country.label', default: 'Country')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${addressInstanceList}" status="i" var="addressInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${addressInstance.id}">${fieldValue(bean: addressInstance, field: "street")}</g:link></td>

						<td>${fieldValue(bean: addressInstance, field: "zipcode")}</td>

						<td>${fieldValue(bean: addressInstance, field: "neighborhood")}</td>

						<td>${fieldValue(bean: addressInstance, field: "county")}</td>

						<td>${fieldValue(bean: addressInstance, field: "town")}</td>

						<td>${fieldValue(bean: addressInstance, field: "state")}</td>

						<td><g:country code="${addressInstance.country}" /></td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${addressInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
