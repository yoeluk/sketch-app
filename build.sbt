enablePlugins(ScalaJSPlugin)
scalaVersion := "2.11.6"
version := "0.1-SNAPSHOT"
name := "Sketcher"
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-target:jvm-1.7",
  "-encoding", "UTF-8",
  "-language:implicitConversions",
  "-language:reflectiveCalls"
)
persistLauncher in Compile := false
persistLauncher in Test := false
skip in packageJSDependencies := false
libraryDependencies ++= Seq(
  "com.github.yoeluk" %%% "paper-scala-js" % "0.1.2-SNAPSHOT"
)
jsDependencies += "org.webjars" % "paperjs" % "0.9.22" / "paper-full.min.js" commonJSName "paper"