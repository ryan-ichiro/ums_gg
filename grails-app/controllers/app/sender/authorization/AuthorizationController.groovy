package app.sender.authorization

import app.sender.business.UserInfoService

class AuthorizationController {
    static responseFormats = ['json', 'xml']

    AuthorizationService authorizationService
    UserInfoService userInfoService

    def login(request){
        respond authorizationService.login(request.JSON)
    }

    def register(request){
        respond userInfoService.createNewUser(request.JSON)
    }
}
