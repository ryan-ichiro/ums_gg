package app.sender.business

import java.time.ZonedDateTime

class UserInfo {
    String firstName
    String lastName
    String username
    String password
    String email

    Boolean verified

    ZonedDateTime createdOnDatetime
    ZonedDateTime lastUpdatedOnDatetime

    static constraints = {
        firstName nullable: false
        lastName nullable: false
        username nullable: false
        password nullable: false
        email nullable: false

        verified default: false
    }

    static mapping = {
        table                   name: "UMS_USER_INFO"
        id                      column: "USER_ID", generator: 'sequence', params:[sequence_name: 'user_info_seq']

        firstName               column: "USER_FIRST_NAME"
        lastName                column: "USER_LAST_NAME"
        username                column: "USER_USERNAME"
        password                column: "USER_PASSWORD"
        email                   column: "USER_EMAIL"

        verified                column: "VERIFIED_BOOL"

        createdOnDatetime       column: "CREATED_ON_DATETIME"
        lastUpdatedOnDatetime   column: "LAST_UPDATED_DATETIME"

        version false
    }
}
