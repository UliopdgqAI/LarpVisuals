plugins {
    id("fabric-loom") version "1.8.11"
}

version = "1.0.0"
group = "com.larp.visuals"
base { archivesName = "larpvisuals" }

repositories {
    mavenCentral()
    maven { url = uri("https://maven.fabricmc.net/") }
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.1")
    mappings(loom.layered {
        officialMojangMappings()
    })
    modImplementation("net.fabricmc:fabric-loader:0.15.11")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.102.0+1.21.1")
}

tasks.withType<JavaCompile> {
    options.release = 21
}

tasks.jar {
    from("LICENSE")
}