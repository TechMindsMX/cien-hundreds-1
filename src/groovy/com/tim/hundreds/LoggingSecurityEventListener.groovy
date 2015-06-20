package com.tim.hundreds

import javax.servlet.http.*
import org.apache.commons.logging.LogFactory
import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AbstractAuthenticationEvent
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutHandler

class LoggingSecurityEventListener implements ApplicationListener<AbstractAuthenticationEvent>, LogoutHandler {

  void onApplicationEvent(AbstractAuthenticationEvent event) {
    event.authentication.with {
      def username = principal.hasProperty('username')?.getProperty(principal) ?: principal
      println "event=${event.class.simpleName} username=${username} " +
      "remoteAddress=${details.remoteAddress} sessionId=${details.sessionId}"
     }
   }

   void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
     authentication.with {
     def username = principal.hasProperty('username')?.getProperty(principal) ?: principal
       println "event=Logout username=${username} " +
       "remoteAddress=${details.remoteAddress} sessionId=${details.sessionId}"
     }
   }
}
