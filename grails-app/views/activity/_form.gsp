<%@ page import="com.tim.hundreds.Activity" %>



<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'activity', 'error')} required">
	<label for="activity">
		<g:message code="activity.activity.label" default="Activity" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="activity" maxlength="100" required="" value="${activityInstance?.activity}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'place', 'error')} required">
	<label for="place">
		<g:message code="activity.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="place" maxlength="100" required="" value="${activityInstance?.place}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="activity.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${activityInstance?.date}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="activity.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${activityInstance?.musician?.id}" class="many-to-one"/>

</div>

