
<%@ page import="com.tim.hundreds.DatosFiscales" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'datosFiscales.label', default: 'DatosFiscales')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-datosFiscales" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-datosFiscales" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="razonSocial" title="${message(code: 'datosFiscales.razonSocial.label', default: 'Razon Social')}" />
					
						<g:sortableColumn property="rfc" title="${message(code: 'datosFiscales.rfc.label', default: 'Rfc')}" />
					
						<th><g:message code="datosFiscales.address.label" default="Address" /></th>
					
						<th><g:message code="datosFiscales.musician.label" default="Musician" /></th>
					
						<g:sortableColumn property="tipoPersona" title="${message(code: 'datosFiscales.tipoPersona.label', default: 'Tipo Persona')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${datosFiscalesInstanceList}" status="i" var="datosFiscalesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${datosFiscalesInstance.id}">${fieldValue(bean: datosFiscalesInstance, field: "razonSocial")}</g:link></td>
					
						<td>${fieldValue(bean: datosFiscalesInstance, field: "rfc")}</td>
					
						<td>${fieldValue(bean: datosFiscalesInstance, field: "address")}</td>
					
						<td>${fieldValue(bean: datosFiscalesInstance, field: "musician")}</td>
					
						<td><g:formatBoolean boolean="${datosFiscalesInstance.tipoPersona}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${datosFiscalesInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
