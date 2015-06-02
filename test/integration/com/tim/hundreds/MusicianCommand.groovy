package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 */
class MusicianCommandSpec extends Specification {
  @Unroll
  void """When we have a musician with name:  #name, history: #history, web: #web, notes: #notes, hasManager: #hasManager we expect the result is: #result"""() {
    given: "An musician"
      MusicianCommand musician = new MusicianCommand()
    when: "We assing values to command"
      musician.name = name
      musician.history = history
      musician.web = web
      musician.notes = notes
      musician.hasManager = hasManager
    then:"We validate command"
      result == musician.validate()
    where:"We have the next cases"
    name             | history  | web                             | notes   | hasManger || result
    'Above & Beyond' | ''       | 'http://www.aboveandbeyond.nu/' | 'notes' | true      || true
  }


}
