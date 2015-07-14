<%@ page import="com.tim.hundreds.CompanyComment" %>


<h4>
	<g:message code="companyComment.general.label" default="General" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
			<label><g:message code="name.label" /></label>
				${companyCommentInstance?.company?.name}
			</li>
			<li>
			<label><g:message code="web.label" /></label>
				${companyCommentInstance?.company?.web}
			</li>
			<li>
			<label><g:message code="businessActivity.label" /></label>
				${companyCommentInstance?.company?.type?.name}
			</li>
    		<g:if test="${companyInstance?.logo}">
    		<li>
				<img class="img-responsive max300" src="${grailsApplication.config.base.logo.url}${companyCommentInstance?.company?.logo}" />
			</li>
			</g:if>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: companyCommentInstance, field: 'general', 'error')} ">
		<label class="${session.labelWidth} control-label" for="general">
			<g:message code="companyComment.general.label" default="General" />
			
		</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="general" id="general" cols="40" rows="5" maxlength="10000" value="${companyCommentInstance?.general}"/>

		</div>
	</div>
</div>

<h4>
	<g:message code="companyComment.description.label" default="Description" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${companyCommentInstance?.company?.description}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: companyCommentInstance, field: 'description', 'error')} ">
		<label class="${session.labelWidth} control-label" for="description">
			<g:message code="companyComment.description.label" default="Description" />
			
		</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="description" id="description" cols="40" rows="5" maxlength="10000" value="${companyCommentInstance?.description}"/>

		</div>
	</div>
</div>

<h4>
	<g:message code="companyComment.datosFiscales.label" default="Datos Fiscales" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${companyCommentInstance?.company?.datosFiscales}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: companyCommentInstance, field: 'datosFiscales', 'error')} ">
		<label class="${session.labelWidth} control-label" for="datosFiscales">
			<g:message code="companyComment.datosFiscales.label" default="Datos Fiscales" />
			
		</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="datosFiscales" id="datosFiscales" cols="40" rows="5" maxlength="10000" value="${companyCommentInstance?.datosFiscales}"/>

		</div>
	</div>
</div>

<h4>
	<g:message code="companyComment.events.label" default="Events" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<g:each in="${companyCommentInstance?.company?.events}" var="i">
			<li>
				${i?.name}
			</li>
			</g:each>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: companyCommentInstance, field: 'events', 'error')} ">
		<label class="${session.labelWidth} control-label" for="events">
			<g:message code="companyComment.events.label" default="Events" />
			
		</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="events" id="events" cols="40" rows="5" maxlength="10000" value="${companyCommentInstance?.events}"/>

		</div>
	</div>
</div>

<h4>
	<g:message code="companyComment.notes.label" default="Notes" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				${companyCommentInstance?.company?.notes}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: companyCommentInstance, field: 'notes', 'error')} ">
		<label class="${session.labelWidth} control-label" for="notes">
			<g:message code="companyComment.notes.label" default="Notes" />
			
		</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="notes" id="notes" cols="40" rows="5" maxlength="10000" value="${companyCommentInstance?.notes}"/>

		</div>
	</div>
</div>

<h4>
	<g:message code="companyComment.refs.label" default="References" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<g:each in="${companyCommentInstance?.company?.references}" var="i">
			<li>
				${i?.name}
			</li>
			</g:each>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: companyCommentInstance, field: 'refs', 'error')} ">
		<label class="${session.labelWidth} control-label" for="refs">
			<g:message code="companyComment.refs.label" default="References" />
			
		</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="refs" id="refs" cols="40" rows="5" maxlength="10000" value="${companyCommentInstance?.refs}"/>

		</div>
	</div>
</div>

<h4>
	<g:message code="companyComment.collaborators.label" default="Collaborators" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<g:each in="${companyCommentInstance?.company?.collaborators}" var="i">
			<li>
				${i?.firstName} ${i?.lastName}
			</li>
			</g:each>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: companyCommentInstance, field: 'collaborators', 'error')} ">
		<label class="${session.labelWidth} control-label" for="collaborators">
			<g:message code="companyComment.collaborators.label" default="Collaborators" />
			
		</label>
		<div class="${session.inputWidth}">
			<g:textArea class="form-control" name="collaborators" id="collaborators" cols="40" rows="5" maxlength="10000" value="${companyCommentInstance?.collaborators}"/>

		</div>
	</div>
</div>


<g:hiddenField name="company.id" value="${companyCommentInstance?.company?.id}" required="" />