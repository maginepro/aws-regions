val scala213Version = "2.13.16"
val scala3Version = "3.3.5"

inThisBuild(
  Seq(
    tlBaseVersion := "1.0",
    organization := "com.magine",
    organizationName := "Magine Pro",
    startYear := Some(2025),
    licenses := Seq(License.Apache2),
    developers ++= List(
      tlGitHubDev("vlovgr", "Viktor Rudebeck")
    ),
    githubWorkflowJavaVersions := Seq(JavaSpec.temurin("17")),
    tlUntaggedAreSnapshots := false,
    crossScalaVersions := Seq(scala213Version, scala3Version),
    scalaVersion := scala3Version,
    tlFatalWarnings := true,
    tlCiHeaderCheck := true,
    tlCiScalafixCheck := true,
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision
  )
)

lazy val root = tlCrossRootProject
  .aggregate(core, circe, ciris)

lazy val core = crossProject(JVMPlatform, JSPlatform, NativePlatform)
  .in(file("modules/core"))
  .settings(name := "aws-regions")

lazy val circe = crossProject(JVMPlatform, JSPlatform, NativePlatform)
  .in(file("modules/circe"))
  .settings(
    name := "aws-regions-circe",
    libraryDependencies += "io.circe" %%% "circe-core" % "0.14.8"
  )
  .dependsOn(core)

lazy val ciris = crossProject(JVMPlatform, JSPlatform, NativePlatform)
  .in(file("modules/ciris"))
  .settings(
    name := "aws-regions-ciris",
    libraryDependencies += "is.cir" %%% "ciris" % "3.7.0"
  )
  .dependsOn(core)
