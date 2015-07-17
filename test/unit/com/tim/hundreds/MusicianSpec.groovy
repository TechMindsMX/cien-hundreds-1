package com.tim.hundreds

import spock.lang.Specification
import spock.lang.Unroll
import spock.lang.Shared

/**
 *
 */
@TestFor(Musician)
class MusicianSpec extends Specification {
  @Shared nextMinute = new Date().getTime() + 60 * 1000 * 1
  @Shared nextHour = new Date().getTime() + 60 * 1000 * 60
  @Shared nextDay = new Date().getTime() + 60 * 1000 * 60 * 24
  @Shared aboveAndBeyond = new Date().getTime() + 60 * 1000 * 60 * 24 * 600

  @Unroll
  void """When we have a musician with name:  #name, history: #history, web: #web, notes: #notes, tags: #tagsComma, logoPath: #logoPath, hasManager: #hasManager we expect the result is: #result"""() {
    given: "An musician"
      def musician = new MusicianCommand()
    when: "We assing values to command"
      musician.uuid = uuid
      musician.name = name
      musician.history = history
      musician.web = web
      musician.notes = notes
      musician.tagsComma = tagsComma
      musician.logoPath = logoPath
      musician.hasManager = hasManager
      musician.formed = formed
      musician.genre = genre
    then:"We validate command"
      result == musician.validate()
    where:"We have the next cases"
    uuid                                       | name             | history   | web                             | notes   | tagsComma | logoPath                               | hasManager | formed              | genre                    || result
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || true
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'A'              | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || true
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'h'       | null                            | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || true
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | null    | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || true
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | null      | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || true
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | null                                   | true       | new Date()          | new Genre(name:'Trance') || true
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | false      | new Date()          | new Genre(name:'Trance') || true
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |null             | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | null      | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://'                       | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | ''      | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | ''        | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb4599.png'  | true       | new Date()          | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png6'| true       | new Date()          | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | ''                                     | true       | new Date()          | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | null                | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date()          | null                     || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date(nextMinute)| new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date(nextHour)  | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date(nextDay)   | new Genre(name:'Trance') || false
    'ae96fd7f42d128185b6cfb8a9cec5176c800f491' |'Above & Beyond' | 'history' | 'http://www.aboveandbeyond.nu/' | 'notes' | 'tags'    | '5c7f5fdfd9a34af3abb28302efb45996.png' | true       | new Date(aboveAndBeyond)  | new Genre(name:'Trance') || false




  }

}
