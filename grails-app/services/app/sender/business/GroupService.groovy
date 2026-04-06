package app.sender.business

import app.sender.Group
import grails.gorm.transactions.Transactional

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
        System.out.println(request)
    }

    @Transactional
    def update(request) {
        System.out.println(request)
    }
}
