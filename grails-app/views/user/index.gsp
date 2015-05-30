<!DOCTYPE html>
<html>
<body>
  <g:hasErrors>
    <g:eachError><g:message error="${it}"/></g:eachError>
  </g:hasErrors>
  <g:form url="[resource:userInstance, action:'save']" >
  <g:textField name="email" placeholder="Email:" /><br/>
  <g:textField name="emailCheck" placeholder="Confirma correo electrónico:" /><br/>
  <g:textField name="firstName" placeholder="Nombre completo:" /><br/>
  <g:textField name="middleName" placeholder="Apellido Paterno:" /><br/>
  <g:textField name="lastName" placeholder="Apellido Materno:" /><br/>
  <g:textField name="username" placeholder="Usuario:" /><br/>
  <g:passwordField name="password" placeholder="Constraseña:" /><br>
  <g:passwordField name="passwordCheck" placeholder="Confirma constraseña:" /><br/>
  <g:textField name="phone" placeholder="Phone:" /><br/><br/>
  <g:submitButton name="create" value="Crear" />
  </g:form>
</body>
</html>
