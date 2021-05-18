import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 23
    const val compileSdk = 30
    const val targetSdk = 30
    val javaVersion = JavaVersion.VERSION_1_8
    const val buildTools = "30.0.3"
}
object Versions {
    // <editor-fold desc="google">
    const val androidx_core = "1.0.1"
    const val androidx_recyclerview = "1.0.0"
    const val androidx_navigation = "2.0.0"
    const val androidx_constraintLayout = "1.1.3"
    const val material = "1.1.0-alpha04"
    // </editor-fold>

    // <editor-fold desc="testing">
    const val junit = "4.12"
    const val androidx_espresso = "3.1.0"
    const val androidx_testing = "1.1.1"
    //</editor-fold>

    // <editor-fold desc="tools">
    const val gradle_android = "3.5.0"
    const val kotlin = "1.3.20"
    const val gradle_versions = "0.21.0"
    // </editor-fold>

}

object Deps {
    const val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidx_constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    const val androidx_material = "com.google.android.material:material:${Versions.material}"
    const val androidx_navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidx_navigation}"
    const val androidx_navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.androidx_navigation}"
    const val androidx_recyclerview = "androidx.recyclerview:recyclerview:${Versions.androidx_recyclerview}"

    val test_lib_junit = "junit:junit:${Versions.junit}"

    val testandroidx_rules = "androidx.test:rules:${Versions.androidx_testing}"
    val testandroidx_runner = "androidx.test:runner:${Versions.androidx_testing}"
    val testandroidx_espressocore = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"

    val tools_gradleandroid = "com.android.tools.build:gradle:${Versions.gradle_android}"
    val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val tools_gradle_versions = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradle_versions}"

}

