package app.sender.authorization

import app.sender.UserInfo
import grails.gorm.transactions.Transactional

class AuthorizationService {

    @Transactional
    def login(request){
        String email = request.email
        String password = request.password

        def successful   = [code: 1, message: "Login Successful, Entering UMS."]
        def unsuccessful = [code: 2, message: "Login failed. Email or password is incorrect."]

        // Should perform some hash function for password

        if(email != null || password != null){
            UserInfo loginUser = UserInfo.findByEmail(email)
            if(!loginUser) {
                return unsuccessful
            } else {
                def userPassword = loginUser.password
                if(userPassword == password){
                    return successful
                } else {
                    return unsuccessful
                }
            }
        } else {
            throw new RuntimeException("Missing parameters in request.")
        }
    }
}
