<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <!-- Fixed navbar -->
        <div class="container theme-showcase">
            <div class="page-header">
                <h2>Registro de usuarios</h2>
                <p><g:message code="user.create.intro" /></p>
            </div>
            <div class="dropdown theme-dropdown clearfix">
                <g:form url="[resource:userInstance, action:'save']" >
                    <div class="col-xs-12 col-md-9 ">
                        <h4 class="text-head-color">Datos de Ingreso</h4>
                        <table class="table">
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
                    <div class="col-xs-12 col-md-9 ">
                        <h4 class="text-head-color">Datos de contacto</h4>
                        <table class="table">
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
                                    <td>
                                        <label class="control-label">
                                            <input class="control-label" type="checkbox" value="">                                                                                                &nbsp;
                                        </label>
                                        Acepto los
                                        <g:link controller="musician" action="index" target="_blank">Términos y condiciones</g:link>
                                        <div>
                                        <g:hiddenField name="role" value="ROLE_USER"/>
                                        <g:submitButton name="create" placeholder="Salvar" class="btn btn-success" value="Enviar"/>
                                        <button type="reset" class="btn btn-danger"><g:message code="cancel.label" /></button>
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
        </div>
        <!-- /container -->
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    </body>
</html>
