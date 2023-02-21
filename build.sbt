ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "2.12.17"

lazy val root = (project in file("."))
  .settings(
    name := "scala-template"
  )

libraryDependencies ++= Seq(
  "com.snowflake" % "snowpark" % "1.7.0",
  "org.scalactic" %% "scalactic" % "3.2.15",
  "org.scalatest" %% "scalatest" % "3.2.15" % "test"
)
