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
    company.uuid = uuid
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
   uuid                                       | name     | description | web                           | logoPath                               | corporatePressPath                     | notes   | tags   | type                                  || result
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' | 'Anjuna' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || true
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' | 'A'      | 'd'         | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || true
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjun'  | 'desc'      | null                          | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || true
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjuna' | 'desc'      | 'http://www.anjunabeats.com/' | null                                   | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || true
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjuna' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | null                                   | 'notes' | 'tags' | new BusinessActivity(name:'Products') || true
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjuna' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'n'     | 'tags' | new BusinessActivity(name:'Products') || true
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjuna' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 't'    | new BusinessActivity(name:'Products') || true
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjuna' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | null    | 'tags' | new BusinessActivity(name:'Products') || true
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjuna' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | null   | new BusinessActivity(name:'Products') || true
  }

  @Unroll
  void """When we have a company with name: #name, description: #description, web: #web, logoPath: #logoPath, corporatePressPath: #corporatePressPath, notes: #notes, tags: #tags, we expect the result is: #result"""() {
  given: "A company"
    CompanyCommand company = new CompanyCommand()
  when: "We assign values to command"
    company.uuid = uuid
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
   uuid | name          | description | web                           | logoPath                               | corporatePressPath                     | notes   | tags   | type                                  || result
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |null          | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |''            | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | null        | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | ''          | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://'                     | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.pn'  | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.pngd'| '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996'     | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pd'  | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdfs'| 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.'    | 'notes' | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | ''      | 'tags' | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | ''     | new BusinessActivity(name:'Products') || false
   'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Anjunabeats' | 'desc'      | 'http://www.anjunabeats.com/' | '5c7f5fdfd9a34af3abb28302efb45996.png' | '493087f832a84ca999efe93f0cfd8473.pdf' | 'notes' | 'tags' | null                                  || false
  }

}
