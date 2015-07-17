# cien-hundreds-1

Para configurar cien-hundreds en tu ambiente local tienes que crear un archivo llamado cien-hundreds-DEVELOPMENT-config.groovy en el PATH donde:

DEVELOPMENT es el nombre del ambiente a ejecutar

PATH es el home del archivo properties: /home/josdem/.cienhundreds

Ejemplo de archivo properties:

dataSource {
  pooled = true
  driverClassName = "com.mysql.jdbc.Driver"
  username = "cienHundreds"
  password = "c13nHDSDB"
  url = "jdbc:mysql://localhost/cien_hundreds"
  properties {
    jmxEnabled = true
    initialSize = 5
    maxActive = 50
    minIdle = 5
    maxIdle = 25
    maxWait = 10000
    maxAge = 10 * 60000
    timeBetweenEvictionRunsMillis = 5000
    minEvictableIdleTimeMillis = 60000
    validationQuery = "SELECT 1"
    validationQueryTimeout = 3
    validationInterval = 15000
    testOnBorrow = true
    testWhileIdle = true
    testOnReturn = false
    jdbcInterceptors = "ConnectionState"
    defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
  }
}
 
forgot {
  password.url='http://localhost:8082/web/services/email/forgotPassword'
  username.url='http://localhost:8082/web/services/email/forgotUsername'
}
musician {
  assigned {
    target.url='http://localhost:8082/web/services/email/musicianAssignedFacilitator'
    user.url='http://localhost:8082/web/services/email/musicianAssignedUser'
  }
  refused {
    url='http://localhost:8082/web/services/email/musicianRefused'
  }
}
company {
  assigned {
    target.url='http://localhost:8082/web/services/email/companyAssignedBuyer'
    user.url='http://localhost:8082/web/services/email/companyAssignedUser'
  }
  refused {
    url='http://localhost:8082/web/services/email/companyRefused'
  }

  edited {
      user.url='http://localhost:8082/web/services/email/companyEdited'
   }
}
base {
  photo.url='http://localhost/cienhundreds/photos/'
  logo.url='http://localhost/cienhundreds/logos/'
  resume.url='http://localhost/cienhundreds/resumes/'
  press.url='http://localhost/cienhundreds/press/'
}

tests{
  userPassword="T3chminds2015"
}

register.url='http://localhost:8082/web/services/email/register'
newUser.url='http://localhost:8082/web/services/email/newUser'
attachments.home='/var/www/html/cienhundreds/'

max.user.attemps=5
