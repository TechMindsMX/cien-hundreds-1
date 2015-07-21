class TIMDatepickerTagLib {

    def timDatePicker = { attrs, body ->
        def out = out
        def name = attrs.name //The name attribute is required for the tag to work seamlessly with grails
        def id = attrs.id ?: name
        def className = attrs.class ?: null
        def value = attrs.value
        def displayFormat = attrs.displayFormat
        def datepickerFormat = attrs.datepickerFormat
        def minDate = attrs.minDate
        def maxDate = attrs.maxDate
        def required = attrs.required ? 'required=\"\"': null

        def displayFormatString = displayFormat ? displayFormat : "dd-mm-yy"
        def datepickerFormatString = datepickerFormat ? datepickerFormat : "dd-MM-yyyy"
        def dateString = value ? value.format(datepickerFormatString) : ""

        out.println "<input type=\"text\" name=\"${name}\" id=\"${id}\" value=\"${dateString}\" class=\"form-control ${className}\" ${required} />"

        out.println "<script type=\"text/javascript\"> \$(document).ready(function(){"
        out.println "\$(\"#${name}\").datepicker({"
        if (minDate) {
            out.println "minDate: '${minDate}', "
        }        
        if (maxDate) {
            out.println "maxDate: '${maxDate}', "
        }
        if (attrs.changeMonth) {
            out.println "changeMonth: true, "
        }
        if (attrs.changeYear) {
            out.println "changeYear: true, "
        }
        out.println "dateFormat: '${displayFormatString}'"
        out.println "});"
        out.println "})</script>"
    }

}
