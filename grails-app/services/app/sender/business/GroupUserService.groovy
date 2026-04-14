package app.sender.business

import app.sender.Group
import app.sender.GroupUser
import app.sender.UserInfo
import grails.gorm.transactions.Transactional

import java.time.ZonedDateTime

class GroupUserService {
    @Transactional
    def getByGroupId(Long groupId) {
        if(!groupId) {
            throw new ResourceException("Group id of ${groupId} is null")
        }

        List<GroupUser> list = GroupUser.findAllByGroupId(groupId)
        if(list.size() == 0){
            return []
        }

        return list
    }

    @Transactional
    def getByUserId(Long userId) {
        if(!userId) {
            throw new ResourceException("Group id of ${userId} is null")
        }

        List<GroupUser> list = GroupUser.findAllByUserId(userId)
        if(list.size() == 0){
            return []
        }

        return list
    }

    @Transactional
    def create(Long groupId, Long userId, Long assigneeUserId) {
        if(!groupId || !userId) {
            throw new ResourceException("Group id or User id is null")
        }

        UserInfo user = UserInfo.findByUserId(userId)
        Group group = Group.findByGroupId(groupId)

        if(!user) {
            throw new ResourceException("User is not found")
        }
        if(!group) {
            throw new ResourceException("Group not found")
        }

        GroupUser groupUser = new GroupUser()

        groupUser.user = user
        groupUser.group = group
        groupUser.createdOnDatetime = ZonedDateTime.now()
        groupUser.createdByUserId = assigneeUserId
        groupUser.lastUpdatedOnDatetime = ZonedDateTime.now()
        groupUser.lastUpdatedByUserId = assigneeUserId

        GroupUser.save(failOnError: true, flush: true)
        return GroupUser
    }
}
