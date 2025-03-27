val scala213Version = "2.13.16"
val scala3Version = "3.3.5"

inThisBuild(
  Seq(
    crossScalaVersions := Seq(scala213Version, scala3Version),
    developers := List(tlGitHubDev("vlovgr", "Viktor Rudebeck")),
    githubWorkflowJavaVersions := Seq(JavaSpec.temurin("17")),
    githubWorkflowTargetBranches := Seq("**"),
    licenses := Seq(License.Apache2),
    organization := "com.magine",
    organizationName := "Magine Pro",
    scalaVersion := scala3Version,
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    startYear := Some(2025),
    tlBaseVersion := "1.0",
    tlCiHeaderCheck := true,
    tlCiScalafixCheck := true,
    tlCiScalafmtCheck := true,
    tlFatalWarnings := true,
    tlJdkRelease := Some(8),
    tlUntaggedAreSnapshots := false,
    versionScheme := Some("early-semver")
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
