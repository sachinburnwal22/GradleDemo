#setup of basic Gradle using cli:
```aiignore
gradle init --use-defaults --type java-application
```
The above command will setup a basic gradle project

```aiignore
./gradlew build
```
The above command can build your project

To prepare a jar which is executable, you need to setup manifest property in build.gradle.kts to identify which is the main class to execute
```grrovy
tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "org.example.App"
    }
}
```

```aiignore
./gradlew jar
```
The above command creates a new jar file in app\build\libs

```aiignore
cd app\build\libs
java -jar fileName.jar
```
If you are in main folder the above cmd will run your code