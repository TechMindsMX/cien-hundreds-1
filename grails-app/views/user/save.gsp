<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>100 Hundreds</title>
        <!-- Bootstrap core CSS -->
        <link href="/cien-hundreds/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Bootstrap theme -->
        <link href="/cien-hundreds/assets/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="/cien-hundreds/assets/theme.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
        <!-- Fixed navbar -->
        <div class="container theme-showcase">
            <div class="well">
                <div class="row">
                    <div class="col-xs-12 col-md-8">
                        <h4>100 Hundreds</h4>
                    </div>
                    <div class="col-xs-6 col-md-4 text-right">
                        <button type="button" class="btn btn-default">Ingresar</button>
                    </div>
                </div>
            </div>
            <div class="page-header">
                <h2>Registro de usuarios</h2>
                <p>Por favor ingrese los datos de este formulario par crear una cuenta de usuario en la plataforma 100  Hundreds</p>
            </div>
            <div class="dropdown theme-dropdown clearfix">
              <g:hasErrors>
                <g:eachError><g:message error="${it.defaultMessage}"/></g:eachError>
              </g:hasErrors>
                <g:form url="[resource:userInstance, action:'save']" >
                    <div class="col-xs-8 col-md-9 ">
                        <table class="table">
                            <thead>
                                <tr style="display: table-row;">
                                    <th class="text-head-color">
                                        <h4>Datos de Ingreso</h4>
                                    </th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody class="borderless">
                                <tr>
                                    <td class="text-right">
                                        <strong>Usuario</strong>
                                    </td>
                                    <td>
                                        <g:textField name="username" class="form-control" placeholder="Ingrese su nombre de Usuario" size="45" />
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">
                                        <strong>Contraseña</strong>
                                    </td>
                                    <td>
                                        <g:passwordField name="password" class="form-control" placeholder="Ingrese una contraseña" />
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">
                                        <strong>Confirme su contraseña</strong>
                                    </td>
                                    <td>
                                        <g:passwordField name="passwordCheck" class="form-control" placeholder="Ingrese nuevamente la contraseña" />
                                        <br>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-xs-8 col-md-9 ">
                        <table class="table">
                            <thead>
                                <tr style="display: table-row;">
                                    <th class="text-head-color">
                                        <h4>Datos de contacto</h4>
                                    </th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody class="borderless">
                                <tr>
                                    <td class="text-right">
                                        <strong>Nombre(s)</strong>
                                    </td>
                                    <td>
                                        <g:textField name="firstName" class="form-control" placeholder="Ingrese su(s) nombre(s)" size="60" />
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">
                                        <strong>Apellido paterno</strong>
                                    </td>
                                    <td>
                                        <g:textField name="middleName" class="form-control" placeholder="Ingrese su apellido paterno" />
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">
                                        <b>Apellido materno</b>
                                    </td>
                                    <td>
                                        <g:textField name="lastName" class="form-control" placeholder="Ingrese su apellido materno" />
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">
                                        <b>Teléfono</b>
                                    </td>
                                    <td>
                                        <g:textField name="phone" class="form-control" placeholder="Ingrese su número telefónico (10 dígitos)" />
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">
                                        <b>Correo electrónico</b>
                                    </td>
                                    <td>
                                        <g:textField name="email" class="form-control" placeholder="Ingrese su correo electrónico" />
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">
                                        <b>Confirme su correo electrónico</b>
                                    </td>
                                    <td>
                                        <g:textField name="emailCheck" class="form-control" placeholder="Ingrese nuevamente su correo electrónico" />
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">
</td>
                                    <td style="display: table-cell;">
                                        <label class="control-label">
                                            <input class="control-label" type="checkbox" value="">                                                                                                &nbsp;
                                        </label>
                                        Acepto los
                                        <a href="#">Términos y condiciones</a>
                                        <div>
                                        <g:submitButton name="create" placeholder="Salvar" class="btn btn-success" value="Enviar"/>
                                        <button type="button" class="btn btn-danger">Cancelar</button>
                                        </div>
                                        <br>
                                        <br>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </g:form>
            </div>
            <div class="well">
                <p>Copyright 2015 100 Hundreds.</p>
            </div>
        </div>
        <!-- /container -->
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    </body>
</html>
