package app.sender.business

class GroupController {
    static responseFormats = ['json', 'xml']

    def groupService

    def index(params) {
        respond groupService.getAllGroups()
    }

    def getByGroupId() {
        respond groupService.getByGroupId(Long.parseLong(params.id))
    }

    def create() {
        respond groupService.create(request.JSON)
    }
}
