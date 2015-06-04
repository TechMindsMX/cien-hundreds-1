package com.tim.hundreds



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class SuggestionController {
    def suggestionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Suggestion.list(params), model:[suggestionInstanceCount: Suggestion.count()]
    }

    def show(Suggestion suggestionInstance) {
        respond suggestionInstance
    }

    def create() {
        respond new Suggestion(params)
    }

    def save(Suggestion suggestionInstance) {
        log.info "Suggestion: ${suggestionInstance.dump()}"
        if (suggestionInstance == null) {
          notFound()
          return
        }

        if (suggestionInstance.hasErrors()) {
            respond suggestionInstance.errors, view:'create'
            return
        }

        try{
          def instance = suggestionService.save(suggestionInstance)
          request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'suggestion.label', default: 'Suggestion'), instance.id])
                redirect instance
            }
            '*' { respond instance, [status: CREATED] }
          }
        } catch (Exception ve){
          log.info "Errors ${ve.errors}"
          respond suggestionInstance.musician.errors, view:'create'
        }
    }

    def edit(Suggestion suggestionInstance) {
        respond suggestionInstance
    }

    @Transactional
    def update(Suggestion suggestionInstance) {
        if (suggestionInstance == null) {
            notFound()
            return
        }

        if (suggestionInstance.hasErrors()) {
            respond suggestionInstance.errors, view:'edit'
            return
        }

        suggestionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Suggestion.label', default: 'Suggestion'), suggestionInstance.id])
                redirect suggestionInstance
            }
            '*'{ respond suggestionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Suggestion suggestionInstance) {

        if (suggestionInstance == null) {
            notFound()
            return
        }

        suggestionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Suggestion.label', default: 'Suggestion'), suggestionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'suggestion.label', default: 'Suggestion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
