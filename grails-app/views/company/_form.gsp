<%@ page import="com.tim.hundreds.Company" %>


<div class="ibox-content">
        <div class="form-group ${hasErrors(bean: companyInstance, field: 'name', 'error')} required">
			<label class="col-sm-2 control-label" for="name">
				<g:message code="company.name.label" default="Nombre" />
				<span class="required-indicator">*</span>
			</label>
			<div class="col-sm-6">
				<g:textField name="name" maxlength="100" required="" class="form-control" value="${companyInstance?.name}"/>
			</div>

		</div>

		<div class="hr-line-dashed"></div>

		<div class="form-group ${hasErrors(bean: companyInstance, field: 'description', 'error')} required">
			<label class="col-sm-2 control-label" for="description">
				<g:message code="company.description.label" default="Descripción" />
				<span class="required-indicator">*</span>
			</label>
			<div class="col-sm-6">
				<g:textArea name="description" cols="40" rows="5" maxlength="10000" required="" class="form-control" value="${companyInstance?.description}"/>
			</div>
		</div>

		<div class="hr-line-dashed"></div>

		<div class="form-group ${hasErrors(bean: companyInstance, field: 'web', 'error')} ">
			<label class="col-sm-2 control-label" for="web">
				<g:message code="company.web.label" default="Web" />

			</label>
			<div class="col-sm-6">
				<g:textField name="web" maxlength="100" class="form-control" value="${companyInstance?.web}"/>
			</div>

		</div>
		<div class="hr-line-dashed"></div>

		<div class="form-group ${hasErrors(bean: companyInstance, field: 'notes', 'error')} ">
			<label class="col-sm-2 control-label" for="notes">
				<g:message code="company.notes.label" default="Notas" />

			</label>
			<div class="col-sm-6">
				<g:textArea name="notes" cols="40" rows="5" maxlength="10000" class="form-control" value="${companyInstance?.notes}"/>
			</div>

		</div>

		<div class="hr-line-dashed"></div>

		<div class="form-group ${hasErrors(bean: companyInstance, field: 'tags', 'error')} ">
			<label class="col-sm-2 control-label" for="tags">
				<g:message code="company.tags.label" default="Tags" />

			</label>
			<div class="col-sm-6">
				<g:textArea name="tags" cols="40" rows="5" maxlength="10000" class="form-control" value="${companyInstance?.tags}"/>
			</div>
		</div>

		<div class="hr-line-dashed"></div>

		<div class="hide form-group ${hasErrors(bean: companyInstance, field: 'logoPath', 'error')} ">
			<label class="col-sm-2 control-label" for="logoPath">
				<g:message code="company.logoPath.label" default="LogoPath" />

			</label>
			<div class="col-sm-6">
				<g:textField name="logoPath" class="form-control" value="${companyInstance?.logoPath}"/>
			</div>
		</div>



		<div class="form-group ${hasErrors(bean: companyInstance, field: 'corporatePress', 'error')} ">
			<label class="col-sm-2 control-label" for="corporatePress">
				<g:message code="company.corporatePress.label" default="Presentacion Corporativa" />

			</label>
			<div class="col-sm-6">
				<g:textField name="corporatePress" class="form-control" value="${companyInstance?.corporatePress}"/>
			</div>
		</div>

		<div class="hr-line-dashed"></div>

		<div class="hide form-group ${hasErrors(bean: companyInstance, field: 'address', 'error')} ">
			<label class="col-sm-2 control-label" for="address">
				<g:message code="company.address.label" default="Address" />

			</label>
			<div class="col-sm-6">
				<g:select id="address" name="address.id" from="${com.tim.hundreds.Address.list()}" optionKey="id" class="form-control" value="${companyInstance?.address?.id}" class="many-to-one" noSelection="['null': '']"/>
			</div>
		</div>



		<div class="hide form-group ${hasErrors(bean: companyInstance, field: 'social', 'error')} ">
			<label class="col-sm-2 control-label" for="social">
				<g:message code="company.social.label" default="Social" />

			</label>
			<div class="col-sm-6">
				<g:select id="social" name="social.id" from="${com.tim.hundreds.Social.list()}" optionKey="id" class="form-control" value="${companyInstance?.social?.id}" class="many-to-one" noSelection="['null': '']"/>
			</div>
		</div>



		<div class="hide form-group ${hasErrors(bean: companyInstance, field: 'datosFiscales', 'error')} ">
			<label class="col-sm-2 control-label" for="datosFiscales">
				<g:message code="company.datosFiscales.label" default="Datos Fiscales" />

			</label>
			<div class="col-sm-6">
				<g:select id="datosFiscales" name="datosFiscales.id" from="${com.tim.hundreds.DatosFiscales.list()}" optionKey="id" class="form-control" value="${companyInstance?.datosFiscales?.id}" class="many-to-one" noSelection="['null': '']"/>
			</div>
		</div>



		<div class="hide form-group ${hasErrors(bean: companyInstance, field: 'references', 'error')} ">
			<label class="col-sm-2 control-label" for="references">
				<g:message code="company.references.label" default="References" />

			</label>
			<div class="col-sm-6">

				<ul class="one-to-many">
				<g:each in="${companyInstance?.references?}" var="r">
				    <li><g:link controller="reference" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
				</g:each>
				<li class="add">
				<g:link controller="reference" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reference.label', default: 'Reference')])}</g:link>
				</li>
				</ul>

			</div>
		</div>



		<div class="hide form-group ${hasErrors(bean: companyInstance, field: 'collaborators', 'error')} ">
			<label class="col-sm-2 control-label" for="collaborators">
				<g:message code="company.collaborators.label" default="Collaborators" />

			</label>
			<div class="col-sm-6">

				<ul class="one-to-many">
				<g:each in="${companyInstance?.collaborators?}" var="c">
				    <li><g:link controller="collaborator" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
				</g:each>
				<li class="add">
				<g:link controller="collaborator" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'collaborator.label', default: 'Collaborator')])}</g:link>
				</li>
				</ul>

			</div>
		</div>



		<div class="hide form-group ${hasErrors(bean: companyInstance, field: 'events', 'error')} ">
			<label class="col-sm-2 control-label" for="events">
				<g:message code="company.events.label" default="Events" />

			</label>
			<div class="col-sm-6">

				<ul class="one-to-many">
				<g:each in="${companyInstance?.events?}" var="e">
				    <li><g:link controller="event" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
				</g:each>
				<li class="add">
				<g:link controller="event" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'event.label', default: 'Event')])}</g:link>
				</li>
				</ul>

			</div>
		</div>



		<div class="hide form-group ${hasErrors(bean: companyInstance, field: 'products', 'error')} ">
			<label class="col-sm-2 control-label" for="products">
				<g:message code="company.products.label" default="Products" />

			</label>
			<div class="col-sm-6">

				<ul class="one-to-many">
				<g:each in="${companyInstance?.products?}" var="p">
				    <li><g:link controller="product" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
				</g:each>
				<li class="add">
				<g:link controller="product" action="create" params="['company.id': companyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'product.label', default: 'Product')])}</g:link>
				</li>
				</ul>

			</div>
		</div>



		<div class="form-group ${hasErrors(bean: companyInstance, field: 'type', 'error')} required">
			<label class="col-sm-2 control-label" for="type">
				<g:message code="company.type.label" default="Giro de la Empresa" />
				<span class="required-indicator">*</span>
			</label>
			<div class="col-sm-6">
				<g:select name="type" from="${com.tim.hundreds.ActivityType?.values()}" keys="${com.tim.hundreds.ActivityType.values()*.name()}" required="" class="form-control" value="${companyInstance?.type?.name()}" />
			</div>
		</div>

		<div class="hr-line-dashed"></div>


		<div class="form-group ${hasErrors(bean: companyInstance, field: 'logo', 'error')} ">
		  <label class="col-sm-2 control-label" for="logo">
		    <g:message code="company.logo.label" default="Logo" />
		  </label>
		  	<div class="col-sm-6">
		  		<input type="file" id="logo" name="logo" />
			</div>
		</div>

		<div class="hr-line-dashed"></div>
</div>

