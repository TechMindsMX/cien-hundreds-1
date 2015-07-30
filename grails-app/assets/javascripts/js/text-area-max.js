$(function() {
    $('form').submit(function (e) {
        $('textarea').each(
            function () {
                var text = this.value;
                // Count line breaks as 2 characters
                text = text.replace(/\r(?!\n)|\n(?!\r)/g, '\r\n');       
                if (text.length > this.maxLength) {
                    $(this).siblings('.validation-error').remove();
                    $(this).focus().after('<span class="error validation-error">El máximo de caracteres es de '+this.maxLength+', ha ingresado '+text.length+'.</span>' ).closest('.form-group').addClass('error');        
                    e.preventDefault();
                }
            }
        );
    });
});
