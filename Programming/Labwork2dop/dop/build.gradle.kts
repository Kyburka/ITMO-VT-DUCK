plugins {
    java
    application
}

group = "ru.ifmo.se"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("libs/Pokemon.jar"))
    implementation("org.jline:jline:3.23.0") // JLine
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src/main/java"))
        }
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

tasks.javadoc {
    options.encoding = "UTF-8"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainClass.set("Main")
}

tasks.withType<JavaExec> {
    systemProperty("file.encoding", "UTF-8")
    systemProperty("console.encoding", "UTF-8")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}