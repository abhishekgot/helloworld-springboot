helloworld-springboot
=====================

Simple Spring Boot example that exposes a single GET endpoint.

Project layout
- src/main/java/org/aom/helloworldspringboot
  - HelloController.java  — REST controller with GET /hello
  - HelloService.java     — service that builds the greeting
  - HelloworldSpringbootApplication.java — Spring Boot entrypoint
- target/ — build output (ignored by .gitignore)

Prerequisites
- Java 17+ (project compiled with recent JDK; adjust as needed)
- Maven (the project includes the Maven wrapper ./mvnw)

Common tasks

Build (from project root):
- ./mvnw -DskipTests package

Run
- ./mvnw spring-boot:run
or
- java -jar target/helloworld-springboot-0.0.1-SNAPSHOT.jar

HTTP endpoint
- GET /hello
  - optional query param: name
  - examples:
    - curl "http://localhost:8080/hello"             -> Hello, World!
    - curl "http://localhost:8080/hello?name=Alice" -> Hello, Alice!

Port 8080 already in use (macOS)
If the server fails to start because port 8080 is occupied, find and kill the process:

1) Find the process listening on 8080:
   lsof -n -iTCP:8080 -sTCP:LISTEN

2) Kill gracefully:
   kill <PID>

3) Force kill if needed:
   sudo kill -9 <PID>

One-liners:
- kill $(lsof -t -i:8080)
- sudo kill -9 $(lsof -t -i:8080)

.gitignore notes
- A .gitignore has been added at the repository root to exclude /target, IDE files, macOS artifacts, env files, etc.
- If files already tracked should now be ignored, untrack them with:
  git ls-files -i --exclude-standard -z | xargs -0 git rm --cached
  git commit -m "Remove ignored files from repository"

Testing
- The project includes a basic test class. Run tests with:
  ./mvnw test
