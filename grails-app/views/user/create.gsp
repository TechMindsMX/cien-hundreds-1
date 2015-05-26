<!DOCTYPE html>
<html>
<body>
  <g:form url="[resource:userInstance, action:'create']" >
  <g:textField name="profile.email" placeholder="Email:" /><br/>
  <g:textField name="emailCheck" placeholder="Confirma correo electrónico:" /><br/>
  <g:textField name="profile.firstName" placeholder="Nombre completo:" /><br/>
  <g:textField name="profile.middleName" placeholder="Apellido Paterno:" /><br/>
  <g:textField name="profile.lastName" placeholder="Apellido Materno:" /><br/>
  <g:textField name="username" placeholder="Usuario:" /><br/>
  <g:passwordField name="password" placeholder="Constraseña:" /><br>
  <g:passwordField name="passwordCheck" placeholder="Confirma constraseña:" /><br/>
  <g:textField name="profile.phone" placeholder="Phone:" /><br/><br/>
  <g:submitButton name="create" placeholder="Salvar" />
  </g:form>
</body>
</html>
