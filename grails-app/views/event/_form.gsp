<%@ page import="com.tim.hundreds.Event" %>



<div class="form-group fieldcontain ${hasErrors(bean: eventInstance, field: 'activity', 'error')} required">
	<label class="${session.labelWidth} control-label" for="activity">
		<g:message code="event.activity.label" default="Activity" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="activity" id="activity" maxlength="100" required="" value="${eventInstance?.activity}"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: eventInstance, field: 'place', 'error')} required">
	<label class="${session.labelWidth} control-label" for="place">
		<g:message code="event.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="place" id="place" maxlength="100" required="" value="${eventInstance?.place}"/>

		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: eventInstance, field: 'company', 'error')} required">
	<label class="${session.labelWidth} control-label" for="company">
		<g:message code="event.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:select id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionKey="id" required="" value="${eventInstance?.company?.id}" class="form-control many-to-one"/>

		</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: eventInstance, field: 'date', 'error')} required">
	<label class="${session.labelWidth} control-label" for="date">
		<g:message code="event.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:timDatePicker name="date" minDate="-10Y" maxDate="-0D" initValue="${eventInstance?.date}"></g:timDatePicker>
		</div>
</div>

<div class="hide form-group fieldcontain ${hasErrors(bean: eventInstance, field: 'uuid', 'error')} required">
	<label class="${session.labelWidth} control-label" for="uuid">
		<g:message code="event.uuid.label" default="Uuid" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:textField class="form-control" name="uuid" id="uuid" required="" value="${eventInstance?.uuid}"/>

		</div>
</div>

