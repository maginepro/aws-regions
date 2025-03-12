ThisBuild / tlBaseVersion := "1.0"

ThisBuild / organization := "com.magine"
ThisBuild / organizationName := "Magine Pro"
ThisBuild / startYear := Some(2025)
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers ++= List(
  tlGitHubDev("vlovgr", "Viktor Rudebeck")
)
ThisBuild / tlUntaggedAreSnapshots := false

val Scala3 = "3.3.5"
ThisBuild / crossScalaVersions := Seq("2.13.16", Scala3)
ThisBuild / scalaVersion := Scala3

lazy val root = tlCrossRootProject
  .aggregate(core, circe, ciris)

lazy val core = crossProject(JVMPlatform, JSPlatform, NativePlatform)
  .in(file("modules/core"))
  .settings(name := "aws-regions")

lazy val circe = crossProject(JVMPlatform, JSPlatform, NativePlatform)
  .in(file("modules/circe"))
  .settings(
    name := "aws-regions-circe",
    libraryDependencies += "io.circe" %% "circe-core" % "0.14.10"
  )
  .dependsOn(core)

lazy val ciris = crossProject(JVMPlatform, JSPlatform, NativePlatform)
  .in(file("modules/ciris"))
  .settings(
    name := "aws-regions-ciris",
    libraryDependencies += "is.cir" %% "ciris" % "3.7.0"
  )
  .dependsOn(core)
