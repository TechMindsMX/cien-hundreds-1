
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
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
    <section class="content">
    	<g:form action="creationReportFilter" class="form form-inline">
			<div class="form-group">
				<label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: companyInstance, field: 'from', 'error')} required">
					<g:message code="company.from.label" default="Desde" />
				</label>
				<div class="${session.inputWidth}">
					<g:timDatePicker class="form-control" name="from" maxDate="-0D" changeMonth="true" changeYear="true"></g:timDatePicker>
				</div>
			</div>
			<div class="form-group">
				<label class="${session.labelWidth} control-label fieldcontain ${hasErrors(bean: companyInstance, field: 'to', 'error')} required">
					<g:message code="company.to.label" default="Hasta" />
				</label>
				<div class="${session.inputWidth}">
					<g:timDatePicker class="form-control" name="to" maxDate="-0D" changeMonth="true" changeYear="true" ></g:timDatePicker>
				</div>
			</div>
			<div class="form-group">
				<div class="${session.inputWidth}">
					<g:submitButton name="send" class="btn btn-success" value="${message(code: 'default.button.send.label', default: 'Enviar')}" />
				</div>
			</div>
    	</g:form>
    </section>
		<div id="list-company" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>

						<g:sortableColumn property="name" title="${message(code: 'company.name.label', default: 'Name')}" />
						<th>${message(code: 'telephone.label', default: 'Teléfono')}</th>
						<th>${message(code: 'email.label', default: 'Correo')}</th>
						<g:sortableColumn property="dateCreated" title="${message(code: 'default.dateCreated.label', default: 'Fecha de creación')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${companyInstanceList}" status="i" var="companyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${companyInstance.id}">${fieldValue(bean: companyInstance, field: "name")}</g:link></td>
						<td>
							<g:each in="${companyInstance.collaborators?.telephones}" var="v"><% v.phone.each {println it} %></g:each>
						</td>
						<td>
							<g:each in="${companyInstance.collaborators?.emails}" var="v"><% v.address.each {println it} %></g:each>
						</td>
						<td><g:formatDate format="dd-MM-yyyy" date="${companyInstance.dateCreated}" /></td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${companyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
