<%@ page import="com.tim.hundreds.MusicianComment" %>

<h4>
	<g:message code="general.label" default="General" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
			<label><g:message code="name.label" /></label>
				${musicianCommentInstance?.musician?.name}
			</li>
			<li>
			<label><g:message code="web.label" /></label>
				<a href="${musicianCommentInstance?.musician?.web}">${musicianCommentInstance?.musician?.web}</a>
			</li>
			<li>
				<label><g:message code="dateCreate.label" /></label>			
				<g:formatDate format="dd-MM-yyyy" date="${musicianCommentInstance?.musician?.formed}" />
    		</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: musicianCommentInstance, field: 'general', 'error')} ">
		<label class="${session.labelWidth} control-label" for="general">
			<g:message code="musicianComment.general.label" default="General" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="general" id="general" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.general}"/>

			</div>
	</div>
</div>
<h4>
	<g:message code="musician.history.placeholder" default="General" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>		
				${musicianCommentInstance?.musician?.history}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: musicianCommentInstance, field: 'history', 'error')} ">
		<label class="${session.labelWidth} control-label" for="history">
			<g:message code="musicianComment.history.label" default="History" />			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="history" id="history" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.history}"/>

			</div>
	</div>
</div>

<h4>
	<g:message code="datosFiscales.label" default="Datos Fiscales" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>		
				<div>${musicianCommentInstance?.musician?.datosFiscales?.razonSocial}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.rfc}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.personaJuridica}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.street}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.neighborhood}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.county}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.town}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.state}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.country}</div>
				<div>${musicianCommentInstance?.musician?.datosFiscales?.address?.zipcode}</div>
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: musicianCommentInstance, field: 'datosFiscales', 'error')} ">
		<label class="${session.labelWidth} control-label" for="datosFiscales">
			<g:message code="musicianComment.datosFiscales.label" default="Datos Fiscales" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="datosFiscales" id="datosFiscales" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.datosFiscales}"/>

			</div>
	</div>
</div>



<h4>
	<g:message code="musicianComment.activities.label" default="Actividades Relevantes" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<g:each in="${musicianCommentInstance?.musician?.activities}">
				<li>		
					${it.activity}
				</li>
			</g:each>	
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: musicianCommentInstance, field: 'activities', 'error')} ">
		<label class="${session.labelWidth} control-label" for="activities">
			<g:message code="musicianComment.activities.label" default="Activities" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="activities" id="activities" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.activities}"/>

			</div>
	</div>
</div>

<h4>
	<g:message code="musicianComment.medias.label" default="Actividades Relevantes" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>
				<h4>
					<label>
						<g:message code="photo.label" default="Fotos" />
					</label>
				</h4>
				<g:each in="${musicianCommentInstance?.musician?.photos}">
					<li>		
						<div class="img pad-bottom">
						<img class="img-responsive img-thumbnail max300" src="${grailsApplication.config.base.photo.url}${it.path}" />
						</div>
					</li>
				</g:each>		
			</li>		
			<li>
				<h4>
					<label>
						<g:message code="video.label" default="Videos" />
					</label>
				</h4>		
				<ul>
					<g:each in="${musicianCommentInstance?.musician?.videos}">
						<li>
							<a href="${it.url}">${it.url}</a>
						</li>
					</g:each>
				</ul>
			</li>		
			<li>
				<h4>
					<label>
						<g:message code="audios.label" default="Audios" />	
					</label>
				</h4>		
				<ul>
					<g:each in="${musicianCommentInstance?.musician?.audios}">
						<li>
							<a href="${it.url}">${it.url}</a>
						</li>
					</g:each>
				</ul>	
			</li>		
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: musicianCommentInstance, field: 'medias', 'error')} ">
		<label class="${session.labelWidth} control-label" for="medias">
			<g:message code="musicianComment.medias.label" default="Medias" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="medias" id="medias" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.medias}"/>

			</div>
	</div>
</div>

<h4>
	<g:message code="musicianComment.suggestions.label" default="Actividades Relevantes" />
</h4>
<div class="row">
	<div class="col-md-4">
		 <ul>
			<g:each in="${musicianCommentInstance?.musician?.suggestions}">
					<li>		
						${it.name}
					</li>
			</g:each>		
		</ul>

	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: musicianCommentInstance, field: 'suggestions', 'error')} ">
		<label class="${session.labelWidth} control-label" for="suggestions">
			<g:message code="musicianComment.suggestions.label" default="Suggestions" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="suggestions" id="suggestions" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.suggestions}"/>

			</div>
	</div>
</div>	


<h4>
	<g:message code="musicianComment.notes.label" default="Actividades Relevantes" />
</h4>
<div class="row">
	<div class="col-md-4">
		<ul>
			<li>		
				${musicianCommentInstance?.musician?.notes}
			</li>
		</ul>
	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: musicianCommentInstance, field: 'notes', 'error')} ">
		<label class="${session.labelWidth} control-label" for="notes">
			<g:message code="musicianComment.notes.label" default="Notes" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="notes" id="notes" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.notes}"/>

			</div>
	</div>
</div>

<h4>
	<g:message code="musicianComment.contacts.label" default="Contactos" />
</h4>
<div class="row">
	<div class="col-md-4">
		 <ul>
			<g:each in="${musicianCommentInstance?.musician?.contacts}">
					<li>		
						${it.firstName} ${it.lastName} <g:link target="_blank" controller="contact" action="show" params="['uuid': it.uuid ]">${message(code: 'default.show.label', args: [message(code: 'contact.label')])}</g:link>
					</li>
			</g:each>		
		</ul>

	</div>
	<div class="col-md-8 form-group fieldcontain ${hasErrors(bean: musicianCommentInstance, field: 'contacts', 'error')} ">
		<label class="${session.labelWidth} control-label" for="contacts">
			<g:message code="musicianComment.contacts.label" default="Contactos" />
			
		</label>
			<div class="${session.inputWidth}">
				<g:textArea class="form-control" name="contacts" id="contacts" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.contacts}"/>

			</div>
	</div>
</div>	

	<g:hiddenField class="form-control" name="contacts" id="contacts" cols="40" rows="5" maxlength="10000" value="${musicianCommentInstance?.contacts}"/>
	<g:hiddenField id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${musicianCommentInstance?.musician?.id}" class="form-control many-to-one"/>
