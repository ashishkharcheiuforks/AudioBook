package com.allsoftdroid.buildsrc

//import kotlin.reflect.full.memberProperties


private const val FEATURE_PREFIX = ":feature_"

// "Module" means "project" in terminology of Gradle API. To be specific each "Android module" is a Gradle "subproject"
object ModuleDependency {
    // All consts are accessed via reflection
    const val APP = ":app"
    const val FEATURE_BOOK = ":feature_book"
    const val FEATURE_BOOK_DETAILS = ":feature_book_details"
    const val FEATURE_MINI_PLAYER=":feature_mini_player"

    const val LIBRARY_COMMON = ":common"

    const val SERVICES = ":services"
    const val DATABASE = ":database"



//    fun getAllModules() = ModuleDependency::class.memberProperties
//        .filter { it.isConst }
//        .map { it.getter.call().toString() }
//        .toSet()
//
//    fun getDynamicFeatureModules() = getAllModules()
//        .filter { it.startsWith(FEATURE_PREFIX) }
//        .toSet()
}