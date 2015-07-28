package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

class UserPermissionsServiceIntegrationSpec extends Specification {

	def userPermissionsService

   @Unroll
    void """Should get a list of #result of manageable user roles for user whith role #currUserAuthority"""() {
    	given: "A user authority"
    	def userAuthority = currUserAuthority
    	when: "ask for a list of roles the user can manage"
    	def list = userPermissionsService.getManageableRoleList(userAuthority)
    	then:
    	result == list.size()
    	where:
    	currUserAuthority 		|| result
    	'ROLE_USER'		  		|| 1
		'ROLE_FACILITATOR'		|| 1	
		'ROLE_BUYER'			|| 1
		'ROLE_MUSICIAN_VIEWER'	|| 1
		'ROLE_COMPANY_VIEWER'	|| 1
    	'ROLE_MUSICIAN_ADMIN'	|| 2
    	'ROLE_COMPANY_ADMIN'	|| 2
    	'ROLE_ADMIN'			|| 6
    }

}

