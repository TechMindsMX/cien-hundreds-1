/**
 * Created by RicardoTIM on 19-Feb-15.
 */
var file_validation = function( event ) {

    var $fileInput = event.target;

    jQuery('.errormsg').remove();

    //check whether browser fully supports all File API
    if (window.File && window.FileReader && window.FileList && window.Blob)
    {
        var $error_span = '';

        if ($fileInput.files[0]) {

            var fname = $fileInput.files[0].name;
            var fextension = fname.split('.')[fname.split('.').length - 1].toLowerCase();
            var fsize = $fileInput.files[0].size;
            var ftype = $fileInput.files[0].type;

            $fileInput.validationErrors = [];

            switch(ftype)
            {
                case 'image/png':
                case 'image/gif':
                case 'image/jpeg':
                case 'image/pjpeg':
                case 'application/pdf':
                    break;
                case 'binary/octet-stream':
                case 'application/octet-stream':
                    if (fextension === '.pdf') {
                        $fileInput.validationErrors.push(event.data.msg.fileType);
                        // jQuery($fileInput).val('').after($error_span);
                    }
                    break;
                default:
                    $fileInput.validationErrors.push(event.data.msg.fileType);
                    // jQuery($fileInput).val('').after($error_span);
            }

            if (fsize >= event.data.msg.maxFileSize) {
                $fileInput.validationErrors.push(event.data.msg.fileSize + event.data.msg.maxFileSize );
                // jQuery($fileInput).val('').after($error_span);
            }
        }
        $error_span = '<div class="alert alert-warning alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+ $fileInput.validationErrors.join('<br /> ') +'</div>';
        jQuery($fileInput).siblings('.alert').remove();

        if ($fileInput.validationErrors.length > 0){
            jQuery($fileInput).val('').after($error_span);
        }
        return $fileInput;
    }else{
        alert("Please upgrade your browser, because your current browser lacks some new features we need!");
    }
};

$(document).ready(function () {
    jQuery('input[type="file"]').on('change' ,{
                msg: {fileType:"Tipo de archivo inválido, solo se permiten imagenes (jpg, png, gif)", fileSize: "Tamaño de archivo inválido, el máximo es de ", maxFileSize: 10000000}
            } , file_validation );

});