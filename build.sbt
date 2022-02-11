lazy val `sandwich-example` = project.in(file("."))
    .aggregate(main, middle, core)

lazy val main = project.in(file("main"))
  .settings(
    scalaVersion := "2.13.8",
    scalacOptions += "-Ytasty-reader"
  )
  .dependsOn(middle)

lazy val middle = project.in(file("middle"))
  .settings(
    scalaVersion := "3.1.0",
    scalacOptions ++= Seq(
      "-language:implicitConversions",
    ),
    libraryDependencies ++= Seq(
      "io.getquill" %% "quill-sql" % "3.16.1.Beta2.2"
    )
  )
  .dependsOn(core)

lazy val core = project.in(file("core"))
  .settings(scalaVersion := "2.13.8")

lazy val commonSettings = Seq(
  version := "0.1.0",
  resolvers ++= Seq(
    Resolver.mavenLocal,
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"
  )
)