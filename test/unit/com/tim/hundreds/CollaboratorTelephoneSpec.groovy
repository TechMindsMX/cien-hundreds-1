package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CollaboratorTelephone)
class CollaboratorTelephoneSpec extends Specification {

	@Unroll
    void "when we have a collaboratorTelephone with: telephone #phone and a type #type, we expect #result"() {
    	given: "a telephone number and type"
    		def collaboratorTelephone = new CollaboratorTelephone()
    	and: "a collaborator"
    		def collaborator = new Collaborator()
    		collaboratorTelephone.collaborator = collaborator
    	when: "we assign the values"
		    collaboratorTelephone.phone = phone
		    collaboratorTelephone.type = type
		then: "We validate result"
			result == collaboratorTelephone.validate()
		where: "We have next values"
			phone         | type                          || result
			'1234567890'  | TelephoneType.PERSONAL_MOBILE || true
			'1234567890'  | TelephoneType.WORK_MOBILE     || true
			'1234567890'  | TelephoneType.PERSONAL        || true
			'1234567890'  | TelephoneType.WORK            || true
			'12345678901' | TelephoneType.WORK            || false
			'123456789'   | TelephoneType.WORK            || false
			'ABCDEFGHIJ'  | TelephoneType.WORK            || false
			'ABCDE12345'  | TelephoneType.WORK            || false
			'abcde12345'  | TelephoneType.WORK            || false
    }
}
