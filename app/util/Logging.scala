package util

import play.api.Logger

trait Logging {
  private val log = Logger.logger
  protected final def info(msg: => String) = log.info(msg)
  protected final def debug(msg: => String) = log.debug(msg)
  protected final def warn(msg: => String) = log.warn(msg)
  protected final def error(msg: => String) = log.error(msg)
  protected final def error(msg: => String, ex: => Throwable) = log.error(msg, ex)
}
