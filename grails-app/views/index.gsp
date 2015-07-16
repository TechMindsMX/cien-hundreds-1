<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title><g:message code="project.name.label" /></title>
	</head>
	<body>
		<div id="edit-activity" class="content scaffold-edit" role="main">
			<h1 class="hide"><g:message code="project.name.label" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors>
			<div class="alert alert-danger">
				<ul class="errors" role="alert">
					<g:eachError var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:eachError>
				</ul>
			</div>
			</g:hasErrors>
		</div>

		<div>
			<div class="jumbotron">
			  <h1>Bienvenido a 100Hundreds</h1>
			  <p>...</p>
			  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
			</div>
		</div>
		
	</body>
</html>
