package app.sender.business

class UserInfoController {
    static responseFormats = ['json', 'xml']
    def userInfoService

    def index(params) {
        if (params.userId)
            respond userInfoService.getUserById(params.userId)
        else
            respond userInfoService.getAllUsers()
    }
}
