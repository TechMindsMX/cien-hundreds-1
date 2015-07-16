<div class="form-group">
	<label class="${session.labelWidth} control-label" >
		<g:message code="name.label" />
	</label>
	<div class="${session.inputWidth} from-control">${userInstance.profile.firstName} ${userInstance.profile.lastName}</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: userInstance, field: 'accountExpired', 'error')} required">
	<label class="${session.labelWidth} control-label" for="accountExpired">${message(code: 'user.status.isBlocked.label')}<span class="required-indicator">*</span></label>
    <div class="${session.inputWidth}">
        <g:checkBox value="${userInstance?.accountExpired}" name="accountExpired" class="form-control" />
    </div>
</div>

<g:hiddenField name="id" value="${userInstance?.id}" />