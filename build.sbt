workbenchSettings

lazy val commonSettings = Seq(
  scalaVersion := "2.11.6",
  resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
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
    "com.github.yoeluk" %%% "paper-scala-js" % "0.1.2-SNAPSHOT"
  )
)

lazy val root = (project in file(".")).settings(commonSettings: _*).settings(
  version := "0.1-SNAPSHOT",
  name := "Sketcher",
  persistLauncher in Compile := false,
  persistLauncher in Test := false,
  skip in packageJSDependencies := false,
  testFrameworks += new TestFramework("utest.runner.Framework")
).enablePlugins(ScalaJSPlugin)


bootSnippet := "sketcher.Sketcher().main(document.getElementById('canvas'));"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)

scalaJSStage in Global := FastOptStage