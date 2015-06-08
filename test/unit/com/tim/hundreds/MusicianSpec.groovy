package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 */
@TestFor(Musician)
class MusicianSpec extends Specification {
  @Unroll
  void """When we have a musician with name:  #name, history: #history, web: #web, notes: #notes, tags: #tags, logoPath: #logoPath, hasManager: #hasManager we expect the result is: #result"""() {
    given: "An musician"
      MusicianCommand musician = new MusicianCommand()
    when: "We assing values to command"
      musician.name = name
      musician.history = history
      musician.web = web
      musician.notes = notes
      musician.tags = tags
      musician.logoPath = logoPath
      musician.hasManager = hasManager
      musician.formed = formed
      musician.genre = genre
    then:"We validate command"
      result == musician.validate()
    where:"We have the next cases"
    name             | history   | web                             | notes   | tags   | logoPath                           | hasManager  | formed       | genre        || result
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || true
    'A'              | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || true
    'Above & Beyond' | 'h'       | null                            | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || true
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | null    | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || true
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | null   | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || true
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | null                               | true        |  new Date()  | Genre.TRANCE || true
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | false       |  new Date()  | Genre.TRANCE || true
  }

  @Unroll
  void """When we have a musician with name:  #name, history: #history, web: #web, notes: #notes, tags: #tags, logoPath: #logoPath, hasManager: #hasManager we expect the result is: #result"""() {
    given: "An musician"
      MusicianCommand musician = new MusicianCommand()
    when: "We assing values to command"
      musician.name = name
      musician.history = history
      musician.web = web
      musician.notes = notes
      musician.tags = tags
      musician.logoPath = logoPath
      musician.hasManager = hasManager
      musician.formed = formed
      musician.genre = genre
    then:"We validate command"
      result == musician.validate()
    where:"We have the next cases"
    name             | history   | web                             | notes   | tags   | logoPath                           | hasManager  | formed       | genre        || result
    null             | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || false
    'Above & Beyond' | null      | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || false
    'Above & Beyond' | 'history' | 'http://'                       | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || false
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | ''      | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || false
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | ''     | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | Genre.TRANCE || false
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb4599.png'  | true        |  new Date()  | Genre.TRANCE || false
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png6'| true        |  new Date()  | Genre.TRANCE || false
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | ''                                 | true        |  new Date()  | Genre.TRANCE || false
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  null        | Genre.TRANCE || false
    'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags' | '5c7f5fdfd9a34af3abb28302efb45996.png' | true        |  new Date()  | null         || false
  }

}
