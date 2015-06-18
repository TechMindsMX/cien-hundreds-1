package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Company)
class CompanySpec extends Specification {

  @Unroll
  void """When we have a company with name: #name, description: #description, web: #web, logoPath: #logoPath, corporatePressPath: #corporatePressPath, notes: #notes, tags: #tags, we expect the result is: #result"""() {
  given: "A company"
    CompanyCommand company = new CompanyCommand()
  when: "We assign values to command"
    company.name = name
    company.description = description
    company.web = web
    company.logoPath = logoPath
    company.corporatePressPath = corporatePressPath
    company.notes = notes
    company.tags = tags
    company.type = type
   then: "We validate command"
    result == company.validate()
   where: "We have next cases"
   name          | description | web                           | logoPath                               | corporatePressPath                     | notes   | tags   | type                   || result
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || true
   'A'           | 'd'         | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || true
   'Anjunabeats' | 'desc'      | null                          | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || true
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | null                                   | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || true
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | null                                   | 'notes' | 'tags' | ActivityType.PRODUCTOS || true
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'n'     | 'tags' | ActivityType.PRODUCTOS || true
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 't'    | ActivityType.PRODUCTOS || true
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | null    | 'tags' | ActivityType.PRODUCTOS || true
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | null   | ActivityType.PRODUCTOS || true
  }

  @Unroll
  void """When we have a company with name: #name, description: #description, web: #web, logoPath: #logoPath, corporatePressPath: #corporatePressPath, notes: #notes, tags: #tags, we expect the result is: #result"""() {
  given: "A company"
    CompanyCommand company = new CompanyCommand()
  when: "We assign values to command"
    company.name = name
    company.description = description
    company.web = web
    company.logoPath = logoPath
    company.corporatePressPath = corporatePressPath
    company.notes = notes
    company.tags = tags
    company.type = type
   then: "We validate command"
    result == company.validate()
   where: "We have next cases"
   name          | description | web                           | logoPath                               | corporatePressPath                     | notes   | tags   | type                   || result
   null          | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   ''            | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | null        | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | ''          | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://'                     | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.pn'  | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.pngd'| '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996'     | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pd'  | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdfs'| 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.'    | 'notes' | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | ''      | 'tags' | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | ''     | ActivityType.PRODUCTOS || false
   'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | null                   || false
  }

}
