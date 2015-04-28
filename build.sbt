
workbenchSettings

lazy val commonSettings = Seq(
  scalaVersion := "2.11.6",
  jsDependencies += "org.webjars" % "paperjs" % "0.9.22" / "paper-full.min.js" commonJSName "paper",
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-target:jvm-1.7",
    "-encoding", "UTF-8",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-language:reflectiveCalls"
  ),
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0"
  )
)

lazy val paperjs = project.settings(commonSettings: _*).settings(
  version := "0.1-SNAPSHOT",
  name := "paper-scala-js",
  persistLauncher in Compile := true,
  persistLauncher in Test := false
).enablePlugins(ScalaJSPlugin)

lazy val root = (project in file(".")).settings(commonSettings: _*).settings(
  version := "0.1-SNAPSHOT",
  name := "Sketcher",
  persistLauncher in Compile := false,
  persistLauncher in Test := false,
  skip in packageJSDependencies := false,
  testFrameworks += new TestFramework("utest.runner.Framework")
).enablePlugins(ScalaJSPlugin).dependsOn(paperjs)


bootSnippet := "example.ScalaJSExample().main(document.getElementById('canvas'));"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)

scalaJSStage in Global := FastOptStage

