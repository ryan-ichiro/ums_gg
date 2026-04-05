package app.sender

import java.time.ZonedDateTime

class Group {
    String name
    Long numberOfUsers
    String emailGroup

    boolean isPrivate
    boolean isActive

    ZonedDateTime createdOnDatetime
    Long createdByUserId
    ZonedDateTime lastUpdatedOnDatetime
    Long lastUpdatedByUserId

    static constraints = {
        name nullable: false
        isPrivate nullable: false

        verified default: false
    }

    static mapping = {
        table                   name: "UMS_GROUP"
        id                      column: "GROUP_ID", generator: 'sequence', params:[sequence: 'group_seq']

        name                    column: "GROUP_NAME"
        numberOfUsers           column: "NUMBER_OF_USERS"
        emailGroup              column: "GROUP_EMAIL"

        isPrivate               column: "PRIVATE_GROUP_BOOL"

        createdOnDatetime       column: "CREATED_ON_DATETIME"
        createdByUserId         column: "CREATED_BY_USER_ID"
        lastUpdatedOnDatetime   column: "LAST_UPDATED_DATETIME"
        lastUpdatedByUserId     column: "LAST_UPDATED_BY_USER_ID"

        version false
    }
}
