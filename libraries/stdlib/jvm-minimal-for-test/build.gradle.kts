import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "Kotlin Mock Runtime for Tests"

apply { plugin("kotlin") }

jvmTarget = "1.6"
javaHome = rootProject.extra["JDK_16"] as String

dependencies {
    compileOnly(project(":kotlin-stdlib"))
}

sourceSets {
    "main" {
        java.apply {
            srcDir(File(buildDir, "src"))
        }
    }
    "test" {}
}

val copySources by task<Copy> {
    from(project(":kotlin-stdlib").projectDir.resolve("jvm/runtime"))
            .include("kotlin/TypeAliases.kt",
                    "kotlin/text/TypeAliases.kt")
    from(project(":kotlin-stdlib").projectDir.resolve("src"))
            .include("kotlin/collections/TypeAliases.kt",
                    "kotlin/jvm/JvmVersion.kt",
                    "kotlin/util/Standard.kt",
                    "kotlin/internal/Annotations.kt",
                    "kotlin/internal/contracts/ContractBuilder.kt",
                    "kotlin/internal/contracts/Effect.kt")
    into(File(buildDir, "src"))
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.6"
    targetCompatibility = "1.6"
}

tasks.withType<KotlinCompile> {
    dependsOn(copySources)
    kotlinOptions {
        freeCompilerArgs += listOf("-module-name", "kotlin-stdlib")
    }
}

val jar = runtimeJar {
    dependsOn(":core:builtins:serialize")
    from(fileTree("${rootProject.extra["distDir"]}/builtins")) { include("kotlin/**") }
}

val distDir: String by rootProject.extra

dist(targetName = "kotlin-stdlib-minimal-for-test.jar", targetDir = File(distDir))
