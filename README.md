# vertx_demo


## Launch

```shell
./gradlew run
```

## Architecture
- Language: Java 1.8.0_161
- Build: Gradle 4.3.1
- Base Framework: Vert.x 3.5.0
- Logging: SLF4J + Logback

### Design
- Definitions
- Domain
    - Package: (project).(product).domain
    - Class Type: Entity, DTO, VO
        - Entity: the object corresponding to DB Object
        - DTO: the object to transfer across networks or process.
        - VO: Immutable object
- Repository
    - Package: (project).(product).repository
    - Class Type: Cache, DAO
        - Cache : 
        - DAO :
- Service
    - Package: (project).(product).service
    - Class Type: Worker,
- Controller


- Verticle
    - 
    - 