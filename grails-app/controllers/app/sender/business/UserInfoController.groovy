package app.sender.business

class UserInfoController {
    static responseFormats = ['json', 'xml']

    def userInfoService

    def index(params) {
        if (params.userId)
            respond userInfoService.getUserById(Integer.parseInt(params.userId))
        else
            respond userInfoService.getAllUsers()
    }

    def save(request) {
        respond userInfoService.createNewUser(request.JSON)
    }
}
