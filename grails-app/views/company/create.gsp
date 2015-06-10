<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-company" class="content scaffold-create" role="main">
			<div class="ibox-title text-head-color">
                <h1>Creación de Copañía</h1>
            </div>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${companyInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${companyInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:uploadForm url="[resource:companyInstance, action:'save']" >
				
				<div class="form-horizontal">
					<g:render template="form"/>
				
					<div class="ibox-content text-center ${hasErrors(bean: musicianInstance, field: 'logo', 'error')} ">					  
						<g:submitButton name="create" class="btn btn-success" value="${message(code: 'default.button.create.label', default: 'Create')}" />
						<button class="btn btn-danger" type="reset">Cancelar</button>
					</div>
				</div>

			</g:uploadForm>
		</div>
	</body>
</html>
