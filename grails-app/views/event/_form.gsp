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

<div class="form-group fieldcontain ${hasErrors(bean: eventInstance, field: 'date', 'error')} required">
	<label class="${session.labelWidth} control-label" for="date">
		<g:message code="event.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
		<div class="${session.inputWidth}">
			<g:timDatePicker name="date" maxDate="-0D" changeMonth="true" changeYear="true" yearRange="-100:+0" value="${eventInstance?.date}" required="true"></g:timDatePicker>
		</div>
</div>

<g:hiddenField name="uuid" id="uuid" required="" value="${eventInstance?.uuid}" class="form-control" />
<g:hiddenField name="companyUuid" id="companyUuid" required="" value="${eventInstance?.company?.uuid}" class="form-control many-to-one"/>
