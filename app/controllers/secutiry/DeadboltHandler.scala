package controllers.security

import _root_.util.Logging
import be.objectify.deadbolt.core.models.Subject
import be.objectify.deadbolt.scala.{DeadboltHandler, DynamicResourceHandler}
import play.api.mvc.{Security, Request, Result, Results}
import scala.util.Try

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

class MyDeadboltHandler(dynamicResourceHandler: Option[DynamicResourceHandler] = None) extends DeadboltHandler with Logging {

  def beforeAuthCheck[A](request: Request[A]) = Future(None)
  //def beforeAuthCheck[A](request: Request[A]) = None

  override def getDynamicResourceHandler[A](request: Request[A]): Future[Option[DynamicResourceHandler]] = {
    Future(dynamicResourceHandler.orElse(Some(new MyDynamicResourceHandler())))
  }

  override def getSubject[A](request: Request[A]): Future[Option[Subject]] = {
    // e.g. request.session.get("user")
    Future.successful {
      request.session.get(Security.username).flatMap(u => Try(u.toInt).toOption).map(new DeadboltSubject(_))
    }
  }

  // TODO: add redirection to "Forbidden page"
  def onAuthFailure[A](request: Request[A]): Future[Result] = {
    Future.successful(Results.Forbidden)
  }
}