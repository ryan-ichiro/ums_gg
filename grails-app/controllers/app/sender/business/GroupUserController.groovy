package app.sender.business

class GroupUserController {

    GroupUserService groupUserService

    def index() {
        if(params.userId) {
            respond groupUserService.getByUserId(Long.parseLong(params.userId))
        } else if(params.groupId) {
            respond groupUserService.getByGroupId(Long.parseLong(params.groupId))
        }
    }

    def create() {
        respond groupUserService.create(
                Long.parseLong(params.groupId),
                Long.parseLong(params.userId),
                Long.parseLong(params.assigneeUserId)
        )
    }

    def delete() {

    }
}
