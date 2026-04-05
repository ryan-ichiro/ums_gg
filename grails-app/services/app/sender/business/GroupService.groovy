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
    def getByGroupId(Long groupId) {
        if(groupId == null) {
            throw new ResourceException("groupId of: ${groupId} is invalid")
        }
        List<Group> group = Group.findAllById(groupId)

        if(group.size() === 0) {
            return []
        }
        return group
    }

    @Transactional
    def create(request) {
        System.out.println(request)
    }
}
