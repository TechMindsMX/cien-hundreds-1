<%@ page import="com.tim.hundreds.Musician" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musician.label', default: 'Musician')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-musician" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-musician" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-stripped">
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'musician.name.label', default: 'Nombre(s)')}" />
						<th>${message(code: 'telephone.label', default: 'Teléfonoooo')}</th>
						<th>${message(code: 'email.label', default: 'Correo')}</th>
						<g:sortableColumn property="dateCreated" title="${message(code: 'musician.dateCreated.label', default: 'Fecha de creación')}" />
						<g:sortableColumn property="logoPath" title="${message(code: 'musician.logoPath.label', default: 'Logo')}" class="col-sm-12 col-md-4" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${musicianInstanceList}" status="i" var="musicianInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${musicianInstance.id}">${fieldValue(bean: musicianInstance, field: "name")}</g:link></td>
						<td>
							<g:each in="${musicianInstance.contacts?.telephones}" var="v"><% v.phone.each {println it} %></g:each>
						</td>
						<td>
							<g:each in="${musicianInstance.contacts?.emails}" var="v"><% v.address.each {println it} %></g:each>
						</td>
						<td><g:formatDate format="dd-MM-yyyy" date="${musicianInstance.dateCreated}" /></td>
										
						<td>
							<g:if test="${musicianInstance.logoPath}">
								<img class="img-responsive max300" src="${grailsApplication.config.base.logo.url}${musicianInstance.logoPath}" />
							</g:if>
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${musicianInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
