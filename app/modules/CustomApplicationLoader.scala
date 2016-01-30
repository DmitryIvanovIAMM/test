package modules

import com.typesafe.config.ConfigFactory
import play.api.ApplicationLoader.Context
import play.api.db.DBApi
import play.api.db.evolutions.Evolutions
import play.api.{Play, Configuration, Mode}
import play.api.inject.guice._
import util.Logging

class CustomApplicationLoader extends GuiceApplicationLoader with Logging {
  override protected def builder(context: Context): GuiceApplicationBuilder = {
    val builder = initialBuilder.in(context.environment).overrides(overrides(context): _*)
    context.environment.mode match {
      case Mode.Prod =>
        // start mode
        builder.loadConfig(Configuration(ConfigFactory.load("application.prod.conf")) ++ context.initialConfiguration)
      case Mode.Dev =>
        // run mode
        info("Load Dev configuration")
        builder.loadConfig(Configuration(ConfigFactory.load("application.dev.conf")) ++ context.initialConfiguration)
      case Mode.Test =>
        // test mode
        info("Load Test configuration")
        builder.loadConfig(Configuration(ConfigFactory.load("application.test.conf")) ++ context.initialConfiguration)

    }
  }
}