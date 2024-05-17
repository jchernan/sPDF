
name := "sPDF"

description := "Create PDFs using plain old HTML+CSS. Uses wkhtmltopdf on the back-end which renders HTML using Webkit."

startYear := Some(2013)

licenses := Seq(
  ("MIT", url("http://opensource.org/licenses/MIT"))
)

organization := "com.andeno"

scalaVersion := "2.13.14"

crossScalaVersions := Seq("2.12.19", "2.13.14")

releaseCrossBuild := true

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8"
)

fork in Test := true

parallelExecution in Test := false

logLevel in compile := Level.Warn

// add dependencies on standard Scala modules, in a way
// supporting cross-version publishing
// taken from: http://github.com/scala/scala-module-dependency-sample
libraryDependencies := {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, scalaMajor)) if scalaMajor >= 11 =>
      libraryDependencies.value ++ Seq(
        "org.scala-lang.modules" %% "scala-xml" % "1.2.0",
        "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
      )
    case _ =>
      libraryDependencies.value
  }
}

libraryDependencies ++= Seq (
  "org.scalatest"   %% "scalatest"      % "3.2.18"   % "test",
  "org.scalatestplus" %% "mockito-5-10" % "3.2.18.0" % "test"
)

publishArtifact in Test := false

githubOwner := "jchernan"
githubRepository := "sPDF"
