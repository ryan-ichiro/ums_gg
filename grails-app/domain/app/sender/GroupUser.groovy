package app.sender

import java.time.ZonedDateTime

class GroupUser {
    UserInfo user
    Group group

    ZonedDateTime createdOnDatetime
    Long createdByUserId
    ZonedDateTime lastUpdatedOnDatetime
    Long lastUpdatedByUserId
    ZonedDateTime logicalDeletedOnDatetime
    Long logicalDeletedByUserId

    static constraints = {
        user nullable: false
        group nullable: false

        createdOnDatetime nullable: false
        createdByUserId nullable: false
        lastUpdatedOnDatetime nullable: false
        lastUpdatedByUserId nullable: false
    }

    static mapping = {
        table                       name: "UMS_GROUP_USER"
        id                          column: "GROUP_USER_ID", generator: 'sequence', params:[sequence_name: 'group_user_seq']

        user                        column: "USER_ID"
        group                       column: "GROUP_ID"

        createdOnDatetime           column: "CREATED_ON_DATETIME"
        createdByUserId             column: "CREATED_BY_USER_ID"
        lastUpdatedOnDatetime       column: "LAST_UPDATED_DATETIME"
        lastUpdatedByUserId         column: "LAST_UPDATED_BY_USER_ID"
        logicalDeletedOnDatetime    column: "LOGICAL_DELETED_DATETIME"
        logicalDeletedByUserId      column: "LOGICAL_DELETED_BY_USER_ID"
    }
}
