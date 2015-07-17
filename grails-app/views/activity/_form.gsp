<%@ page import="com.tim.hundreds.Activity" %>

<div class="form-group fieldcontain ${hasErrors(bean: activityInstance, field: 'activity', 'error')} required">
	<label class="${session.labelWidth} control-label" for="activity">
		<g:message code="activity.label" default="Activity" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="activity" maxlength="100" required="" value="${activityInstance?.activity}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: activityInstance, field: 'place', 'error')} required">
	<label class="${session.labelWidth} control-label" for="place">
		<g:message code="place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:textField class="form-control" name="place" maxlength="100" required="" value="${activityInstance?.place}"/>
	</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: activityInstance, field: 'date', 'error')} required">
	<label class="${session.labelWidth} control-label" for="date">
		<g:message code="date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<div class="${session.inputWidth}">
		<g:timDatePicker name="date" maxDate="-0D" value="${activityInstance?.date}" required="true"></g:timDatePicker>
	</div>
</div>

<div class="hide fieldcontain ${hasErrors(bean: activityInstance, field: 'musician', 'error')} required">
	<label for="musician">
		<g:message code="video.musician.label" default="Musician" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musician" name="musician.id" from="${com.tim.hundreds.Musician.list()}" optionKey="id" required="" value="${activityInstance?.musician?.id}" class="many-to-one"/>

</div>
