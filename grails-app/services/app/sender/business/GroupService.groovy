package app.sender.business

import app.sender.Group
import grails.gorm.transactions.Transactional

import java.time.ZonedDateTime

class GroupService {
    @Transactional
    def getAllGroups() {
        List<Group> groups = Group.findAll()
        return groups
    }

    @Transactional
    def getActiveTable () {

    }

    @Transactional
    def getByGroupId(Long groupId) {
        if(groupId == null) {
            throw new ResourceException("groupId of: ${groupId} is invalid")
        }
        Group group = Group.findById(groupId)

        return group
    }

    @Transactional
    def create(request) {
        def name = request.name
        def emailGroup = request.emailGroup
        def responsibleUser = request.responsibleUser

        if(!name || !emailGroup || !responsibleUser) {
            throw new ResourceException("Invalid request. " +
                    "name: ${name}. " +
                    "emailGroup: ${emailGroup}. " +
                    "responsibleUser: ${responsibleUser}."
            )
        }

        Group group = new Group()

        group.name = name
        group.emailGroup = emailGroup
        group.numberOfUsers = 0
        group.isPrivate = Boolean.FALSE

        group.createdOnDatetime = ZonedDateTime.now()
        group.createdByUserId = responsibleUser
        group.lastUpdatedOnDatetime = ZonedDateTime.now()
        group.lastUpdatedByUserId = responsibleUser

        group.save(failOnError: true)

        return group
    }

    @Transactional
    def update(request, groupId) {
        def name = request.name
        def emailGroup = request.emailGroup
        def responsibleUser = request.responsibleUser
        Group group = Group.findById(groupId)

        if(!name || !emailGroup || !responsibleUser) {
            throw new ResourceException("Invalid request. " +
                    "name: ${name}. " +
                    "emailGroup: ${emailGroup}. " +
                    "responsibleUser: ${responsibleUser}."
            )
        }
        if(!group) {
            throw new ResourceException("Group: ${groupId} does not exist")
        }

        group.name = name
        group.emailGroup = emailGroup

        group.lastUpdatedByUserId = responsibleUser
        group.lastUpdatedOnDatetime = ZonedDateTime.now()

        group.save(failOnError: true)

        return group
    }
}
