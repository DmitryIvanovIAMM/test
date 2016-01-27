name := """test"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"


libraryDependencies ++= Seq(
  cache,
  ws,
  specs2 % Test,
  "com.typesafe.play"         % "play_2.11"              % "2.4.6",
  "com.typesafe.play"         %% "anorm"                 % "2.4.0",
  "com.typesafe.slick"        %% "slick"                 % "3.1.1",
  "com.typesafe.play"         %% "play-slick"            % "1.1.1",
  "com.typesafe.play"         %% "play-slick-evolutions" % "1.1.1",
  "org.slf4j"                 % "slf4j-nop"              % "1.6.4",
  "org.mindrot"               % "jbcrypt"                % "0.3m",
  "joda-time"                 % "joda-time"              % "2.7",
  "org.joda"                  % "joda-convert"           % "1.7",
  "com.github.tototoshi"      %% "slick-joda-mapper"     % "2.1.0",
  "com.typesafe.play"         %% "play-mailer"           % "4.0.0-M1",
  "io.strongtyped"            %% "active-slick"          % "0.3.3",
  "postgresql"                % "postgresql"             % "9.1-901.jdbc4",
  "org.apache.pdfbox"         % "pdfbox"                 % "1.8.9",
  "com.opencsv"               % "opencsv"                % "3.5",
  "be.objectify"              %% "deadbolt-scala"        % "2.4.2",
  "ch.qos.logback"            % "logback-classic"        % "1.1.2",
  "org.scalatest"             %% "scalatest"             % "2.2.5"    % "test",
  "org.scalatestplus"         %% "play"                  % "1.4.0-M3" % "test",
  "org.scalacheck"            %% "scalacheck"            % "1.12.4"   % "test",
  "org.specs2"                %% "specs2-core"           % "3.0"      % "test",
  "com.h2database"            % "h2"                     % "1.4.185"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator