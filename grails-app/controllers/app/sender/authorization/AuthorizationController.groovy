package app.sender.authorization

class AuthorizationController {
    static responseFormats = ['json', 'xml']

    AuthorizationService authorizationService

    def login(request){
        def a = authorizationService.login(request.JSON)
        respond a
    }
}
