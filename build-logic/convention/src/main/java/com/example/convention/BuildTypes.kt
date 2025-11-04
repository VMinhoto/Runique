package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *>,
    extensionType: ExtensionType
){
    commonExtension.run {
        buildFeatures{
            buildConfig = true
        }

        val apikey = gradleLocalProperties(rootDir).getProperty("API_KEY")
        when(extensionType){
            ExtensionType.APPLICATION -> {
                extensions.configure<ApplicationExtension>{
                    buildTypes{
                        debug{
                            configureDebugBuildType(apikey)

                        }
                        release{
                            configureReleaseBuildType(commonExtension, apikey)
                        }
                    }
                }
            }
            ExtensionType.LIBRARY -> {
                extensions.configure<LibraryExtension>{
                    buildTypes{
                        debug{
                            configureDebugBuildType(apikey)

                        }
                        release{
                            configureReleaseBuildType(commonExtension, apikey)
                        }
                    }
                }
            }
        }
    }
}

private fun BuildType.configureDebugBuildType(apiKey: String) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"http://192.168.1.246:8080\"")
}

private fun BuildType.configureReleaseBuildType(
    commonExtension: CommonExtension<*, *, *, *, *>,
    apiKey: String
) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"http://192.168.1.246:8080\"")

    isMinifyEnabled = true
    proguardFiles(
        commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}