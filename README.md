## Grails 7.0.7 Documentation

- [User Guide](https://grails.apache.org/docs/7.0.7/guide/index.html)
- [API Reference](https://grails.apache.org/docs/7.0.7/api/index.html)
- [Grails Guides](https://guides.grails.org/index.html)
---

## Feature views-json documentation

- [Grails JSON Views documentation](https://grails.apache.org/docs/7.0.7/guide/theWebLayer.html)

## Feature spring-boot-devtools documentation

- [Grails SpringBoot Developer Tools documentation](https://docs.spring.io/spring-boot/reference/using/devtools.html)

---

## application.yml

```yml
server:
  servlet:
    context-path: ## /{contextPath}
info:
  app:
    name: '@info.app.name@'
    version: '@info.app.version@'
    grailsVersion: '@info.app.grailsVersion@'
grails:
  mime:
    disable:
      accept:
        header:
          userAgents:
            - Gecko
            - WebKit
            - Presto
            - Trident
    types:
      json:
        - application/json
        - text/json
      hal:
        - application/hal+json
        - application/hal+xml
      xml:
        - text/xml
        - application/xml
      atom: application/atom+xml
      css: text/css
      csv: text/csv
      js: text/javascript
      rss: application/rss+xml
      text: text/plain
      all: '*/*'
  codegen:
    defaultPackage: app.sender
  profile: rest-api
  views:
    default:
      codec: html

dataSource:
  ## dataSource for project, postgres, H2, oracle, etc.
environments:
  local:
    dataSource:
      local:
      ## dataSource for local environment
  development:
    dataSource:
      dbCreate: create-drop
      url: jdbc:h2:mem:devDb;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE
  test:
    dataSource:
      dbCreate: update
      url: jdbc:h2:mem:testDb;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE
  production:
    dataSource:
      dbCreate: none
      url: jdbc:h2:./prodDb;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE
hibernate:
  cache:
    queries: false
    use_second_level_cache: false
    use_query_cache: false


```