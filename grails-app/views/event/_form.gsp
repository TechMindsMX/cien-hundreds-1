<%@ page import="com.tim.hundreds.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'activity', 'error')} required">
	<label for="activity">
		<g:message code="event.activity.label" default="Activity" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="activity" maxlength="100" required="" value="${eventInstance?.activity}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'place', 'error')} required">
	<label for="place">
		<g:message code="event.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="place" maxlength="100" required="" value="${eventInstance?.place}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'company', 'error')} required">
	<label for="company">
		<g:message code="event.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="company" name="company.id" from="${com.tim.hundreds.Company.list()}" optionKey="id" required="" value="${eventInstance?.company?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="event.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${eventInstance?.date}"  />

</div>

