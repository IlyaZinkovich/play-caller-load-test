name := "play-caller-load-test"

version := "1.0"

scalaVersion := "2.12.1"

enablePlugins(GatlingPlugin)

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0" % "test,it"
libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.3.0" % "test,it"
libraryDependencies += "com.googlecode.libphonenumber" % "libphonenumber" % "8.8.0"
libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"