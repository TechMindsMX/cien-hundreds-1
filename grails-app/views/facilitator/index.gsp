<%@ page import="com.tim.hundreds.Role" %>
<!DOCTYPE html>
<html>
<body>
  <g:form url="[resource:facilitatorInstance, action:'save']" >
  <g:textField name="email" placeholder="Email:" /><br/>
  <g:textField name="emailCheck" placeholder="Confirma correo electrónico:" /><br/>
  <g:textField name="firstName" placeholder="Nombre completo:" /><br/>
  <g:textField name="middleName" placeholder="Apellido Paterno:" /><br/>
  <g:textField name="lastName" placeholder="Apellido Materno:" /><br/>
  <g:textField name="username" placeholder="Usuario:" /><br/>
  <g:passwordField name="password" placeholder="Constraseña:" /><br/>
  <g:passwordField name="passwordCheck" placeholder="Confirma constraseña:" /><br/>
  <g:textField name="phone" placeholder="Phone:" /><br/>
  <g:select name="role.authority" from="${Role.findAll()}" optionKey="id" optionValue="authority"/><br/><br/>
  <g:submitButton name="create" placeholder="Salvar" />
  </g:form>
</body>
</html>
