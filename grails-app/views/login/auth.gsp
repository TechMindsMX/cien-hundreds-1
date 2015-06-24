<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="main">
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown max900">
        <div class="row">
            <asset:image src="cien_logo.gif" />

            <h3>Bienvenido a 100-Hundreds</h3>
        </div>
        <div class="row">
            <div class="col-xm-12 col-md-6 text-left">
               <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                    <div class="form-group">
                        <label for="j_username">Nombre de usuario</label>
                        <input type="text" name='j_username' class="form-control" placeholder="Nombre de usuario" id='username' >
                    </div>
                    <div class="form-group">
                        <label for="j_password">Contraseña</label>
                        <input type="password" name='j_password' class="form-control" placeholder="Contraseña" id='password' >
                    </div>
                    <button type="submit" class="btn btn-success">Ingresar</button>
                    <button type="reset" class="btn btn-danger"><g:message code="cancel.label" /></button>
               </form>
            </div>
            <div class="col-xm-12 col-md-6 well">
                <p>
                    <g:link controller="recovery" action="user" class="btn btn-block btn-success">Recuperar usuario</g:link>
                </p>
                <p>
                    <g:link controller="recovery" action="index" class="btn btn-block btn-success">Recuperar contraseña</g:link>
                </p>
                <p>
                    <p class="text-center">Aún no tiene una cuenta?</p>
                    <g:link controller="user" action="create" class="btn btn-block btn-success">Registrar nueva cuenta</g:link>
                </p>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>

    <!-- Mainly scripts -->
    <asset:javascript src="js/jquery-2.1.1.js" />
    <asset:javascript src="js/bootstrap.min.js" />

</body>

</html>
