resolvers += "jitpack" at "https://jitpack.io"

name := "spark-slack"

version := "0.0.1"

scalaVersion := "2.11.12"

sparkVersion := "2.3.0"

sparkComponents ++= Seq("sql")

libraryDependencies ++= Seq(
  "net.gpedro.integrations.slack" % "slack-webhook" % "1.2.1",
  "org.json4s" %% "json4s-native" % "3.3.0"
)
libraryDependencies += "com.github.mrpowers" % "spark-daria" % "v2.3.0_0.18.0"

libraryDependencies += "com.github.mrpowers" % "spark-fast-tests" % "v2.3.0_0.7.0" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// test suite settings
fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
// Show runtime of tests
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

// JAR file settings
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
// Add the JAR file naming conventions described here: https://github.com/MrPowers/spark-style-guide#jar-files
// You can add the JAR file naming conventions by running the shell script
assemblyJarName in assembly := s"${name.value}_${scalaBinaryVersion.value}-${sparkVersion.value}_${version.value}.jar"

