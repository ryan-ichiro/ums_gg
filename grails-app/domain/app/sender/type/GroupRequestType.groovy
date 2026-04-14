package app.sender.type

import java.time.ZonedDateTime

class GroupRequestType {
    String message

    ZonedDateTime createdOnDatetime
    Long createdByUserId
    ZonedDateTime lastUpdatedOnDatetime
    Long lastUpdatedByUserId

    static constraints = {
        message nullable: false

        createdOnDatetime nullable: false
        createdByUserId nullable: false
        lastUpdatedOnDatetime nullable: false
        lastUpdatedByUserId nullable: false
    }

    static mapping = {
        table                       name: "UMS_GROUP_REQUEST_TYPE"
        id                          column: "GROUP_REQUEST_TYPE_ID", generator: 'sequence', params:[sequence_name: 'group_request_type_seq']

        message                     column: "REQUEST_TYPE_MESSAGE"

        createdOnDatetime           column: "CREATED_ON_DATETIME"
        createdByUserId             column: "CREATED_BY_USER_ID"
        lastUpdatedOnDatetime       column: "LAST_UPDATED_DATETIME"
        lastUpdatedByUserId         column: "LAST_UPDATED_BY_USER_ID"
    }
}
