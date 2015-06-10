
<%@ page import="com.tim.hundreds.Company" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-company" class="ibox float-e-margins" role="main">
			
			<div class="ibox-title">
				<div class="ibox-title text-head-color">
                	<h1>Listado de Copañías</h>
            	</div>
				<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
				</g:if>
			</div>
			
			<div class="ibox-content">
				<div class="table-responsive">
					<table class="table table-bordered table-striped">
					<thead>
							<tr>
							
								<g:sortableColumn property="name" title="${message(code: 'company.name.label', default: 'Nombre')}" />
							
								<g:sortableColumn property="description" title="${message(code: 'company.description.label', default: 'Description')}" />
							
								<g:sortableColumn property="web" title="${message(code: 'company.web.label', default: 'Web')}" />
							
								<g:sortableColumn property="notes" title="${message(code: 'company.notes.label', default: 'Notas Adicionales')}" />
							
								<g:sortableColumn property="tags" title="${message(code: 'company.tags.label', default: 'Tags')}" />
							
								<g:sortableColumn property="logo" title="${message(code: 'company.logo.label', default: 'Logo')}" />
							
							</tr>
						</thead>
						<tbody>
						<g:each in="${companyInstanceList}" status="i" var="companyInstance">
							<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							
								<td><g:link action="show" id="${companyInstance.id}">${fieldValue(bean: companyInstance, field: "name")}</g:link></td>
							
								<td>${fieldValue(bean: companyInstance, field: "description")}</td>
							
								<td>${fieldValue(bean: companyInstance, field: "web")}</td>
							
								<td>${fieldValue(bean: companyInstance, field: "notes")}</td>
							
								<td>${fieldValue(bean: companyInstance, field: "tags")}</td>
							
								<td>${fieldValue(bean: companyInstance, field: "logo")}</td>
							
							</tr>
						</g:each>
						</tbody>
					</table>
				</div>
			</div>
			<div class="pagination">
				<g:paginate total="${companyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
