package app.sender

class UrlMappings {
    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")
        "/"(controller: 'application', action:'index')
        "500"(view:'/error')
        "404"(view:'/notFound')

        group "/userInfo", {
            get "/" (controller: "userInfo", action: "index", method: "GET")
            post "/" (controller: "userInfo", action: "save", method: "POST")
        }

        group "/authorization", {
            post "/login" (controller: "authorization", action: 'login', method: "POST")
            post "/register" (controller: "authorization", action: 'register', method: "POST")
        }

        group "/group", {
            get "/" (controller: "group", action: "index", method: "GET")
            get "/${id}" (controller: "group", action: "getByGroupId", method: "GET")
            post "/" (controller: "group", action: "create", method: "POST")
            put "/${id}" (controller: "group", action: "update", method: "PUT")
            get "/getActive" (controller: "group", action: "getActiveTable", method: "GET")
        }

        group "/groupUser", {
            get "/" (controller: "groupUser", action: 'index', method: "GET")
            post "/" (controller: "groupUser", action: 'create', method: "POST")
            delete "/" (controller: "groupUser", action: 'delete', method: "DELETE")
        }

    }
}
