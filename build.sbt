import sbt.Keys.version

name := "so-testbed"

val versions = Map(
  "scalaTest" -> "3.1.0",
  "scalaTest-Mockito" -> "1.0.0-M2",
  "typesafeConfig" -> "1.3.1",
  "enumeratum" -> "1.5.13",
  "shapeless" -> "2.3.3",
  "mockito" -> "3.2.4"
)

organization := "io.github.arkorwan"
version := "0.1"
scalaVersion := "2.12.10"
scalacOptions += "-deprecation"
updateOptions := updateOptions.value.withCachedResolution(true)
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % versions("typesafeConfig"),
  "com.beachape" %% "enumeratum" % versions("enumeratum"),
  "com.chuusai" %% "shapeless" % versions("shapeless"),
  // testing
  "org.scalatest" %% "scalatest" % versions("scalaTest") % "test",
  "org.mockito" % "mockito-core" % versions("mockito") % "test",
  "org.scalatestplus" %% "scalatestplus-mockito" % versions("scalaTest-Mockito") % "test"
)
