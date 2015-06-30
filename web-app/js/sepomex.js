/**
 * Created by lutek on 30/06/2015.
 */
function cambio() {
    var pais 		= $(this).val();
    var calle		= $('#street');
    var cp			= $('#zipcode');
    var colonia 	= $('#neighborhood');
    var delegacion 	= $('#county');
    var ciudad 		= $('#town');
    var estado 		= $('#state');

    if(pais == 'mex') {
        colonia.parent().html('<select name="' + colonia.prop('name') + '" id="' + colonia.prop('id') + '"></select>');
        delegacion.parent().html('<select name="' + delegacion.prop('name') + '" id="' + delegacion.prop('id') + '"></select>');
        ciudad.parent().html('<select name="' + ciudad.prop('name') + '" id="' + ciudad.prop('id') + '"></select>');
        estado.parent().html('<select name="' + estado.prop('name') + '" id="' + estado.prop('id') + '"></select>');
    }else {
        calle.val('');
        cp.val('');
        colonia.parent().html('<input type="text" class="form-control" value="" required="" maxlength="100" id="neighborhood" name="neighborhood">');
        delegacion.parent().html('<input type="text" class="form-control" value="" required="" maxlength="100" id="county" name="county">');
        ciudad.parent().html('<input type="text" class="form-control" value="" required="" maxlength="100" id="town" name="town">');
        estado.parent().html('<input type="text" class="form-control" value="" required="" maxlength="100" id="state" name="state">');

    }

}

function llenarcampos() {
    var pais = $('#country').val();

    if(pais == 'mex') {
        var codigoPostal = $(this).val();

        var ajax = $.ajax({
            url: "http://sepomex.trama.mx/sepomexes/" + codigoPostal,
            dataType: 'json',
            crossDomain: true
        });

        ajax.done(function (response) {
            console.log(response);
            if(response.id != null) {
                var colonia 	= $('#neighborhood');
                var delegacion 	= $('#county');
                var ciudad 		= $('#town');
                var estado 		= $('#state');

                //Limpio los campos
                colonia.find('option').remove();
                delegacion.find('option').remove();
                ciudad.find('option').remove();
                estado.find('option').remove();

                //lleno los campos
                $.each(response.dAsenta, function (k, v) {
                    colonia.append('<option value="' + v + '">' + v + '</option>');
                });
                delegacion.append('<option value="' + response.dMnpio + '">' + response.dMnpio + '</option>');
                if (response.dCiudad != '') {
                    ciudad.append('<option value="' + response.dCiudad + '">' + response.dCiudad + '</option>');
                } else {
                    ciudad.append('<option value="N/A">N/A</option>');
                }
                estado.append('<option value="' + response.dEstado + '">' + response.dEstado + '</option>');
            }else{
                error();
            }
        });

        ajax.error(function (xhr, ajaxOptions, thrownError) {
            error();
        });
    }
}

function error() {
    $('#street').val('');
    $('#zipcode').val('');
    $('#neighborhood').find('option').remove();
    $('#county').find('option').remove();
    $('#town').find('option').remove();
    $('#state').find('option').remove();
}

$(document).ready(function(){
    $('#country').on('change',cambio);
    $('#zipcode').on('change',llenarcampos);

    $('#country').trigger('change');
    $('#zipcode').trigger('change');
});