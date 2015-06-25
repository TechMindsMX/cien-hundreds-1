package com.tim.hundreds

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class StaticController {

    static showMe = false /*Parametro para aparecer en el menú*/

    def index() {
    }


}
