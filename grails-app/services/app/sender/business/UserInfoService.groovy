package app.sender.business

import grails.gorm.transactions.Transactional

import java.time.ZonedDateTime


class UserInfoService {

    @Transactional
    def getAllUsers() {
       List<UserInfo> users = UserInfo.findAll()
       return users
    }

    @Transactional
    def getUserById(Long userId) {
        UserInfo user = UserInfo.findById(userId)
        return user
    }

    @Transactional
    def createNewUser(request) {
        def firstName = request.firstName
        def lastName = request.lastName
        def username = request.username
        def password = request.password
        def email = request.email

        if(firstName == null
        || lastName == null
        || username == null
        || password == null
        || email == null){
            throw new RuntimeException("Missing properties of user info in request.")
        }

        UserInfo newUser = new UserInfo()

        newUser.firstName = firstName
        newUser.lastName =  lastName
        newUser.username = username
        newUser.password = password
        newUser.email = email
        newUser.verified = Boolean.FALSE
        newUser.createdOnDatetime = ZonedDateTime.now()
        newUser.lastUpdatedOnDatetime = ZonedDateTime.now()

        newUser.save(failOnError: true, flush: true)

        return newUser
    }
}
