package controllers.security

import be.objectify.deadbolt.scala.{DeadboltHandler, DynamicResourceHandler}
import play.api.mvc.Request

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class MyDynamicResourceHandler extends DynamicResourceHandler {

  override def isAllowed[A](name: String, meta: String, deadboltHandler: DeadboltHandler, request: Request[A]): Future[Boolean] = {
    Future(true)
    // TODO: finish implementation per https://github.com/schaloner/deadbolt-2-scala-examples/blob/master/app/security/MyDynamicResourceHandler.scala example
  }

  // todo implement this when demonstrating permissions
  def checkPermission[A](permissionValue: String, deadboltHandler: DeadboltHandler, request: Request[A]): Future[Boolean] = Future(false)
}