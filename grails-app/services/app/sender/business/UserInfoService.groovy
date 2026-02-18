package app.sender.business

import jakarta.transaction.Transactional

class UserInfoService {

    @Transactional
    def getAllUsers() {
       List<UserInfo> users = UserInfo.findAll()
       return users
    }

    @Transactional
    def getUserById(userId) {
        UserInfo user = UserInfo.findById(userId)
        return user
    }
}
