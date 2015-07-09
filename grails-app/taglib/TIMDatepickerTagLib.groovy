class TIMDatepickerTagLib {

    def timDatePicker = { attrs, body ->
        def out = out
        def name = attrs.name //The name attribute is required for the tag to work seamlessly with grails
        def id = attrs.id ?: name
        def value = attrs.value
        def displayFormat = attrs.displayFormat
        def datepickerFormat = attrs.datepickerFormat
        def minDate = attrs.minDate
        def maxDate = attrs.maxDate

        def displayFormatString = displayFormat ? displayFormat : "dd-mm-yy"
        def datepickerFormatString = datepickerFormat ? datepickerFormat : "dd-MM-yyyy"
        def dateString = value ? value.format(datepickerFormatString) : ""

        out.println "<input type=\"text\" name=\"${name}\" id=\"${id}\" value=\"${dateString}\" class=\"form-control\" />"

        out.println "<script type=\"text/javascript\"> \$(document).ready(function(){"
        out.println "\$(\"#${name}\").datepicker({"
        out.println "minDate: '${minDate}', maxDate: '${maxDate}', dateFormat: '${displayFormatString}', changeMonth: true, changeYear: true"
        out.println "});"
        out.println "})</script>"
    }

}
