package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import org.springframework.web.multipart.MultipartFile

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ResumeStorerService)
class ResumeStorerServiceSpec extends Specification {

  void "should store a resume"() {
  given:
    MultipartFile multipartFile = Mock(MultipartFile)
    File logoFile = new File('/tmp/resume.pdf')
  when:
    service.storeFile(multipartFile)
  then:
    1 * multipartFile.transferTo(logoFile)
  }

}
