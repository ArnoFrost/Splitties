/*
 * Copyright (c) 2018. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    val projectSdk_version: Int by extra
    val projectBuildTools_version: String by extra
    val library_version: String by extra
    compileSdkVersion(projectSdk_version)
    buildToolsVersion(projectBuildTools_version)
    defaultConfig {
        minSdkVersion(14)
        targetSdkVersion(projectSdk_version)
        versionCode = 1
        versionName = library_version
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    sourceSets {
        names.forEach { getByName(it).java.srcDir("src/$it/kotlin") }
    }
}

dependencies {
    api(Libs.kotlin.stdlibJdk7)
}

apply {
    from("../publish.gradle")
}
