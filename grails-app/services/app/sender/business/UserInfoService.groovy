package app.sender.business

import app.sender.UserInfo
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
        String firstName = request.firstName
        String lastName = request.lastName
        String username = request.username
        String password = request.password
        String email = request.email

        if(firstName == null
        || lastName == null
        || username == null
        || password == null
        || email == null){
            throw new RuntimeException("Missing properties of user info in request.")
        }

        UserInfo check = UserInfo.findByEmail(email)

        if(check){
            return [code: 2, newUser: null, message: "A user with this email already exists."]
        }

        UserInfo newUser = new UserInfo()

        newUser.firstName = firstName
        newUser.lastName =  lastName
        newUser.username = username
        newUser.password = password
        newUser.email = email
        newUser.verified = Boolean.FALSE
        newUser.admin = Boolean.TRUE
        newUser.createdOnDatetime = ZonedDateTime.now()
        newUser.lastUpdatedOnDatetime = ZonedDateTime.now()

        newUser.save(failOnError: true, flush: true)

        return [code: 1, user: newUser, message: "Registration successful"]
    }
}
